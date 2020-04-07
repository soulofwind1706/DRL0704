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
import com.tranxuanqui.danhgiarenluyenlv.Adapter.TieuChiAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTieuChiActivity extends AppCompatActivity {

    TieuChiAdapter tieuChiAdapter;
    String urlDELETETC ="http://192.168.43.217/server/deletetieuchidanhgia.php";
    List<Tieuchi> tieuchiList = new ArrayList();
    ListView listView;
    Button btnADDTC;
    final String SERVER = "http://192.168.43.217/server/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_tieu_chi);
        addControl();
        addEvent();
        tieuChiAdapter= new TieuChiAdapter(this,R.layout.activity_list_tieu_chi,tieuchiList);
        listView.setAdapter(tieuChiAdapter);
        btnADDTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ListTieuChiActivity.this, AddTieuChiActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControl() {
        listView= findViewById(R.id.lvTieuchidanhgia);
        btnADDTC= findViewById(R.id.btnAddTieuchiad);
    }

    private void addEvent() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "gettieuchidanhgia.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for( int i=0; i < response.length();i++) {
                            Gson gson = new Gson();
                            try {
                                Tieuchi ri = gson.fromJson(response.getJSONObject(i).toString(), Tieuchi.class);
                                tieuchiList.add(ri);
                                tieuChiAdapter.updateListTitle(tieuchiList);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(ListTieuChiActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public void DELETETC(final int idtc){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, urlDELETETC, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(ListTieuChiActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ListTieuChiActivity.this,ListTieuChiActivity.class));
                }else{
                    Toast.makeText(ListTieuChiActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ListTieuChiActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("idtieuchi",String.valueOf(idtc));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
}
