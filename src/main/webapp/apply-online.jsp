<%-- 
    Document   : apply-online
    Created on : Aug 15, 2016, 3:25:06 PM
    Author     : akhtar
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>G.A.S Memorial Public School</title>
<LINK REL="SHORTCUT ICON" href="images/logo.png">
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<script src="applyonline/applyonline.js"></script>
<script src="js/subscriber.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/common.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="G.A.S.M Public School, G.A.S Public school,GASM Public School, GAS School, GAS Memorial School,G.A.S Memorial School,G.A.S Memorial Public College,G.A.S.M Public College,Sipah Ibrahimabad ,School in Sipah Ibrahimabad,College in Sipah Ibrahimabad, Madhuban, Mau, School in Mau,Ghulam Akram Siddiqui, Ghulam Sabir Siddiqui,Pradhan Sipah Ibrahimabad,Madarsa in Sipah Ibrahimabad,Dr Sabir Siddiqui,Dr Sabir,Noman" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<!--fonts-->
<link
	href='//fonts.googleapis.com/css?family=Arimo:400,400italic,700,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Raleway:400,700,800,600,500'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat'
	rel='stylesheet' type='text/css'>
<!--start-smoth-scrolling-->
<link rel="stylesheet" href="applyonline/formoid-solid-green.css"
	type="text/css" />
<script type="text/javascript" src="applyonline/formoid-solid-green.js"></script>
</head>
<body>

	<!---pop-up-box---->
	<link href="css/popuo-box.css" rel="stylesheet" type="text/css"
		media="all" />
	<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
	<div id="small-dialog" class="mfp-hide">
		<div class="search-top">
			<div class="login">
				<input type="button" value=""> <input type="text"
					value="Search.." onfocus="this.value = '';"
					onblur="if (this.value == '') {
                                this.value = 'Search..';
                            }">
			</div>
			<p>Education</p>
		</div>
	</div>
	<script>
		$(document).ready(function() {
			$('.popup-with-zoom-anim').magnificPopup({
				type : 'inline',
				fixedContentPos : false,
				fixedBgPos : true,
				overflowY : 'auto',
				closeBtnInside : true,
				preloader : false,
				midClick : true,
				removalDelay : 300,
				mainClass : 'my-mfp-zoom-in'
			});

		});
	</script>
	<!--End of pop-up-->

	<!--//header-->
	<%@include file="WEB-INF/JSPF/header.jspf"%>
	<!-- End of header-->

	<!--banner-->
	<div class="head">
		<div class="container">
			<h2>
				<a href="index.html">Home</a> / <span>Apply Online </span>
			</h2>
		</div>
	</div>
	<!--contact-->
	<div class="contact">
		<div class="container" style="width: 80%;">
			<form:form id="applyForm" modelAttribute="user"  action="ApplyOnline"
				enctype="multipart/form-data" class="formoid-solid-green"
				style="background-color: #ffffff; font-size: 14px; font-family: 'Roboto', Arial, Helvetica, sans-serif; color: #34495E; max-width: 550px; min-width: 150px"
				method="get">
				<div class="title">
					<h2>Admission Form</h2>
				</div>
				<div class="element-name">
					<label class="title"><span class="required">*</span></label><span
						class="nameFirst"><form:input  placeholder=" First Name" 
						type="text" path="applyFirstName" size="15" maxlength="50" name="applyFirst"
						required="required"
						pattern="^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$" /><span
						class="icon-place"></span></span><span class="nameLast"><form:input
						placeholder=" Last Name" type="text" path="applyLastName" maxlength="50" size="15"
						name="applyLast" pattern="^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$" /><span
						class="icon-place"></span></span>
				</div>
				<div class="element-input">
					<label class="title"><span class="required">*</span></label>
					<div class="item-cont">
						<form:input class="large" type="text" path="applyFather" maxlength="50" name="applyFather"
							required="required" placeholder="Father's Name"
							pattern="^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$" /><span
							class="icon-place"></span>
					</div>
				</div>
				<div class="element-input">
					<label class="title"><span class="required">*</span></label>
					<div class="item-cont">
						<form:input class="large" type="text" path="applyMother"  maxlength="50" name="applyMother"
							required="required" placeholder="Mother's Name"
							pattern="^[A-Za-z\s]{1,}[\.]{0,1}[A-Za-z\s]{0,}$" /><span
							class="icon-place"></span>
					</div>
				</div>
				<div class="element-date">
					<label class="title"><span class="required">*</span></label>
					<div class="item-cont">
						<form:input class="large" data-format="yyyy-mm-dd" type="date" path="applyDob"
							name="applyDate" required="required" placeholder="Date of Birth" /><span
							class="icon-place"></span>
					</div>
				</div>
				<div class="element-phone">
					<label class="title"><span class="required">*</span></label>
					<div class="item-cont">
						<form:input class="large" type="tel" path="applyMobile" maxlength="10"
							pattern="[+]?[\.\s\-\(\)\*\#0-9]{3,}" name="applyMobile"
							required="required" placeholder="Parent's Mobile Number" value="" /><span
							class="icon-place"></span>
					</div>
				</div>
				<div class="element-email">
					<label class="title"></label>
					<div class="item-cont">
						<form:input class="large" type="email" path="applyEmail" maxlength="100"
							name="applyEmail" value="" placeholder="Email" /><span
							class="icon-place"></span>
					</div>
				</div>
				<div class="element-radio">
					<label class="title">Gender<span class="required">*</span></label>
					<div class="column column2">
						<label><form:input type="radio" path="applyGender" name="applyGender"
							value="Female" required="required" /><span>Female</span></label>
					</div>
					<div class="column column2">
						<label><form:input type="radio" path="applyGender" name="applyGender" value="Male"
							required="required" /><span>Male</span></label>
					</div>
				</div>
				<div class="element-address">
					<label class="title"><span class="required">*</span></label><span
						class="addr1"><form:input placeholder="Street Address"
						type="text" path="applyStreet" maxlength="200" name="applyStreet" required="required"
						pattern="^[a-zA-Z0-9@\\-_,/. ]*$" /><span class="icon-place"></span></span><span
						class="addr2"><form:input placeholder="Address Line 2"
						type="text" path="applyLine2" maxlength="200" name="applyLine2"
						pattern="^[a-zA-Z0-9@\\-_,/. ]*$" /><span class="icon-place"></span></span><span
						class="city"><form:input placeholder="City" type="text" path="applyCity"
						maxlength="200" name="applyCity" /><span class="icon-place"></span></span><span
						class="state"><form:input
						placeholder="State / Province / Region" type="text" path="applyState"
						maxlength="200" name="applyState" required="required"
						pattern="^[a-zA-Z0-9@\\-_,/. ]*$" /><span class="icon-place"></span></span><span
						class="zip"><form:input placeholder="Postal / Zip Code"
						type="text" path="applyZip" maxlength="6" name="applyZip" required="required"
						pattern="^[0-9]{6}$" /><span class="icon-place"></span></span>
					<div class="country">
						<select name="applyCountry" required="required"><option
								selected="selected" value="" disabled="disabled">--- Select a country ---</option>
							<option value="United States">United States</option>
							<option value="United Kingdom">United Kingdom</option>
							<option value="Australia">Australia</option>
							<option value="Indonesia">India</option></select><i></i><span
							class="icon-place"></span>
					</div>
				</div>
				<div class="element-file">
					<label class="title"></label>
					<div class="item-cont">
						<label class="large"><div class="button">Choose File</div>
							<input type="file" class="file_input" name="file" />
							<div class="file_text">Upload Your Transfer Certificate</div> <span
							class="icon-place"></span></label>
					</div>
				</div>
				<div class="submit">
					<input type="submit" id="applySubmit" value="Submit" />
				</div>
				<div id="applyResponse" style="height: 40px; width: 90%;">
					<c:if test="${requestScope.applyValidFlag == 'false'}">
						<c:if test="${requestScope.applyValid == 'true'}">
							<div class='alert alert-success' role='alert'>${requestScope.applyMsg}</div>
						</c:if>
						<c:if test="${requestScope.applyValid == 'false'}">
							<div class='alert alert-danger' role='alert'>${requestScope.applyMsg}</div>
						</c:if>
					</c:if>
				</div>
			</form:form>
			<div class="col-sm-4" style="float: right; width: 40%;">
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Documents required</h3>
					</div>
					<div class="panel-body">Photocopy of Birth certificate.</div>
					<div class="panel-body">For class II and above photocopy of
						previous 3 years report cards.</div>
					<div class="panel-body">For class II and above, transfer
						certificate to be provide at the time of admission(if applicable).
					</div>
					<div class="panel-body">Passport size photographs (Five of
						the student & one each of the parents).</div>
					<div class="panel-body">Incomplete or illegible Registration
						Forms, without photograph will not be accepted.</div>
					<div class="panel-body">Address Proof of Parents.</div>
					<div class="panel-body">
						<hr />
						Partially genrated form is to be Filled by Student/Parents and
						need to submit in school before last date of admission.
					</div>
				</div>
			</div>
			<!-- /.col-sm-4 -->
			<!-- Stop Formoid form-->
		</div>

	</div>

	<!--//contact-->
	<!--footer-->
	<div class="footer">
		<div class="footer-mid">
			<div class="container">
				<div class="col-sm-3 ft-grid1">
					<h3>Location</h3>
					<p>Sipah Ibrahimabad,</p>
					<p>Madhuban, Mau (U.P)</p>
					<p>Mob : +91 945 458 2817</p>
				</div>
				<div class="col-sm-3 ft-grid2">
					<h3>Follow Us</h3>
					<ul class="social-in">
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="twitter"> </i></a></li>
						<li><a href="#"><i class="dribbble"> </i></a></li>
					</ul>
				</div>
				<div class="col-sm-6 ft-grid1">
					<h3>Newsletter</h3>
					<form id="subscribeForm">
						<input type="text" value="" name="subscribeEmail"
							placeholder="Enter email address" onfocus="this.value = '';"
							onblur="if (this.value == '') {
                                        this.value = '';
                                    }"
							required=""> <input type="button" id="subscribeSubmit"
							value="Subscribe">

					</form>
					<div id="subscribeResponse"></div>

				</div>
				<div class="clearfix"></div>
			</div>
		</div>
		<div class="class-footer">
			<div class="container">
				<div class="col-md-6 footer-nav">
					<ul>
						<li><a href="index.html">Home</a></li>
						<li><a href="team.html">About</a></li>
						<li><a href="services.html">Services</a></li>
						<li><a href="gallery.html">Gallery</a></li>
						<li><a href="codes.html"> Short Codes</a></li>
						<li><a href="contact.html">Contact</a></li>

					</ul>
				</div>
				<div class="col-md-6 footer-grid">
					<p>
						© 2016 GASMPS. All rights reserved | Design by <a
							href="https://www.linkedin.com/in/noman-akhtar-a37192b7/"
							target="_blank">akhtar</a>
					</p>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!--//footer-->
</body>
</html>