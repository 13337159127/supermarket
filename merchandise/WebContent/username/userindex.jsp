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

<link href="username/assets/css/bootstrap.min.css" rel="stylesheet" />
<link href="username/assets/css/animate.min.css" rel="stylesheet" />
<link href="username/assets/css/paper-dashboard.css" rel="stylesheet" />
<link href="username/assets/css/demo.css" rel="stylesheet" />
<link href="username/assets/css/font-awesome.min.css" rel="stylesheet">
<link href="username/assets/css/css.css" rel='stylesheet' type='text/css'>
<link href="username/assets/css/themify-icons.css" rel="stylesheet">

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
					<li class="active"><a href="dashboard.html"> <i class="ti-panel"></i>
							<p>用户信息列表</p>
					</a></li>
					<li><a href="username/add.jsp"> <i class="ti-user"></i>
							<p>添加用户名</p>
					</a></li>
					<li><a href="/merchandise/FondCommodity"> <i class="ti-view-list-alt"></i>
							<p>返回首页</p>
					</a></li>
				</ul>
			</div>
		</div>

		<div class="main-panel">
			<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">用户名信息</a>
				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-panel"></i>
								<p>用户名管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/merchandise/FondUser">查询用户名</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/merchandise/FondClassify">查询分类</a></li>
							</ul></li>
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
									<h4 class="title">用户名信息</h4>
								</div>

								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>用户名Id</th>
                                            <th>用户名</th>
                                            <th>用户名密码</th>
                                            <th>编辑商品</th>
                                            <th>删除商品</th>
										</thead>
										<c:forEach items="${list}" var="user"> 
											<tbody>
											  <td>${user.userId}</td>
                                              <td>${user.loginName}</td>
                                              <td>${user.passWord}</td>
                                              <td><a href="/merchandise/GetIdFondUser?userId=${user.userId}">编辑商品</a></td>
                                              <td><a href="/merchandise/DeleteUserName?userId=${user.userId}">删除商品</a></td>
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

<script src="username/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="username/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="username/assets/js/bootstrap-checkbox-radio.js"></script>
<script src="username/assets/js/chartist.min.js"></script>
<script src="username/assets/js/bootstrap-notify.js"></script>
<script src="username/assets/js/paper-dashboard.js"></script>
<script src="username/assets/js/demo.js"></script>

</html>