package com.tranxuanqui.danhgiarenluyenlv.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.UserAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserListActivity extends AppCompatActivity {

    final String SERVER = "http://192.168.43.217/server/";
    String urlDELETE ="http://192.168.43.217/server/deleteuser.php";
    ListView UserList;
    List<User> userss= new ArrayList<>();
    Button btnAdd;
    UserAdapter userAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);
        addControls();
        addEvents();
        userAdapter= new UserAdapter(this,R.layout.faqs_userchinh,userss);
        UserList.setAdapter(userAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(UserListActivity.this, AddUserActivity.class);
                startActivity(intent);
            }
        });
    }
    private void addEvents() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getuser2.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for( int i=0; i < response.length();i++) {
                            Gson gson = new Gson();
                            try {
                                User ri = gson.fromJson(response.getJSONObject(i).toString(), User.class);
                                userss.add(ri);
                                userAdapter.updateListTitle(userss);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(UserListActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public void DELETE(final int iduser){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, urlDELETE, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(UserListActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UserListActivity.this,UserListActivity.class));
                }else{
                    Toast.makeText(UserListActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UserListActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("iduser",String.valueOf(iduser));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }

    private void addControls() {
        UserList = findViewById(R.id.lvUser);
        btnAdd= findViewById(R.id.btnADDu);
    }
}
