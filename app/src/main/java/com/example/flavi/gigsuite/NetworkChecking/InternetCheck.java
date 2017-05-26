package com.example.flavi.gigsuite.NetworkChecking;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by junior on 26/05/17.
 */

public class InternetCheck extends AsyncTask<Void, Void, Void> {

    private Activity activity;
    private InternetCheckListener listener;

    public InternetCheck(Activity x){
        activity = x;
    }

    @Override
    protected Void doInBackground(Void... params) {
        boolean b = hasInternetAccess();
        listener.onComplete(b);
        return null;
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) activity.getSystemService(activity.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    private boolean hasInternetAccess() {
        if (isNetworkAvailable()) {
            try {
                HttpURLConnection urlc = (HttpURLConnection) (new URL("http://clients3.google.com/generate_204").openConnection());
                urlc.setRequestProperty("User-Agent", "Android");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode() == 204 &&
                        urlc.getContentLength() == 0);
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("TAG IOException", "There is no internet connection");
            }
        } else {
            Log.d("TAG", "No network available!");
        }
        return false;
    }

    public void isInternetConnectionAvailable(InternetCheckListener x){
        listener = x;
        execute();
    }

    public interface InternetCheckListener{
        void onComplete(boolean connected);
    }

}