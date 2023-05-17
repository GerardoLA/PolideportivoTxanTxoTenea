<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
<div class="container">
    <div class="row">
      <div class="col-md-6 offset-md-3">
        <h2 class="text-center text-dark mt-5">TxanTxoTenea</h2>
        <div class="card my-5">

          <form class="card-body cardbody-color p-lg-5" Action="Desktop" method="post">

            <div class="text-center">
            
              <img src="https://image.spreadshirtmedia.net/image-server/v1/compositions/T996A1PA2179PT10X21Y24D163176781W6288H5644/views/1,width=550,height=550,appearanceId=1,backgroundColor=FFFFFF,noPt=true/la-persona-con-el-signo-de-interrogacion-posavasos.jpg" class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3"
                width="200px" alt="profile"><!-- https://pixabay.com/es/vectors/an%c3%b3nimo-avatar-desconocido-persona-154716/ -->
            </div>
			<br><small style="color: red;">${error}</small> <br>
            <div class="mb-3">
              <input type="text" name="nombre" class="form-control" id="Username" aria-describedby="emailHelp"
                placeholder="Usuario">
            </div>
            <br>
            <div class="mb-3">
              <input type="password" name="contrasena" class="form-control" id="password" placeholder="password">
            </div>
            <br>
            <div class="text-center"><button type="submit" class="btn btn-dark px-5 mb-5 w-100">Login</button></div>
            
          </form>
        </div>

      </div>
    </div>
  </div>
</body>
</html>