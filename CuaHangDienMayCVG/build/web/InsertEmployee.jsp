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
        <title>Insert Employee</title>

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
                margin-left: 10%;

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
    <center><h1>THÊM NHÂN VIÊN</h1></center>
    <center>            <p class="e">${e}</p><p class="success">${success}</p>
    </center>
    <div class="group-btn">

        <form method='POST' action='InsertEmployeeServlet' enctype="multipart/form-data" >
            <div class="group-form">
                <div class="group-form-items">
                    <label>EMPLOYEE CODE</label><input name='employeeCode' value="${employeeCode}"  placeholder="Từ 4 đến 10 ký tự, VD: NV**"><p class="warn">${CheckEmployeeCode}</p>
                </div>

                <div class="group-form-items"> 
                    <label>FULLNAME</label><input name='fullnameEmployee' value="${fullnameEmployee}"  placeholder="Từ 5 đến 200 ký tự, VD: Nguyễn Văn Hiền"><p class="warn">${CheckFullname}</p>
                </div>

                <div class="group-form-items">
                    <label>CCCD / CMND</label><input name='cccd' value="${cccd}"  placeholder="Từ 9 đến 12 ký tự, VD: 342032301"><p  class="warn">${CheckCCCD}</p>
                </div>

                <div class="group-item">

                    <div class="input-gender" style="margin-bottom: 8px;">
                        <label id="gender">GENDER</label><input id="male" type="radio" style="width: 50px" name="gender" required value="Nam"><span for="gender">Nam</span>
                        <input id="female" type="radio" style="width: 50px"  name="gender" required value="Nữ"><span for="female">Nữ</span>
                    </div>
                </div>

                <div class="group-form-items"> 
                    <label>THUMBNAIL</label>
                    <input type="file" required name="thumbnail"  >


                </div>
                <div class="group-form-items">
                    <label>DATE OF BIRTH</label><input type="date" max="2022-06-10" value="${date}" name='date' required ><p class="warn">${CheckDate}</p>
                </div>

                <div class="group-form-items">
                    <label>TEL</label><input name='tel' value="${tel}" required placeholder="Từ 10 đến 50 ký tự, VD: 0384319***"><p class="warn">${CheckTel}</p>
                </div>

                <div class="group-form-items">
                    <label>EMAIL</label><input type="email" value="${email}" name='email'  placeholder="nguyenvanhien@gmail.com"><p class="warn">${CheckEmail}</span>
                </div>

                <div class="group-form-items">
                    <label>ADDRESS</label><textarea  cols="36" rows="5" name='address'  placeholder="Từ 10 đến 200 ký tự, VD: số nhà/ ấp / xã / huyện/ thành phố">${address}</textarea><p class="warn">${CheckAddress}</span>
                </div>

                <div class="group-form-items">
                    <label>NATION</label><input name='nation' value="${nation}" required placeholder="Từ 2 đến 50 ký tự, VD: Kinh"><p class="warn">${CheckNation}</span>
                </div>
            </div>

            <button type="submit">Insert Employee</button>
            <button type="reset">CLEAR</button>

            <a href="Employee.jsp"> Back to EMPLOYEE LIST</a>
        </form>
    </div>
</body>
</html>
