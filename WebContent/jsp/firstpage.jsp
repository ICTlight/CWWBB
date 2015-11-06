<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0"/>
  <link href="<%=request.getContextPath() %>/bootstrap/css/bootstrap-3.0.3.min.css" rel="stylesheet" type="text/css"/>
  <script src="<%=request.getContextPath() %>/bootstrap/js/jquery-2.1.4.min.js"></script>
  <script src="<%=request.getContextPath() %>/bootstrap/js/bootstrap-3.0.3.min.js"></script> 
  <link rel="stylesheet" href="<%=request.getContextPath() %>/assets/css/jira.css" type="text/css" media="all">
  <script src="<%=request.getContextPath() %>/assets/js/1096093.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/atl-analytics.min.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/global.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/jquery-waypoints.js"></script>
  <script src="<%=request.getContextPath() %>/assets/js/product-tour-template.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/assets/js/conversion.js"></script>
  <title>财务外包--首页</title>    
    <style>
        @media only screen and (min-width : 992px) {
            .smartling-fr .product-intro .section-heading-text h3 {
                font-size: 28px;
                line-height: 1.2;
            }
            .smartling-fr .customer-logos-row .customer-logos__button {
                margin-top: 12px;
            }
            .smartling-fr .customer-logos__button .button {
                height: auto;
            }
            .smartling-fr .customer-logos__button .buttonTxt {
                line-height: 1.2;
                padding-top: 2px;
                padding-bottom: 2px;
            }
        }
    </style>

    
	<script>
    $(function() {
        var hamburgerButton = $('header .mobile-nav .hamburger'),
                navPage = $(hamburgerButton.next('.nav-page')),
                contentToHide = $('#header, #contentContainer'),
                activeMobileToggle = function(){
                    hamburgerButton.toggle(function() {
                        $(this).addClass('open');
                        navPage.show();
                        contentToHide.addClass('fixed').css({'top':'0'});
                    }, function() {
                        $(this).removeClass('open');
                        navPage.hide();
                        contentToHide.removeClass('fixed').css({'top':'auto'});
                    });
                };
        activeMobileToggle();
        if (window.matchMedia) {
            var screenWidth = window.matchMedia( "(max-width: 667px)");
            function WidthChange(screenWidth) {
                if (!screenWidth.matches) {
                    hamburgerButton.removeClass('open');
                    navPage.hide();
                    contentToHide.removeClass('fixed').css({'top':'auto'});
                }
            }
            screenWidth.addListener(WidthChange);
            WidthChange(screenWidth);
        }
    });
	</script>

	<script>
	function delprice(){
		var num = document.getElementById('usersSelectDropdown').value;
		document.getElementById('monthlyPrice').innerHTML=num;
	}
	</script>
</head>
<body id="products" class=" jira en">
<div id="container" class="container">
	<header id="header">
        <jsp:include page="/jsp/utils/head.jsp"></jsp:include>
    </header>
	<div id="contentContainer">
        <section id="productIntro" class="sectionWrap product-intro">
            <div class="grid grid-6 flush-bottom">
                <div class="column colspan-2 section-heading-text">
                    <img src="<%=request.getContextPath() %>/assets/img/fescoc.png" alt="" height="45"/>
                    <h3>财务外包系统 &nbsp;<small>承担客户薪酬管理中大量的事务性工作，以专业化的人员、运用高效的信息系统，实施最优的操作流程，为客户提供高质量的财务外包服务，帮助客户降低成本、分担风险、节省时间，提升员工满意度。</small></h3>
                    <div class="cta-link">
                        <a href="/CWWBB/jsp/regist.jsp" class="button standard">
                            <span class="buttonTxt">我要试</span>
                        </a>
                    </div>
                </div>
                <div class="column last colspan-4 product-intro__image">
                    <div class="video"><a class="embedVideoLink launchVideo videoLB" href="#" >财务外包系统</a></div>
                    <div class="overlay">
                        <span class="close"></span>
                        <iframe src="" frameborder="0" allowfullscreen=""></iframe>
                    </div>
                    <div class="linkImage product-intro__image--play-button videoPlayButton"><a href=""><img src="<%=request.getContextPath() %>/assets/img/start.png" alt="" height="115" /></a></div>
                    <div class="">
                        <div class="img-wrap">
                            <img src="<%=request.getContextPath() %>/assets/img/wall.jpg" alt="财务外包首页截图" />
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="navigation" class="sectionWrap product-navigation">
            <div class="grid grid-1 flush-bottom">
                <div class="column colspan-1 navigation">
                    <nav>
                        <ul>
                            <li class="listImage selected"><a href=""><img src="<%=request.getContextPath() %>/assets/img/fesco.png" alt="" height="48" /></a></li>
                            <li class="selected"><a href="#"><strong>产品特性</strong></a></li>
                            <li><a href="#pricingSection"><strong>价格</strong></a></li>
                            <li><a href="/CWWBB/jsp/regist.jsp" class="button buttonSm"><span class="buttonTxt">我要试</span></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </section>
        <section id="planAndTrack1" class="sectionWrap product-benefits product-benefits__intro">
        <br>      
            <div class="grid grid-6 flush-bottom">
                <div class="column last colspan-all section-heading-text center">
                    <h3>I  产品一--薪酬服务.</h3>
                    <p>为企业提供全面、专业、深入的薪酬外包服务，旨在为企业提供全方位的薪酬外包服务解决方案，并助力于方案的落地实施，从而协助企业规范操作流程、降低人工成本、分担潜在风险、实现企业效率最大化。</p>
                </div>
                <div class="column colspan-3 overflowing-image-column overflowing-image-column--flush-bottom">
                    <div class="">
                        <div class="img-wrap modal-image">
                            <img src="<%=request.getContextPath() %>/assets/img/wall.jpg" alt="财务外包--产品一" />
                        </div>
                    </div>
                </div>
                <div class="column last colspan-3 section-description-text">
                    <div class="">
                        <h4>特色一</h4>
                        <p>根据客户提供的工资数据，编制当月工资计算及汇总表，在客户指定工资发放日前将工资代发至员工指定工资账户.</p>
                    </div>
                    <div class="">
                        <h4>特色二</h4>
                        <p>依据客户财务制度提供行政费用报销服务 ，购买外汇，向外籍员工境外账户支付外币工资。</p>
                    </div>
                </div>
            </div>
        </section>
        
        <section id="planAndTrack2" class="sectionWrap product-benefits product-benefits__intro">
        <br>
            <div class="grid grid-6 flush-bottom">
                <div class="column last colspan-all section-heading-text center">
                    <h3>II  产品二--税务服务</h3>
                    <p>为企业提供全面、专业、深入的税务服务，旨在为企业提供全方位的税务服务解决方案，并助力于方案的落地实施，从而协助企业规范操作流程、降低人工成本、分担潜在风险、实现企业效率最大化.</p>
                </div>
                <div class="column colspan-3 overflowing-image-column overflowing-image-column--flush-bottom">
                    <div class="">
                        <div class="img-wrap modal-image">
                            <img src="<%=request.getContextPath() %>/assets/img/wall.jpg" alt="财务外包--产品一" />
                        </div>
                    </div>
                </div>
                <div class="column last colspan-3 section-description-text">
                    <div class="">
                        <h4>特色一</h4>
                        <p>依照税法的规定计算个人所得税，并完成个人所得税的明细及综合申报.</p>
                    </div>
                    <div class="">
                        <h4>特色二</h4>
                        <p>协助客户办理残保金申报及缴款工作，并为客户员工提供有关工资及个人所得税的答疑服务.</p>
                    </div>
                </div>
            </div>
        </section>
        
        <section id="planAndTrack3" class="sectionWrap product-benefits product-benefits__intro">
        <br>
            <div class="grid grid-6 flush-bottom">
                <div class="column last colspan-all section-heading-text center">
                    <h3>III  产品三--财务外包系统平台.</h3>
                    <p>为企业提供全面、专业、深入的财务外包服务，旨在为企业提供全方位的财务外包服务解决方案，并助力于方案的落地实施，从而协助企业规范操作流程、降低人工成本、分担潜在风险、实现企业效率最大化.</p>
                </div>
                <div class="column colspan-3 overflowing-image-column overflowing-image-column--flush-bottom">
                    <div class="">
                        <div class="img-wrap modal-image">
                            <img src="<%=request.getContextPath() %>/assets/img/wall.jpg" alt="财务外包--产品一" />
                        </div>
                    </div>
                </div>
                <div class="column last colspan-3 section-description-text">
                    <div class="">
                        <h4>特色一</h4>
                        <p>除了为客户提供完善的薪酬处理方案之外，还通过财务外包系统平台为客户提供工资数据的智能处理.</p>
                    </div>
                    <div class="">
                        <h4>特色二</h4>
                        <p>通过系统平台安全、准确、计算高效的优势；为客户提供全面的薪酬核算业务.</p>
                    </div>
                </div>
            </div>
        </section>
        
        <section id="pricingSection" class="sectionWrap pricing-section">
            <div class="grid grid-6">
                <div class="column colspan-all center">
                    <h2>收费标准</h2>
                </div>
                <div id="smallTeamsPricing" class="column colpush colspan-2 price-block price-block--callout-tab center">
                    <h3>小团队</h3>
                    <h1><sup>￥</sup>50</h1> <p><span class="term-users">每月</span></p> <p><span class="term-users">少于10人</span></p>
                    
                    <div class="cta-link">
                    <br>
                        <a href="/CWWBB/jsp/regist.jsp" class="button standard">
                        
                            <span class="buttonTxt">我要试</span>
                        </a>
                    </div>
                </div>
                <div id="largeTeamsPricing" class="column last colspan-2 price-block center">
                    <h3>大团队</h3>
                    <h1><sup>￥</sup><span id="monthlyPrice">75</span></h1> <p><span class="term-users">每月</span></p>
                    <div id="usersSelectContainer" class="">
                        <form>
                        <div class="col-md-4"></div>
                            <div class="users-select-dropdown input-group col-md-4">
                                <select id="usersSelectDropdown" class="form-control" onchange="delprice()">
                                    <option value="75">15 人</option>
                                    <option value="150">25 人</option>
                                    <option value="300">50 人</option>
                                    <option value="450">100 人</option>
                                    <option value="750">500 人</option>
                                    <option value="1500">2,000 人</option>
                                </select>
                            </div>
                           <div class="col-md-4"></div> 
                        </form>
                    </div>
                    <br>
                    <div class="cta-link"><br><a href="/CWWBB/jsp/regist.jsp" class="button standard"><span class="buttonTxt">我要试</span></a></div>                   
                </div>
            </div>
        </section>
    </div>
    <footer id="wac-desktop-footer" class="desktop-footer SL_swap" style="height:60px">
         <jsp:include page="/jsp/utils/foot.jsp"></jsp:include>
    </footer>
</div>
</body>
</html>