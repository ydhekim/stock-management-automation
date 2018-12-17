<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>employee page</title>
<style type="text/css">
* {
	box-sizing: border-box;
	text-align: right;
}

.column {
	float: left;
	width: 33.33%;
	padding: 10px;
	border: 1px solid black;
}

.row:after {
	content: "";
	display: table;
	clear: both;
}
</style>
</head>
<body>
	<%
		String userName = null;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username"))
					userName = cookie.getValue();
			}
		}
		if (userName == null)
			response.sendRedirect("login.html");
	%>
	<h3>
		Merhaba, personel numaraniz:
		<%=userName%>, islem yetkisi: siparis
	</h3>
	<form action="LogoutController" method="post">
		<input type="submit" value="Cikis!">
	</form>

	<div class="row">
		<div class="column">
		<h2>Siparis Menu</h2>

			<h3>1. Siparis Ver</h3>
			<form action="PlaceOrderController" method="post">
			Siparos ID <input name="orderId" type="text"> <br> 
			Tedarikci ID <input name="supplierId" type="text"> <br> 
			Personel Numaraniz <input name="employeeId" type="text"> <br> 
			Urun Miktari <input name="orderAmount" type="text"> <br> 
			<input type="submit" value="Siparis Ver!">
			</form>

			<h3>2. Siparis Durumunu Gor</h3>
			<form action="ShowOrderStatusController" method="post">
				Personel Numaraniz <input name="employeeId" type="text"> <br> <input
					type="submit" value="Gor!">
			</form>
		</div>
	</div>

</body>
</html>