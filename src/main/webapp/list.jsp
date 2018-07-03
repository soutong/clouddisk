<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<title>网络U盘</title>
		<link rel="stylesheet" href="css/style.css" type="text/css" media="screen" />
		<style>
		td{
		padding:2px;
		font-family:宋体;
		}
		</style>
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
						咨询电话：66666666 / 88888888
					</div>
					<div id="nav">
						<div id="nav-bg">
							<ul>
								<li>
									<a href="/clouddisk/download.jsp">下载</a>
								</li>
								<li>
									<a href="/clouddisk/register.jsp">注册</a>
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
				 <h4 class="service-head">欢迎您：${user.userName } </h4>
				 <p>&nbsp;</p>
				 <table style="border:solid 1px gray;padding:2px" width="100%">
				 	<thead style="background-color:#EEE">
				 		<tr>
				 			<th width="30%">文件名</th><th width="20%">上传日期</th><th width="15%">大小</th><th width="25%">提取码</th><th width="10%">操作</th>
				 		</tr>
				 	</thead>
				 	<tbody>
				 	<c:if test="${empty fileList }">
				 	<tr>
				 	<td colspan="5">暂时没有文件</td>
				 	</tr>
				 	</c:if>
				 	<c:if test="${not empty fileList }">
				 	<c:forEach items="${fileList }" var="fileInfos">
					 		<tr>
					 			<td>${fileInfos.fileName }</td>
					 			<td>${fileInfos.createDate }</td>
					 			<td>${fileInfos.fileSize }</td>
					 			<td>${fileInfos.fileLink }</td>
					 			<td><A href="download.action?fileLink=${fileInfos.fileLink }">下载</A> <A href="delete.action?fileName=${fileInfos.fileName }&&fileInfoID=${fileInfos.fileInfoID}">删除</A></td>
					 		</tr>
					 	</c:forEach>
					 </c:if>	
				 	</tbody>
				 </table>
				 <p>&nbsp;</p>
				 <h4 class="service-head">上传文件</h4>
				 <form action="upload.action" enctype="multipart/form-data" method="post">
						上传文件的数量：
						<c:if test="${user.userType==2 }">
						<select onchange="makeFile(this.options[this.selectedIndex].text)">
							<option>1</option>
							<option>2</option>
							<option>3</option>
						</select>
						</c:if>		
					<div id="divFile">
						<input type="file" name="upLoadFiles"/><br/>
					</div>
						
					<input type="submit" value="上传"/>
				</form>
				  
				<script>
				  	function makeFile(v) {
					  	var divFile = document.getElementById('divFile');
					  	divFile.innerHTML='';
					  	for (var i=0;i<v;i++) {
					  		divFile.innerHTML += '<input type="file" name="upLoadFiles"' + i + '"><br/>';
					  	}
				  	}
				</script>
			</div>
		</div>
		<div id="footer">
			项目设计 : codingtong
		</div>
	</body>
</html>
