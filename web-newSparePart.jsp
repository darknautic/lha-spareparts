<%@page import="java.util.HashMap"%>
<%@page import="java.util.Arrays"	%>
<%@page import="java.util.List"		%>

<%@page import="com.lhaModel.SparePart"%>
<%@page import="com.lhaModel.Stock"%>





<%@page	language="java" 
				contentType="text/html; charset=UTF-8"
    		pageEncoding="UTF-8"
    		%>


<%

out.println("++++++++++++++++++++++++++");

	String sparePartString = request.getParameter("sparePart").toString();	
	Stock auxStock = new Stock();
	List<String> aux = auxStock.stringFormattedToStringList(sparePartString);
	
	//out.println(sparePartString);
	//out.println(aux);
	
	
  HashMap<String,String> keyValue = new HashMap<String,String>();
    
  for(String s : aux){	 
	  
	  List<String> a;
	  a = Arrays.asList(s.split(":"));
	  
	  if(a.size() == 1 ){
		  keyValue.put(a.get(0), "");
	  }
	  else if (a.size() == 2 ){
		  keyValue.put(a.get(0),a.get(1));
	  }
	  	    
  }
  
  out.println(keyValue);
  
	
	
	SparePart sparePart = new SparePart();
	sparePart.setBarCode(keyValue.get("barCode"));
	sparePart.setSparePartName(keyValue.get("sparePart"));
	sparePart.setBriefDescription(keyValue.get("briefDescription"));
	sparePart.setBrand(keyValue.get("briefDescription"));
	sparePart.setPartNumber(keyValue.get("briefDescription"));
	//sparePart.setSystems(keyValue.get("briefDescription"));
	//sparePart.setCompatibility(keyValue.get("briefDescription"));
	//sparePart.setProviders(keyValue.get("briefDescription"));
	sparePart.setStockMin(Integer.parseInt(keyValue.get("stockMin").toString()));
	sparePart.setSalePrice(Double.parseDouble(keyValue.get("salePrice").toString()));
	//sparePart.setSpecialOfferPrice(keyValue.get("briefDescription"));
	sparePart.storeSparePart();
	
	
	
	
	
%>
