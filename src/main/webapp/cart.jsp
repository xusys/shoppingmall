<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>
<body>
<table>
    欢迎,${user.username}
    <p>back to  <a href="/untitled1_war/mall.jsp">mall</a> now!</p>

</table>

<table border="1" cellspacing="0"width="800" >
    <tr>
        <th>购物车ID</th>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${cartList}" var="cart">
        <tr>
            <td>${cart.id}</td>
            <td>${cart.goodsid}</td>
            <td>${cart.goodsname}</td>
            <td>${cart.price}</td>
            <td>${cart.quantity}</td>

            <td><a href="/untitled1_war/selectcartServlet?id=${cart.id}&operation=1">修改 </a>
                <a href="/untitled1_war/selectcartServlet?id=${cart.id}&operation=2">删除 </a>
<%--                <a href="/untitled1_war/selectidServlet?id=${goods.id}&operation=3">添加至购物车</a>--%>
            </td>

        </tr>
    </c:forEach>
    <tr>
        总价格:${totalprice}<input type="button" value="结算" id="purchase">
    </tr>
</table>

<%--<script>--%>
<%--    document.getElementById("add").onclick=function ()--%>
<%--    {--%>
<%--        location.href="/untitled1_war/addgoods.jsp";--%>
<%--    }--%>

<%--</script>--%>
<script>
    document.getElementById("purchase").onclick=function ()
    {
        location.href="/untitled1_war/verify.jsp";
    }

</script>
</body>
</html>