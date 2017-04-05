package com.manchehahiyo.www.manchechahiyo;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Kishwor Shahi on 4/3/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String Register_Request_URL="http://wwwkishworshahicom.000webhostapp.com/Login.Register.php";
private Map<String, String>params;

public RegisterRequest(String name, String username, int age , String password, Response.Listener<String>listener){
    super(Method.POST, Register_Request_URL, listener,null);
    params = new HashMap<>();
    params.put("name",name);
    params.put("username",username);
    params.put("password",password);
    params.put("age",age+"");
}

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
