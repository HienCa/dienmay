<%-- 
    Document   : LogIn
    Created on : Apr 28, 2022, 8:00:36 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>log In</title>

        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
            }
            body{
                margin-top: 50px;
                background-image: url("images/nen.jpg");
                background-size: cover
            }
            .container{
                min-height: 1000px;
                margin-bottom: 20px;
                margin-left: 35%;
            }
            h1{
                margin-left: 20%;
                color: #fff;
            }
            .group-items{

                max-width: 500px;
                background-color: #fff;
                font-size: 24px;
                border-radius: 8px;
                border: 4px solid #ccc;
            }
            .group-item{
                margin: 30px;

            }
            label{
                display: block;
            }
            input{
                width: 100%;
                padding: 16px;
                border-radius: 8px;
                border: 1px solid #ccc;
            }
            .group-item-btn{
                font-size: 32px;
                background-color: rgb(19, 74, 242);
                width: 100%;
                margin-left: 28px;
                color: #fff;
                max-width: 435px;
                margin-bottom: 20px;
                border-radius: 8px;
                border: 1px solid #ccc;
                cursor: pointer;

            }
            .group-btn-back{
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .btn-back{
                padding: 8px;
                width: 100%;
                background-color: #ccc;
                display: block;
                text-align: center;
                text-decoration: none;
                color: #fff;
            }
            .err{
                color: red;
                margin-left: 5%;
            }
        </style>
    </head>
    <body>

        <form method="POST" action="LogInServlet">
            <div class="container">
                <h1>Log In</h1>
                <div class="group-items">

                    <div class="group-item">
                        <label>Username</label>
                        <input type="text" required name="username" value="${username}"  ${disabled} placeholder="Enter your username"/>
                        <p style="color: red">${CheckUsername} </p>
                    </div>

                    <div class="group-item">
                        <label>Password</label>
                        <input type="password" required name="password" value="${password}" ${disabled} placeholder="Enter your password"/>
                        <p style="color: red">${CheckPassword} </p>

                    </div>

                    <button class="group-item-btn" ${disabled}>Log in</button>
                    <div class="group-btn-back"> 
                        <a href="index.jsp" class="btn-back" style="border-right: 1px solid #fff">Go to Home</a>
                        <a href="SignIn.jsp" class="btn-back ">Go to SignIn</a>
                    </div>
                </div>
                <h2 class="err"> ${e}</h2>


            </div>    
        </form>

    </body>
</html>
