<%-- 
    Document   : index
    Created on : Jun 24, 2016, 12:53:42 AM
    Author     : akhtar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <title>G.A.S Memorial Public School</title>
        <LINK REL="SHORTCUT ICON" href="images/logo.png">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery.min.js"></script>
        <!-- Custom Theme files -->
        <!--theme-style-->
        <link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
        <!--//theme-style-->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="G.A.S.M Public School, G.A.S Public school,GASM Public School, GAS School, GAS Memorial School,G.A.S Memorial School,G.A.S Memorial Public College,G.A.S.M Public College,Sipah Ibrahimabad ,School in Sipah Ibrahimabad,College in Sipah Ibrahimabad, Madhuban, Mau, School in Mau,Ghulam Akram Siddiqui,Ghulam Sabir Siddiqui,Pradhan Sipah Ibrahimabad,Madarsa in Sipah Ibrahimabad,Dr Sabir Siddiqui,Dr Sabir,Noman" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!--flexslider-->
        <link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
        <!--//flexslider-->
        <link href='//fonts.googleapis.com/css?family=Arimo:400,400italic,700,700italic' rel='stylesheet' type='text/css'>
        <link href='//fonts.googleapis.com/css?family=Raleway:400,700,800,600,500' rel='stylesheet' type='text/css'>
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
        <!--banner-->
        <div class="banner">
            <!--//header-->
			<%@include file="/WEB-INF/JSPF/index-header.jspf" %>
            <!-- End of header-->

            <div class="container">
                <div class="slider" >
                    <section class="slider" >
                        <div class="flexslider" style="margin-top: 100px;">
                            <ul class="slides" >
                                <li>
                                    <div class="banner-matter">
                                        <!--<h3>Education is the movement from darkness to light</h3>-->
                                        <h3>You will never win if you never begin.</h3>
                                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised .There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised .</p>
                                        <a href="faq.html" class="hvr-rectangle-out">Read More</a>
                                    </div>
                                </li>
                                <li>
                                    <div class="banner-matter">
                                        <h3>Every exit is an entry somewhere else.</h3>
                                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised .</p>
                                        <a href="faq.html" class="hvr-rectangle-out">Read More</a>
                                    </div>
                                </li>
                                <li>
                                    <div class="banner-matter">
                                        <h3>If you can dream it, you can do it.</h3>
                                        <p>There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised .</p>
                                        <a href="faq.html" class="hvr-rectangle-out">Read More</a>
                                    </div>
                                </li>

                            </ul>
                        </div>
                    </section>

                    <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>
                    <!--FlexSlider-->
                    <script defer src="js/jquery.flexslider.js"></script>
                    <script type="text/javascript">
                        $(function () {
                            SyntaxHighlighter.all();
                        });
                        $(window).load(function () {
                            $('.flexslider').flexslider({
                                animation: "slide",
                                start: function (slider) {
                                    $('body').removeClass('loading');
                                }
                            });
                        });
                    </script>
                </div>
            </div>
        </div>
        <!--content-->
        <div class="content">
            <div class="container">
                <div class="col-top">
                    <h2>About</h2>
                    <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text</p>
                </div>
            </div>
            <div class="content-top">
                <div class=" col-md-3 grid-top">
                    <i class="glyphicon glyphicon-education"></i>
                    <div class="caption">
                        <h4>Contrary to popular</h4>
                        <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>
                    </div>
                </div>
                <div class=" col-md-3 grid-top">
                    <i class="glyphicon glyphicon-lamp"></i>
                    <div class="caption">
                        <h4>Lorem ipsum dolor</h4>
                        <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>
                    </div>
                </div>
                <div class=" col-md-3 grid-top">
                    <i class="glyphicon glyphicon-time "></i>
                    <div class="caption">
                        <h4>At vero eos </h4>
                        <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>				 
                    </div>
                </div>
                <div class=" col-md-3 grid-top">				
                    <i class="glyphicon glyphicon-hourglass"></i>
                    <div class="caption">
                        <h4>Sed ut perspiciatis</h4>
                        <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>
                    </div>
                </div>
                <div class="clearfix"> </div>	
            </div>
            <div class="content-middle">
                <div class="container">
                    <div class="col-mid">
                        <h3>Our School Services</h3>
                        <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text</p>
                    </div>
                    <div class="content-middle1">
                        <div class="col-md-4 content-middle2">
                            <a href="faq.html"><img src="images/pi.jpg " class="img-responsive" alt=""></a>
                            <div class="content-middle3">
                                <h4><a href="faq.html">It is a long established</a></h4>
                                <label></label>
                                <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>
                            </div>
                        </div>
                        <div class="col-md-4 content-middle2">
                            <a href="faq.html"><img src="images/pi1.jpg " class="img-responsive" alt=""></a>
                            <div class="content-middle3">
                                <h4><a href="faq.html">It is a long established</a></h4>
                                <label></label>
                                <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>
                            </div>
                        </div>
                        <div class="col-md-4 content-middle2">
                            <a href="faq.html"><img src="images/pi2.jpg " class="img-responsive" alt=""></a>
                            <div class="content-middle3">
                                <h4><a href="faq.html">It is a long established</a></h4>
                                <label></label>
                                <p> Lorem Ipsum is not simply random text. It has roots in a piece of classical </p>
                            </div>
                        </div>
                        <div class="clearfix"> </div>
                    </div>
                </div>
            </div>
            <!---->
            <div class="middle-content">
                <div class="container">
                    <div class="middle-content1">
                        <h3>"Excellence is continuous process, and not an accident!"</h3>			
                    </div>
                </div>
            </div>

            <!--event start-->
            <div class="event-news">
                <div class="container">
                    <div class="content-events">
                        <h3> Events &amp; News</h3>
                        <p>Be the part of following Events and makes our dream true</p>
                    </div>	
                    <div class="slider" >
                        <section class="slider" >
                            <div class="flexslider" style="margin-top: 50px;">
                                <ul class="slides" >
                                    <li>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                    <li>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-md-4 new-more">
                                            <div class="now-more1">
                                                <div class="event">
                                                    <h4>26/06/2015</h4>
                                                    <label></label>
                                                    <h6><a href="faq.html">Sed ut perspiciatis </a></h6>
                                                    <p>Kasertas lertyasea deeraeser miasera lertasa ritise doloert ferdas caplicabo nerafaes asety u lasec vaserat.</p>
                                                    <a href="faq.html" class="hvr-rectangle-out ">Read More</a>
                                                </div>
                                            </div>
                                        </div>
                                    </li>
                                </ul>
                            </div>
                        </section>

                        <script>window.jQuery || document.write('<script src="js/libs/jquery-1.7.min.js">\x3C/script>')</script>
                        <!--FlexSlider-->
                        <script defer src="js/jquery.flexslider.js"></script>
                        <script type="text/javascript">
                            $(function () {
                                SyntaxHighlighter.all();
                            });
                            $(window).load(function () {
                                $('.flexslider').flexslider({
                                    animation: "slide",
                                    start: function (slider) {
                                        $('body').removeClass('loading');
                                    }
                                });
                            });
                        </script>
                    </div>
                </div>
            </div>
        </div>
        <!--//content-->
        <!--footter-->
        <%@include file="/WEB-INF/JSPF/footer.jspf" %>
        <!--//footter-->
    </body>
</html>