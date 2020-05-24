<html>
<link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
	

		var bnt=$('#carga').val(); 
		 $.post('ServeletControler',{

		 },function(response){

		 var datos = JSON.parse(response);
		 //console.log(datos);

		 var tabladatos = document.getElementById('tablaDatos');
		 for(let item of datos){

		 	tabladatos.innerHTML += `

		 		 <tr>
				 <td>${item.id}</td>
				<td>${item.nombreProducto}</td>
				 <td>${item.precioProducto}</td>
				<td>${item.cantidadProducto}</td>
				<td>${item.totalProducto}</td>
				
				<td> <a href="ServeletControler?btn=ELIMINAR&Id=${item.id}" class="btn btn-warning"> Eliminar<a/> 
					 <a href="botones.jsp?idBus=${item.id}&nombreP=${item.nombreProducto}&precioP=${item.precioProducto}&CantidadP=${item.cantidadProducto}&totalP=${item.totalProducto}"class="btn btn-danger"> Actualizar<a/>	
				</td>
				 </tr>

		 `
		 }



		});
	

		
	});

</script>


<body>
<h2>AGREGAR DATOS</h2>




			
			<a href="botones.jsp" class="btn btn-info">AGREGAR</a>
										
			
			 <table class="table table-dark" id="tablaDatos">
			 	<thead>
			 		<th>Id</th>
			 		<th>Nombre Producto</th>
			 		<th>Precio Producto</th>
			 		<th>Cantidad Producto</th>
			 		<th>Total Producto</th>
					<th>Opciones</th>

			 	</thead>

			 	<tbody>
			 		

			 	</tbody>

			 </table>


			
</body>
</html>


