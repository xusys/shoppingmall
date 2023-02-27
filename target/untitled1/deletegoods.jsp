<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改商品</title>
</head>
<body>
<h3>修改商品</h3>
<form action="/untitled1_war/deletegoodsServlet" method="post">
    <input type="hidden" name="id" value="${goods.id}">
    名字<input name="name" value="${goods.name}" readonly><br>
    价格<input name="price"value="${goods.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')" readonly><br>
    介绍<textarea rows="5" cols="20" name="description" readonly> ${goods.description}</textarea>
    <input type="submit" value="确认">
</form>
<p><a href="/untitled1_war/mall.jsp">返回</a> </p>
</body>
