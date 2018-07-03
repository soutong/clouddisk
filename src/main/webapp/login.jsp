<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<title>网络U盘</title>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<div id="logo">
					<div style="color: #888; font-size: 36px; font-family: 微软雅黑">
						网络U盘
					</div>
					<div style="color: #333; font-size: 12px; font-family: 微软雅黑">
						永久的网络数据存储专家
					</div>
				</div>
				<div id="nav-box">
					<div id="toll">
						咨询电话：66666666/ 88888888
					</div>
					<div id="nav">
						<div id="nav-bg">
							<ul>
								<li>
									<a href="/clouddisk/download.jsp">下载</a>
								</li>
								<li>
									<a href="/clouddisk/regiser.jsp">注册</a>
								</li>
								<li>
									<a href="/clouddisk/contact.jsp">帮助</a>
								</li>
							</ul>
						</div>
						<div id="left-nav"></div>
					</div>
				</div>
			</div>
			<div id="content">
				 <h4 class="service-head">请您登录</h4>
				 <form action="user/login.action" method="post">
				 <P>用户名：<input name="userName"/>
				 <P>密 码 ：<input name="userPwd"/>
				 <p><input type="submit" value="登录"/> 
				 </form>
			</div>
		</div>
		<div id="footer">
			项目设计 : codingtong
		</div>
	</body>
</html>
