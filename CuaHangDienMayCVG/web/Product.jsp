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
        <title>Product List</title>

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

    <center><h1 style="margin: 10px">QUẢN LÝ SẢN PHẨM</h1></center>
    <div class="group-btn">

        <div>
            <a style="width: 300px" href="InsertProduct.jsp"> Insert Product</a>

            <a style="width: 300px" href="Managements.jsp"> Back to Managements</a>

            <form action="AllProductServlet" method="processRequest">
                <div class="search">
                    <div class="search-btn">
                        <input class="search-input" name = "findProduct" placeholder ="Bạn tìm gì...">
                        <div>
                            <button type="submit">Search</i></button>
                        </div>
                        </input>
                    </div>
                </div>


            </form>
        </div>

    </div>
    <center><h1 class="productCount">Số lượng sản phẩm hiện có: ${list.size()}</h1>
        <h2 style="color: greenyellow">${success} ${e}</h2>
    </center>  
    <div class="content">
        <table class="table">
            <tr>
                <th>Xóa sản phẩm</th>
                <th>Sửa sản phẩm</th>
                <th>Mã sản phẩm</th>
                <th>Hình ảnh</th>
                <th>Tên sản phẩm</th>
                <th>TYPE</th>
                <th>COLOR</th>
                <th>OS</th>
                <th>SCREEN</th>
                <th>Card</th>
                <th>PIN</th>
                <th>CPU</th>
                <th>Kích thước, cân năng</th>
                <th>RAM</th>
                <th>Hard Drive</th>
                <th>Giá</th>

            </tr>

            <c:forEach items="${list}" var="p">
                <tr>                            

                    <td ><a style="background-color: red" class="btn-edit" href="DeleteProductServlet?MaSP=${p.getMaSP()}">DELETE</a> </td>
                    <td ><a style="background-color: green" class="btn-edit" href="ProductServlet?MaSP=${p.getMaSP()}"
                            
                            <%-- ?NameSp=${p.getNameSp()}?TypeSP=${p.getTypeSp()}?thumbnail=${p.getThumbnail()}?Price=${p.getPrice()}?ColorSP=${p.getColorSP()}?Screen=${p.getScreen()}?Card=${p.getCard()}?Pin=${p.getPin()}?CPU=${p.getCPU()}?OS=${p.getOS()}?SizeWeight=${p.getSizeWeight()}?RAM=${p.getRAM()}?HardDrive=${p.getHardDrive()} --%> 
                            >UPDATE</a> </td>
                    <td class="item-style" style="background-color:rgba(0,255,0,0.6)">${p.getMaSP()}</td>
                    <td><img src="images/${p.getThumbnail()}"  style="width: 200px; height: 200px; " alt="thumbnail"/></td>
                    <td class="item-style">${p.getNameSp()}</td>
                    <td class="item-style">${p.getTypeSp()}</td>
                    <td class="item-style">${p.getColorSP()}</td>
                    <td class="item-style">${p.getOS()}</td>
                    <td class="item-style">${p.getScreen()}</td>
                    <td class="item-style">${p.getCard()}</td>
                    <td class="item-style">${p.getPin()}</td>
                    <td class="item-style">${p.getCPU()}</td>
                    <td class="item-style">${p.getSizeWeight()}</td>
                    <td class="item-style">${p.getRAM()}</td>
                    <td class="item-style">${p.getHardDrive()}</td>
                    <td class="item-style">${p.getPrice()}</td>


                </tr>
            </c:forEach>

        </table>

    </div>



</body>


</html>
