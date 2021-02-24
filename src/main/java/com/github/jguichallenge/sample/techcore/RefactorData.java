package com.github.jguichallenge.sample.techcore;

import org.json.JSONObject;

public class RefactorData {
    private String rawAPIData = "{\"coord\":{\"lon\":37.6156,\"lat\":55.7522},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02d\"}],\"base\":\"stations\",\"main\":{\"temp\":260.43,\"feels_like\":254.18,\"temp_min\":260.15,\"temp_max\":260.93,\"pressure\":1028,\"humidity\":72},\"visibility\":10000,\"wind\":{\"speed\":4,\"deg\":60},\"clouds\":{\"all\":20},\"dt\":1614003334,\"sys\":{\"type\":1,\"id\":9027,\"country\":\"RU\",\"sunrise\":1613968682,\"sunset\":1614005302},\"timezone\":10800,\"id\":524901,\"name\":\"Moscow\",\"cod\":200}\n" +
            "{\"visibility\":10000,\"timezone\":10800,\"main\":{\"temp\":260.43,\"temp_min\":260.15,\"humidity\":72,\"pressure\":1028,\"feels_like\":254.18,\"temp_max\":260.93},\"clouds\":{\"all\":20},\"sys\":{\"country\":\"RU\",\"sunrise\":1613968682,\"sunset\":1614005302,\"id\":9027,\"type\":1},\"dt\":1614003334,\"coord\":{\"lon\":37.6156,\"lat\":55.7522},\"weather\":[{\"icon\":\"02d\",\"description\":\"few clouds\",\"main\":\"Clouds\",\"id\":801}],\"name\":\"Moscow\",\"cod\":200,\"id\":524901,\"base\":\"stations\",\"wind\":{\"deg\":60,\"speed\":4}}";
    private JSONObject jsonObject;

    public RefactorData() {
        this.jsonObject = new JSONObject(rawAPIData);
    }

    public String getImageId(){
        return jsonObject.getJSONObject("weather").getString("icon");
    }

    public String getTemperature() {
        return String.valueOf(jsonObject.getJSONObject("main").getDouble("temp"));
    }
}

