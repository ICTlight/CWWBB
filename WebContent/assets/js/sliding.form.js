$(function() {
        	document.getElementById('personal').style.backgroundImage = 'url(<%=request.getContextPath() %>/assets/img/right.png)';
        	var fieldsetCount = $('#formElem').children().length;
        	var current = 1;
        	var stepsWidth	= 0;
            var widths	= new Array();
        	$('#steps .step').each(function(i){
                var $step = $(this);
        		widths[i] = stepsWidth;
                stepsWidth += $step.width();
            });
        	$('#steps').width(stepsWidth);
        	$('#formElem').children(':first').find(':input:first').focus();	
        	
        	$('#renavigation').show();
            $('#tonext').bind('click',function(e){
        		var $this	= $(this);
        		current = document.getElementById("currentpage").value;
        		var prev	= current;
        		$this.closest('ul').find('li').removeClass('selected');
                $this.parent().addClass('selected');
                if(parseInt(current)<4){
        			current = parseInt(current) + 1;
                }else{
                	current = parseInt(current);
                }
        		document.getElementById("currentpage").value = current;
        		
        		if(current !=1){
            		document.getElementById("goback").style.display="";      		  
            	}else{
            		document.getElementById("goback").style.display="none";
            	}
                $('#steps').stop().animate({
                    marginLeft: '-' + widths[current-1] + 'px'
                },500,function(){
        			if(current == fieldsetCount)
        				validateSteps();
        			else
        				validateStep(prev);
        			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
        		});
                e.preventDefault();
            });
        	
            $('#skipdetail').bind('click',function(e){
            	current = 3;
        		var prev	= current;
        		$('#detail').removeClass('selected');
        		current = 4;
        		document.getElementById("currentpage").value = current;
        		
                $('#steps').stop().animate({
                    marginLeft: '-' + widths[current-1] + 'px'
                },500,function(){
        			if(current == fieldsetCount)
        				validateSteps();
        			else
        				validateStep(prev);
        			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
        		});
                e.preventDefault();
            });  
            
             $('#goback').bind('click',function(e){
        		var $this	= $(this);
        		current = document.getElementById("currentpage").value;
        		var prev	= current;
        		$this.closest('ul').find('li').removeClass('selected');
                $this.parent().addClass('selected');
                if(parseInt(current)>1){
        			current = parseInt(current) - 1;
                }else{
                	current = parseInt(current);
                }
        		
        		document.getElementById("currentpage").value = current;
        		
        		if(current !=1){
            		document.getElementById("goback").style.display="";      		  
            	}else{
            		document.getElementById("goback").style.display="none";
            	}
                $('#steps').stop().animate({
                    marginLeft: '-' + widths[current-1] + 'px'
                },500,function(){
        			if(current == fieldsetCount)
        				validateSteps();
        			else
        				validateStep(prev);
        			$('#formElem').children(':nth-child('+ parseInt(current) +')').find(':input:first').focus();	
        		});
                e.preventDefault();
            });  
        	
        	$('#formElem > fieldset').each(function(){
        		var $fieldset = $(this);
        		$fieldset.children(':last').find(':input').keydown(function(e){
        			if (e.which == 9){
        				$('#renavigation li:nth-child(' + (parseInt(current)+1) + ') a').click();
        				$(this).blur();
        				e.preventDefault();
        			}
        		});
        	});
        	
        	function validateSteps(){
        		var FormErrors = false;
        		for(var i = 1; i < fieldsetCount; ++i){
        			var error = validateStep(i);
        			if(error == -1)
        				FormErrors = true;
        		}
        		$('#formElem').data('errors',FormErrors);	
        	}
        	
        	function validateStep(step){
        		if(step == fieldsetCount) return;
        		
        		var error = 1;
        		var hasError = false;
        		$('#formElem').children(':nth-child('+ parseInt(step) +')').find(':input:not(button)').each(function(){
        			var $this 		= $(this);
        			var valueLength = jQuery.trim($this.val()).length;
        			
        			if(valueLength == ''){
        				hasError = true;
        				$this.css('background-color','#FFEDEF');
        			}
        			else
        				$this.css('background-color','#FFFFFF');	
        		});
        		var $link = $('#renavigation li:nth-child(' + parseInt(step) + ') a');
        		$link.parent().find('.error,.checked').remove();
        		
        		var valclass = 'checked';
        		if(hasError){
        			error = -1;
        			valclass = 'error';
        		}
        		$('<span class="'+valclass+'"></span>').insertAfter($link);
        		
        		return error;
        	}
        	
        	$('#registerButton').bind('click',function(){
        		if($('#formElem').data('errors')){
        			alert('Please correct the errors in the Form');
        			return false;
        		}	
        	});
        });
        