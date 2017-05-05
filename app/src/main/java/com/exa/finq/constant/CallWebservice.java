package com.exa.finq.constant;

import android.content.Context;
import android.graphics.Color;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Anil Sharma & Swapnil Jadhav on 13/7/16.
 */
public class CallWebservice {
    public static JSONArray jsonArray1 = null;


     /* used it while u get whole data in response  not only id

      @param context
      @param method
      @param url
      @param param
      @param listener
      @param aClass
      @param <T>
*/




    public synchronized static <T> void getWebservice(final Context context, int method, String url, final HashMap<String, String> param, final VolleyResponseListener listener, final Class<T[]> aClass) {
        if (Connectivity.isConnected(context)) {
             CustomProgressDialog.showDialog(context,"Loading...");
            JsonObjectRequest req = new JsonObjectRequest(url, new JSONObject(param),
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                CustomProgressDialog.dismissDialog(context);
                                JSONObject jsonObject = response;
                                String key = jsonObject.getString(IConstants.RESPONSE_KEY);
                                String message = jsonObject.getString(IConstants.RESPONSE_MESSAGE);
//                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                                if (key.equalsIgnoreCase(IConstants.RESPONSE_SUCCESS)) {
                                    jsonArray1 = jsonObject.getJSONArray(IConstants.RESPONSE_INFO);
                                    GsonBuilder gsonBuilder = new GsonBuilder();
                                    Gson gson = gsonBuilder.create();

                                    Object[] object = gson.fromJson(String.valueOf(jsonArray1), aClass);
                                    listener.onResponse(object);
                                } else if (key.equalsIgnoreCase(IConstants.RESPONSE_ERROR)) {
                                    CustomProgressDialog.dismissDialog(context);
                                    listener.onError(message.toString());
                                }
                            } catch (JSONException e) {
                                CustomProgressDialog.dismissDialog(context);
                                listener.onError(e.getMessage());
                            }

                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    CustomProgressDialog.dismissDialog(context);
                    listener.onError(error.toString());
                }
            });
            AppController.getInstance().addToRequestQueue(req);

        } else {
            CustomProgressDialog.showAlertDialogMessage(context, "Check Internet Connection", "Check Internet Connection");
        }
    }


}
