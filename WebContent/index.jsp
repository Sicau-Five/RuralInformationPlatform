<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
	<head>
		<meta charset="UTF-8">
		<title>川农信息平台</title>
		<!--
        	作者：314445437@qq.com
        	时间：2016-10-24
        	描述：以下先导入css样式表
        -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" type="text/css" href="css/docs.min.css"/>
		<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
		<script src="js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
		<!-----------------------分割线------------------------>
		
		<style type="text/css">
			.bs-docs-section{
				    margin-bottom: 60px;
			}
			.glyphicon-class{
				display: block;
				text-align: center;
				word-wrap: break-word;
			}
			
			.bs-glyphicons li {
				list-style-type: none;
    			float: left;
			    width: 25%;
			    height: 115px;
			    padding: 10px;
			    font-size: 10px;
			    line-height: 1.4;
			    text-align: center;
			    background-color: #f9f9f9;
			    border: 1px solid #Fff;
			}
			.bs-glyphicons li:hover{
				background-color: darkslateblue;
				color: white;
			}
			
			.bs-glyphicons-list {
			    padding-left: 0;
			    list-style: none;
			}
			ul, ol {
			    margin-top: 0;
			    margin-bottom: 10px;
			}
			
			.bs-glyphicons li {
				width: 12.5%;
				font-size: 12px;
			}
			
			.glyphicon {
			    position: relative;
			    top: 1px;
			    display: inline-block;
			    font-family: 'Glyphicons Halflings';
			    font-style: normal;
			    font-weight: 400;
			    line-height: 1;
			    -webkit-font-smoothing: antialiased;
			    -moz-osx-font-smoothing: grayscale;
			}
			
			.bs-glyphicons .glyphicon {
				margin-top: 5px;
				margin-bottom: 10px;
				font-size: 24px;
			}
			.bs-glyphicons{
				margin: 20px auto 20px auto;
			}
			
			.red_{
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="container bs-docs-container">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container-fluid">
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header">
				      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <a class="navbar-brand" href="index.html">主页</a>
				    </div>
				
				    <!-- Collect the nav links, forms, and other content for toggling -->
				    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				      <ul class="nav navbar-nav">
				        <li><a href="#"></a></li>
				        <li><a href="#">便民服务</a></li>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown">其他 <span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#">电子商务</a></li>
				            <li><a href="#">电子农务</a></li>
				            <li><a href="#">电子政务</a></li>
				            <li class="divider"></li>
				            <li><a href="#">农家汇</a></li>
				            <li class="divider"></li>
				            <li><a href="#">限时抢购</a></li>
				          </ul>
				        </li>
				      </ul>
				      <form class="navbar-form navbar-left" role="search">
				        <div class="form-group">
				          <input type="text" class="form-control" placeholder="Search">
				        </div>
				        <button type="submit" class="btn btn-default">搜索</button>
				      </form>
				      <ul class="nav navbar-nav navbar-right">
				      <% 
				      	String userid = session.getAttribute("userid") == null?"":session.getAttribute("userid").toString();
				    		
				    		if(!(userid == "" && !userid.equals("error"))){%>
				    			<li><a>欢迎您,<%=userid %></a></li>
				    		
				    		<%}else{%>
				    			<li><a href="login.jsp">登录</a></li>
				    		<%}%>
				        <li class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown">扫二维码登录 <span class="caret"></span></a>
				          <ul class="dropdown-menu" role="menu">
				            <li><a href="#">其他类型登录</a></li>
				            <li class="divider"></li>
				            <li><img src="img/ewm.jpg"/></li>
				          </ul>
				        </li>
				      </ul>
				    </div><!-- /.navbar-collapse -->
				  </div><!-- /.container-fluid -->
				</nav>
			<div class="row">
				<div class="col-md-12" role="main">
					<div class="bs-docs-section">
						<h1 id="glyphicons" class="page-header">川农信息平台暂时主页</h1>
						<h2 id="glyphicons-glyphs">这是一个农业服务平台</h2>
						<p>如果你有什么农业方面的需要?</p>
						<p>测试账号:20140243 密码:1314</p>
						<div class="bs-glyphicons">
							<ul class="bs-glyphicons-list">
								<li>
									<span class="glyphicon glyphicon-asterisk">
									</span>
									<span class="glyphicon-class">便民服务
									</span>
								</li>
								<li>
									<span class="glyphicon glyphicon-plus">
									</span>
									<span class="glyphicon-class">电子商务
									</span>
								</li>
								<li>
									<span class="glyphicon glyphicon-euro">
									</span>
									<span class="glyphicon-class">电子政务
									</span>
								</li>
								<li>
									<span class="glyphicon glyphicon-minus">
									</span>
									<span class="glyphicon-class">抢购土特产!
									</span>
								</li>
							</ul>
						</div><!-- bs-glyphicons-->
						<h2 id="glyphicons-how-to-use">想购买土特产?</h2>
						<p>稍后将开放购买平台</p>
						<div class="bs-callout bs-callout-danger">
							<h4>想要了解农业新闻吗?</h4>
							<p>稍后通过平台就能了解!</p>
						</div>
						<div class="bs-callout bs-callout-danger">
							<h4>这里还可以发布哟!</h4>
							<p>如果你发布了你的农产品,别人就可以购买!</p>
						</div>
					</div>
	
				</div>
			</div>
		</div>
	</body>
</html>
