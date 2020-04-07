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
import com.tranxuanqui.danhgiarenluyenlv.Model.Mucdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateDMActivity extends AppCompatActivity {

    String urlUpDM= "http://192.168.43.217/server/updatemucdanhgia.php";
    int idDM=0;
    EditText edtNoidungDM,edtMaxdiemDM;
    Button btnUpDM,btnHuyDM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_dm);
        addControl();
        Intent intent= getIntent();
        Mucdanhgia mucdanhgiaa = (Mucdanhgia) intent.getSerializableExtra("dm");
        idDM= mucdanhgiaa.getIdmucdanhgia();
        edtNoidungDM.setText(mucdanhgiaa.getNoidung());
        edtMaxdiemDM.setText(""+mucdanhgiaa.getMaxdiem());

        btnHuyDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnUpDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String NoidungDM= edtNoidungDM.getText().toString().trim();
                String MaxdiemDM= edtMaxdiemDM.getText().toString().trim();
                if(NoidungDM.matches("")||MaxdiemDM.matches("")){
                    Toast.makeText(UpdateDMActivity.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
                else {
                    UPDM(urlUpDM);
                }
            }
        });
    }

    private  void UPDM(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(UpdateDMActivity.this, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateDMActivity.this, ListDanhMucActivity.class));
                }else{
                    Toast.makeText(UpdateDMActivity.this, "Cập nhập thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateDMActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("idmucdanhgia",idDM+"");
                params.put("noidung",edtNoidungDM.getText().toString().trim());
                params.put("maxdiem",edtMaxdiemDM.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }
    private void addControl() {
        edtNoidungDM= findViewById(R.id.edtupnoidungDM);
        edtMaxdiemDM= findViewById(R.id.edtupmaxdiemDM);
        btnUpDM=findViewById(R.id.btnupDM);
        btnHuyDM= findViewById(R.id.btnexitupDM);
    }
}
