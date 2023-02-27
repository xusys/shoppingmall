<%--
  Created by IntelliJ IDEA.
  User: mia mondo
  Date: 2023/2/25
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加商品</title>
</head>
<body>
<h3>添加商品</h3>
<form action="/untitled1_war/addgoodsServlet" method="post">
    名字<input name="name"><br>
    价格<input name="price" oninput="value=value.replace(/[^\-?\d.]/g,'')" ><br>
    介绍<textarea rows="5" cols="20" name="description" ></textarea>
    <input type="submit" value="提交">
</form>
<p><a href="/untitled1_war/mall.jsp">返回</a> </p>
</body>
