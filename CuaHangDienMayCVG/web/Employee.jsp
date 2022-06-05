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
        <title>Employee List</title>

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
            .showAllProduct:hover{
                opacity: 0.8;
            }
            .search{
                display:flex;
            }
            .search-input{
                padding-left: 8px;
                height: 40px;
                min-width: 500px;
            }
            .search-icon{
                color: white;
                background-color:rgb(10, 173, 238);
                padding: 10px;
                cursor: pointer;
            }
            .search-btn{
                display: flex;
                justify-content:space-around;
                cursor: pointer;
            }
            .search-icon:hover{
                opacity: 0.8;
                border: 2px solid #fff;
                border-radius:5px
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

        <div class="header">
            <center><h1 style="margin: 10px">QUẢN LÝ NHÂN VIÊN</h1></center>

        </div> 
        <div class="group-btn">

            <div>
                <a style="width: 300px" href="InsertEmployee.jsp"> Insert EMPLOYEE</a>
                <a style="width: 300px" href="Managements.jsp"> Back to Managements</a>

                <form action="FindEmployeeServlet" method="processRequest">
                    <div class="search">
                        <div class="search-btn">
                            <input class="search-input" name = "findEmployee" placeholder ="Bạn tìm gì...">
                            <div>
                                <button type="submit">Search</i></button>
                            </div>
                            </input>

                        </div>
                    </div>


                </form>
            </div>

        </div>
    <center><h1 class="productCount">Số lượng nhân viên hiện có: ${list.size()}</h1><h2 style="color: greenyellow">${success} ${e}</h2></center>  
    <div class="content">
        <table class="table">
            <tr>
                <th>Xóa nhân viên</th>
                <th>Sửa nhân viên</th>
                <th>Mã nhân viên</th>
                <th>Hình ảnh</th>
                <th>Họ và tên</th>
                <th>Giới tính</th>
                <th>CCCD / CMND</th>
                <th>Ngày sinh</th>
                <th>Số điện thoại</th>
                <th>Email</th>
                <th>Địa chỉ</th>
                <th>Dân tộc</th>

            </tr>

            <c:forEach items="${list}" var="p">
                <tr>                            

                    <td ><a style="background-color: red" class="btn-edit" href="DeleteEmployeeServlet?employeeCode=${p.getEmployeeCode()}">DELETE</a> </td>
                    <td ><a style="background-color: green" class="btn-edit" href="UpdateEmployeeServlet?employeeCode=${p.getEmployeeCode()}">UPDATE</a> </td>
                    <td class="item-style" style="background-color:rgba(0,255,0,0.6)">${p.getEmployeeCode()}</td>
                    <td><img src="images/${p.getThumbnail()}" style="width: 200px; height: 200px; " alt="thumbnail-employee"/></td>
                    <td class="item-style">${p.getFullName()}</td>
                    <td class="item-style">${p.getGender()}</td>                            
                    <td class="item-style">${p.getCCCD()}</td>
                    <td class="item-style">${p.getDateOfBirth()}</td>                            
                    <td class="item-style">${p.getTel()}</td>
                    <td class="item-style">${p.getEmail()}</td>
                    <td class="item-style">${p.getAddress()}</p></td>
                    <td class="item-style">${p.getNation()}</p></td>

                </tr>
            </c:forEach>

        </table>

    </div>



</body>


</html>
