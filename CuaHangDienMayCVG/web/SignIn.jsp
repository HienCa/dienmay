<%-- 
    Document   : SignIn
    Created on : Apr 28, 2022, 8:11:22 AM
    Author     : PC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign In</title>
        <style>
            *{
                padding: 0;
                margin: 0;
                box-sizing: border-box;
                
            }
            body{
                margin-top: 20px;
                background-image: url("images/nen.jpg");
                background-size: cover
            }
            .container{
                min-height: 1000px;
                margin-bottom: 10px;
                margin-left: 35%;
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
                margin-bottom: 40px;
                border-radius: 8px;
                border: 1px solid #ccc;
                cursor: pointer;

            }
            .input-gender{
                display: flex;
                justify-content: space-around;
                align-content: center;
                border: 1px solid #ccc;
                padding: 16px;
                border-radius: 8px;
            }
            h1{
                margin-left: 20%;
                color: #fff;
            }
            .group-btn-back{
                display: flex;
                justify-content: space-between;
                align-items: center;
            }
            .btn-back{
                padding: 8px;
                min-width: 50%;
                background-color: #ccc;
                display: inline-block;
                text-align: center;
                text-decoration: none;
                color: #fff;
            }
            h2{
                color: greenyellow;
            }
            h3{
                color: red;
            }
            .Notification{
                text-align: center;
                margin-bottom: 20px;
            }
            .charLenght{
                color:#ccc;
            }
        </style>
    </head>
    <body>
    
        <form method="POST" action="SignInServlet">
            <div class="container">
                <h1>Sign In</h1>
                <div class="group-items">
                        
                        <div class="group-item">
                            <label>Username</label>
                            <input type="text"  name="username" value="${username}"  placeholder="Enter your username"/></span><span id="error-Username" style="color: red">${checkUsername} </span>
                        </div>
                        
                        <div class="group-item">
                            <label>Email</label>
                            <input type="email"  name="email" value="${email}" placeholder="Enter your email"/></span>
                        </div>
                        
                        <div class="group-item">
                            <label>Tel</label>
                            <input type="text"  name="tel"  value="${tel}" placeholder="Enter your tel"/></span ><span id="error-Tel" style="color: red">${checkTel} </span>
                        </div>    
                    
                        <div class="group-item">
                            <label>Password</label>
                            <input type="password"  name="password1" value="${password1}" placeholder="Enter your password"/><span id="error-Password" style="color: red">${checkPass} </span>
                        </div>
                    
                        <div class="group-item">
                            <label>Confirm Password</label>
                            <input type="password"  name="password2" value="${password1}" placeholder="Confirm your password"/><span id="error-Confirm Password" style="color: red">${checkPass} </span>
                        </div>
                        
                        <div class="group-item">
                            <label>Date of birth</label>
                            <input type="date"  name="date" value="${date}"  placeholder="Enter your date of birth: DD/MM/YYYY"/></span><span id="error- Date of Birth" style="color: red">${checkDate} </span>
                        </div>
                                      
                        <div class="group-item">
                            <label id="gender">Gender</label>
                            <div class="input-gender">
                                <input id="male" type="radio" name="gender" style="width: 50px"    value="Male"><label for="gender">Male</label>
                                <input id="female" type="radio" name="gender" style="width: 50px"   value="Female"><label for="gender">Female</label>
                            </div>
                        </div>                       
                                           
                        <div class="group-item">
                            <label>Address</label>
                            
                            <textarea name="address" rows="6" cols="56" >${address}</textarea></span><span id="error-Address" style="color: red">${CheckAddress} </span>
                        </div>


                        <button id="btn-SignIn" class="group-item-btn">Sign in</button>
                        <div class="group-btn-back">
                            
                            <a href="index.jsp" class="btn-back" style="border-right: 1px solid #fff">Go to Home</a>
                            <a href="LogIn.jsp" class="btn-back ">Go to LogIn</a>
                        </div>
                </div>
                

            </div>    
            <div class="Notification"> 
                <h2>${success}</h2>
                <h3>${er}</h3>
                <h3>${exist}</h3>
            </div>
        </form>
        
    </body>
</html>
