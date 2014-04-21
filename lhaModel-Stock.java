package com.lhaModel;

/**
 * Created by austsa01 on 11/04/2014.
 */


import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.*;
import com.mongodb.util.JSON;
import com.mongodb.util.JSONCallback;
import org.omg.CORBA.*;


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
        DBCollection spares = db.getCollection("spares");

        /*handling system array*/
        List<String> systemArray = new ArrayList<String>();
        systemArray = stringFormattedToStringList(newRecord.get("system"));
        //BasicDBObject system = new BasicDBObject("system",systemArray);

        /*handling models JSON document*/
        System.out.println("models ==>"+ newRecord.get("model"));
        //----------------------

        /**
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
         */
            String modelString = new String();
            modelString = newRecord.get("model");
            HashMap<String,Object> auxHash = new HashMap<String, Object>();
            auxHash = formatted01(modelString);




        //----------------------


        BasicDBObject newJSON = new BasicDBObject("sparepart",newRecord.get("sparepart")).
                                append("briefDescription", newRecord.get("briefDescription")).
                                append("brand", newRecord.get("brand")).
                                append("partNumber",newRecord.get("partNumber")).
                                append("system",systemArray).
                                append("barCode",newRecord.get("barCode")).
                                append("model", auxHash);
        //spares.insert(newJSON);

    }


    public static List<String> stringFormattedToStringList(String s) {

        List<String> result = new ArrayList<String>();
        List<String> aux = new ArrayList<String>();
        //return Arrays.asList(s.substring(1,s.length()-1).replaceAll("\"","").split(","));
        aux =  Arrays.asList(s.substring(1,s.length()-1).replaceAll("\"","").split(","));
        // .substring  removes the first an last characters from the string ('[' & ']')
        // .replaceAll removes all quotation marks from the string (replaces with empty string)
        // .split brakes the string into a string array on commas (omitting the commas)
        // Arrays.asList converts the array to a List

        for(int i=0;i<aux.size() ; i++) {
            result.add(aux.get(i).trim());
        }

        return result;
    }



    public static HashMap<String, Object> formatted01(String modelString){
        HashMap<String, Object> auxHash = new HashMap<String, Object>();
        List<String> aux = new ArrayList<String>();
        aux = Arrays.asList(modelString.substring(1,modelString.length() - 1).split("},"));

        System.out.println("substring -" + modelString.substring(1,modelString.indexOf("=")));

        HashMap<String,String> autos = new HashMap<String, String>();
        autos.put("a","a");
        autos.put("b","b");
        autos.put("c","c");

        String s= new String();
        for(int i=0; i < aux.size(); i++)
        {
            if(i < (aux.size()-1) )
                s = aux.get(i).trim()+"}";
            else
                s = aux.get(i).trim();
            //auxHash.put(s.substring(0,s.indexOf("=")),s.replace(s.substring(0,s.indexOf("=")+1),""));
            auxHash.put(s.substring(0,s.indexOf("=")),autos);
            //**********
            // ***************************
            // mandar este string a otra funcion
            System.out.println(s.replace(s.substring(0,s.indexOf("=")+1),""));

            System.out.println(i + " ==> "+s);
        }

        System.out.println(auxHash);

        return auxHash;

    }





}
