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
            <h2 > <a href="index.html">Home</a> / <span>Contact </span></h2>
         </div>
      </div>
      <!--contact-->
      <div class="contact" >
         <div class="container">
            <div class="contact-grids" >
               <div class="contact-form">
                  <h3>Contact Form</h3>
                  <form:form id="contactForm" method="POST" modelAttribute="tblContact" action="contact" >
                     <div class="col-md-6 contact-bottom">
                        <div class=" in-contact">
                           <form:input  type="text" path="contactName" placeholder="Name" required="" maxlength="100"/>
                        </div>
                        <div class=" in-contact">
                           <form:input type="text" path="contactEmail"  placeholder="Email" required="" maxlength="100"/>
                        </div>
                        <div class=" in-contact">
                           <form:input type="text" path="contactMobile" placeholder="Mobile Number" required="" maxlength="10"/>
                        </div>
                     </div>
                     <div class="col-md-6 contact-bottom-top">
                        <form:textarea path="contactMessage" placeholder="Message"  required="" maxlength="1500"></form:textarea>								
                     </div>
                     <div class="clearfix"> </div>
                     <div class="send-top">
                        <label class="hvr-rectangle-out">
                        <input type="button" value="Send" id="contactSubmit" >
                        <script>
                        $('#contactSubmit').on('click',function(){
                            $('#contactForm').submit();
                        });
                        </script>
                        </label>
                     </div>
                  </form:form>
                  <div class="send-top" id="contactResponse">
                  <c:set var="object" value="${res}" />
                  <c:choose>
                  <c:when test="${empty object}"></c:when>
                  <c:otherwise>
                  	<c:choose>
                  		<c:when test="${object.status}">
                  			<div class='alert alert-success' role='alert' style='text-align: center;'> <strong>Thank you! ${object.message}</strong></div>
                  		</c:when>
                  		<c:otherwise>
                  			<div class='alert alert-danger' role='alert' style='text-align: center;'><strong>Oh snap! ${object.message}</strong> </div>
                  		</c:otherwise>
                  	</c:choose>
                  </c:otherwise>
                  </c:choose>
                  </div>
               </div>
               <div class="address">
                  <div class=" address-more">
                     <h3>Address</h3>
                     <div class="col-md-4 address-grid">
                        <i class="glyphicon glyphicon-map-marker"></i>
                        <div class="address1">
                           <p>G.A.S.M Public School</p>
                           <p>Sipah Ibrahimabad,</p>
                           <p>Madhuban, Mau</p>
                           <p>U.P (221603)</p>
                        </div>
                        <div class="clearfix"> </div>
                     </div>
                     <div class="col-md-4 address-grid ">
                        <i class="glyphicon glyphicon-phone"></i>
                        <div class="address1">
                           <p>+91 945 458 2817</p>
                        </div>
                        <div class="clearfix"> </div>
                     </div>
                     <div class="col-md-4 address-grid ">
                        <i class="glyphicon glyphicon-envelope"></i>
                        <div class="address1">
                           <p><a href="mailto:info@gasmps.in">info@gasmps.in</a></p>
                        </div>
                        <div class="clearfix"> </div>
                     </div>
                     <div class="clearfix"> </div>
                  </div>
               </div>
               <div class=" map">
               		<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d209010.70700362526!2d83.55990013991277!3d26.13142847677207!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x39922907c19184fb%3A0x1cbbb44feb09fe8d!2sG.A.S+Memorial+Public+School!5e0!3m2!1sen!2sin!4v1475172086764" width="600" height="450" frameborder="0" style="border:0" allowfullscreen></iframe>
               </div>
            </div>
         </div>
      </div>
      <!--//contact-->
      <!--footer-->
      <%@include file="/WEB-INF/JSPF/footer.jspf" %>
      <!--//footer-->
   </body>
</html>