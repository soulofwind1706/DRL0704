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
import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateTCActivity extends AppCompatActivity {

    String urlUpTC= "http://192.168.43.217/server/updatetieuchidanhgia.php";
    int idTC=0;
    EditText edtNoidungTC,edtMaxdiemTC,edtIdmucdanhgiaTC;
    Button btnUpTC,btnHuyTC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_tc);
        Intent intent= getIntent();
        addControl();
        Tieuchi tieuchii = (Tieuchi) intent.getSerializableExtra("tc");
        idTC= tieuchii.getIdtieuchi();
        edtNoidungTC.setText(tieuchii.getNoidung());
        edtMaxdiemTC.setText(""+tieuchii.getMaxdiem());
        edtIdmucdanhgiaTC.setText(""+tieuchii.getIdmucdanhgia());

        btnHuyTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnUpTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NoidungTC= edtNoidungTC.getText().toString().trim();
                String MaxdiemTC= edtMaxdiemTC.getText().toString().trim();
                if(NoidungTC.matches("")||MaxdiemTC.matches("")){
                    Toast.makeText(UpdateTCActivity.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
                else {
                    UPTC(urlUpTC);
                }
            }
        });
    }

    private  void UPTC(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(UpdateTCActivity.this, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateTCActivity.this, ListTieuChiActivity.class));
                }else{
                    Toast.makeText(UpdateTCActivity.this, "Cập nhập thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateTCActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("idtieuchi",idTC+"");
                params.put("noidung",edtNoidungTC.getText().toString().trim());
                params.put("maxdiem",edtMaxdiemTC.getText().toString().trim());
                params.put("idmucdanhgia",edtIdmucdanhgiaTC.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void addControl() {
        edtNoidungTC= findViewById(R.id.edtupnoidungTC);
        edtMaxdiemTC= findViewById(R.id.edtupmaxdiemTC);
        edtIdmucdanhgiaTC=findViewById(R.id.edtupidmucdanhgia);
        btnUpTC=findViewById(R.id.btnupTC);
        btnHuyTC= findViewById(R.id.btnexitupTC);
    }
}
