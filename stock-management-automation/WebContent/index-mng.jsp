<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>manager page</title>
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
if(cookies !=null){
for(Cookie cookie : cookies){
	if(cookie.getName().equals("username")) userName = cookie.getValue();
}
}
if(userName == null) response.sendRedirect("login.html");
%>
<h3>Merhaba, personel numaraniz: <%=userName %>, islem yetkisi: supervizor</h3>
<form action="LogoutController" method="post">
	<input type="submit" value="Cikis!">
</form>
	<div class="row">
		<div class="column">
			<h2>Departman Menu</h2>

			<h3>1. Departman Ekleme</h3>
			<form action="InsertDepartmentController" method="post">
				Departman ID <input name="departmentId" type="text"> <br>
				Departman Adi <input name="departmentName" type="text"> <br>
				<input type="submit" value="Ekle!">
			</form>

			<h3>2. Departman Silme</h3>
			<form action="DeleteDepartmentController" method="post">
				Departman ID <input name="departmentId" type="text"> <br>
				<input type="submit" value="Sil!">
			</form>

			<h3>3. Departman Guncelleme</h3>
			<form action="UpdateDepartmentController" method="post">
				Departman ID <input name="departmentId" type="text"> <br>
				Departman Adi <input name="departmentName" type="text"> <br>
				<input type="submit" value="Guncelle!">
			</form>

			<h3>4. Departman Listeleme</h3>
			<form action="GetAllDepartmentsController" method="get">
				<input type="submit" value="Listele!">
			</form>
		</div>
		<div class="column">
			<h2>Tedarikci Menu</h2>
			
			<h3>1. Tedarikci Ekleme</h3>
			<form action="InsertSupplierController" method="post">
				Tedarikci ID <input name="supplierId" type="text"> <br>
				Tedarikci Adi <input name="supplierName" type="text"> <br>
				Urun ID <input name="productId" type="text"> <br>
				<input type="submit" value="Ekle!">
			</form>

			<h3>2. Tedarikci Silme</h3>
			<form action="DeleteSupplierController" method="post">
				Tedarikci ID <input name="supplierId" type="text"> <br>
				<input type="submit" value="Sil!">
			</form>

			<h3>3. Tedarikci Guncelleme</h3>
			<form action="UpdateSupplierController" method="post">
				Tedarikci ID <input name="supplierId" type="text"> <br>
				Tedarikci Adi <input name="supplierName" type="text"> <br>
				Urun ID <input name="productId" type="text"> <br>
				<input type="submit" value="Guncelle!">
			</form>

			<h3>4. Tedarikci Listeleme</h3>
			<form action="GetAllSuppliersController" method="get">
				<input type="submit" value="Listele!">
			</form>
		</div>

		<div class="column">
			<h2>Depo Personeli Menu</h2>
			
			<h3>1. Depo Personeli Ekleme</h3>
			<form action="InsertWarehouseAttendantController" method="post">
				Personel ID <input name="warehouseAttendantId" type="text"> <br>
				Personel PW <input name="password" type="text"> <br>
				Personel Adi <input name="firstName" type="text"> <br>
				Personel Soyadi <input name="lastName" type="text"> <br>
				Departman ID <input name="departmentId" type="text"> <br>
				<input type="submit" value="Ekle!">
			</form>

			<h3>2. Depo Personeli Silme</h3>
			<form action="DeleteWarehouseAttendantController" method="post">
				Personel ID <input name="warehouseAttendantId" type="text"> <br>
				<input type="submit" value="Sil!">
			</form>

			<h3>3. Depo Personeli Guncelleme</h3>
			<form action="UpdateWarehouseAttendantController" method="post">
				Personel ID <input name="warehouseAttendantId" type="text"> <br>
				Personel PW <input name="password" type="text"> <br>
				Personel Adi <input name="firstName" type="text"> <br>
				Personel Soyadi <input name="lastName" type="text"> <br>
				Departman ID <input name="departmentId" type="text"> <br>
				<input type="submit" value="Guncelle!">
			</form>

			<h3>4. Depo Personeli Listeleme</h3>
			<form action="GetAllWarehouseAttendantsController" method="get">
				<input type="submit" value="Listele!">
			</form>
		</div>
	</div>
</body>
</html>