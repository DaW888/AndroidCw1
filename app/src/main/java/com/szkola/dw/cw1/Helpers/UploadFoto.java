package com.szkola.dw.cw1.Helpers;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class UploadFoto extends AsyncTask {

    private String result;

    public UploadFoto() {

    }

    @Override
    protected Object doInBackground(Object[] objects) {
        String url = (String) objects[0];
        HttpPost httpPost = new HttpPost(url);


        File file = new File("/storage/emulated/0/Pictures/wajda/ludzie/190413_071657.jpg");
        int size = (int) file.length();
        byte[] bytes = new byte[size];

        try {
            BufferedInputStream buf = new BufferedInputStream(new FileInputStream(file));
            buf.read(bytes, 0, bytes.length);
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





        httpPost.setEntity(new ByteArrayEntity(bytes));

        DefaultHttpClient httpClient = new DefaultHttpClient();

        HttpResponse httpResponse;
        try {
            httpResponse = httpClient.execute(httpPost);
            result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Object o) {
        Log.d("asd", result);

        super.onPostExecute(o);
    }
}
