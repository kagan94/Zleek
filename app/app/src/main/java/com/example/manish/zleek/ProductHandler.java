package com.example.manish.zleek;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by Leo on 27-Nov-16.
 */

public class ProductHandler {

    public void ProductHandler(){
        String url = "";

        getInfoByUrl();

    }

    public void getInfoByUrl()
    {
        // Example of needed url - https://api.zalando.com/articles?gender=male
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https")
                .authority("api.zalando.com")
                .appendPath("articles");

        // Add some params here
        builder.appendQueryParameter("gender", "male");

        String request_url = builder.build().toString();

        Log.d("My app", request_url);
        Log.e("My app", request_url);
        System.out.println(request_url);


        // Send get request and receive
       // JSONObject json = readJsonFromUrl(request_url);

        try {
            new getProducts().execute(new URL(request_url));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        // String json_info = json_obj.toString();
        // System.out.println(json_obj.get("content"));

//        System.out.println(json);
//        JSONArray arr=null;
//        try {
//            arr = json.getJSONArray("content");
//            // Show products
//            for (int i = 0; i < arr.length(); i++) {
//                JSONObject o = arr.getJSONObject(i);
//                System.out.println(o);
//            }
//
//        } catch (JSONException e) {
//            System.out.println(e);
//        }

    }

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }


    private class getProducts extends AsyncTask<URL, Integer, JSONObject> {
        protected JSONObject doInBackground(URL... urls) {
            JSONObject json = null;
            try {
                InputStream is = urls[0].openStream();
                try {
                    BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                    String jsonText = readAll(rd);
                    json = new JSONObject(jsonText);
                } catch (JSONException e) {
                    e.printStackTrace();
                } finally {
                    is.close();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return json;
        }

        protected void onPostExecute(JSONObject result) {
            Log.d("tag", result.toString());
        }
    }
}
