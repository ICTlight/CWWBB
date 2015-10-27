<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<%session = request.getSession();   %>
 	<!-- <h1 id="usertype" style="display:none" ><%=session.getAttribute("usertype")%></h1>
	<h1 id="userid" style="display:none" ><%=session.getAttribute("userid")%></h1>
	<h1 id="username" style="display:none" ><%=session.getAttribute("username")%></h1>
	<h1 id="status" style="display:none" ><%=session.getAttribute("status")%></h1>
	<h1 id="email" style="display:none" ><%=session.getAttribute("email")%></h1>  -->
	<a id="tomypage" href="/CWWBB/jsp/mypage.jsp" style="display:none"></a>
	        <div class="box">
            <div id="logo"><img src="<%=request.getContextPath() %>/assets/img/fesco90.png" alt="logo" /><a id="logotorefresh" href="/CWWBB/jsp/firstpage.jsp"></a></div>
            <div class="mobile-nav">
                <span class="hamburger"></span>
                <div class="nav-page">
                    <ul>
                        <li><a href="">产品介绍</a>
                            <ul>
                                <li><a href="/CWWBB/jsp/firstpage.jsp#planAndTrack1">产品1</a></li>
                                <li><a href="/CWWBB/jsp/firstpage.jsp#planAndTrack2">产品2</a></li>
                                <li><a href="/CWWBB/jsp/firstpage.jsp#planAndTrack3">产品3</a></li>
                            </ul>
                        </li>
                        <li><a href="">服务支持</a></li>
                        <li><a href="">移动版</a></li>
                        <li><a href="">FAQ</a></li>
                        <li><a href="">注册</a></li>
                        <li><a href="">登陆</a></li>
                        
                    </ul>
                </div>
            </div>
            <div id="mainNav">
                <ul>
                    <li>
                        <a href="" >产品介绍</a>
                        <nav role="renavigation">
                            <section id="subnavProducts" class="sectionWrap wac-subnav">
                                <div class="grid grid-4 flush-bottom">
                                    <div class="column colspan-1 subnav-drawer-column">
                                        <a href="/CWWBB/jsp/firstpage.jsp#planAndTrack1">
                                            <span>产品1</span><span>薪酬服务</span></a>
                                    </div>
                                    <div class="column colspan-1 subnav-drawer-column">
                                        <a href="/CWWBB/jsp/firstpage.jsp#planAndTrack2">
                                            <span>产品2</span><span>税务服务</span></a>
                                    </div>
                                    <div class="column colspan-1 subnav-drawer-column">
                                        <a href="/CWWBB/jsp/firstpage.jsp#planAndTrack3">
                                            <span>产品3</span><span>财务外包系统平台</span></a>
                                    </div>
                                </div>
                            </section>
                        </nav>
                    </li>
                    <li><a href="" >服务支持</a></li>
                    <li><a href="" >移动版</a></li>
                    <li><a href="" >FAQ</a></li>
                </ul>
            </div>
            <div id="usersNav" >
                <ul>              	
                    <li><a href="/CWWBB/jsp/regist.jsp" >注册</a></li>
                    <li><a href="/CWWBB/jsp/login.jsp" >登陆</a></li>                  
                </ul>
            </div>
        </div>
</body>
</html>