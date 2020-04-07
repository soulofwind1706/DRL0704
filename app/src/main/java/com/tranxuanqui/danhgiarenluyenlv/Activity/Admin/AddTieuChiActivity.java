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

public class AddTieuChiActivity extends AppCompatActivity {

    String urlADDTC= "http://192.168.43.217/server/addtieuchidanhgia.php";
    EditText edtNoidungTC,editMaxdiemTC,edtIdmucdanhgia;
    Button btnAddTC, btnExitTC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tieu_chi);
        addControl();
        btnAddTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NoidungDM= edtNoidungTC.getText().toString().trim();
                String MaxdiemDM= editMaxdiemTC.getText().toString().trim();
                String Idmucdg= edtIdmucdanhgia.getText().toString().trim();
                if(NoidungDM.isEmpty()||MaxdiemDM.isEmpty()||Idmucdg.isEmpty()){
                    Toast.makeText(AddTieuChiActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    AddSV(urlADDTC);
                }

            }
        });
        btnExitTC.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(AddTieuChiActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddTieuChiActivity.this, ListTieuChiActivity.class));
                }else{
                    Toast.makeText(AddTieuChiActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddTieuChiActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("noidung",edtNoidungTC.getText().toString().trim());
                params.put("maxdiem",editMaxdiemTC.getText().toString().trim());
                params.put("idmucdanhgia",edtIdmucdanhgia.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void addControl() {
        edtIdmucdanhgia= findViewById(R.id.edtaddidmucdanhgia);
        btnExitTC=findViewById(R.id.btnexitTC);
        btnAddTC= findViewById(R.id.btnaddTC);
        edtNoidungTC= findViewById(R.id.edtaddnoidungTC);
        editMaxdiemTC= findViewById(R.id.edtaddmaxdiemTC);
    }
}
