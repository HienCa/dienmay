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
        <title>Insert Customer</title>

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
                margin-left: 20%;
                margin-top: 5%;
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
    <center><h1>THÊM KHÁCH HÀNG</h1></center>
    <center>            <p class="e">${e}</p><p class="success">${success}</p>
    </center>
    <div class="group-btn">

        <form method='POST' action='InsertCustomerServlet' >
            <div class="group-form">
                <%--<div class="group-form-items">
                    <label>CUSTOMER CODE</label><input name='CustomerCode'   value="${CustomerCode}"  placeholder="Từ 4 đến 10 ký tự, VD: KH**"><p class="warn">${CheckCustomerCode}</p>
                </div>--%>

                <div class="group-form-items"> 
                    <label>FULLNAME</label><input name='Fullname' required  value="${Fullname}" placeholder="Từ 4 đến 200 ký tự, VD: Nguyễn Văn Hiền"><p class="warn">${CheckFullname}</p>
                </div>

                <div class="group-item">

                    <div class="input-gender" style="margin-bottom: 8px;">
                        <label id="gender">GENDER</label><input id="male" type="radio" style="width: 50px" name="gender" required value="Nam"><span for="gender">Nam</span>
                        <input id="female" type="radio" style="width: 50px"  name="gender" required value="Nữ"><span for="female">Nữ</span>
                    </div>
                </div>

                <div class="group-form-items">
                    <label>DATE OF BIRTH</label><input type="date" value="${DateOfBirth}" min="2009-01-01" max="2022-01-01" name='DateOfBirth'  ><p class="warn">${CheckDateOfBirth}</p>
                </div>

                <div class="group-form-items">
                    <label>CCCD / CMND</label><input name='CCCD' value="${CCCD}" placeholder="Từ 9 đến 12 ký tự, VD: 342032303"><p class="warn">${CheckCCCD}</p>
                </div>

                <div class="group-form-items">
                    <label>TEL</label><input name='Tel' value="${Tel}" required  placeholder="Từ 9 đến 50 ký tự, VD: 0384319***"><p class="warn">${CheckTel}</p>
                </div>

                <div class="group-form-items">
                    <label>EMAIL</label><input type="email" name='Email'  maxlength="255" value="${Email}"  placeholder="nguyenvanhien@gmail.com"><p class="warn">${CheckEmail}</p>
                </div>

                <div class="group-form-items">
                    <label>ADDRESS</label><textarea  cols="36" rows="5" name='Address' maxlength="255" required placeholder="Từ 5 đến 200 ký tự, VD: số nhà/ ấp / xã / huyện/ thành phố"">${Address}</textarea><p class="warn">${CheckAddress}</p>
                </div>

            </div>

            <button type="submit">Insert Customer</button>
            <button type="reset">CLEAR</button>

            <a href="Customers.jsp"> Back to CUSTOMER LIST</a>
        </form>
    </div>
</body>
</html>
