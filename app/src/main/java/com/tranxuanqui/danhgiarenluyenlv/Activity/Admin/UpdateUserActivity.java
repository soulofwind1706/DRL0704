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
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.HashMap;
import java.util.Map;

public class UpdateUserActivity extends AppCompatActivity {

    String urlUp= "http://192.168.43.217/server/updateuser.php";
    int id=0;
    EditText edtTenup,edtEmailup,edtPassup,edtIdroleup,edtIdlopup;
    Button btnUp,btnHuy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        Intent intent= getIntent();
        User user = (User) intent.getSerializableExtra("info");
        addControl();
        id= user.getIduser();
        edtTenup.setText(user.getTenuser());
        edtEmailup.setText(user.getEmailuser());
        edtPassup.setText(user.getPassword()+"");
        edtIdroleup.setText(user.getIdrole()+"");
        edtIdlopup.setText(user.getIdlop()+"");
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Ten= edtTenup.getText().toString().trim();
                String Email= edtEmailup.getText().toString().trim();
                String Pass= edtPassup.getText().toString().trim();
                String Role= edtIdroleup.getText().toString().trim();
                String Lop= edtIdlopup.getText().toString().trim();
                if(Ten.matches("")||Email.matches("")||Pass.matches("")||Role.equals("")||Lop.equals("")){
                    Toast.makeText(UpdateUserActivity.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }
                else {
                    UPSV(urlUp);
                }
            }
        });
    }
    private  void UPSV(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(UpdateUserActivity.this, "Cập nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateUserActivity.this, UserListActivity.class));
                }else{
                    Toast.makeText(UpdateUserActivity.this, "Cập nhập thất bại", Toast.LENGTH_SHORT).show();
                }

            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(UpdateUserActivity.this, "Lỗi !", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("iduser",id+"");
                params.put("tenuser",edtTenup.getText().toString().trim());
                params.put("emailuser",edtEmailup.getText().toString().trim());
                params.put("password",edtPassup.getText().toString().trim());
                params.put("idrole",edtIdroleup.getText().toString().trim());
                params.put("idlop",edtIdlopup.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }

    private void addControl() {
        edtTenup=findViewById(R.id.edttenupuser);
        edtEmailup=findViewById(R.id.edtemailupuser);
        edtPassup=findViewById(R.id.edtpassupuser);
        edtIdroleup=findViewById(R.id.edtidroleupuser);
        edtIdlopup=findViewById(R.id.edtidlopupuser);
        btnUp=findViewById(R.id.btnuserup);
        btnHuy=findViewById(R.id.btnexitup);
    }
}
