package com.example.dolgozodemo.core;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public final class RequestHandler {
    private RequestHandler() {
    }

    public static Response getRequest(String url) throws IOException {
        HttpURLConnection conn = setupConnection(url);
        return getResponse(conn);
    }

    public static Response postRequestURLEncoded(String url, HashMap<String, String> params) throws IOException {
        HttpURLConnection conn = setupConnection(url);
        conn.setRequestMethod("POST");
        String output = getPostDataString(params);
        doConnectionOutput(conn, output);
        return getResponse(conn);
    }

    private static void doConnectionOutput(HttpURLConnection conn, String output) throws IOException {
        conn.setDoInput(true);
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(os, StandardCharsets.UTF_8));
        writer.write(output);
        writer.flush();
        writer.close();
        os.close();
    }

    private static String getPostDataString(HashMap<String, String> params) {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
            } else {
                result.append("&");
            }
            result.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
        return result.toString();
    }

    public static Response postRequestJSON(String url, String params) throws IOException {
        HttpURLConnection conn = setupConnection(url);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        doConnectionOutput(conn, params);
        return getResponse(conn);
    }

    public static Response putRequestJSON(String url, String params) throws IOException {
        HttpURLConnection conn = setupConnection(url);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", "application/json");
        doConnectionOutput(conn, params);
        return getResponse(conn);
    }

    public static Response deleteRequest(String url) throws IOException {
        HttpURLConnection conn = setupConnection(url);
        conn.setRequestMethod("DELETE");

        return getResponse(conn);
    }

    private static Response getResponse(HttpURLConnection conn) throws IOException {
        int responseCode = conn.getResponseCode();
        InputStream stream;
        if (responseCode < 400) {
            stream = conn.getInputStream();
        } else {
            stream = conn.getErrorStream();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));

        StringBuilder sb = new StringBuilder();
        String s;
        while ((s = bufferedReader.readLine()) != null) {
            sb.append(s).append(System.lineSeparator());
        }
        return new Response(responseCode, sb.toString().trim());
    }

    private static HttpURLConnection setupConnection(String url) throws IOException {
        URL urlObj = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();

        conn.setReadTimeout(15000);
        conn.setConnectTimeout(15000);
        return conn;
    }
}