<%-- 
    Document   : InsertProduct
    Created on : May 3, 2022, 7:28:08 PM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Order</title>

        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                font-size: 24px;
            }
            body{
                margin: 20px 0px 20px 20px;
                color: #fff;
                font-size: 24px;
                margin: 0;
                padding: 0;
                box-sizing: border-box;
                min-height: 100%;
                background-image: url("images/nen.jpg");
                background-repeat: no-repeat;
                background-size: cover
            }
            .group-btn{
                display: flex;
                max-width: 1000px;
                justify-content: space-around;
                align-items: center;
                margin-left: 35%;
                margin-top: 5%;
            }
            .group-form-items{
                font-size: 16px;
                margin-bottom: 16px;
                min-height: 20px;
                min-width: 100px;
            }
            .group-form-items label{
                min-width: 230px;
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
                min-width: 300px;
                text-align: left;
            }
            input{
                width: 500px;
                padding: 10px;
            }

            .e{
                color: red;
                text-align: center;
            }
            .success{
                color: greenyellow;
                text-align: center;
                font-size: 40px;
            }
            a{
                text-decoration: none;
                display: inline-block;
                background-color: red;
                padding: 22px;
                color: #fff;
                border: 1px solid green;
                font-weight: bold;
                min-width: 400px;
                text-align: center;

            }
            a:hover{
                opacity: 50%;
                
            }
            .warn{
                color: red;
                margin-left: 300px;
            }
        </style>
    </head>
    <body>
    <center><h1>SỬA THÔNG TIN ĐƠN ĐẶT HÀNG</h1></center>

    <div class="group-btn">

        <form method='POST' action='UpdateOrderServlet' >
            <div class="group-form">
                <div class="group-form-items">
                    <label>ORDER CODE</label><input name='orderCode' value="${order.getOrderCode()}"  required placeholder="Từ 4 đến 10 ký tự"><span class="warn">${CheckOrderCode}</span>
                </div>

                <div class="group-form-items"> 
                    <label>PRODUCT NAME</label><input name='productName' value="${order.getProductName()}" required placeholder="Từ 4 đến 200 ký tự, VD: LaptopABC"><span class="warn">${CheckProductCode}</span>
                </div>

                <div class="group-form-items">
                    <label>CUSTOMER NAME</label><input name='customerName'  value="${order.getCustomerName()}" required placeholder="Từ 4 đến 200 ký tự, VD: Văn B"><span class="warn">${CheckCustomerCode}</span>
                </div>


                <div class="group-form-items"> 
                    <label>EMPLOYEE NAME</label><input name='employeeName' value="${order.getEmployeeName()}" required placeholder="Từ 4 đến 200 ký tự, VD: Thị B"><span class="warn">${CheckEmployeeCode}</span>
                </div>

                <div class="group-form-items">
                    <label>ORDER DATE</label><input type="date" max="2022-06-10" name='orderDate'  value="${order.getOrderDate()}" required ><span class="warn">${CheckOrderDate}</span>
                </div>

                <div class="group-form-items">
                    <label>QUANTITY</label><input type="number"  value="${order.getQuantity()}" required min="1" max="1000" name='quantity' placeholder="1"><span class="warn">${CheckQuantity}</span>
                </div>

                <div class="group-form-items">
                    <label>AMOUNT</label><input name='amount' value="${order.getAmount()}"  required min="1000000" max="99999999" placeholder="Từ 7 đến 9 ký tự số, VD: 22000000"><span class="warn">${CheckAmount}</span>
                </div>

                <div class="group-form-items">
                    <label>PAYMENT METHOD</label><!--<input name='paymentMethod' value="${paymentMethod}" required placeholder="Tiền mặt / Chuyển khoản/ Nợ"><p class="warn">${CheckPaymentMethod}</p>  -->
                    <select name="paymentMethod" value="${order.getPaymentMethod()}" class="group-form-items">
                        <option value="Tiền mặt">Tiền mặt</option>
                        <option value="Chuyển khoản">Chuyển khoản</option>
                        <option value="Nợ">Nợ</option>
                    </select>
                </div>


            </div>

            <button type="submit">Update ORDER</button>
            <button type="reset">CLEAR</button>

            <a href="Orders.jsp"> Back to ORDER LIST</a>

            <p class="e">${e}</p><p class="success">${success}</p>
        </form>
    </div>
</body>
</html>
