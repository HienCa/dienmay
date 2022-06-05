<%-- 
    Document   : index
    Created on : May 9, 2022, 9:41:34 AM
    Author     : PC
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style/index.css">
        <link rel="stylesheet" href="style/grid.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />


        <title>dienmayCvG</title>
    </head>
    <body>
        <div style="background-color: #25304b">

            <h1 class="userLogin">${username}${e}
                <span style="margin-left: 8px; cursor: pointer"><i class="fas fa-user-circle"></i></span>
            </h1>
            <center><h1 style="color: #fff; background-color: #25304b; ">CvG STORE</h1></center>
            <%--<c:if test="${sessionScope.user.userName == 'nguyenvanhien' }">--%>
                <div class="Management">
                    <a href="Managements.jsp" class="managements">Managements</a>
                </div>
               <%-- </c:if> --%>
            <div class="header" >

                <div class="logo ">
                    <img src="images/logoCvG.jpg" alt="logoCvG" class="logo-img"></img>   
                    <p style="margin: 8px">Mua Theo Cách Chơi Của Bạn!</p>
                </div>
                <form action="FindProductServlet" method="POST">
                    <div class="search">
                        <div class="search-btn">
                            <input class="search-input" name = "findProduct" placeholder ="Bạn tìm gì...">
                            <button type="submit"><i class="search-icon fa fa-search" aria-hidden="true"></i></button>
                            </input>

                        </div>
                    </div>
                </form>

                <div class="cart ">
                    <i class="cart-icon fa fa-cart-plus" aria-hidden="true"></i>
                </div>

                <div class="login-signup">
                    <c:if test="${sessionScope.user == null}">
                        <a style='text-decoration: none; color: #fff' href="SignIn.jsp"><div class="signup">Sign In</div></a>
                        <a style='text-decoration: none; color: #fff' href="LogIn.jsp"><div class="login">Log In</div></a>
                    </c:if>
                    <c:if test="${sessionScope.user != null}">
                        <a style='text-decoration: none; color: #fff' href="LogOut"><div class="login">Log Out</div></a>

                    </c:if>

                </div>
            </div>
        </div>
        <h2 style="background-color: #ffc107; color: black"> ${findEmpty}</h2>
        <div style="color: black;">
            <center>
                <h3>${note}</h3>
                <p>${note1}</p>
                <p>${note2}</p>
                <p>${note3}</p>
                <p>${note4}</p>
            </center>
        </div>
        <div class="sub-nav">     
            <div class="item-main">
                <a href="#laptop-gaming">
                    <i class="fas fa-gamepad icon-config"></i>
                    <p>GAMING</p>
                </a>
                <a href="#laptop-mac">
                    <i class="fab fa-apple icon-config"></i>
                    <p>MAC</p>
                </a>

                <a href="#laptop-design">
                    <i class="fas fa-bezier-curve icon-config"></i>
                    <p>HỌC TẬP, VĂN PHÒNG</p>   
                </a>
            </div>
        </div>
        <!-- 
                <form  action="AllProductServlet" method="processRequest">
                    <button class = "showAllProduct" type="submit">SHOW ALL PRODUCT</button>
                    <div class="slider">
                        <img src="images/desk-1920x200-1.png" alt="slider-img" class="slider-img">
                        <img src="images/hanglaptop.jpg" alt="slider-img" class="slider-img">
                    <a href="#laptop-study">
                                <i class="fas fa-book-reader icon-config"></i>
                                <p>HỌC TẬP, VĂN PHÒNG</p>
                            </a>
                    </div>        
            
                   </form>
        -->



        <div class="container">   
            <div class="row grid wide">
                <div class="col m-12 c-12 l-12">
                    <div class="slideshow-container">

                        <div class="mySlides fade">
                            <img src="images/acer-nitro-5-gaming.jpg" style="width:100%; height: 500px; ">
                        </div>

                        <div class="mySlides fade">
                            <img src="images/lenovo-gaming-legion-5.jpg" style="width: 100%; height: 500px;  ">
                        </div>

                        <div class="mySlides fade">
                            <img src="images/lenovo-ideapad-3-15itl6-i5-82h801p9vn-thumb-600x600.jpg" style="width: 100%; height: 500px; ">
                        </div>

                        <div class="mySlides fade">
                            <img src="images/macbook-pro-m1-2020-gray-600x600.jpg" style="width: 100%; height: 500px;   ">
                        </div>

                    </div>
                </div>
            </div>

            <br>

            <div style="text-align:center">
                <span class="dot"></span> 
                <span class="dot"></span> 
                <span class="dot"></span> 
            </div>


            <div id = "laptop-gaming" class="row grid wide">
                <div class="sub-silder">
                    <img src="images/gamingdes-1200x200.jpg" alt="GAMING-img" class="sub-slider-img">
                </div>
                <c:forEach items="${list}" var="p">
                    <c:choose>
                        <c:when test="${p.getTypeSp() == 'GAMING'}">

                            <div class="devide col m-3 c-3 l-3 devide-js">
                                <img src= "images/${p.getThumbnail()}" alt="gaming-img" class="msi-img">
                                <div class="config-descrip">
                                    <div class="title">${p.getNameSp()}</div>
                                    <div class="price">${p.getPrice()} đ</div> 
                                    <div class="info-detail">

                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">M.HÌNH:</span></b>${p.getScreen()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">CPU:</span></b>${p.getCPU()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">CARD:</span></b>${p.getCard()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">RAM:</span></b>${p.getRAM()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">HARD DRIVE:</span></b>${p.getHardDrive()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">COLOR:</span></b>${p.getColorSP()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">SCREEN:</span></b>${p.getScreen()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">OS:</span></b>${p.getOS()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">TYPE:</span></b>${p.getTypeSp()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">SIZE, WEIGHT:</span></b>${p.getSizeWeight()}</p>

                                    </div>

                                    <div class="buy-group-btn">
                                        <p class="buy-btn">MUA NGAY</p>
                                        <i class="fa-solid fa-cart-circle-plus"></i>
                                    </div>

                                </div>

                            </div>
                        </c:when>    
                    </c:choose>           
                </c:forEach>
            </div>    

            <div id = "laptop-mac" class="row grid wide">
                <div class="sub-silder">        
                    <img src="images/Bannermacbook-1200x200.jpg" alt="MAC-img" class="sub-slider-img">
                </div>
                <c:forEach items="${list}" var="p">
                    <c:choose>
                        <c:when test="${p.getTypeSp() == 'MAC'}">

                            <div class="devide col m-3 c-3 l-3 devide-js">

                                <img src= "images/${p.getThumbnail()}" alt="MAC-img" class="msi-img">

                                <div class="config-descrip">
                                    <div class="title">${p.getNameSp()}</div>
                                    <div class="price">${p.getPrice()} đ</div> 
                                    <div class="info-detail">

                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">M.HÌNH:</span></b>${p.getScreen()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">CPU:</span></b>${p.getCPU()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">CARD:</span></b>${p.getCard()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">RAM:</span></b>${p.getRAM()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">HARD DRIVE:</span></b>${p.getHardDrive()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">COLOR:</span></b>${p.getColorSP()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">SCREEN:</span></b>${p.getScreen()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">OS:</span></b>${p.getOS()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">TYPE:</span></b>${p.getTypeSp()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">SIZE, WEIGHT:</span></b>${p.getSizeWeight()}</p>

                                    </div>
                                    <div class="buy-group-btn">
                                        <p class="buy-btn">MUA NGAY</p>
                                        <i class="fa-solid fa-cart-circle-plus"></i>
                                    </div>
                                </div>

                            </div>
                        </c:when>    
                    </c:choose>           
                </c:forEach>
            </div>                

            <div id = "laptop-design" class="row grid wide">
                <div class="sub-silder">        
                    <img src="images/Hoctapvanphong-1200x200.jpg" alt="HocTapVanPhong-img" class="sub-slider-img">
                </div>
                <c:forEach items="${list}" var="p">
                    <c:choose>
                        <c:when test="${p.getTypeSp() == 'HOC TAP-VAN PHONG'}">

                            <div class="devide col m-3 c-3 l-3 devide-js">
                                <img src= "images/${p.getThumbnail()}" alt="HOC TAP-VAN PHONG-img" class="msi-img">
                                <div class="config-descrip">
                                    <div class="title">${p.getNameSp()}</div>
                                    <div class="price">${p.getPrice()} đ</div> 
                                    <div class="info-detail">

                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">M.HÌNH:</span></b>${p.getScreen()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">CPU:</span></b>${p.getCPU()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">CARD:</span></b>${p.getCard()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">RAM:</span></b>${p.getRAM()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">HARD DRIVE:</span></b>${p.getHardDrive()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">COLOR:</span></b>${p.getColorSP()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">SCREEN:</span></b>${p.getScreen()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">OS:</span></b>${p.getOS()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">TYPE:</span></b>${p.getTypeSp()}</p>
                                        <p style='border-bottom: 1px solid #ccc;'><b><span class="sub-title">SIZE, WEIGHT:</span></b>${p.getSizeWeight()}</p>

                                    </div>
                                    <div class="buy-group-btn">
                                        <p class="buy-btn">MUA NGAY</p>
                                        <i class="fa-solid fa-cart-circle-plus"></i>
                                    </div>
                                </div>

                            </div>
                        </c:when>    
                    </c:choose>           
                </c:forEach>

            </div> 
        </div>

        <!--
            cart
        -->
        <div>
            <div id="myModal" class="modal">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Giỏ Hàng</h5>
                        <span class="close">&times;</span>
                    </div>
                    <div class="modal-body">
                        <div class="cart-row">
                            <span class="cart-item cart-header cart-column">Sản Phẩm</span>
                            <span class="cart-price cart-header cart-column">Giá</span>
                            <span class="cart-quantity cart-header cart-column">Số Lượng</span>
                        </div>
                        <div class="cart-items">

                        </div>
                        <div class="cart-total">
                            <strong class="cart-total-title">Tổng Cộng:</strong>
                            <span class="cart-total-price">0 VNĐ</span>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary close-footer">Đóng</button>
                        <button type="button" class="btn btn-primary order">Thanh Toán</button>
                    </div>
                </div>
            </div>
        </div>


        <div class="footer">
            <div class="row grid wide footer-content">
                <div class=" col c-4 m-4 l-4">
                    <h3>THÔNG TIN LIÊN HỆ</h3>
                    <P>Công ty một số thành viên CvG</P>
                    <div class="info-cty" >
                        <div class="" style="margin:8px">
                            <i class="fas fa-map-marker-alt icon-width" style="min-width: 30px"></i>Bình Mỹ / Củ Chi / TPHCM
                        </div>

                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fas fa-envelope icon-width" style="min-width: 30px"></i>laptopCvG@gmail.com
                        </div>
                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fas fa-phone-alt  icon-width" style="min-width: 30px"></i>0384319201
                        </div>
                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fas fa-clock icon-width" style="min-width: 30px"></i>Thời gian làm việc: 7h:30 - 22h (Thứ 2 - Chủ nhật)
                        </div>
                    </div>

                </div>
                <div class="col c-4 m-4 l-4">
                    <h3>TRUY CẬP NHANH</h3>
                    <div class="info-cty">
                        <div class="footer-info-detail"  style="margin:8px">
                            <i class="fas fa-arrow-right icon-width" style="min-width: 30px"></i><a href="index.jsp">Trang chủ</a>
                        </div>
                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fas fa-arrow-right icon-width" style="min-width: 30px"></i><a>Liên hệ</a>
                        </div>
                    </div>

                </div>

                <div class=" col c-4 m-4 l-4">
                    <h3>FOLLOW US</h3>
                    <div class="info-cty">
                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fab fa-facebook icon-width" style="min-width: 30px"></i><a href= "https://www.facebook.com/nguyenvanhien0506/"></i>Facebook</a>
                        </div>

                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fab fa-youtube icon-width" style="min-width: 30px"></i><a href="" >Youtube</a>
                        </div>

                        <div class="footer-info-detail" style="margin:8px">
                            <i class="fab fa-instagram-square icon-width" style="min-width: 30px"></i><a href="">Instagram</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>


    </body>
    <script src = "index.js"></script>


</html>