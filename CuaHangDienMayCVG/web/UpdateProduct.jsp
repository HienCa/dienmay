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
        <title>Update Product</title>
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
    <center><h1>SỬA SẢN PHẨM</h1></center>
    <center><p class="e">${e}</p><p class="success">${success}</p></center>
    <div class="group-btn">
        <form method='POST' action='ProductServlet' enctype="multipart/form-data">
            <div class="group-form">
                <div class="group-form-items">
                    <label>PRODUCT CODE</label><input type="text" name="MaSP" required value="${product.getMaSP()}"  ${disabled} placeholder="Từ 4 đến 10 ký tự, VD: SP01">
                    <p class="warn">${CheckMaSP}</p>
                </div>

                <div class="group-form-items"> 
                    <label>PRODUCT NAME</label><input name="NameSp" required value="${product.getNameSp()}"  placeholder="Từ 10 đến 200 ký tự"><p class="warn">${CheckNameSp}</p>
                </div>

                <div class="group-form-items"> 
                    <label>THUMBNAIL</label>
                    <input type="file" name="thumbnail" required value="${product.getThumbnail()}">
                </div>

                <div class="group-form-items"> 
                    <label>TYPE</label>
                    <select name="TypeSP" value="${product.getTypeSp()}" class="group-form-items">
                        <option value="GAMING">GAMING</option>
                        <option value="MAC">MAC</option>
                        <option value="HOC TAP-VAN PHONG">HOC TAP-VAN PHONG</option>
                    </select>
                </div>

                <div class="group-form-items"> 
                    <label>COLOR</label>
                    <select name="ColorSP" value="${product.getColorSP()}" class="group-form-items">
                        <option value="ĐEN">MÀU ĐEN</option>
                        <option value="XÁM">MÀU XÁM</option>
                        <option value="BẠC">MÀU XANH</option>
                        <option value="HỒNG">MÀU HỒNG</option>
                        <option value="XANH">MÀU XANH</option>
                        <option value="ĐỎ">MÀU ĐỎ</option>
                        <option value="VÀNG">MÀU VÀNG</option>
                    </select>
                </div>
                <div class="group-form-items">
                    <label>PRICE</label><input name='Price' value="${product.getPrice()}"  required placeholder="Từ 10 đến 200 ký tự, VD: 20000000"><p class="warn">${CheckPrice}</p>
                </div>

                <div class="group-form-items">
                    <label>SCREEN</label><input name='Screen' value="${product.getScreen()}" required  placeholder="Từ 10 đến 200 ký tự, VD: 15.6 Full HD 165Hz"><p class="warn">${CheckScreen}</p>
                </div>

                <div class="group-form-items">
                    <label>RAM</label><input name='RAM' value="${product.getRAM()}" required  placeholder="Từ 3 đến 200 ký tự, VD: 8GB"><p class="warn">${CheckRam}</p>
                </div>

                <div class="group-form-items">
                    <label>CARD</label><input name='Card' value="${product.getCard()}" required placeholder="Từ 5 đến 200 ký tự, VD: Card rời RTX 3050Ti 4GB"><p class="warn">${CheckCard}</p>
                </div>

                <div class="group-form-items">
                    <label>PIN</label><input name='Pin' value="${product.getPin()}" required placeholder="Từ 4 đến 200 ký tự, VD:60Wh"><p class="warn">${CheckPin}</p>
                </div>

                <div class="group-form-items"> 
                    <label>CPU</label><input name='CPU' value="${product.getCPU()}" required placeholder="Từ 5 đến 200 ký tự, VD: i711800H2.30 GHz"><p class="warn">${CheckCPU}</p>
                </div>

                <div class="group-form-items"> 
                    <label>OS</label>
                    <select name="OS" value="${list.getOS()}" class="group-form-items">
                        <option value="WINDOWS">WINDOWS</option>
                        <option value="Mac OS">MAC OS</option>
                        <option value="Windows 10 Home SL">Windows 10 Home SL</option>
                        <option value="Windows 11 Home SL">Windows 11 Home SL</option>
                        <option value="Windows 7">Windows 7</option>
                    </select>
                </div>


                <div class="group-form-items">
                    <label>SIZE, WEIGHT</label><input name='SizeWeight' required value="${product.getSizeWeight()}"  placeholder="Từ 5 đến 200 ký tự"><p class="warn">${CheckSizeWeight}</p>
                </div>

                <div class="group-form-items">
                    <label>HARD DRIVE</label><input name='HardDrive' required value="${product.getHardDrive()}"  placeholder="Từ 5 đến 200 ký tự, VD: SSD 500GB"><p class="warn">${CheckHardDrive}</p>
                </div>

            </div>

            <button type="submit">Update Product</button>
            <button type="reset">CLEAR</button>

            <a href="Product.jsp"> Back to PRODUCT LIST</a>
            <p class="e">${e}</p><p class="success">${success}</p>
        </form>
    </div>
</body>
</html>
