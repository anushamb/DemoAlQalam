package com.frocerie.demoalqalam.prayer;

import org.json.JSONObject;

/**
 * Created by avocet on 07/07/17.
 */

public interface VolleyResponse {


    public void success(JSONObject object);
    public void error(String Message);


}
