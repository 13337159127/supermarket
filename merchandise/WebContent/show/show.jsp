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
					<li class="active"><a href="dashboard.html"> <i class="ti-panel"></i>
							<p>商品信息列表</p>
					</a></li>
					<li><a href="/merchandise/FondAddClassify"> <i class="ti-user"></i>
							<p>添加商品</p>
					</a></li>
					<li><a href="/merchandise/CommoditySum"> <i class="ti-view-list-alt"></i>
							<p>用户商品总数</p>
					</a></li>
					<li><a href="/merchandise/DaySumCommodity"> <i class="ti-text"></i>
							<p>每天录入商品总数</p>
					</a></li>
					<li><a href="/merchandise/ClassifySumCommodity"> <i class="ti-pencil-alt2"></i>
							<p>每个分类商品总数</p>
					</a></li>
					<li><a href="/merchandise/FondClassify"> <i class="ti-map"></i>
							<p>商品分类管理</p>
					</a></li>
					<li><a href="/merchandise/FondUser"> <i class="ti-bell"></i>
							<p>用户名管理</p>
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
							<ul class="dropdown-menu">
								<li><a href="/merchandise/FontUser">查询用户名</a></li>
							</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"> <i class="ti-bell"></i>								 
								<p>分类管理</p> <b class="caret"></b>
						</a>
							<ul class="dropdown-menu">
								<li><a href="/merchandise/FondClassify">查询分类</a></li>
							</ul></li>
					  </li>
					</ul>
				</div>
			</div>
			</nav>
			 
			<div class="content">
				<div class="container-fluid">
				<center> 
				<form action="">
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>分类</label> <input type="text" name="classify"
										style="width: 300px; display: inline"
										class="form-control border-input" placeholder="请输入分类名"
										value="">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>名称</label> <input type="text" name="designation"
										style="width: 300px; display: inline"
										class="form-control border-input" placeholder="请输入商品名称"
										value="">
								</div>
							</div>
						</div>
                        <div class="row">
							<div class="col-md-12">
								<div class="form-group">
									<label>排序</label> 
									<select name="sort" style="width: 300px; display: inline" class="form-control border-input">
                                    <option value="commodityId">商品id</option>
                                    <option value="commodityPrice">商品价格</option>
                                    <option value="commodityMuch">商品数量</option>
                                    </select>
								</div>
							</div>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-info btn-fill btn-wd">查询</button>
						</div>
 			        <br>
 					</form>
					</center>			
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="header">
									<h4 class="title">商品信息列表</h4>
								</div>

								<div class="content table-responsive table-full-width">
									<table class="table table-striped">
										<thead>
											<th>id</th>
											<th>名称</th>
											<th>价格</th>
											<th>数量</th>
											<th>保质期</th>
											<th>生产地</th>
											<th>分类</th>
											<th>管理员</th>
											<th>录入时间</th>
											<th>编辑商品</th>
											<th>操作商品</th>
										</thead>
										<c:forEach items="${re}" var="commodity">
											<tbody>
												<td>${commodity.commodityId}</td>
												<td>${commodity.commodityName}</td>
												<td>${commodity.commodityPrice}</td>
												<td>${commodity.commodityMuch}</td>
												<td>${commodity.commodityPeriod}</td>
												<td>${commodity.commodityYiedly}</td>
												<td>${commodity.category}</td>
												<td>${commodity.loginName}</td>
												<!-- 格式化时间和日期 -->
												<td><fmt:formatDate value="${commodity.entryTime}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
												<td><a href="/merchandise/FondUpdateCommodity?commodityId=${commodity.commodityId}">修改商品</a></td>
												<td><a href="/merchandise/DeleteCommodity?commodityId=${commodity.commodityId}">删除商品</a></td>
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