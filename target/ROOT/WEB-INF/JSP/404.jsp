<!-- 
   Author: akhtar
   Author URL: http://multikbis.com
   Date : 20 June 2016
   -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
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
      <link rel="stylesheet" href="error/color-1.css">
      <link href="error/error.css" rel="stylesheet" type="text/css" media="all" />
      <link rel="stylesheet" href="./font-awesome.min.css">
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
      <!--status-404-->
      <main class="main-content section-padding white-bg" style="background-color: #f5f5f5;" >
         <!-- 404 Holder -->
         <div class="container" >
            <div class="error-holder">
               <div class="error-detail">
                  <img src="images/error.png" alt="404-error">
                  <h2>4<strong>0</strong>4</h2>
                  <p>Oops! The page you requested was not found!</p>
                  <div class="search-bar">
                     <input type="text" class="form-control" placeholder="Search Here">
                     <button type="button">
                     <span class="fa fa-paper-plane-o"></span>
                     </button>  
                  </div>
               </div>
            </div>
         </div>
         <!-- 404 Holder -->
      </main>
      <!--//status-404-->
      <!--footer-->
      <%@include file="/WEB-INF/JSPF/footer.jspf" %>
      <!--//footer-->
   </body>
</html>