<%-- 
    Document   : MainMenu
    Created on : Oct 8, 2022, 7:57:33 PM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/styleindex.css" rel="stylesheet">
    
    <title>Nutrition</title>
    
        <style>
        .header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin: 0 20px;
}

.navbar {
  list-style: none;
  display: flex;
  justify-content: center;
  padding: 10px 0;
  margin-bottom: 0;
}

.navbar__link {
  margin: 0 34px;
}

.banner img {
  width: 100%;
}

    </style>
   
</head>


    
<body>
	<div class="header">


		<div>
			<a href="test.html"><img src="image/logo1.jpg"></a>
		</div>

		<div>
			<ul class="navbar">
				<li class="navbar__link"><a href="#">Home</a></li>
				<li class="navbar__link"><a href="#">About</a></li>
				<li class="navbar__link"><a href="#">Food</a></li>
				<li class="navbar__link"><a href="#">Exercise</a></li>
				<li class="navbar__link"><a href="#">Contact</a></li>
			</ul>
		</div>

		<div>
			<form>
				<input type="text" placeholder="Search in website">
				<button type="submit">Search</button>
			</form>
		</div>

	</div>

	<div class="banner">

		<img src="image/Food.jpg" alt="Chanel" />

	</div>

	<div>
		<div>
			<a href="Login.jsp">Login</a><br>
			<a href="RegisterAccount.jsp">Register</a><br>
		</div>
	</div>
    
        <script>
            
        </script>
</body>
</html>
