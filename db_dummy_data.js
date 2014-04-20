db.spares.insert({
  sparepart : "Bujia",
  briefDescription : "",
  brand : "NGK",
  partNumber : "NGK-2021-1",
  system : ["Afinacion","Arranque"],  
  barCode : "449539480394",  
  model :  {  Aveo : {
                      standar : [2007,2008,2009,2010],
                      limited : [2007,2008],
                      sport : [2010]
                     },
              Camaro : {
                      v6 : [2007,2008,2009,2010],
                      v8 : [2014]                    
                     }
              Ferrari : {
                      class01 : [2010],
                      class02 : [2011],
                      class03 : [2012],
                      class04 : [2013],
                      class05 : [2014],
                     }
    
  },
  Provider : ["Sagaji" ,"Egarama","Proveedor-3","Proveedor-4"],  
  stockMin : 40,
  existence : 60,  
  specialOfferPrice : 10,   /* calculado por porcentage o pesos descontados esto es manejado desde la 
                            interface y aqui solo se guarda el resultado
                            */
  salePrice : 16.00, // It is set by manager or business owner
  balance : 340  /**
                goal : To know how money is in stock : 
                in(+)(unitPrice*how many bougth)  out,sale(-)(salesPrice)
                */
});

--------------------------------------------------------------------
--------------------------------------------------------------------

db.spares.insert({
  sparepart : "Bujia",
  briefDescription : "", 
  brand : "NGK",
  partNumber : "NGK-2021-1",
  system : ["Afinacion"],  
  barCode : "449539480394",  
  model :  {  Aveo : {
                      standar : [2007,2008,2009,2010],                      
                     }
    
  },
  Provider : ["Sagaji" ,"egarama"],  
  stockMin : 40,
  existence : 60,  
  specialOfferPrice : 10,
  salePrice : 16.00,
  balance : 340  
});

db.spares.insert({
  sparepart : "Bujia Laser",
  briefDescription : "",
  brand : "NGK",
  partNumber : "NGK-2021-1-L",
  system : ["Afinacion"],  
  barCode : "0870935409504",  
  model :  {  Aveo : {
                      limited : [2010,2011,2012,2013]                      
                     }
    
  },
  Provider : ["Sagaji" ,"Rolcar"],
  stockMin : 20,
  existence : 28,  
  specialOfferPrice : null,
  salePrice : 40.00,
  balance : 40  
});

db.spares.insert({
  sparepart : "Bujia Platinium",
  brand : "NGK",
  partNumber : "NGK-2021-1-P",
  system : ["Afinacion"],  
  barCode : "01582524564564",  
  model :  {  Aveo : {                      
                      sport : [2014],
                      limited : [2013]
                     }
    
  },
  Provider : ["Sagaji" ,"Cordero"],
  stockMin : 7,
  existence : 28,  
  specialOfferPrice : null,
  salePrice : 180.00,
  balance : 21  
}); 



db.spares.insert({
  sparepart : "Amortiguador Delantero Izq",
  brand : "Bogue",
  partNumber : "MP-2840",
  system : ["Suspension"],  
  barCode : "84657775992",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["SYD"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 990.00,
  balance : 0  
});

db.spares.insert({
  sparepart : "Amortiguador Delantero Der",
  brand : "Bogue",
  partNumber : "MP-2841",
  system : ["Suspension"],  
  barCode : "846577755457",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["SYD"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 990.00,
  balance : 0  
});

db.spares.insert({
  sparepart : "Amortiguador Delantero Izq (Gas)",
  brand : "Bogue",
  partNumber : "MP-2840-G",
  system : ["Suspension"],  
  barCode : "85736800223",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["SYD"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 1400.00,
  balance : 0  
});

db.spares.insert({
  sparepart : "Amortiguador Delantero Der (Gas)",
  brand : "Bogue",
  partNumber : "MP-2841-G",
  system : ["Suspension"],  
  barCode : "8573680048485",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["SYD"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 1400.00,
  balance : 0  
});

db.spares.insert({
  sparepart : "Amortiguador Trasero Izq y Der",
  brand : "Bogue",
  partNumber : "MP-2841-G",
  system : ["Suspension"],  
  barCode : "1573680048485",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["SYD"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 600.00,
  balance : 0  
});

db.spares.insert({
  sparepart : "Amortiguador Delantero Izq",
  brand : "KYB",
  partNumber : "KB-2840",
  system : ["Suspension"],  
  barCode : "9989889898",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["Sagaji"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 780.50,
  balance : 0  
});


db.spares.insert({
  sparepart : "Amortiguador Delantero Der",
  brand : "KYB",
  partNumber : "KB-2841",
  system : ["Suspension"],  
  barCode : "99757575757",  
  model :  {  Gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  Provider : ["Sagaji"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 780.50,
  balance : 0  
});
