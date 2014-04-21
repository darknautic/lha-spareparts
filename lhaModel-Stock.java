package com.lhaModel;

/**
 * Created by s47id on 11/04/2014.
 */



import com.mongodb.*;
import java.lang.Object;
import java.net.UnknownHostException;
import java.util.*;
import java.util.ArrayList;



public class Stock {

    public String _ip;
    public int _port;
    public String _dbName;
    private DB db;


    public Stock(){};


    public void connect(){
        try {
            MongoClient mongoClient = new MongoClient(_ip,_port);
            db = mongoClient.getDB(_dbName);

        }catch (UnknownHostException e){
            System.err.println("Connection Failed: " + e);

        }
    }


    public Set<String> collectionList(){

        Set<String> theList = new HashSet<String>();
        theList = db.getCollectionNames();
        return theList;
    }


    public List getSpareOptions(){
        DBCollection spares = db.getCollection("spares");
        //List obj = collection.find( query ).skip( 1000 ).limit( 100 ).toArray();
        List a = spares.find().toArray();
        return a;

    }






    public ArrayList<String> getSpareOptionsArray(){
        DBCollection spares = db.getCollection("spares");
        DBCursor spareOptions = spares.find();
        ArrayList<String> a = new ArrayList<String>();

        try{
            while (spareOptions.hasNext()){
                a.add(spareOptions.next().toString());
            }
        }finally {
            spareOptions.close();
        }


        return a;


    }

    //---

    public List all(){
        DBCollection spares = db.getCollection("spares");
        //List obj = collection.find( query ).skip( 1000 ).limit( 100 ).toArray();
        List a = spares.find().toArray();
        return a;

    }

    public void nuevoRegistro(HashMap<String,String> newRecord){

        /*Init Collection */
        DBCollection spares = db.getCollection("spares");


        /*handling system array*/
        List<String> systemArray = new ArrayList<String>();
        systemArray = stringFormattedToStringList(newRecord.get("system").toLowerCase());



        /*handling models JSON document*/
        String modelString;
        modelString = newRecord.get("model").toLowerCase();
        HashMap<String,Object> modelHash;
        modelHash = stringModelToHashModel(modelString);


        /*handling providers array*/
        List<String> providersArray = new ArrayList<String>();
        providersArray = stringFormattedToStringList(newRecord.get("providers").toLowerCase());


        /*building document to be inserted*/
        BasicDBObject newDocument = new BasicDBObject("sparePart",newRecord.get("sparePart").toLowerCase()).
                append("briefDescription", newRecord.get("briefDescription").toLowerCase()).
                append("brand", newRecord.get("brand").toLowerCase()).
                append("partNumber",newRecord.get("partNumber").toLowerCase()).
                append("system",systemArray).
                append("barCode",newRecord.get("barCode").toLowerCase()).
                append("model", modelHash).
                append("provider",providersArray).
                append("stockMin",Integer.parseInt(newRecord.get("stockMin"))).
                append("salePrice",Double.parseDouble(newRecord.get("salePrice"))).
                append("specialOfferPrice",Double.parseDouble(newRecord.get("specialOfferPrice")));



        spares.insert(newDocument);

    }




    public void entradaAlmacen(HashMap<String,Object> entrada){
        DBCollection spares = db.getCollection("spares");
        DBCollection stockLog = db.getCollection("stockLog");
        int existence = 0;
        double balance = 0.0;

        existence = getExistence(entrada.get("barCode").toString().toLowerCase());
        balance = getBalance(entrada.get("barCode").toString().toLowerCase());

        //howManyBefore
        //System.out.println(getExistence(entrada.get("barCode").toString().toLowerCase()));

        BasicDBObject newLog = new BasicDBObject("eventDate",entrada.get("eventDate")).
                append("io","in").
                append("partNumber",entrada.get("partNumber").toString().toLowerCase()).
                append("barCode",entrada.get("barCode")).
                append("howMany",entrada.get("howMany")). //how many are entering
                append("howManyBefore",existence). //how many exist before this entrance
                append("purchasePrice",entrada.get("purchasePrice")). //unitPrice
                append("provider", entrada.get("provider").toString().toLowerCase());


        stockLog.insert(newLog);

        //Updating Existence of this sparePart
        setExistence(existence + (int)Double.parseDouble(entrada.get("howMany").toString()),
                entrada.get("barCode").toString().toLowerCase());

        //Updating Balance
        setBalance(balance + Double.parseDouble(entrada.get("howMany").toString())*Double.parseDouble(entrada.get("purchasePrice").toString()),
                entrada.get("barCode").toString().toLowerCase());

    }


    public int getExistence(String barCode){
        int result = 0;
        DBCollection spares = db.getCollection("spares");
        BasicDBObject query = new BasicDBObject("barCode", barCode);
        DBCursor existence = spares.find(query);
        DBObject existenceDoc ;

        try {
            if(existence.hasNext()) {  //Not while used - because search by barCode must return only 1 Document
                existenceDoc = existence.next();
                result =(int) Double.parseDouble(existenceDoc.get("existence").toString());

            }
        } finally {
            existence.close();
        }




        return result;
    }


        public void setExistence(int existence,String barCode){
            DBCollection spares = db.getCollection("spares");

            BasicDBObject query = new BasicDBObject("barCode", barCode);
            BasicDBObject newDoc = new BasicDBObject();
            newDoc.append("$set",new BasicDBObject().append("existence",existence));

            spares.update(query,newDoc);

        }


    public double getBalance(String barCode){
        double result = 0;
        DBCollection spares = db.getCollection("spares");
        BasicDBObject query = new BasicDBObject("barCode", barCode);
        DBCursor cursor = spares.find(query);
        DBObject doc ;

        try {
            if(cursor.hasNext()) {  //Not while used - because search by barCode must return only 1 Document
                doc = cursor.next();
                result = Double.parseDouble(doc.get("balance").toString());

            }
        } finally {
            cursor.close();
        }



        return result;
    }


    public void setBalance(double newBalance,String barCode){
        DBCollection spares = db.getCollection("spares");

        BasicDBObject query = new BasicDBObject("barCode", barCode);
        BasicDBObject newDoc = new BasicDBObject();
        newDoc.append("$set",new BasicDBObject().append("balance",newBalance));

        spares.update(query,newDoc);

    }






    public static List<String> stringFormattedToStringList(String s) {

        List<String> result = new ArrayList<String>();
        List<String> aux;
        aux =  Arrays.asList(s.substring(1,s.length()-1).replaceAll("\"","").split(","));
        // .substring  removes the first an last characters from the string ('[' & ']')
        // .replaceAll removes all quotation marks from the string (replaces with empty string)
        // .split brakes the string into a string array on commas (omitting the commas)
        // Arrays.asList converts the array to a List
        /**
         * Example of string that handle
         * [2008, 2009, 2010]
         *
         */

        for(int i=0;i<aux.size() ; i++) {
            result.add(aux.get(i).trim()); //.trim() - clean extra white spaces
        }

        return result;
    }

    public static List<Integer> stringFormattedToIntegerList(String s) {

        List<Integer> result = new ArrayList<Integer>();
        List<String> aux;
        aux =  Arrays.asList(s.substring(1,s.length()-1).replaceAll("\"","").split(","));
        // .substring  removes the first an last characters from the string ('[' & ']')
        // .replaceAll removes all quotation marks from the string (replaces with empty string)
        // .split brakes the string into a string array on commas (omitting the commas)
        // Arrays.asList converts the array to a List
        /**
         * Example of string that handle
         * [2008, 2009, 2010]
         *
         */

        for(int i=0;i<aux.size() ; i++) {
            result.add(Integer.parseInt(aux.get(i).trim())); //.trim() - clean extra white spaces
        }

        return result;
    }





    public static HashMap<String, Object> stringModelToHashModel(String modelString){

        HashMap<String, Object> auxHash = new HashMap<String, Object>();
        List<String> aux;

        aux = Arrays.asList(modelString.substring(1,modelString.length() - 1).split("},"));
        /**
         *
         * Example of string that can handle
         * {Aveo={standar=[2005]}, Ferrari={v6=[2011, 2012, 2013, 2014], v8=[2015], v12=[2014, 2015]}, Golf={limited=[2013], standar=[2008, 2009, 2010]}}
         *
         *
         * {
            Aveo={
                standar=[2005]
            },
            Ferrari={
                v6=[2011, 2012, 2013, 2014],
                v8=[2015],
                v12=[2014, 2015]
            },
            Golf={
                limited=[2013],
                standar=[2008, 2009, 2010]
            }
         }
         *
         *
         */



        String s;
        for(int i=0; i < aux.size(); i++)
        {
            if(i < (aux.size()-1) )
                s = aux.get(i).trim()+"}";
            else
                s = aux.get(i).trim();


            //System.out.println(">>"+s.replace(s.substring(0,s.indexOf("=")+1),""));
            //auxHash.put(s.substring(0,s.indexOf("=")),s.replace(s.substring(0,s.indexOf("=")+1),""));
            auxHash.put(s.substring(0,s.indexOf("=")),
                    arrayStringFormattedToHashMap(s.replace(s.substring(0,s.indexOf("=")+1),"")));

        }


        return auxHash;

    }





    public static HashMap<String, Object> arrayStringFormattedToHashMap(String str) {

        List<String> aux ;
        HashMap<String, Object> auxHash = new HashMap<String, Object>();

        aux = Arrays.asList(str.substring(1, str.length() - 1).split("],"));
        /**
         * .substring -  removes the first an last characters from the string ('{' & '}')
         * .split - brakes the string into a string array on commas (omitting the commas)
         *
         * Example of String that this function can handle
         * {v6=[2011, 2012, 2013, 2014], v8=[2015], v12=[2014, 2015]}
         */


        String s;
        for (int i = 0; i < aux.size(); i++) {
            if (i < (aux.size() - 1))
                s = aux.get(i).trim() + "]";
            else
                s = aux.get(i).trim();

            //System.out.println("><>>" +s);
            //System.out.println("><>>Key:" +s.substring(0,s.indexOf("=")));
            //System.out.println("><>>value:" +s.replace( s.substring(0, s.indexOf("=") + 1), "" ));
            auxHash.put(s.substring(0,s.indexOf("=")),
                        stringFormattedToIntegerList(s.replace(s.substring(0,s.indexOf("=")+1),"")));

        }



        return auxHash;

    }



}
