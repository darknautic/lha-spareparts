package com.lhaModel;

import com.mongodb.DBCursor;
import com.mongodb.util.JSON;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Stock stock = new Stock();
        stock._ip="10.29.210.41";
        stock._port=27017;
        stock._dbName="lha";
        stock.connect();


        //List  (Faster)
        System.out.println();
        List b = stock.getSpareOptions();
        System.out.println(b.size());
        System.out.println(b.get(2));


        // Array
        System.out.println();
        Object a[] = stock.getSpareOptionsArray().toArray();
        System.out.println(a.length);
        System.out.println(a[2]);





    }


}

/**
 * Help
 */

// jackson JSON : http://wiki.fasterxml.com/JacksonDownload
// http://api.mongodb.org/java/2.9.2/index.html?com/mongodb/DBCursor.html
// http://jsonformatter.curiousconcept.com/
// http://stackoverflow.com/questions/9562150/java-parsing-an-arraylist-and-setting-them-into-a-object
// http://www.programcreek.com/2013/03/hashset-vs-treeset-vs-linkedhashset/
