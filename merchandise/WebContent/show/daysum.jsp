<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8" />
<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
<link rel="icon" type="image/png" sizes="96x96"	href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<title></title>

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />

<link href="show/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="show/assets/css/animate.min.css" rel="stylesheet" />
<link href="show/assets/css/paper-dashboard.css" rel="stylesheet" />
<link href="show/assets/css/demo.css" rel="stylesheet" />
<link href="show/assets/css/font-awesome.min.css" rel="stylesheet">
<link href="show/assets/css/css.css" rel='stylesheet' type='text/css'>
<link href="show/assets/css/themify-icons.css" rel="stylesheet">

</head>
<body>

	<div class="wrapper">
		<div class="sidebar" data-background-color="white"
			data-active-color="danger">
			<div class="sidebar-wrapper">
				<div class="logo">
					<a href="#" class="simple-text"> 超市管理系统 </a>
				</div>

				<ul class="nav">
					<li class="active"><a href="show/success.jsp"> <i class="ti-panel"></i>
							<p>返回首页</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">商品信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
					   </li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
						</li>
					</ul>
				</div>
			</div>
			</nav>
			 
			<div class="content">
				<div class="container-fluid">			
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">每天录入信息</h4>
								</div>

								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>时间</th>
											<th>商品总数</th>	 
										</thead>
										<c:forEach items="${list}" var="commodity">
											<tbody>
												<td>${commodity.date}</td>
												<td>${commodity.num}</td>
											</tbody>
										</c:forEach>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<script src="show/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="show/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="show/assets/js/bootstrap-checkbox-radio.js"></script>
<script src="show/assets/js/chartist.min.js"></script>
<script src="show/assets/js/bootstrap-notify.js"></script>
<script src="show/assets/js/paper-dashboard.js"></script>
<script src="show/assets/js/demo.js"></script>

</html>