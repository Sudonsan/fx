package com.forex.forex;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiFunction;


import static com.forex.forex.ForexApplication.demo_connection;

public class GETHistory {


     static boolean isArray(final Object obj) {
        if (obj != null)
            return obj.getClass().isArray();
        return false;
    }
    static ObservableList<Candles> getHistoricalData(String tokenization) throws Exception {
        HistoricalData candlesData =new HistoricalData();
        String priceList = sendGetRequest("/candles/1/m1", "num=100" , tokenization);
        System.out.println(priceList);
       // System.out.println("here we are...");
        Gson gson = new Gson();

        JsonObject jsonObject = new JsonParser().parse(priceList).getAsJsonObject();

       /* Double pageName = jsonObject.getAsJsonPrimitive("instrument_id");
                .getAsJsonObject("response").get("instrument_id").getAsDouble();

        String instrumnetId = jsonObject.getAsJsonObject("instrument_id").getAsString();
         System.out.println(pageName);*/

        JsonArray arr = jsonObject.getAsJsonArray("candles");

      //  List<Candles> posts = new ArrayList<Candles>();
        //posts = Arrays.asList(gson.fromJson(arr, Candles[].class));


//
          //'Candles [] arrayCandles = new Candles[arr.size()];

       // ArrayList<Candles> list = new ArrayList<Candles>();
        //JSONArray jsonArray = (JSONArray)jsonObject;


        //JSONArray jArr = ArrayUtil.convert(arr);
      //  System.out.println(jArr);
        //System.out.println(arr.get(1).getAsJsonArray().size());
        //System.out.println(post_id);

        List<Candles> mainDataList = new ArrayList<>();

        for (int i = 0; i < arr.size(); i++) {
            Candles mainData= new Candles();

                //System.out.println(arr.get(i).getAsJsonArray().get(j));
                mainData.setHistoryDate((arr.get(i).getAsJsonArray().get(0)).toString());
                mainData.setBidOpen(arr.get(i).getAsJsonArray().get(1).getAsDouble());
                mainData.setBidclose(arr.get(i).getAsJsonArray().get(2).getAsDouble());
                mainData.setBidhigh(arr.get(i).getAsJsonArray().get(3).getAsDouble());
                mainData.setBidlow(arr.get(i).getAsJsonArray().get(4).getAsDouble());
                mainData.setAskopen(arr.get(i).getAsJsonArray().get(5).getAsDouble());
                mainData.setAskclose(arr.get(i).getAsJsonArray().get(6).getAsDouble());
                mainData.setAskhigh(arr.get(i).getAsJsonArray().get(7).getAsDouble());
                mainData.setAsklow(arr.get(i).getAsJsonArray().get(8).getAsDouble());
                mainData.setTickqty(arr.get(i).getAsJsonArray().get(9).getAsDouble());
                mainDataList.add(mainData);
            }

            candlesData.setCandles(mainDataList);

       /* for (Candles c:candlesData.getCandles())

              {
                  System.out.println(c.getHistoryDate());
                  System.out.println(c.getTickqty());
            
        }*/
            //JSONObject rec = arr.getJSONObject(i);
            //card.set_id(rec.get("ID").toString());




           // String post_id = arr.get(i).getAsJsonObject().get("post_id").getAsString();
           // System.out.println(post_id);



        ObservableList<Candles> list = FXCollections.observableList(mainDataList);

        return list;


       // HistoricalData historicalData = new  HistoricalData();
       // final JsonObject jsonObject =json.getAsJsonObject();
       // JsonElement titleElement = priceList.get("title")

        //ListHistory  list =new ListHistory();

        //historicalData=gson.fromJson(priceList, HistoricalData.class);
        // list.setMainData((List<HistoricalData>) historicalData);
        //System.out.println(list.size());




       // System.out.println(historicalData.getCandles());

       // JsonParser parser = new JsonParser();
       // JsonObject rootObejct = parser.parse(priceList).getAsJsonObject();
       // JsonElement projectElement = rootObejct.get("response");


       // List<Candles> projectList = new ArrayList<>();



//Check if "project" element is an array or an object and parse accordingly...
       /* if (projectElement.isJsonObject()) {
            //The returned list has only 1 element
            candlesData= gson.fromJson(projectElement, HistoricalData.class);

            System.out.println(candlesData.instrumnetId);
            //projectList.add(project);
        }
        else if (projectElement.isJsonArray()) {
            //The returned list has >1 elements
            Type projectListType = new TypeToken<List<Candles>>() {}.getType();
            projectList = gson.fromJson(projectElement, projectListType);
            System.out.println(projectList);
        }*/
      //  Gson gson =new Gson();
       // Type collectionType = new TypeToken<Collection<HistoricalData>>(){}.getType();
       // Collection<HistoricalData> enums = gson.fromJson(priceList, collectionType);

       // Type collectionType = new TypeToken<List<HistoricalData>>(){}.getType();
      //  List<HistoricalData> lcs = (List<HistoricalData>) new Gson().fromJson( priceList , collectionType);

       // candlesData  = gson.fromJson(priceList, HistoricalData.class);



      // Type collectionType = new TypeToken<List<Candles>>(){}.getType();
       // candlesData.candles = (List<Candles>) new Gson().fromJson( priceList , collectionType);

       // System.out.println(candlesData.instrumnetId);
       // System.out.println(candlesData.periodId);
//        System.out.println(candlesData.candles.size());

        //for (int i=0; i< candlesData.candleArray.size();i++)
       // System.out.println(candlesData.candleArray);

       // Gson gson = new GsonBuilder().setPrettyPrinting().create();
      //  String jsonOutput = gson.toJson(priceList);
       // String s=gson.fromJson(priceList,String.class);


        // HistoricalData historicalData = new  HistoricalData();
      //  historicalData  = gson.fromJson(priceList, HistoricalData.class);

       // System.out.println("dataaaa");
      //  System.out.println(jsonOutput);
        }

    public static String sendGetRequest(String path, String param , String token) throws Exception {

        final String path2 = demo_connection + path + "?" + param;
        final URL url = new URL(path2);
        final HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Set the appropriate header fields in the request header. connection.setRequestMethod("GET");
        connection.setRequestProperty("Authorization", token);
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("host", APP.trading_api_host_demo);
        connection.setRequestProperty("port", APP.trading_api_port);
        connection.setRequestProperty("path", path + "/?" + param);


        connection.setRequestProperty("User-Agent", "request");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded'");

        final String response = getResponseString(connection);
        final int responseCode = connection.getResponseCode();

        System.out.println("\nSending 'GET' request: " + path2);
        System.out.println("Response Code : " + responseCode);

        if (responseCode == 200) {
            return response;
        } else {
            throw new Exception(response);
        }
    }

    public static String getResponseString(HttpURLConnection conn) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            final StringBuilder stringBuffer = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                stringBuffer.append(line);

                stringBuffer.append('\r');

            }
            reader.close();
            return stringBuffer.toString();
        }


    }
}


