package com.example.accesscode.exampleasync;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends Activity {

    TextView timeText;
    AsyncTime getTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timeText = (TextView) findViewById(R.id.time);
        getTime = new AsyncTime();
    }

    @Override
    protected void onResume(){
        super.onResume();
        getTime.execute();
    }

    public class AsyncTime extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... voids) {
            String time_url = "http://www.timeapi.org/utc/now";
            try {
                URL url = new URL(time_url);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                String output = readStream(connection.getInputStream());
                output = output.replace('T', '\n');
                return output;
            }
            catch (Exception e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            timeText.setText(s);
        }

        private String readStream(InputStream in) throws IOException {
            char[] buffer = new char[1024 * 4];
            InputStreamReader reader = new InputStreamReader(in, "UTF8");
            StringWriter writer = new StringWriter();
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            return writer.toString();
        }
    }


}
