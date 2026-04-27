<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>	
<c:url var="APIurl" value="/api-web-user"/>
<c:url var="LoginURL" value="/dang-nhap"/>
<c:url var="RegisterURL" value="/dang-ky"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Đăng ký tài khoản</title>
</head>
<body>
	<div class="container">
		<!-- <h1 class="form-heading">login Form</h1> -->
		<div class="login-form">
			<div class="main-div">
				<c:if test="${not empty messageResponse}">
					<div class="alert alert-${alert}">
  						${messageResponse}
					</div>
				</c:if>
				<form id="formSubmit">
					<div class="form-group">
						<input type="text" class="form-control" id="userName" name="userName"
							placeholder="Tên đăng nhập">
					</div>
                    <div class="form-group">
						<input type="text" class="form-control" id="fullName" name="fullName"
							placeholder="họ và tên">
					</div>
					<div class="form-group">
                        <input type="password" class="form-control" id="password" name="password" 
                            placeholder="Mật khẩu">
                    </div>
                    <div class="form-group">
                        <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" 
                            placeholder="Nhập lại mật khẩu">
                    </div>
                    <div class="form-group" style="display: flex; justify-content: space-between; align-items: flex-end;">
                        <input type="button" class="btn btn-white btn-warning btn-bold" id = "btnRegister" value="Đăng ký" />
                       
                        <button type="btnFilter" class="btn dec btn-warning mt-2" >
                            <a href='<c:url value="/thoat?action=logout" />'  style="text-decoration: none; color: inherit;">
                            Thoát
                            </a>
                        </button>
                    </div>
				</form>
			</div>
		</div>
	</div>
<script>
    $('#btnRegister').click(function (e) {
        e.preventDefault();
        var data = {};
        var formData = $('#formSubmit').serializeArray();
        $.each(formData, function (i, v) {
            data[""+v.name+""] = v.value;
        });

        // kiểm tra mật khẩu nhập lại
        if (data["password"] !== data["confirmPassword"]) {
        	window.location.href = "${RegisterURL}?action=register&message=password_not_match";
            return;
        }
        delete data["confirmPassword"];
        addUser(data);
    });
    function addUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(data),
            dataType: 'json',
            success: function (result) {
            	window.location.href = "${LoginURL}?action=login&message=register_success";
            },
            error: function (error) {
            	window.location.href = "${RegisterURL}?action=register&message=register_failed";
            }
        })
    }
</script>
</body>
</html>
