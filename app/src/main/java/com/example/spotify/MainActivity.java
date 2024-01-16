package com.example.spotify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.spotify.query.TokenRequest;

public class MainActivity extends AppCompatActivity {
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue = Volley.newRequestQueue(this);

        TokenRequest tokenRequest = new TokenRequest(new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("access token", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("error", "onErrorResponse: " + error);
            }
        });

        requestQueue.add(tokenRequest);
    }
}