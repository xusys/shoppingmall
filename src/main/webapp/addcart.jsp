
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>

<html>
<head>
    <title>添加购物车</title>
</head>
<body>
<h3>添加购物车</h3>
<form action="/untitled1_war/addcartServlet" method="post">
    <input type="hidden" name="goodsid" value="${goods.id}">
    <input type="hidden" name="usersid" value="${user.id}">
    名字<input name="goodsname" value="${goods.name}" readonly><br>
    价格<input name="price"value="${goods.price}" oninput="value=value.replace(/[^\-?\d.]/g,'')" readonly><br>
<%--    介绍<textarea rows="5" cols="20" name="description"> ${goods.description}</textarea>--%>
    购买数量<input name="quantity" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')" REQUIRED>
    <input type="submit" value="提交">
</form>
<p><a href="/untitled1_war/mall.jsp">返回</a> </p>
</body>