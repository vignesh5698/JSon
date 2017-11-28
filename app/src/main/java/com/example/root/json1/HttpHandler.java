package com.example.root.json1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 11/28/17.
 */

public class HttpHandler {
    public HttpHandler(){}
    private static final String TAG=HttpHandler.class.getSimpleName();
    public String makeServiceCall(String req){
        String response=null;
        try {
            URL url=new URL(req);
            HttpURLConnection con=(HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            InputStream i=new BufferedInputStream(con.getInputStream());
            response=convert(i);
        }catch (Exception e){
            System.out.println("Exception:"+e);
        }
        return response;
    }
    private String convert(InputStream i){
        BufferedReader reader=new BufferedReader(new InputStreamReader(i));
        StringBuilder sb=new StringBuilder();
        String line;
        try {
            while ((line=reader.readLine())!=null){
                sb.append(line).append('\n');
            }
        }catch (Exception e){

        }
        return sb.toString();
    }
}
