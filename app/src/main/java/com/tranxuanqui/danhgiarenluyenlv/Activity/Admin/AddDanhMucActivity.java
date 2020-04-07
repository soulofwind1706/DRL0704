package com.tranxuanqui.danhgiarenluyenlv.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.HashMap;
import java.util.Map;

public class AddDanhMucActivity extends AppCompatActivity {

    //http://danhgiarenluyen.000webhostapp.com/getuser.php

    String urlADDDM= "http://192.168.43.217/server/addmucdanhgia.php";
    EditText edtNoidungDM,editMaxdiemDM;
    Button btnAddDM, btnExitDM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_danh_muc);
        addControl();
        btnAddDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NoidungDM= edtNoidungDM.getText().toString().trim();
                String MaxdiemDM= editMaxdiemDM.getText().toString().trim();
                if(NoidungDM.isEmpty()||MaxdiemDM.isEmpty()){
                    Toast.makeText(AddDanhMucActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    AddSV(urlADDDM);
                }

            }
        });
        btnExitDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void AddSV(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(AddDanhMucActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddDanhMucActivity.this, ListDanhMucActivity.class));
                }else{
                    Toast.makeText(AddDanhMucActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddDanhMucActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("noidung",edtNoidungDM.getText().toString().trim());
                params.put("maxdiem",editMaxdiemDM.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void addControl() {
        btnExitDM=findViewById(R.id.btnexitDM);
        btnAddDM= findViewById(R.id.btnaddDM);
        edtNoidungDM= findViewById(R.id.edtaddnoidungDM);
        editMaxdiemDM= findViewById(R.id.edtaddmaxdiemDM);
    }
}
