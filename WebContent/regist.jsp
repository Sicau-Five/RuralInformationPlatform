<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="ui-page-login">

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
		<title></title>
		<link href="css/mui.min.css" rel="stylesheet" />
		<link href="css/style.css" rel="stylesheet" />
		<style>
			.area {
				margin: 20px auto 0px auto;
			}
			.mui-input-group:first-child {
				margin-top: 20px;
			}
			.mui-input-group label {
				width: 22%;
			}
			.mui-input-row label~input,
			.mui-input-row label~select,
			.mui-input-row label~textarea {
				width: 78%;
			}
			.mui-checkbox input[type=checkbox],
			.mui-radio input[type=radio] {
				top: 6px;
			}
			.mui-content-padded {
				margin-top: 25px;
			}
			.mui-btn {
				padding: 10px;
			}
			
		</style>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		
		
	</head>

	<body>
		<div class="container">
			<header class="mui-bar mui-bar-nav">
				<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
				<h1 class="mui-title">注册</h1>
			</header>
			<div class="mui-content">
				<form class="mui-input-group" method="post" action="regist.do">
					<div class="mui-input-row">
						<label>ID用户名</label>
						<input name="userId" type="text" class="mui-input-clear mui-input" placeholder="请输入账号">
					</div>
					<div class="mui-input-row">
						<label>姓名</label>
						<input name="userName" type="text" class="mui-input-clear mui-input" placeholder="请输入姓名">
					</div>
					<div class="mui-input-row">
						<label>密码</label>
						<input name="userPwd" type="password" class="mui-input-clear mui-input" placeholder="请输入密码">
					</div>
					<div class="mui-input-row">
						<label>确认</label>
						<input name="userPwdCon" type="password" class="mui-input-clear mui-input" placeholder="请确认密码">
					</div>
					<div class="mui-input-row">
						<label>邮箱</label>
						<input type="email" name="email" class="mui-input-clear mui-input" placeholder="请输入邮箱">
					</div>
					<input class="login_btn btn btn-info btn-lg" type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注册&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"/>
					${registInfo}
				</form>
			</div>
		</div>
		
	</body>

</html>