<%-- 
    Document   : UpdateProduct
    Created on : May 4, 2022, 7:47:16 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Employee</title>
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
    <center><h1>SỬA THÔNG TIN NHÂN VIÊN</h1></center>

    <div class="group-btn">

        <form method='POST' action='UpdateEmployeeServlet' enctype="multipart/form-data">
            <div class="group-form">
                <div class="group-form-items">
                    <label>EMPLOYEE CODE</label><input name='employeeCode' value="${employee.getEmployeeCode()}"  required placeholder="Từ 4 đến 10 ký tự, VD: NV**"><p class="warn">${CheckEmployeeCode}</p>
                </div>

                <div class="group-form-items"> 
                    <label>FULLNAME</label><input name='fullnameEmployee' value="${employee.getFullName()}" required placeholder="Từ 5 đến 200 ký tự, VD: Nguyễn Văn Hiền"><p class="warn">${CheckFullname}</p>
                </div>

                <div class="group-form-items">
                    <label>CCCD / CMND</label><input name='cccd' value="${employee.getCCCD()}" required placeholder="Từ 9 đến 12 ký tự, VD: 342032301"><p  class="warn">${CheckCCCD}</p>
                </div>

                <div class="group-item">

                    <div class="input-gender" style="margin-bottom: 8px;">
                        <label id="gender">GENDER</label><input id="male" type="radio" style="width: 50px" name="gender" required value="Nam"><span for="gender">Nam</span>
                        <input id="female" type="radio" style="width: 50px"  name="gender" required value="Nữ"><span for="female">Nữ</span>
                    </div>
                </div>

                <div class="group-form-items"> 
                    <label>THUMBNAIL</label>
                    <input type="file" name="thumbnail" required value="${employee.getThumbnail()}">


                </div>
                <div class="group-form-items">
                    <label>DATE OF BIRTH</label><input type="date" max="2022-06-10" value="${employee.getDateOfBirth()}" name='date' required ><p class="warn">${CheckDate}</p>
                </div>

                <div class="group-form-items">
                    <label>TEL</label><input name='tel' value="${employee.getTel()}" required placeholder="Từ 10 đến 50 ký tự, VD: 0384319***"><p class="warn">${CheckTel}</p>
                </div>

                <div class="group-form-items">
                    <label>EMAIL</label><input type="email" value="${employee.getEmail()}" name='email'  placeholder="nguyenvanhien@gmail.com"><p class="warn">${CheckEmail}</span>
                </div>

                <div class="group-form-items">
                    <label>ADDRESS</label><textarea  cols="36" rows="5" name='address' required placeholder="Từ 10 đến 200 ký tự, VD: số nhà/ ấp / xã / huyện/ thành phố">${employee.getAddress()}</textarea><p class="warn">${CheckAddress}</span>
                </div>

                <div class="group-form-items">
                    <label>NATION</label><input name='nation' value="${employee.getNation()}" required placeholder="Từ 2 đến 50 ký tự, VD: Kinh"><p class="warn">${CheckNation}</span>
                </div>

            </div>

            <button type="submit">Update Employee</button>
            <button type="reset">CLEAR</button>

            <a href="Employee.jsp"> Back to EMPLOYEE LIST</a>
            <p class="e">${e}</p><p class="success">${success}</p>
        </form>
    </div>
</body>
</html>
