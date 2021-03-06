<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>sicau信息化登录平台</title>
		
		<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
		<script src="js/JQuery3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		
		<style type="text/css">
			.login_btn{
				position: relative;
				margin-left: 22%;
			}
			.login_h1{
				background-color: lawngreen;
				opacity: 0.9;
				margin-left: auto;
				margin-right: auto;
				width: 300px;
				text-align: center;

			}
			.login_h1 h4{
				height: 50px;
				line-height: 50px;
			}
			.login_form{
				opacity: 0.9;
				background-color: #C0C0C0;
				width: 300px;
				margin:auto;
				
			}
			.regist_href{
				width: 136px;
				margin-left: auto;
				margin-right: auto;
			}
			.blank_{
				height: 100px;
			}
		</style>
		
		<script type="text/javascript">
		    //刷新验证码
		    function changeImg(){
		        document.getElementById("verifyCode").src="${pageContext.request.contextPath}/drawimage.do?"+Math.random();
		    }
    	</script>
	</head>
	<body background="img/bg.jpeg">
		<div class="blank_">
		</div>
		<div class="container">
			<div class="col-md-4 col-sm-4 col-xs-4">
				
			</div>
			<div class="col-md-4 col-sm-4 col-xs-4">
				<div class="row login_block">
					<div class="row login_h1">
						<h4>携手Sicau 共创地球村</h4>
						${info}
					</div>
					<div class="row login_form">
						<br/>
						<br/>
						<form class="form-login" action="login.do" method="post">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-user">&nbsp;&nbsp;</span><input name="username" id="userid" value="" placeholder="请输入用户名" />
							<br/>
							<br/>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-lock">&nbsp;&nbsp;</span><input type="password" id="userpwd" name="userpassword" placeholder="请输入密码"/>
							<br/>
							<br/>
							<%--这里是加载验证码的地方 --%>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<span class="glyphicon glyphicon-pencil">&nbsp;&nbsp;</span>
							<input type="text"  name="verify" placeholder="请输入验证码">
							<br/><br/>
							<div style="height:26px; width:118px; float:left;"></div>
							<img src="${pageContext.request.contextPath}/drawimage.do" onclick="changeImg()" id="verifyCode">
							<br/>
							<br/>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<input class="login_btn btn btn-info btn-lg" type="submit" value="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"/>
							<br/>
							<br/>
							<div class="regist_href">
								<a href="regist.jsp">没有账号?去注册</a>
							</div>
							<br/>
							<br/>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-4 col-sm-4 col-xs-4">
				
			</div>
		</div>
	</body>
</html>