<!-- 
Author: akhtar
Author URL: http://multikbis.com
Date : 20 June 2016
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
      <script src="js/jquery.chocolat.js"></script>
      <link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen" charset="utf-8">
      <!--light-box-files -->
      <script type="text/javascript" charset="utf-8">
         $(function () {
             $('.gallery-top a').Chocolat();
         });
      </script>
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
      <%@include file="/WEB-INF/JSPF/index-header.jspf" %>
      <!-- End of header-->
      <!--banner-->
      <div class="head">
         <div class="container">
            <h2 > <a href="index.html">Home</a> / <span>Gallery </span></h2>
         </div>
      </div>
      <!--galllery-->
      <div class="gallery">
         <div class="container">
            <div class="grid">
               <c:set var = "object" value="${res}"/>
               <c:choose>
                  <c:when test="${empty object}"></c:when>
                  <c:otherwise>
                     <c:forEach var="data" items="${object}">
                        <div class="gallery-grid">
                           <div class="col-sm-6 gallery-top">
                              <a href="data:image/jpeg;base64,${data[0]}" rel="title" class="b-link-stripe b-animate-go  thickbox">
                                 <figure class="effect-zoe">
                                    <img src="data:image/jpeg;base64,${data[0]}" alt="img25"/>
                                    <figcaption>
                                       <h3>${data[1]}</h3>
                                       <p class="icon-links">
                                          <span class="glyphicon glyphicon-heart"></span>
                                          <span class="glyphicon glyphicon-eye-open"></span>
                                       </p>
                                       <p class="description">${data[2]}</p>
                                    </figcaption>
                                 </figure>
                              </a>
                           </div>
                           <div class="col-sm-6 gallery-top">
                              <a href="data:image/jpeg;base64,${data[4]}" rel="title" class="b-link-stripe b-animate-go  thickbox">
                                 <figure class="effect-zoe">
                                    <img src="data:image/jpeg;base64,${data[4]}" alt="img25"/>
                                    <figcaption>
                                       <h3>${data[5]}</h3>
                                       <p class="icon-links">
                                          <span class="glyphicon glyphicon-heart"></span>
                                          <span class="glyphicon glyphicon-eye-open"></span>
                                       </p>
                                       <p class="description">${data[6]}</p>
                                    </figcaption>
                                 </figure>
                              </a>
                           </div>
                           <div class="clearfix"> </div>
                        </div>
                     </c:forEach>
                  </c:otherwise>
               </c:choose>
            </div>
         </div>
      </div>
      <!--//galllery-->
      <!--footter-->
      <%@include file="/WEB-INF/JSPF/footer.jspf" %>
      <!--//footter-->
   </body>
</html>