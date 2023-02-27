<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商城首页</title>
</head>
<body>
<table>
    欢迎,${user.username}
    <p>back to <a href="/untitled1_war/logoutServlet">Login</a> now!</p>
<c:if test="${user.username !='admin'}"> <p><a href="/untitled1_war/cartServlet">购物车</a></p></c:if>
<c:if test="${user.username =='admin'}"><p><a href="/untitled1_war/historyServlet?operation=1">购买总记录 </a></c:if>
<c:if test="${user.username !='admin'}">   <a href="/untitled1_war/historyServlet?operation=2&usersid=${user.id}">用户查询购买记录</a></c:if>
<c:if test="${user.username =='admin'}">    <a href="/untitled1_war/historyServlet?operation=3">商品销售记录</a></c:if>
    </p>
    <form action="/untitled1_war/mallServletSearch" method="post">
        <label for="name">name:</label>
        <input type="text" id="name" name="name">
        <label for="id">id:</label>
        <input type="text" id="id" name="id" oninput="value=value.replace(/^(0+)|[^\d]+/g,'')">

        <input type="submit" value="查询">
    </form>
</table>
<c:if test="${user.username =='admin'}">
<input type="button" value="新增" id="add"><br>
</c:if>

<table border="1" cellspacing="0" width="800">
    <tr>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品介绍</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${goodsList}" var="goods">
        <tr>
            <td>${goods.id}</td>
            <td>${goods.name}</td>
            <td>${goods.price}</td>
            <td>${goods.description}</td>
            <td>
                <c:if test="${user.username =='admin'}">
                <a href="/untitled1_war/selectidServlet?id=${goods.id}&operation=1">修改 </a>
                <a href="/untitled1_war/selectidServlet?id=${goods.id}&operation=2">删除 </a>
            </c:if>
                <c:if test="${user.username !='admin'}">
                <a href="/untitled1_war/selectidServlet?id=${goods.id}&operation=3">添加至购物车</a>
                </c:if>
            </td>

        </tr>
    </c:forEach>
</table>

<script>
    document.getElementById("add").onclick = function () {
        location.href = "/untitled1_war/addgoods.jsp";
    }

</script>

</body>
</html>