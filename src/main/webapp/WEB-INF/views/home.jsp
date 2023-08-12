<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="../../resources/css/mainStyle.css">
</head>
<meta charset="UTF-8">


<style>
</style>

<script src="../../resources/js/mainScript.js"></script>

<body>
	<div id="page">
		<!-- 메뉴바 -->
		<header class="header">
			<div class="container">

				<div class="menubar mainlogo">
					<a href="#">BookStore</a>
				</div>
				<div class="menubar text-center">
					<div class="header_fade">
						<div class="header_fade active">
							<a href="#">Discovery</a>
						</div>
						<div class="header_fade disactive">
							<a href="#">Journey</a>
						</div>
					</div>
				</div>
				<div class="menubar text-right">
					<div class="menu_side">
						<a href="#" class="user_detail"> User <!-- <img src="#"> -->
						</a> <a href="#" class="search"> Search <!-- <img src="#"> -->
						</a>
						
					</div>
				</div>


			</div>

		</header>


		<!-- 메인홈페이지 설명용 이미지들 -->
		<section class="main_container">
			<div class="container">
				<div class="books main_leftop">
					<div class="square1"></div>
				</div>
				<div class="books main_rightop">
					<div class="square2"></div>
				</div>
				<div class="books main_rightbottom">
					<div class="square3"></div>
				</div>
			</div>
		</section>



		<section class="product_container">
			<div class="container">
				<h2>
					<a href="#"></a>
				</h2>

				<div class="product_list">
					<article class="bookdata first-item">
						<div>
							<div class="item_img">
								<img src="#">
							</div>
							<h4>
								<a href="#">제목칸</a>
							</h4>
						</div>
					</article>
					<article class="bookdata seconde-item">
						<div>
							<div class="item_img">
								<img src="#">
							</div>
							<h4>
								<a href="#">제목칸</a>
							</h4>
						</div>
					</article>
					<article class="bookdata last-item">
						<div>
							<div class="item_img">
								<img src="#">
							</div>
							<h4>
								<a href="#">제목칸</a>
							</h4>
						</div>
					</article>
				</div>
			</div>
		</section>

	</div>

</body>


</html>
