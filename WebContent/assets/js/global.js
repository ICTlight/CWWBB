/* =========================================================
 BEGIN NAVIGATION
 ========================================================= */

(function($){
	$(function(){
		var header = $('#header'),
			originalHeaderHeight = header.height(),
			topnavLis = $('#mainNav > ul > li', header),
			topnavLinks = topnavLis.children("a"),
			subnavs = $('.wac-subnav', topnavLis),
			activeNavClass = 'active',
			selectedClass = 'selected',

			setHeaderHeight = function(additionalHeight){
				header.css({
					height: originalHeaderHeight + additionalHeight
				})
					// navChange event fires so that jQuery waypoints sticky nav functionality can reset and recalculate sticky nav position
					.one("webkitTransitionEnd otransitionend oTransitionEnd msTransitionEnd transitionend", function(e){
						$(document).trigger("navChange");
					});

				$(document).trigger("navChange");

				if (additionalHeight > 0) {
					header.css({ 'borderBottom': '1px solid #e9e9e9' });
				} else {
					header.css({
						'borderBottom': 'none',
						'height': ''
					});
				}
			},
			toggleSubnav = function(subnav){
				var prevActiveSubnav,
					incomingAddClasses,
					isForward = null;
				// do nothing if no subnav was passed in
				if(subnav){
					incomingAddClasses = [activeNavClass, "in"];
					prevActiveSubnav = subnavs.not(subnav).filter("." + activeNavClass);

					// if there's a subnav that's currently present
					if(prevActiveSubnav.length){
						isForward = getSubnavIndex(subnav) > getSubnavIndex(prevActiveSubnav);
						closeSubnav(false, prevActiveSubnav, !isForward);
					}
					// if nav is already active or can't be found, close the subnav
					if(subnav.hasClass(activeNavClass) || !subnav.length){
						// outgoing
						closeSubnav(true, subnav, isForward);
					}
					// else add the active class and set the drawer height to our incoming nav height
					else {
						if(isForward === true){
							incomingAddClasses.push("forward");
						} else if (isForward === false){
							incomingAddClasses.push("backward");
						}

						subnav
							.removeClass("out backward forward")
							.addClass(incomingAddClasses.join(" "));

						setHeaderHeight(subnav.outerHeight());
					}

				}
			},
			closeSubnav = function(collapseHeader, activeSubnav, isForward){
				var outgoingRemoveClasses = [activeNavClass, "in", "backward", "forward"];
				outgoingAddClasses = ["out"];

				if(!activeSubnav){
					activeSubnav = subnavs.filter("." + activeNavClass);
				}

				if(isForward === true){
					outgoingAddClasses.push("forward");
				} else if(isForward === false){
					outgoingAddClasses.push("backward");
				}

				if(activeSubnav && activeSubnav.length){
					activeSubnav
						.removeClass(outgoingRemoveClasses.join(" "))
						.addClass(outgoingAddClasses.join(" "));
				}
				if(collapseHeader){
					setHeaderHeight(0);
					// remove any active or selected states from DOM
					topnavLis.removeClass(selectedClass);
				}
			},
			getSubnavIndex = function(subnav){
				return topnavLis.index( subnav.closest("li") );
			},
			topnavLinkActivate = function(e){
				var link = $(e.currentTarget);

				// if link has a URL treat as a normal link instead of opening submenu
				if ( link.attr('href') ) {
					return true;
				} else {
					// set nav state
					link.closest('li').toggleClass(selectedClass)
						.siblings('.' + selectedClass).removeClass(selectedClass);

					toggleSubnav( link.closest("li").find(".wac-subnav") );

					e.stopPropagation();
					e.preventDefault();
				}
			};

		topnavLinks.on('click', topnavLinkActivate);

		// on resize, resize the drawer in case content height has changed
		$(window).on('resize.topNav', function(e){
			setHeaderHeight( subnavs.filter("." + activeNavClass).outerHeight() );
		});

		// do not close nav when these
		subnavs.on('click', function(e){
			e.stopPropagation();
		});

		// clicking anywhere else on the page will close the subnav
		$(document).on('click', function(e){
			closeSubnav(true);
		});
	});
})(jQuery);

/* =========================================================
 BEGIN FOOTER LANGUAGE MENU
 ========================================================= */

(function(){
	var languageSelectMenuAnchor = $('#languageMenu a');
	var languageSelectMenu = $('#languageMenuSelect');
	var currentLanguage = $('html').attr("lang").substr(0, 2).toLowerCase();

// Adjust width of select menu underneath the anchor tag for different languages
	languageSelectMenu.css( "width", languageSelectMenuAnchor.width() );

	languageSelectMenuAnchor.click(function (e){
		e.preventDefault();
	});

	languageSelectMenu.change(function(){
		window.location = $(this).val();
	});

	var languageSelection = function(){
		if (currentLanguage) {
			languageSelectMenu.find("option[data-language=" + currentLanguage + "]").attr("selected", "selected").prop("selected", "selected");
		}
	};
	languageSelection();
})();

/* =========================================================
 BEGIN SEARCH
 ========================================================= */
(function($){

	var imkt = window.imkt || (window.imkt = {});

	imkt.search = imkt.search || {};

	/* STATIC */
	// any component that is dependent on the google search api being loaded should call this static method with a callback
	// it first checks to see if the api has been loaded
	// if it has, it immediately executes the callback
	// otherwise it loads the api and executes the callback when the api finishes loading
	imkt.search.init = function(cb){
		this.apiIsLoaded() ? cb() : this.load(cb);
	};

	/* STATIC */
	// this loads the Google Custom Search Element API and executes the supplied when it's all good to go
	imkt.search.load = function(cb){
		this.engineId = "004158415757119463896:yiaveaifukw";
		window.__gcse = {
			parseTags: "explicit",
			callback: function(){
				if (document.readyState === "complete") {
					cb();
				} else {
					google.setOnLoadCallback(cb, true);
				}
			}
		};
		$.getScript( (document.location.protocol.indexOf("https") === 0 ? "https:" : "http:") + "//www.google.com/cse/cse.js?cx=" + this.engineId );
	};

	/* STATIC */
	imkt.search.apiIsLoaded = function(){
		return typeof google !== "undefined" && google.search && google.search.cse;
	};

	/* SEARCH PAGE WITH RESULTS (constructor) */
	imkt.search.CustomSearch = function(el, tag, params){

		this.el = el;
		this.tag = tag; // "tag" as defined by google ("search", "searchbox", "searchresults", "searchbox-only", "searchresults-only") : https://developers.google.com/custom-search/docs/element#overview
		this.params = $.extend({}, {
			// default params here, supported attributes https://developers.google.com/custom-search/docs/element#supported_attributes
			enableHistory: true,
			queryParameterName: "query",
			resultSetSize: "large",
			enableAutoComplete: true,
			autoCompleteMaxCompletions: 3,
			linkTarget: "_self"
		}, params);

		imkt.search.init( $.proxy(this.render, this) );
	};

	imkt.search.CustomSearch.prototype = {
		render: function(){
			var options = {
				div: this.el,
				tag: this.tag,
				attributes: this.params
			};

			// empty the container first
			$(typeof this.el === "string" ? "#"+this.el : this.el).empty();

			google.search.cse.element.render(options);
		}
	};

	/* STANDALONE SEARCH INPUT (constructor) */
	imkt.search.SearchInputOnly = function(el, params){

		this.el = el;
		this.params = $.extend({}, {
			deferred: true,
			autoCompleteOptions: {
				maxCompletions: 0
			}
		}, params);

		this.init();

	};

	imkt.search.SearchInputOnly.prototype = {
		init: function(){
			this.$el = $(this.el);

			if(this.params.deferred){
				this.$el.one("focusin keypress mouseenter", $.proxy(this.activate, this));
			} else {
				this.activate();
			}
		},
		activate: function(){
			if(!this.rendered){
				imkt.search.init( $.proxy(this.render, this) );
			}
		},
		render: function(){
			google.search.CustomSearchControl.attachAutoCompletionWithOptions(
				imkt.search.engineId,
				this.el,
				this.$el.closest("form")[0],
				this.params.autoCompleteOptions
			);
			this.rendered = true;
		}
	};

	// this selector should revert back to a single id once tests are done
	$(function(){
		$("input[id='searchInput']").each(function(){
			new imkt.search.SearchInputOnly(this);
		});
	});

})(jQuery);