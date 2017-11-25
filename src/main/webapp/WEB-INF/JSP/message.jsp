<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- 
Author: akhtar
Author URL: http://multikbis.com
Date : 20 June 2016
-->
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
                <h2 > <a href="<c:url value='/'/>">Home</a> / <span>Message </span></h2>	
            </div>
        </div>
        <!--content-->
        <div class="about">
            <div class="container">
                <div class="about-top">
                    <div class="col-md-4 red">
                        <a href="faq.html"><img class="img-responsive" src="images/ab.jpg" alt=""></a>
                        <div id="message" class="alert alert-info" >
                        </div>
                    </div>
                    <div class="col-md-8 come">
                        <div class=" about-wel">
                            <h5><a href="faq.html">FOUNDER PRESIDENT'S MESSAGE &nbsp;&nbsp;(Founder GAS Group)</a></h5>
                            <p>Children are the centre of universe, their welfare and happiness must be our ultimate goal. Education is a tool that can empower our children to change the destiny of a nation. We felt the need to have this right kind of education at GASMPS, that provides global outlook with roots firmly embedded in our culture.

                                GAS Memorial Public School Path under the GAS Social Trust has a legacy of its own in the field of education, it will not only provide quality education par excellence but will also create a platform for positive, progressive likeminded people to converge and create. <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;The central conception of education in India has been that it is the source of illumination guiding us in all spheres of life. It takes into account the entire sphere of life giving a sense of perspective and proportion.

                                We have set very high goals and standards for our institution .Each and every student will be provided with opportunity to realize his or her potential by focussing on individual differences and right frequency between teacher and the taught. The education imparted must ensure students learn how to think rather than what to think. Education is about the total configuration of ideas, practices and conduct.

                                As Dr. Abdul Kalam said "I have three visions for India, Freedom, Development and Strength. Our students will imbibe these qualities in the conducive environment created at school and train to be competent professionals, responsible citizens and future world leaders."</p>
                            <p>Our aim is to focuses on:</p>
                            <ul>
                                <li><a href="#"><i class="glyphicon glyphicon-ok"></i>Values of honesty, compassion, tolerance and respect for others.</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-ok"></i>Development of democratic and secular values.</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-ok"></i>Respect for our country's rich and varied heritage and a sense of national pride.</a></li>
                                <li><a href="#"><i class="glyphicon glyphicon-ok"></i>Learning to contribute to humanity through cooperative efforts.</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="clearfix"> </div>
                </div>
            </div>
            <!---->
            <div class="middle-content">
                <div class="container">
                    <div class="middle-content1">
                        <h3>"The best preparation for tomorrow is doing your best today!"</h3>			
                    </div>
                </div>
            </div>
            <!--//-->
            <div class="container">
                <div class="about-top">
                    <div class="col-md-4 red">
                        <a href="faq.html"><img class="img-responsive" src="images/ab.jpg" alt=""></a>
                        <div id="message" class="alert alert-info" >
                            <strong style="text-align: center;">Dr. Yahiya Siddiqui </strong>
                        </div>
                    </div>
                    <div class="col-md-8 come">
                        <div class=" about-wel">
                            <h5><a href="faq.html">CHAIRPERSON'S MESSAGE &nbsp;&nbsp;(Chairman GAS Group)</a></h5>
                            <p>The singular aim at GAS Memorial Public School, is to inspire and nurture the physical and mental need of every child and set him on a path of success for his lifetime. We know this is most likely to happen in an environment that is happy, positive, secure, supportive and conducive to his learning. 

                                At GASMPS, Sipah Ibrahimabad, the infrastructure, the facilities and the compassionate and supportive team of teachers ensures that each and every child realizes his true potentials and work towards it for his future. 

                                It is our utmost responsibility to do everything we can to ensure that all children in our care have a positive and a supportive experience, where they can enthusiastically explore the wide learning opportunities offered inside our classrooms and beyond. This not only encompasses a challenging academic program, but also the development of good character, respect for elders, an appreciation of the fine arts, a curiosity about the world, a passion for knowledge, an understanding of technology, and a commitment to make the world and the society a better place.



                                <br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; "We are a community who believes that education is the key to success in preparing for the future.” I strongly feel that education is the breath of a society and it is only holistic education that can ensure the education of body, mind and soul which is the need of the day. I am proud that in today's changing world, we at GASMPS teach our children the maturity of judgement to handle the challenges of growing up and working in a world where skills are as important as knowledge and where success emanates from a solid foundation.</p>
                        </div>
                    </div>

                    <div class="clearfix"> </div>
                </div>
            </div>
        </div>


        <!--//content-->
        <!--footter-->
        <%@include file="/WEB-INF/JSPF/footer.jspf" %>
        <!--//footter-->
    </body>
</html>