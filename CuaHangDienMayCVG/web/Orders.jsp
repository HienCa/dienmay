<%-- 
    Document   : Product
    Created on : May 2, 2022, 7:01:58 PM
    Author     : PC
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order List</title>

        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                font-size: 24px;
            }
            body{
                margin-top:20px;
                color: #fff;
                font-size: 24px;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                min-height: 100%;
                background-image: url("images/nen.jpg");

                background-size: cover
            }
            .table, th, td{
                border: 2px solid green;
                min-width: 200px;
                min-height: 200px
            }
            th, td{
                padding: 8px;
            }
            th{
                background-color: rgba(0,255,0,0.9);
            }
            .group-btn{
                display: flex;
                color: #fff;
                justify-content: space-around;
                align-items: center;
                margin-left: 100px;
            }
            .group-form-items{
                font-size: 16px;
                margin-bottom: 16px;
                min-height: 20px;
            }
            button{
                padding: 20px;
                cursor: pointer;
                font-weight: bold;
            }
            button:hover{
                background-color: red;
            }
            label{
                display: inline-block;
                min-width: 200px;
            }
            input{
                width: 500px;
                padding: 10px;
            }
            .e{
                color: red;
                text-align: center;
            }
            a{
                text-decoration: none;
                display: inline-block;
                background-color: green;
                padding: 22px;
                color: #fff;
                border: 1px solid green;

                font-weight: bold;
            }
            a:hover{
                opacity: 50%;
            }
            .findText{
                border-bottom: 6px solid red;
                background-color: lightgrey;
                display: inline-block;
                min-width: 200px;
            }
            .item-style{
                text-align: center;
            }
            .productCount{
                font-weight: bold;
                margin: 8px 0px;
            }
            .showAllProduct{
                display: inline-block;
                background-color: red;
                padding: 22px;
                color: #fff;
                border: 1px solid green;
                font-weight: bold;
            }
            .btn-edit{
                cursor: pointer;
                background-color: transparent;
                width: 100%;
                text-align: center;
            }
            .btn-edit:hover{
                background-color: green;
            }

        </style>

    </head>
    <body>
    <center><h1 style="margin: 10px">QUẢN LÝ ĐƠN ĐẶT HÀNG</h1></center>


    <div class="group-btn">

        <div>
            <a style="width: 300px" href="InsertOrder.jsp"> Insert ORDER</a>

            <a style="width: 300px" href="Managements.jsp"> Back to Managements</a>

            <form action="FindOrderServlet" method="processRequest">
                <div class="search">
                    <div class="search-btn">
                        <input class="search-input" name = "findOrder" placeholder ="Bạn tìm gì...">
                        <div>
                            <button type="submit">Search</i></button>
                        </div>
                        </input>
                    </div>
                </div>


            </form>
        </div>

    </div>
    <center><h1 class="productCount">Số lượng sản phẩm hiện có: ${list.size()}</h1><h2 style="color: greenyellow">${success} ${e}</h2></center>  
    <div class="content">
        <table class="table">
            <tr>
                <th>Xóa đơn đặt hàng</th>
                <th>Sửa đơn đặt hàng</th>
                <th>Mã đơn đặt hàng</th>
                <th>Tên sản phẩm</th>
                <th>Tên khách hàng</th>
                <th>Tên nhân viên </th>
                <th>Số lượng</th>
                <th>Tổng tiền</th>
                <th>Ngày đặt hàng</th>
                <th>Phương thức thanh toán</th>

            </tr>

            <c:forEach items="${list}" var="p">
                <tr>                            

                    <td ><a style="background-color: red" class="btn-edit" href="DeleteOrderServlet?orderCode=${p.getOrderCode()}">DELETE</a> </td>
                    <td ><a style="background-color: green" class="btn-edit" href="UpdateOrderServlet?orderCode=${p.getOrderCode()}">UPDATE</a> </td>
                    <td class="item-style" style="background-color:rgba(0,255,0,0.6)">${p.getOrderCode()}</td>                           
                    <td class="item-style">${p.getProductName()}</td>
                    <td class="item-style">${p.getCustomerName()}</td>
                    <td class="item-style">${p.getEmployeeName()}</td>
                    <td class="item-style">${p.getQuantity()}</td>
                    <td class="item-style">${p.getAmount()}</td>
                    <td class="item-style">${p.getOrderDate()}</td>
                    <td class="item-style">${p.getPaymentMethod()}</td>


                </tr>
            </c:forEach>

        </table>

    </div>



</body>


</html>
