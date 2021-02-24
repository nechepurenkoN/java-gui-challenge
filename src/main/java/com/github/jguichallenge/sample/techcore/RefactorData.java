package com.github.jguichallenge.sample.techcore;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RefactorData {
    private String key = "4fd3cb7cf5bdac394a0d6c5bcd8cbd54";
    private String urlPrefix = "http://api.openweathermap.org/data/2.5/weather?";
    private JSONObject dataSave;

    public void apiTalk(String cityValue) {
        try {
            URL url = new URL(this.urlPrefix+"q="+cityValue+"&appid="+this.key);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader inside = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = inside.readLine()) != null) {
                content.append(inputLine);
            }
            inside.close();
            dataSave = new JSONObject(content.toString());
            con.disconnect();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getImageId(){
        return dataSave.getJSONArray("weather").getJSONObject(0).getString("icon");
    }

    public String getTemperature() {
        return String.valueOf(Math.round( dataSave.getJSONObject("main").getDouble("temp") - 273.15) );
    }
}

