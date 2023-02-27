<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>确认购买</title>
</head>
<body>
<h3>确认购买</h3>
<table border="1" cellspacing="0"width="800" >
    <tr>
        <th>购物车ID</th>
        <th>商品ID</th>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>商品数量</th>

    </tr>
    <c:forEach items="${cartList}" var="cart">
        <tr>
            <td>${cart.id}</td>
            <td>${cart.goodsid}</td>
            <td>${cart.goodsname}</td>
            <td>${cart.price}</td>
            <td>${cart.quantity}</td>


        </tr>
    </c:forEach>
    <tr>
        总价格:${totalprice}<input type="button" value="支付" id="purchase">
    </tr>
</table>
<p><a href="/untitled1_war/cart.jsp">返回</a> </p>
<script>
    document.getElementById("purchase").onclick=function ()
    {
        location.href="/untitled1_war/purchaseServlet?operation=1";
    }

</script>
</body>