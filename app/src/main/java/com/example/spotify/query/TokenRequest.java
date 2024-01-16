package com.example.spotify.query;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class TokenRequest extends StringRequest {
    private static final String TOKEN_URL = "https://accounts.spotify.com/api/token";
    private static final String CLIENT_ID = "3bc12fd1b1ba4cddad30b9a22936c89a";
    private static final String CLIENT_SECRET = "11dd043f4ccd470090c8cdca70ceea11";

    public TokenRequest(Response.Listener<String> listener, Response.ErrorListener errorListener) {
        super(Method.POST, TOKEN_URL, listener, errorListener);
    }

    @Override
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        String authString = CLIENT_ID + ":" + CLIENT_SECRET;
        String encodedAuthString = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            encodedAuthString = java.util.Base64.getEncoder().encodeToString(authString.getBytes());
        }
        headers.put("Authorization", "Basic " + encodedAuthString);
        headers.put("Content-Type", "application/x-www-form-urlencoded");
        return headers;
    }

    @Override
    protected Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credentials");
        return params;
    }
}
