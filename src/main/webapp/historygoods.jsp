<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>销售记录</title>
</head>
<body>
<table>
    <p>back to <a href="/untitled1_war/mall.jsp">mall</a> now!</p>
    <h1>销售记录</h1>

</table>

<table border="1" cellspacing="0" width="800">
    <tr>

        <th>商品ID</th>
        <th>商品名字</th>

        <th>价格</th>
        <th>总卖出数量</th>

    </tr>
    <c:forEach items="${carthistory}" var="cart">
        <tr>

            <td>${cart.goodsid}</td>
            <td>${cart.goodsname}</td>

            <td>${cart.price}</td>
            <td>${cart.totalquantity}</td>



        </tr>
    </c:forEach>
</table>


</body>
</html>
