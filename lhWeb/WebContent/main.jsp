<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8"> 
        <title>LH ..... </title>
        <meta name="generator" content="Bootply" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/jquery.dataTables.css">
        
        <script type="text/javascript" src="//code.jquery.com/jquery-1.10.2.min.js"></script>
		<script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
		<script type='text/javascript' src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script type='text/javascript' src="js/allJs.js"></script> 
        
        <style type="text/css">
            html,
body {
  height: 100%;
}

#wrap {
  min-height: 100%;
  height: 100%;
  /* Negative indent footer by its height */
  margin: 0 auto -82px 0;
  /* Pad bottom by footer height */
  padding: 0 0 80px 0;
}

/* Set the fixed height of the footer here */
#footer {
  height: 80px;
  background-color: #f5f5f5;
}


#wrap > .center-container {
  padding: 50px 0 0 0;
  margin:0;
}

#footer > .container {
  padding-top:5px
  padding-left: 15px;
  padding-right: 15px;
}

.center-container {
  height:100%;
  display: table;
  width:100%;
  margin:0;
}

.center-row {
  height:50%;
  width:100%;
  display: table-row;
}
  
.center-row > div {
  height:100%;
  width:50%;
  display: table-cell;
  border:0 solid #eee;
  color:#fff;
  vertical-align:middle;
}
</style>
    </head>
   
<script type="text/javascript">
$(document).ready(function() {
	$("#registerSP").click(function(env){	
		systems = [];
		systems.push($("#systems").val());
		
		providers = [];
		providers.push($("#providers").val());
		
		var sparePart = {
						"barCode" : $("#barCode").val(),
						"sparePart" : $("#sparePart").val(),
						"briefDescription" : $("#briefDescription").val(),
						"brand" : $("#brand").val(),
						"brandNumber" : $("#brandNumber").val(),
						"partNumber" : $("#partNumber").val(),
						"systems" : systems,
						"providers" : providers,
						"stockMin" : $("#stockMin").val(),
						"salePrice" : $("#salePrice").val()											
						};	
		$(".form-control").val('');
		ajaxSend("newSparePart.jsp", sparePart);		
	});	
});

/*
$(document).ready(function() {
   var t = $('#compatibilityTable').DataTable();
 
    $('#addRow').on( 'click', function () {
        t.row.add( [
			$("#compatibilityCar").val(),
			$("#compatibilityEdicion").val(),
			$("#compatibilityModelo").val()
            counter +'.1',
            counter +'.2',
            counter +'.3',
            counter +'.4',
            counter +'.5'
        ] ).draw();
    } );
    // Automatically add a first row of data
    //$('#addRow').click();
    
    $("#registerSP").click(function(env){   	
    	//var idx = 1;
    	//alert(t.rows().data().length);
    	//alert(t.cell( idx, 0 ));
    	//alert("No mames");
    	//ajaxSend("newSparePart.jsp", sparePart);
    });
    
    
} );*/
</script>    
    <body>
        
        <!-- Wrap all page content here -->
<div id="wrap">
  
  <!-- Fixed navbar -->
  <div class="navbar navbar-default navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">LH</a>
      </div>
      <div class="collapse navbar-collapse">
        <ul class="nav navbar-nav">
          <li class="active"><a href="main.jsp">Carga Articulos</a></li>
          <li><a href="altaProducto.jsp">Entrada Almacen</a></li>
          <li><a href="ventaProducto.jsp">Registro de Ventas</a></li>
          <li><a href="inventario.jsp">Inventario</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
  
     <div class="container">
     	<div class="container col-md-7">

	<h2>Nuevo Articulo.</h2>					
				<h7>Registro de Articulos</h7><br><br>
				
	      <!-- <form id="newSparePart">--> 
	      <!-- Codigo -->
	      	<div class="form-group"> 
            	<input id="barCode" type="text" class="form-control" placeholder="Codigo de Barras">
	      	</div>
        	
        	<!-- Nombre -->
          <div class="form-group">          
            <input id="sparePart" type="text" class="form-control" placeholder="Nombre de Articulo">
          </div>
          
          <!-- Descripcion-->
          <div class="form-group">            
            <input id="briefDescription" type="text" class="form-control" placeholder="Descripcion">
          </div>
					
					<!-- Marca -->
          <div class="form-group">
            <input id="brand" type="text" class="form-control" placeholder="Marca" list="brands"/>
            <datalist id="brands">              
              <option value="NGK"></option>
              <option value="Bogue"></option>
              <option value="KYB"></option>                           
            </datalist>
          </div>
          <!-- Numero de Marca -->
          <div class="form-group">
            <input id="brandNumber" type="text" class="form-control" placeholder="Numero de Parte" list="brands"/>
          </div>
					
					<!-- Numero de Parte -->
					<div class="form-group">            
            <input id="partNumber" type="text" class="form-control" placeholder="Numero de Referencia (opcional)">
          </div>
					          
          
          <!-- Sistemas -->
          <div class="form-group">
            <input id="systems" type="text" class="form-control" placeholder="Sistemas" list="systems"/>
            <datalist id="systems">              
              <option value="Afinacion"></option>
              <option value="Suspension"></option>                                         
            </datalist>
          </div>
          
          
          <!-- Compatibilidad -->
          <!-- <div class="form-group">
            <input id="compatibility" type="text" class="form-control" placeholder="Car | Edicion | Modelo"/>
          </div>-->
          <!-- 
          <div style="border-color: gray; background-color: blue; width: 100%; padding: 5px;">
          <div class="form-group">
            <div><input id="compatibilityCar" type="text" class="form-control" placeholder="Car"/></div>
          </div>
          <div class="form-group">
            <div><input id="compatibilityEdicion" type="text" class="form-control" placeholder="Edicion"/></div>
           </div>
           <div class="form-group"> 
            <div><input id="compatibilityModelo" type="text" class="form-control" placeholder="Modelo"/></div>
            </div>
            <div class="form-group">
            	<button id="addRow" type="button" class="btn btn-info">Agregar</button>
          	</div>
          	<table id="compatibilityTable" class="display" cellspacing="0" width="100%">
		        <thead>
		            <tr>
		                <th>Car</th>
		                <th>Edicion</th>
		                <th>Modelo</th>
		            </tr>
		        </thead>
    		</table>
            </div>
               -->
          
          <!-- Proveedores -->
          <div class="form-group">
            <input id="providers" type="text" class="form-control" placeholder="Proveedores" list="providersList"/>
            <datalist id="providersList">              
              <option value="Sagaji"></option>
              <option value="Rolecar"></option>
              <option value="Cordero"></option>
              <option value="Egarama"></option>
              <option value="SYD"></option>                                         
            </datalist>
          </div>
          
          <!-- Stock Minimo -->
					<div class="form-group">            
            <input id="stockMin" type="number" min="0" class="form-control" placeholder="Minimo en Almacen">
          </div>
          
          <!-- Precio Venta -->
					<div class="form-group">            
            <input id="salePrice" type="number" min="0" class="form-control" placeholder="Precio Venta">
          </div>
          
          <!-- Precio Especial -->
					<div class="form-group">            
            <input id="specialOfferPrice" type="number" min="0" class="form-control" placeholder="Precio Especial / Promocion ">
          </div>
          
          
          
          <div class="form-group">
            <button id="registerSP" type="submit" class="btn btn-info">Registrar</button>
          </div>
          
       <!-- </form> -->
      
      <div id="reponse"></div>
				
				<span id="msg"></span>
				<br><br><br><br><br>	
					
	
</div>
  	</div>

</div>
<!-- 
<div id="footer">
  <div class="container">
    <p>&nbsp;</p>
    <p class="lead">This Bootstrap layout was made @<a href="">Bootply.com</a></p>
  </div>
</div>-->
        
    </body>
</html>


    