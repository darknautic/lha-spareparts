db.spares.insert({
  sparePart : "bujia",
  briefDescription : "",
  brand : "ngk",
  partNumber : "ngk-2021-1",
  system : ["afinacion","arranque"],  
  barCode : "449539480394",  
  model :  {  aveo : {
                      standar : [2007,2008,2009,2010],
                      limited : [2007,2008],
                      sport : [2010]
                     },
              camaro : {
                      v6 : [2007,2008,2009,2010],
                      v8 : [2014]                    
                     }
              ferrari : {
                      class01 : [2010],
                      class02 : [2011],
                      class03 : [2012],
                      class04 : [2013],
                      class05 : [2014],
                     }
    
  },
  providers : ["sagaji" ,"egarama","proveedor-3","proveedor-4"],  
  stockMin : 40,
  existence : 60,  
  salePrice : 16.00, // it is set by manager or business owner
  specialOfferPrice : 10,   /* calculado por porcentage o pesos descontados esto es manejado desde la 
                            interface y aqui solo se guarda el resultado
                            */
  balance : 340  /**
                goal : to know how money is in stock : 
                in(+)(unitprice*how many bougth)  out,sale(-)(salesprice)
                */
});

--------------------------------------------------------------------
--------------------------------------------------------------------

db.spares.insert({
  sparePart : "bujia",
  briefDescription : "", 
  brand : "ngk",
  partNumber : "ngk-2021-1",
  system : ["afinacion"],  
  barCode : "4495394803947",  
  model :  {  aveo : {
                      standar : [2007,2008,2009,2010]
                     }
    
  },
  providers : ["sagaji" ,"egarama"],  
  stockMin : 40,
  existence : 60,  
  specialOfferPrice : 10,
  salePrice : 16.00,
  balance : 340  
});

db.spares.insert({
  sparePart : "bujia laser",
  briefDescription : "",
  brand : "ngk",
  partNumber : "ngk-2021-1-l",
  system : ["afinacion"],  
  barCode : "0870935409504",  
  model :  {  aveo : {
                      limited : [2010,2011,2012,2013]                      
                     }
    
  },
  providers : ["sagaji" ,"rolcar"],
  stockMin : 20,
  existence : 28,  
  specialOfferPrice : null,
  salePrice : 40.00,
  balance : 40  
});

db.spares.insert({
  sparePart : "bujia platinium",
  briefDescription : "",
  brand : "ngk",
  partNumber : "ngk-2021-1-p",
  system : ["afinacion"],  
  barCode : "01582524564564",  
  model :  {  aveo : {                      
                      sport : [2014],
                      limited : [2013]
                     }
    
  },
  providers : ["sagaji" ,"cordero"],
  stockMin : 7,
  existence : 28,  
  specialOfferPrice : null,
  salePrice : 180.00,
  balance : 21  
}); 



db.spares.insert({
  sparePart : "amortiguador delantero izq",
  briefDescription : "",
  brand : "bogue",
  partNumber : "mp-2840",
  system : ["suspension"],  
  barCode : "84657775992",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["syd"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 990.00,
  balance : 0  
});

db.spares.insert({
  sparePart : "amortiguador delantero der",
  briefDescription : "derecho",
  brand : "bogue",
  partNumber : "mp-2841",
  system : ["suspension"],  
  barCode : "846577755457",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["syd"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 990.00,
  balance : 0  
});

db.spares.insert({
  sparePart : "amortiguador delantero izq (gas)",
  briefDescription : "gas izquierdo",
  brand : "bogue",
  partNumber : "mp-2840-g",
  system : ["suspension"],  
  barCode : "85736800223",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["syd"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 1400.00,
  balance : 0  
});

db.spares.insert({
  sparePart : "amortiguador delantero der (gas)",
  briefDescription : "",
  brand : "bogue",
  partNumber : "mp-2841-g",
  system : ["suspension"],  
  barCode : "8573680048485",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["syd"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 1400.00,
  balance : 0  
});

db.spares.insert({
  sparePart : "amortiguador trasero izq y der",
  briefDescription : "",
  brand : "bogue",
  partNumber : "mp-2841-g",
  system : ["suspension"],  
  barCode : "1573680048485",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["syd"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 600.00,
  balance : 0  
});

db.spares.insert({
  sparePart : "amortiguador delantero izq",
  briefDescription : "",
  brand : "kyb",
  partNumber : "kb-2840",
  system : ["suspension"],  
  barCode : "9989889898",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["sagaji"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 780.50,
  balance : 0  
});


db.spares.insert({
  sparePart : "amortiguador delantero der",
  briefDescription : "",
  brand : "kyb",
  partNumber : "kb-2841",
  system : ["suspension"],  
  barCode : "99757575757",  
  model :  {  gol : {
                      standar : [2009,2010,2011,2012]
                     }
    
  },
  providers : ["sagaji"],
  stockMin : 8,
  existence : 8,  
  specialOfferPrice : null,
  salePrice : 780.50,
  balance : 0  
});





db.stockLog.insert({
  eventDate : new Date(),
  io : "in",  
  partNumber : "ngk-2021-1",
  barCode : "4495394803947",  
  howMany : 17,
  howManyBefore : 1,  
  purchasePrice : 5.10,
  provider : "sagaji"
});
