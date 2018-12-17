<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>warehouse attendant page</title>
<style type="text/css">
* {
	box-sizing: border-box;
	text-align: right;
}

.column {
	float: left;
	width: 50%;
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
		<%=userName%>, islem yetkisi: depo
	</h3>
	<form action="LogoutController" method="post">
		<input type="submit" value="Cikis!">
	</form>

	<div class="row">
		<div class="column">
			<h2>Siparis Menu</h2>

			<h3>1. Siparis Listeleme</h3>
			<form action="GetAllOrdersController" method="get">
				<input type="submit" value="Listele!">
			</form>

			<h3>2. Siparis Onaylama</h3>
			<form action="ConfirmOrderController" method="post">
				Siparis ID <input name="orderId" type="text"> <br> <input
					type="submit" value="Onayla!">
			</form>
		</div>
		<div class="column">
			<h2>Urun Menu</h2>

			<h3>1. Urun Ekle</h3>
			<form action="InsertProductController" method="post">
				Urun ID <input name="productId" type="text"> <br> 
				Urun Miktar <input name="productAmount" type="text"> <br>
				Urun Ad <input name="productName" type="text"> <br>
				Urun Tip <input name="productType" type="text"> <br> 
				<input type="submit" value="Ekle!">
			</form>

			<h3>2. Urun Sil</h3>
			<form action="DeleteProductController" method="post">
				Urun ID <input name="productId" type="text"> <br>
				<input type="submit" value="Sil!">
			</form>

			<h3>2. Urun Guncelle</h3>
			<form action="UpdateProductController" method="post">
				Urun ID <input name="productId" type="text"> <br> 
				Urun Miktar <input name="productAmount" type="text"> <br>
				Urun Ad <input name="productName" type="text"> <br>
				Urun Tip <input name="productType" type="text"> <br> 
				<input type="submit" value="Guncelle!">
			</form>

			<h3>2. Urun Listele</h3>
			<form action="GetAllProductsController" method="get">
				<input type="submit" value="Listele!">
			</form>
		</div>
	</div>
</body>
</html>