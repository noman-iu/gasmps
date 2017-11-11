<!-- 
Author: akhtar
Author URL: http://multikbis.com
Date : 20 June 2016
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <title>G.A.S Memorial Public School</title>
        <LINK REL="SHORTCUT ICON" href="images/logo.png">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <script src="js/subscribe.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/common.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="G.A.S.M Public School, G.A.S Public school,GASM Public School, GAS School, GAS Memorial School,G.A.S Memorial School,G.A.S Memorial Public College,G.A.S.M Public College,Sipah Ibrahimabad ,School in Sipah Ibrahimabad,College in Sipah Ibrahimabad, Madhuban, Mau, School in Mau,Ghulam Akram Siddiqui, Ghulam Sabir Siddiqui,Pradhan Sipah Ibrahimabad,Madarsa in Sipah Ibrahimabad,Dr Sabir Siddiqui,Dr Sabir,Noman" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='https://fonts.googleapis.com/css?family=Arimo:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Raleway:400,700,800,600,500' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
        <!--start-smoth-scrolling-->
        <script src="js/bootstrap.js"></script>

    </head>
    <body> 

        <!---pop-up-box---->					  
        <link href="css/popuo-box.css" rel="stylesheet" type="text/css" media="all"/>
        <script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
        <div id="small-dialog" class="mfp-hide" >
            <div class="search-top">
                <div class="login">
                    <input type="button" value="">
                    <input type="text" value="Search.." onfocus="this.value = '';" onblur="if (this.value == '') {
                                this.value = 'Search..';
                            }">		
                </div>
                <p>Education</p>
            </div>				
        </div>
        <script>
            $(document).ready(function () {
                $('.popup-with-zoom-anim').magnificPopup({
                    type: 'inline',
                    fixedContentPos: false,
                    fixedBgPos: true,
                    overflowY: 'auto',
                    closeBtnInside: true,
                    preloader: false,
                    midClick: true,
                    removalDelay: 300,
                    mainClass: 'my-mfp-zoom-in'
                });

            });
        </script>		
        <!--End of pop-up-->

        <!--//header-->
        <%@include file="/WEB-INF/JSPF/header.jspf" %>
        <!-- End of header-->

        <!--banner-->
        <div class="head">
            <div class="container">
                <h2 > <a href="<c:url value='/'/>">Home</a> / <span>Login</span></h2>
            </div>
        </div>
        <!--content-->
        <div class="container">
            <div class="page">
                <!--Forms-->
                <div class="bs-example" data-example-id="simple-horizontal-form">
                    <form:form class="form-horizontal" modelAttribute="tblLogin" action="login" method="POST">
                        <div class="form-group">
                            <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                            <div class="col-sm-10">
                                <form:input type="email" path="loginEmail" class="form-control" id="inputEmail3" placeholder="Email"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputPassword3" class="col-sm-2 control-label">Password</label>
                            <div class="col-sm-10">
                                <form:input type="password"  path="loginPassword" class="form-control" id="inputPassword3" placeholder="Password"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <div class="checkbox">
                                    <label>
                                        <input type="checkbox"> Remember me
                                    </label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" class="btn btn-default">Sign in</button>
                            </div>
                        </div>
                    </form:form>
                </div>
                <!--//forms-->
            </div>
        </div>

        <!--footer-->
        <%@include file="/WEB-INF/JSPF/footer.jspf" %>
        <!--//footer-->
    </body>
</html>