package com.tranxuanqui.danhgiarenluyenlv.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.UserRoleAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Userrole;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ListRoleActivity extends AppCompatActivity {

    UserRoleAdapter userRoleAdapter;
    List<Userrole> userroles = new ArrayList();
    ListView listView;
    final String SERVER = "http://192.168.43.217/server/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_role);
        addControl();
        addEvent();
        userRoleAdapter= new UserRoleAdapter(this,R.layout.activity_list_role,userroles);
        listView.setAdapter(userRoleAdapter);
    }

    private void addControl() {
        listView= findViewById(R.id.lvrole);
    }

    private void addEvent() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getusersrole.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for( int i=0; i < response.length();i++) {
                            Gson gson = new Gson();
                            try {
                                Userrole ri = gson.fromJson(response.getJSONObject(i).toString(), Userrole.class);
                                userroles.add(ri);
                                userRoleAdapter.updateListTitle(userroles);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(ListRoleActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

}
