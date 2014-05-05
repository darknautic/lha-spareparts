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
        <!--[if lt IE 9]>
          <script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->










        <!-- CSS code from Bootply.com editor -->
        
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
          <li><a href="main.jsp">Carga Articulos</a></li>
          <li><a href="altaProducto.jsp">Entrada Almacen</a></li>
          <li class="active"><a href="ventaProducto.jsp">Registro de Ventas</a></li>
          <li><a href="inventario.jsp">Inventario</a></li>
        </ul>
      </div><!--/.nav-collapse -->
    </div>
  </div>
  
     <div class="container">
     	<div class="container col-md-7">

<!-- $$$$$$$$$$$$$$$$$$$$ -->

	
	<h2>Nuevo Articulo.</h2>					
				<h7>Registro de Venta</h7><br><br>
				
	      <!-- <form id="newSparePart" role="form" action="">  -->
	      
	      	<!-- Codigo -->
          <div class="form-group">          
            <input id="barCode" type="text" class="form-control" placeholder="Codigo de Barras">
          </div>
	      	
        	<!-- Nombre -->
          <div class="form-group">          
            <input id="cantidad" type="text" class="form-control" placeholder="Cantidad">
          </div>
          
          <!-- Numero de Serie-->
          <div class="form-group">            
            <input id="numeroSerie" type="text" class="form-control" placeholder="Numero de Parte">
          </div>					                
          
          <!-- Numero de Serie-->
          <div class="form-group">            
            <input id="total" type="text" class="form-control" placeholder="Total de la Venta">
          </div>
          
          <div class="form-group">
            <button id="ventaSP" type="submit" class="btn btn-info">Registrar</button>
          </div>
          
      <!-- </form>  -->  
      
      
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
    
    <script type='text/javascript' src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script type='text/javascript' src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
	<script type='text/javascript' src="js/allJs.js"></script>
</html>


    