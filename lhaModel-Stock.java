package com.lhaModel;

/**
 * Created by austsa01 on 11/04/2014.
 */


import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;


import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;


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



}
