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
        <meta name="keywords" content="G.A.S.M Public School, G.A.S Public school,GASM Public School, GAS School, GAS Memorial School,G.A.S Memorial School,G.A.S Memorial Public College,G.A.S.M Public College,Sipah Ibrahimabad ,School in Sipah Ibrahimabad,College in Sipah Ibrahimabad, Madhuban, Mau, School in Mau,Ghulam Akram Siddiqui, Ghulam Sabir Siddiqui,Pradhan Sipah Ibrahimabad,Madarsa in Sipah Ibrahimabad,Dr Sabir Siddiqui,Dr Sabir,Noman akhtar" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--fonts-->
        <link href='//fonts.googleapis.com/css?family=Arimo:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Raleway:400,700,800,600,500' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Montserrat' rel='stylesheet' type='text/css'>
        <!--start-smoth-scrolling-->
        <script src="js/bootstrap.js"></script>
        <script src="comment/comment.js"></script>

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
                <h2 > <a href='<c:url value='/'/>'>Home</a> / <span>FAQ's </span></h2>
            </div>
        </div>
        <div class="container">
            <div class="single">
                <a href="#"><img class="img-responsive" src="images/ss.jpg" alt=" "></a>
                <div class=" single-grid">
                    <h4>SED LOREET ALIQUAM LEOTELLUS DOLOR DAPIBUS</h4>				
                    <ul class="blog-ic">
                        <li><a href="#"><span> <i  class="glyphicon glyphicon-user"> </i>Super user</span> </a> </li>
                        <li><span><i class="glyphicon glyphicon-time"> </i>June 14, 2013</span></li>		  						 	
                        <li><span><i class="glyphicon glyphicon-eye-open"> </i>Hits:145</span></li>
                    </ul>		  						
                    <p>Cras consequat iaculis lorem, id vehicula erat mattis quis. Vivamus laoreet velit justo, in ven e natis purus pretium sit amet. Praesent lectus tortor, tincidu nt in consectetur vestibulum, ultrices nec neque. Praesent nec sagittis mauris. Fusce convallis nunc neque. Integer egestas aliquam interdum. Nulla ante diam, interdum nec tempus eu, feugiat vel erat. Integer aliquam mi quis accum san porta.
                        Quisque nec turpis nisi. Proin lobortis nisl ut orci euismod, et lobortis est scelerisque. Sed eget volutpat ipsum. Integer fring illa leo porttitor, ultrices quam non, lobortis ligula. Aliquam vel consequat arcu.</p>
                    <p>On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish.
                        On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish.</p>
                </div>
                <div  class="comments" id="commentContainer" style="background-color: yellow;">
                    <h3>Comments</h3>
                    <div class="media1">
                        <div class="media-body">
                            <h4 class="media-heading">	Richard Spark</h4>
                            <h6>11/OCT/2015 at 21:20:25 on Sunday</h6>
                            <p>On the other hand, we denounce with righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs .  </p>
                        </div>
                        <div class="media-right">
                            <a href="#">
                                <img src="images/si.png" alt=""> </a>
                        </div>
                    </div>
                    <div class="media" id="media2">
                        <div class="media-left">
                            <a href="#">
                                <img src="images/si.png" alt="">
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading">Joseph Goh</h4>
                            <h6>11/OCT/2015 at 21:20:25 on Sunday</h6>
                            <p>to ensue; and equal blame belongs .  </p>
                        </div>

                    </div>
                    <li style="text-align: center;list-style: none;margin-top: 40px;bottom: 0;">
                        <ul style="margin: 0;padding: 0;background-color: red;">
                            <a   data-hover="Text" style="text-align: center;float: left"><h4><i class="glyphicon glyphicon-chevron-left"> </i>Back</h4></a>
                            <a   data-hover="Text" style="text-align: center;float: right;"><h4>Load more <i class="glyphicon glyphicon-chevron-right"> </i></h4></a>
                        </ul>
                    </li>
                </div>
                <div class="comment-bottom">
                    <h3>Leave a Comment</h3>
                    <form id="commentForm">	
                        <input type="text" placeholder="Name" name="commentName" required="">
                        <input type="text" placeholder="Email" name="commentEmail" required="">
                        <input type="text" placeholder="Subject" name="commentSubject" required="">

                        <textarea  placeholder="Message" name="commentMessage" required=""></textarea>
                        <label class="hvr-rectangle-out">
                            <input type="button" value="Send" id="commentSubmit">
                        </label>
                        <div id="commentResponse" style="height: 40px;width: 100%;background-color: yellow;margin-top: 5%;"></div>
                    </form>

                </div>
            </div>	
        </div>		

        <!--footer-->
        <%@include file="/WEB-INF/JSPF/footer.jspf" %>
        <!--//footer-->
    </body>
</html>