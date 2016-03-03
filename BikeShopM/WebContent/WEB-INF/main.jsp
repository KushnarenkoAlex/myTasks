<!DOCTYPE html>
<html>
<head>
<title>Bike Shop</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<script src="js/jquery.min.js"></script>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<link
    href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400'
    rel='stylesheet' type='text/css'>
<script src="js/jquery.easydropdown.js"></script>
<link href="css/nav.css" rel="stylesheet" type="text/css" media="all" />
<script src="js/scripts.js" type="text/javascript"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 900);
		});
	});
</script>


</head>
<body>
    <script src="js/responsiveslides.min.js"></script>
    <script>
					$(function() {
						$("#slider").responsiveSlides({
							auto : true,
							nav : true,
							speed : 500,
							namespace : "callbacks",
							pager : true,
						});
					});
				</script>
    <div class="banner-bg banner-bg1">
        <div class="container">
            <div class="header">
                <div class="logo">
                    <a href="index.html"><img src="images/logo.png"
                        alt="" /></a>
                </div>
                <div class="top-nav">
                    <label class="mobile_menu" for="mobile_menu">
                        <span>Menu</span>
                    </label> <input id="mobile_menu" type="checkbox">
                    <ul class="nav">
                        <li class="dropdown1"><a href="bikeList">BICYCLES</a></li>
                        <li class="dropdown1"><a
                            href="sign_up.html">MY ACCOUNT</a>
                            <ul class="dropdown2">
                                <li><a href="login">LOG IN</a></li>
                                <li><a href="register">SIGN UP</a></li>
                            </ul></li>
                        <a class="shop" href="cart.html"><img
                            src="images/cart.png" alt="" /></a>
                    </ul>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
        <div class="caption">
            <div class="slider">
                <div class="callbacks_container">
                    <ul class="rslides" id="slider">
                        <li><h1>HANDMADE BICYCLE</h1></li>
                        <li><h1>SPEED BICYCLE</h1></li>
                        <li><h1>MOUINTAIN BICYCLE</h1></li>
                    </ul>
                    <p>
                        You <span>create</span> the <span>journey,</span>
                        we supply the <span>parts</span>
                    </p>
                    <a class="morebtn" href="bicycles.html">SHOP
                        BIKES</a>
                </div>
            </div>
        </div>
        <div class="dwn">
            <a class="scroll" href="#cate"><img
                src="images/scroll.png" alt="" /></a>
        </div>
    </div>
    <div id="cate" class="categories">
        <div class="container">
            <h3>CATEGORIES</h3>
            <div class="categorie-grids">
                <a href="bicycles.html"><div
                        class="col-md-4 cate-grid grid1">
                        <h4>FIXED / SINGLE SPEED</h4>
                        <p>Are you ready for the 27.5 Revloution ?</p>
                        <a class="store" href="bicycles.html">GO TO
                            STORE</a>
                    </div></a> <a href="bicycles.html"><div
                        class="col-md-4 cate-grid grid2">
                        <h4>PREMIMUM SERIES</h4>
                        <p>Exclusive Bike Components</p>
                        <a class="store" href="bicycles.html">GO TO
                            STORE</a>
                    </div></a> <a href="bicycles.html"><div
                        class="col-md-4 cate-grid grid3">
                        <h4>CITY BIKES</h4>
                        <p>Street Playground</p>
                        <a class="store" href="bicycles.html">GO TO
                            STORE</a>
                    </div></a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="bikes">
        <h3>POPULAR BIKES</h3>
        <div class="bikes-grids">
            <ul id="flexiselDemo1">
                <li><img src="images/bik1.jpg" alt="" />
                    <div class="bike-info">
                        <div class="model">
                            <h4>
                                FIXED GEAR<span>$249.00</span>
                            </h4>
                        </div>
                        <div class="model-info">
                            <select>
                                <option value="volvo">OPTION</option>
                                <option value="saab">Option</option>
                                <option value="opel">Option</option>
                                <option value="audi">Option</option>
                            </select> <a href="bicycles.html">BUY</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="viw">
                        <a href="bicycles.html">Quick View</a>
                    </div></li>
                <li><img src="images/bik2.jpg" alt="" />
                    <div class="bike-info">
                        <div class="model">
                            <h4>
                                BIG BOY ULTRA<span>$249.00</span>
                            </h4>
                        </div>
                        <div class="model-info">
                            <select>
                                <option value="volvo">OPTION</option>
                                <option value="saab">Option</option>
                                <option value="opel">Option</option>
                                <option value="audi">Option</option>
                            </select> <a href="bicycles.html">BUY</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="viw">
                        <a href="bicycles.html">Quick View</a>
                    </div></li>
                <li><img src="images/bik3.jpg" alt="" />
                    <div class="bike-info">
                        <div class="model">
                            <h4>
                                ROCK HOVER<span>$300.00</span>
                            </h4>
                        </div>
                        <div class="model-info">
                            <select>
                                <option value="volvo">OPTION</option>
                                <option value="saab">Option</option>
                                <option value="opel">Option</option>
                                <option value="audi">Option</option>
                            </select> <a href="bicycles.html">BUY</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="viw">
                        <a href="bicycles.html">Quick View</a>
                    </div></li>
                <li><img src="images/bik4.jpg" alt="" />
                    <div class="bike-info">
                        <div class="model">
                            <h4>
                                SANSACHG<span>$249.00</span>
                            </h4>
                        </div>
                        <div class="model-info">
                            <select>
                                <option value="volvo">OPTION</option>
                                <option value="saab">Option</option>
                                <option value="opel">Option</option>
                                <option value="audi">Option</option>
                            </select> <a href="bicycles.html">BUY</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="viw">
                        <a href="bicycles.html">Quick View</a>
                    </div></li>
                <li><img src="images/bik5.jpg" alt="" />
                    <div class="bike-info">
                        <div class="model">
                            <h4>
                                JETT MAC<span>$340.00</span>
                            </h4>
                        </div>
                        <div class="model-info">
                            <select>
                                <option value="volvo">OPTION</option>
                                <option value="saab">Option</option>
                                <option value="opel">Option</option>
                                <option value="audi">Option</option>
                            </select> <a href="bicycles.html">BUY</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="viw">
                        <a href="bicycles.html">Quick View</a>
                    </div></li>
                <li><img src="images/bik6.jpg" alt="" />
                    <div class="bike-info">
                        <div class="model">
                            <h4>
                                SANSACHG<span>$249.00</span>
                            </h4>
                        </div>
                        <div class="model-info">
                            <select>
                                <option value="volvo">OPTION</option>
                                <option value="saab">Option</option>
                                <option value="opel">Option</option>
                                <option value="audi">Option</option>
                            </select> <a href="bicycles.html">BUY</a>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="viw">
                        <a href="bicycles.html">Quick View</a>
                    </div></li>
            </ul>
            <script type="text/javascript">
													$(window)
															.load(
																	function() {
																		$(
																				"#flexiselDemo1")
																				.flexisel(
																						{
																							visibleItems : 3,
																							animationSpeed : 1000,
																							autoPlay : true,
																							autoPlaySpeed : 3000,
																							pauseOnHover : true,
																							enableResponsiveBreakpoints : true,
																							responsiveBreakpoints : {
																								portrait : {
																									changePoint : 480,
																									visibleItems : 1
																								},
																								landscape : {
																									changePoint : 640,
																									visibleItems : 2
																								},
																								tablet : {
																									changePoint : 768,
																									visibleItems : 3
																								}
																							}
																						});
																	});
												</script>
            <script type="text/javascript" src="js/jquery.flexisel.js"></script>
        </div>
    </div>
    <!---->
    <div class="contact">
        <div class="container">
            <h3>CONTACT US</h3>
            <p>Please contact us for all inquiries and purchase
                options.</p>
            <form>
                <input type="text" placeholder="NAME" required="">
                <input type="text" placeholder="SURNAME" required="">
                <input class="user" type="text"
                    placeholder="USER@DOMAIN.COM" required=""><br>
                <textarea placeholder="MESSAGE"></textarea>
                <input type="submit" value="SEND">
            </form>
        </div>
    </div>
    <!---->
    <div class="footer">
        <div class="container wrap">
            <div class="logo2">
                <a href="index.html"><img src="images/logo2.png"
                    alt="" /></a>
            </div>
            <div class="ftr-menu">
                <ul>
                    <li><a href="bicycles.html">BICYCLES</a></li>
                    <li><a href="parts.html">PARTS</a></li>
                    <li><a href="accessories.html">ACCESSORIES</a></li>
                    <li><a href="404.html">MY ACCOUNT</a></li>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <!---->

</body>
</html>

