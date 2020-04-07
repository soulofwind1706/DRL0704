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

public class AddUserActivity extends AppCompatActivity {

    String urlADD= "http://192.168.43.217/server/adduser.php";
    EditText edtTen,edtEmail,edtPass,edtIdrole,edtIdlop;
    Button btnAdd, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        addControl();
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ten= edtTen.getText().toString().trim();
                String Email= edtEmail.getText().toString().trim();
                String Pass= edtPass.getText().toString().trim();
                String Role= edtIdrole.getText().toString().trim();
                String Lop= edtIdlop.getText().toString().trim();
                if(Ten.isEmpty()||Email.isEmpty()||Pass.isEmpty()||Role.isEmpty()||Lop.isEmpty()){
                    Toast.makeText(AddUserActivity.this, "Vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    AddSV(urlADD);
                }

            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(AddUserActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AddUserActivity.this, UserListActivity.class));
                }else{
                    Toast.makeText(AddUserActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddUserActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("tenuser",edtTen.getText().toString().trim());
                params.put("emailuser",edtEmail.getText().toString().trim());
                params.put("password",edtPass.getText().toString().trim());
                params.put("idrole",edtIdrole.getText().toString().trim());
                params.put("idlop",edtIdlop.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private void addControl() {
        btnExit=findViewById(R.id.btnexit);
        btnAdd= findViewById(R.id.btnadduser);
        edtTen= findViewById(R.id.edttenadduser);
        edtEmail= findViewById(R.id.edtemailadduser);
        edtPass= findViewById(R.id.edtpassadduser);
        edtIdrole= findViewById(R.id.edtidroleadduser);
        edtIdlop= findViewById(R.id.edtidlopadduser);
    }
}
