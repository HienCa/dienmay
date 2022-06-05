<%-- 
    Document   : index
    Created on : Apr 28, 2022, 7:32:49 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý cửa hàng điện máy</title>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            body{
                color: #fff;
                font-size: 24px; 
                margin: 0; padding: 0;
                box-sizing: border-box;
                min-height: 100%;
                background-image: url("images/nen.jpg");
                background-repeat: no-repeat;
                background-size: cover
            }
            h1{
                margin: 20px;
                text-align: center;
            }
            h2{
                text-align: center;
            }
           
            .container{
                display: flex;
                justify-content: space-around;
                align-items: center;         
   
            }
            a{
                text-decoration: none;
                border: 1px solid #fff;
                border-radius: 16px;
                background-color: transparent;
                padding: 30px;
                color: #fff;
                font-weight: bold;
                text-align: center;
                margin-top: 50px;
            }
            a:hover{
                opacity: 70%;
                border: 3px solid #fff;
            }
        </style>

    </head>
    <body style="font-size: 24px; margin: 0; padding: 0; box-sizing: border-box;">
        
        <div class="header">
            <h1>ĐIỆN MÁY CvG</h1>
            
           
        </div>      
        <h2>${username}</h2>
        <div class="container">
            <a href="Product.jsp">PRODUCT MANAGEMENT</a>
            <a href="Employee.jsp">EMPLOYEE MANAGEMENT</a>
            <a href="Orders.jsp">ORDER MANAGEMENT</a>
            <a href="Customers.jsp">CUSTOMER MANAGEMENT</a>
            
        </div>
        <a href="index.jsp" style="display: block; background-color: transparent; text-align: center; " >Back to HOME</a>
    </body>
</html>
