package com.example.root.json1;

import android.app.ProgressDialog;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ProgressDialog progressDialog;
    private ListView lv;
    private static String url="https://api.androidhive.info/contacts/";
    ArrayList<HashMap<String,String>> contactlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactlist=new ArrayList<>();
        lv=(ListView)findViewById(R.id.list);
        new GetContacts().execute();
    }
    private class GetContacts extends AsyncTask<void,void,void>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog=new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Please Wait..");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected void doInBackground(void... params) {
            HttpHandler sh=new HttpHandler();
            String jsonstr=sh.makeServiceCall(url);
            //Log.e(TAG,"Respose from URL");
            if(jsonstr!=null){
            try{
                JSONObject jsonobj=new JSONObject(jsonstr);
                JSONArray contacts=new jsonobj.getJSONArray("contacts");
                for (int i=0;i<contacts.length();i++){
                    JSONObject c=contacts.getJSONObject(i);
                    String id=c.getString("id");
                    String name=c.getString("name");
                    String email=c.getString("email");
                    String address=c.getString("address");
                    String gender=c.getString("gender");
                    JSONObject phone=c.getJSONObject("phone");
                    String mobile=phone.getString("mobile");
                    String home=phone.getString("home");
                    String office=phone.getString("office");
                    HashMap<String,String> contact=new HashMap<>();


                }
            }catch (Exception e){

            }
            }
        }
        }

        @Override
        protected void onPostExecute(void aVoid) {
            super.onPostExecute(aVoid);
    }
}
