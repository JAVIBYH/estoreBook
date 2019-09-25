<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>briup电子商务-注册页</title>
<link rel="stylesheet" href="css/common.css"/>
<link rel="stylesheet" href="css/style.css" />

<script type="text/javascript">
		window.onload = function(){
			
			var form = document.getElementById("form");
			form.onsubmit = function(){
				return userNameClick() && passwordClick() && zipCodeClick() && telephoneClick() && emailClick();
			}
			
			document.getElementById("username").onblur = userNameClick;
			document.getElementById("password").onblur = passwordClick;
			document.getElementById("zipCode").onblur = zipCodeClick;
			document.getElementById("telephone").onblur = telephoneClick;
			document.getElementById("email").onblur = emailClick;
			
			//用户名判定
			function userNameClick(){
				var name = document.getElementById("username").value;
				var nameConfirm  = /^\w{3,10}$/;
				var flag = nameConfirm.test(name);
				var errors = document.getElementsByName("error");
				if(flag){
					errors[0].innerHTML = "<img width='30px' height='20px' src='images/gou.png'></img> ";
				} else {
					errors[0].innerHTML = "用户名格式错误!";
				}
				return flag;
			}
			
			//密码判定
			function passwordClick(){
				var password = document.getElementById("password").value;
				var passwordConfirm = /^\w{3,10}$/;
				var flag = passwordConfirm.test(password);
				var errors = document.getElementsByName("error");
				if(flag){
					errors[1].innerHTML = "<img width='30px' height='20px' src='images/gou.png'></img> ";
				} else {
					errors[1].innerHTML = "密码格式错误!";
				}
				return flag;
			}
			
			//邮编判定
			function zipCodeClick(){
				var zipCode = document.getElementById("zipCode").value;
				var zipCodeConfirm = /^\d{3,7}$/;
				var flag = zipCodeConfirm.test(zipCode);
				var errors = document.getElementsByName("error");
				if(flag){
					errors[2].innerHTML = "<img width='30px' height='20px' src='images/gou.png'></img> ";
				} else {
					errors[2].innerHTML = "邮编格式错误!";
				}
				return flag;
			}
			
			//手机号判定
			function telephoneClick(){
				var telephone = document.getElementById("telephone").value;
				var telephoneConfirm = /^\d{11}$/;
				var flag = telephoneConfirm.test(telephone);
				var errors = document.getElementsByName("error");
				if(flag){
					errors[3].innerHTML = "<img width='30px' height='20px' src='images/gou.png'></img> ";
				} else {
					errors[3].innerHTML = "手机号格式错误!";
				}
				return flag;
			}
			
			//电子邮箱判定/^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/
			function emailClick(){
				var email = document.getElementById("email").value;
				var emailConfirm = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/;
				var flag = emailConfirm.test(email);
				var errors = document.getElementsByName("error");
				if(flag){
					errors[4].innerHTML = "<img width='30px' height='20px' src='images/gou.png'></img> ";
				} else {
					errors[4].innerHTML = "邮箱格式错误!";
				}
				return flag;
			}
			
			
		}


</script>

</head>
<body>
	<div class="container2">
    	<div class="header2">
        	<div>
            	<a href="#"><img class="logo" src="images/logon_register.png"></a>
            </div>
            <div>
            	<ul class="tabs">
                	<li class="phone current"><a href="#">用户注册，请将信息填写完整</a></li>
                </ul>
            </div>
            <div class="tlg">
            	已有账号 <a href="login.jsp">登陆</a>
            </div>
        </div>
        <div class="content2">
			<form action="registerServlet" method="post" id="form">
            <ul class="reg_box">
                <li>
                    <span><b>*</b>用户名：</span>
                    <input type="text" name="username" id="username"/>
                    <span name="error" style="width: 120px;height: 20px;"></span>
                </li>
               <li>
                    <span><b>*</b>密码：</span>
                    <input type="password" name="password" id="password"/>
                    <span name="error" style="width: 120px;height: 20px;"></span>
                </li>
                <li>
                    <span><b>*</b>邮编：</span>
                    <input type="text" name="zipCode" id="zipCode"/>
                    <span name="error" style="width: 120px;height: 20px;"></span>
                </li>
                <li>
                    <span><b>*</b>电话：</span>
                    <input type="text" name="telephone" id="telephone"/>
                    <span name="error" style="width: 120px;height: 20px;"></span>
                </li>
                <li>
                    <span><b>*</b>电子邮箱：</span>
                    <input type="text" name="email" id="email"/>
                    <span name="error" style="width: 120px;height: 20px;"></span>
                </li>
                 
            </ul>
            <p>
                <input type="checkbox" checked/>
                 我已阅读并同意
                <a href="#">用户注册协议</a>
            </p>
            <input class="btn_submit" type="submit" value="立即注册"/>
           </form>
        </div>
   	</div>
</body>
</html>
