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

        /**
         *
         * Lista de todas las refacciones
         *
         * */
        System.out.println();
        System.out.println("Method \"all\".. ");
        b = stock.all();
        for(int i = 0; i < b.size();i++)
            System.out.println(b.get(i));




        /**
         *
         * Registrar Nueva Refaccion
         *
         * */

        HashMap<String, String> newRecord = new HashMap<String, String>();

        /*nombre de la refaccion*/
        newRecord.put("sparepart", "Led");

        /*descripcion breve de la refaccion -- este campo tambien es utilizado en las busquedas*/
        newRecord.put("briefDescription", "Led super luminoso");


        /*Marca de  la refaccion*/
        newRecord.put("brand", "Infra");

        /*Codigo de la refaccion */
        newRecord.put("partNumber", "INFR-3232-327");


        /*definiendo sistemas compatibles con esta refaccion*/
        List<String> sistemas = new ArrayList<String>();
        sistemas.add("Electrico");
        sistemas.add("Iluminacion");
        sistemas.add("Super Faros");
        newRecord.put("system",sistemas.toString());


        /*Codigo de barras*/
        newRecord.put("barCode","849406967");


        /*definiendo los automobiles ,  modelos y ediciones compatibles con esta refaccion*/
        HashMap<String, String> models = new HashMap<String, String>();

        HashMap<String, String> Golf = new HashMap<String, String>();
        HashMap<String, String> Aveo = new HashMap<String, String>();
        HashMap<String, String> Ferrari = new HashMap<String, String>();

        List<String> golfStandar = new ArrayList<String>();
        List<String> golfLimited = new ArrayList<String>();
        List<String> aveoStandar = new ArrayList<String>();
        List<String> ferrariV6 = new ArrayList<String>();
        List<String> ferrariV8 = new ArrayList<String>();
        List<String> ferrariV12 = new ArrayList<String>();

        golfStandar.add("2008");golfStandar.add("2009");golfStandar.add("2010");
        golfLimited.add("2013");
        aveoStandar.add("2005");
        ferrariV6.add("2011");ferrariV6.add("2012");ferrariV6.add("2013");ferrariV6.add("2014");
        ferrariV8.add("2015");
        ferrariV12.add("2014");ferrariV12.add("2015");


        Golf.put("standar",golfStandar.toString());
        Golf.put("limited",golfLimited.toString());
        Aveo.put("standar",aveoStandar.toString());
        Ferrari.put("v6",ferrariV6.toString());
        Ferrari.put("v8",ferrariV8.toString());
        Ferrari.put("v12",ferrariV12.toString());


        models.put("Golf",Golf.toString());
        models.put("Aveo",Aveo.toString());
        models.put("Ferrari",Ferrari.toString());

        newRecord.put("model",models.toString());
        System.out.println();
        //System.out.println("models : " + models.toString());



        /*otro campo*/


        System.out.println(newRecord);
        System.out.println(newRecord.get("sparepart"));
        System.out.println(newRecord.size());




        stock.nuevoRegistro(newRecord);




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
