package com.example.bittu.urlconnection;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{
    TextView textView;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textViewshow);
        textView2 = (TextView)findViewById(R.id.textView2);
        new checkConnextion().execute("http://www.google.com");

    }
    class checkConnextion extends AsyncTask<String,Void,String>
    {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            textView2.setText("response code is :");
        }

        @Override
        protected String doInBackground(String... pram) {
            URL url = null;
            try
            {
                url =new URL(pram[0]);
            } catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            try
            {
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                return String.valueOf(urlConnection.getResponseCode());


            }
            catch(IOException e)
            {
                Log.e("Error",e.getMessage(),e);
            }
            return null;
        }
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            textView.setText(String.valueOf(s));
        }
        }
    }



