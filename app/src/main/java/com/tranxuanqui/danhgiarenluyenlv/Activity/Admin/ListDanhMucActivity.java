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
import com.tranxuanqui.danhgiarenluyenlv.Adapter.MucDanhGiaAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Mucdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListDanhMucActivity extends AppCompatActivity {

    String urlDELETEDM ="http://192.168.43.217/server/deletemucdanhgia.php";

    MucDanhGiaAdapter mucDanhGiaAdapter;
    List<Mucdanhgia> mucdanhgiaList = new ArrayList();
    ListView listView;
    Button btnADDDM;
    final String SERVER = "http://192.168.43.217/server/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_danh_muc);
        addControl();
        addEvent();
        mucDanhGiaAdapter= new MucDanhGiaAdapter(this,R.layout.activity_list_danh_muc,mucdanhgiaList);
        listView.setAdapter(mucDanhGiaAdapter);
        btnADDDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(ListDanhMucActivity.this, AddDanhMucActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addControl() {
        listView= findViewById(R.id.lvDanhmucdanhgia);
        btnADDDM= findViewById(R.id.btnAddDMad);
    }

    private void addEvent() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getmucdanhgia.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for( int i=0; i < response.length();i++) {
                            Gson gson = new Gson();
                            try {
                                Mucdanhgia ri = gson.fromJson(response.getJSONObject(i).toString(), Mucdanhgia.class);
                                mucdanhgiaList.add(ri);
                                mucDanhGiaAdapter.updateListTitle(mucdanhgiaList);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(ListDanhMucActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public void DELETEDM(final int iddm){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, urlDELETEDM, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(ListDanhMucActivity.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(ListDanhMucActivity.this,ListDanhMucActivity.class));
                }else{
                    Toast.makeText(ListDanhMucActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ListDanhMucActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("idmucdanhgia",String.valueOf(iddm));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
}
