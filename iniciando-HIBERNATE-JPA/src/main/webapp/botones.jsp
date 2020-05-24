

<html>
<head>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<% 
String idBus= request.getParameter("idBus");
 String nombreeP= request.getParameter("nombreP");
 String PreciioP= request.getParameter("precioP");
 String CantidaadP= request.getParameter("CantidadP");
 String totaalP= request.getParameter("totalP");


 if(idBus==null){
 	idBus="";
 	nombreeP="";
 	PreciioP="";
 	CantidaadP="";
 	totaalP="";

}
%>
 


<body>

<form action="ServeletControler">
<table align="center">
	<thead>
	
	</thead>	
				<tbody>
					
						<tr>
							

								<td>
									
									
				    <p>id</p> <input type="text" name="Id" value="<%=idBus%>">
					<p>Nombre producto</p> <input type="text" name="Nproductos" value="<%=nombreeP%>">
					<p>Precio producto</p> <input type="text" name="Pproductos" value="<%=PreciioP%>">
					<p>Cantidad productos</p> <input type="text" name="Cproductos" value="<%=CantidaadP%>">
					<p>Total producto</p> <input type="text" name="Tproductos"value="<%=totaalP%>">
										
										
										
									
								</td>
						</tr>
				</tbody>
			</table>
			
				<input type="submit" class="btn btn-info" value="GUARDAR" name="btn">
				<input type="submit" class="btn btn-info" value="ACTUALIZAR" name="btn">
</form>
</body>
</html>