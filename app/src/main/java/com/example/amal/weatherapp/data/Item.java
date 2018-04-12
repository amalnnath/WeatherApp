package com.example.amal.weatherapp.data;

import org.json.JSONObject;

/**
 * Created by Amal on 2018-04-10.
 */

public class Item implements JSONPopulator{

    private Condition condition;

    public Condition getCondition() {
        return condition;
    }

    @Override
    public void populate(JSONObject data) {

        condition = new Condition();
        condition.populate(data.optJSONObject("condition"));

    }
}
