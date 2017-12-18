<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!--A Design by W3layouts 
Author: W3layout
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE html>
<html>
<head>
<title>Barata Shop</title>
<link href="${base_url}/view/user/assets/css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${base_url}/view/user/assets/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!--theme-style-->
<link href="${base_url}/view/user/assets/css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="I wear Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<script type="text/javascript" src="${base_url}/view/user/assets/js/move-top.js"></script>
<script type="text/javascript" src="${base_url}/view/user/assets/js/easing.js"></script>
<!--fonts-->
<link href='//fonts.googleapis.com/css?family=Lato:100,300,400,700,900' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Montez' rel='stylesheet' type='text/css'>
<!--//fonts-->
<!-- start menu -->
<!--//slider-script-->
<script src="${base_url}/view/user/assets/js/easyResponsiveTabs.js" type="text/javascript"></script>
		    <script type="text/javascript">
			    $(document).ready(function () {
			        $('#horizontalTab').easyResponsiveTabs({
			            type: 'default', //Types: default, vertical, accordion           
			            width: 'auto', //auto or any width like 600px
			            fit: true   // 100% fit in a container
			        });
			    });
				
</script>	
		  		 <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
<!-- js -->
<script src="${base_url}/view/user/assets/js/bootstrap.js"></script>
<!-- js -->
<script src="${base_url}/view/user/assets/js/simpleCart.min.js"> </script>
<!-- start menu -->
<link href="${base_url}/view/user/assets/css/memenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="${base_url}/view/user/assets/js/memenu.js"></script>
<script>$(document).ready(function(){$(".memenu").memenu();});</script>	
<!-- /start menu -->
</head>
<body> 
<!--header-->
<div class="header">
	<div class="header-top">

			<div class="header-bottom">
			<div class="container">			
				<div class="logo">
					<h1><a href="${base_url}">Barata<span>Shop</span></a></h1>
				</div>
			<div class="top-nav">
				<ul class="memenu skyblue">
					<li class="grid"><a href="${base_url}">Início</a>
						
					</li>
					<li class="grid"><a href="${base_url}/contato">Contato</a>
						
					</li> 
				</ul>
				<div class="clearfix"> </div>
			</div> 
					<div class="cart box_1">
						<a href="${base_url}/cart"> 
						<h3> <div class="total">
								<fmt:formatNumber value="${cart_total}" type = "currency" /> (${cart_quant})</div>
							<img src="${base_url}/view/user/assets/images/cart2-2.png" alt=""/></h3>
						</a>
						<p><a href="${base_url}/cart" class="simpleCart_empty">Carrinho</a></p>  
						<div class="clearfix"> </div>
					</div> 
					<c:if test="${user != null}">
					<div class="cart box_1">  
						<p><a href="${base_url}/user/logout" class="simpleCart_empty"><i class="glyphicon glyphicon-user"> </i>Sair</a></p>
					</div>
					</c:if>					
					<c:if test="${user == null}"> 
					<div class="cart box_1">  
					    <p><a href="${base_url}/user/login" class="simpleCart_empty"><i class="glyphicon glyphicon-user"> </i>Login</a></p>
					    <br> 
					    <p><a href="${base_url}/user/create" class="simpleCart_empty"><i class="glyphicon glyphicon-lock"> </i>Cadastrar</a></p>
					</div>
					</c:if>

<div class="clearfix"> </div>
					<!---->
				</div>
			<div class="clearfix"> </div>
		</div>
		</div>
		
 	<div class="clearfix"> </div>	
</div>