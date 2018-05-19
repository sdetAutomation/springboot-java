package com.sdet.auto.springbootjava.proxy;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sdet.auto.springbootjava.model.ResultObject;
import org.springframework.web.client.RestTemplate;

public class GroupktProxy {

    private static final String groupktUrl = "http://services.groupkt.com/country/get/iso2code/";
    static RestTemplate restTemplate = new RestTemplate();

    public static ResultObject getGroupktInfo(String isoCode){

        ResultObject resultObject = new ResultObject();

        String response = restTemplate.getForObject(groupktUrl + isoCode, String.class);

        // due to json from groupkt not formatted correctly, cannot directly serialize to GroupktObject below
        // ResponseEntity<GroupktObject> = restTemplate.getForEntity(groupktUrl + isoCode, GroupktObject.class);

        JsonParser parser = new JsonParser();
        JsonElement responseAsElement = parser.parse(response);

        JsonObject  restResponse = responseAsElement.getAsJsonObject().getAsJsonObject("RestResponse");

        JsonObject  resultAsJsonObj = restResponse.get("result").getAsJsonObject();

        String name = resultAsJsonObj.get("name").getAsString();
        String alpha2_code = resultAsJsonObj.get("alpha2_code").getAsString();
        String alpha3_code = resultAsJsonObj.get("alpha3_code").getAsString();

        resultObject.setName(name);
        resultObject.setAlpha2_code(alpha2_code);
        resultObject.setAlpha3_code(alpha3_code);

        return resultObject;
    }
}