package com.github.jguichallenge.sample.core;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenWeatherGetter implements OpenWeather {
    private final String key;
    private final String urlPrefix;

    public OpenWeatherGetter() {
        this.key = System.getenv("OpenWeather");
        this.urlPrefix = "http://api.openweathermap.org/data/2.5/weather?";
    }

    @Override
    public JSONObject getWeather(String cityValue) {
        JSONObject apiResponse = null;
        try {
            URL url = new URL(this.urlPrefix+"q="+cityValue+"&appid="+this.key);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            String response = this.readResponse(con.getInputStream());
            apiResponse = new JSONObject(response);
            con.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return apiResponse;
    }

    private String readResponse(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(
                new InputStreamReader(inputStream));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
