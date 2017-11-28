package com.example.root.json1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
            
        }

        @Override
        protected void onPostExecute(void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
