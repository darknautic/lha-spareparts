/**
 * 
 */

$( document ).ready(function() {
	
});


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
					"partNumber" : $("#partNumber").val(),
					"systems" : systems,
					"providers" : providers,
					"stockMin" : $("#stockMin").val(),
					"salePrice" : $("#salePrice").val()											
					};
	
	//console.log(sparePart);
	
	$.ajax({	
				type:"POST",
	       		url: "newSparePart.jsp",		              
	       		data: "sparePart="+JSON.stringify(sparePart),
	       		//contentType: 'application/json; charset=utf-8',
	       		//dataType: 'json',
	       		success: function(msg)    { $("span#msg").text(msg);   },
	       		error:   function(xml,msg){ $("span#msg").text(" Error"); }
	 });	
		
		
	

	
	
	
	
});


