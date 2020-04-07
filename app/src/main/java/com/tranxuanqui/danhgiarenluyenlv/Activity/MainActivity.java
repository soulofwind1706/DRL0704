package com.tranxuanqui.danhgiarenluyenlv.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.ShowPointActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.CanBoPhongCTHSSV.CTSVActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.CoVanHocTap.ShowPointGVActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.SinhVien.SV_DanhGiaActivity;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    final String SERVER = "http://192.168.43.217/server/";
    EditText edtuser,edtpassword;
    Button btndangnhap,btnthoat;
    String tentk,mk,tentkhoan,email,mk2,quyenuser;
    Integer idu;
    String idclaa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        ControlButton();
    }
    private void ControlButton() {
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tentk=edtuser.getText().toString().trim();
                mk=edtpassword.getText().toString().trim();
                if(tentk.length()==0 && mk.length()==0)
                {
                    Toast.makeText(MainActivity.this,"Username or Password null!",Toast.LENGTH_SHORT).show();
                }
                else if(tentk.length()==0 || mk.length()==0){
                    Toast.makeText(MainActivity.this,"Username or Password null!",Toast.LENGTH_SHORT).show();
                }
                else {
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVER+ "login.php", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MainActivity.this,
                                    response,
                                    Toast.LENGTH_LONG
                            );
                            try {

                                JSONArray jsonArray = new JSONArray(response);
                                int len = jsonArray.length();
                                for (int i = 0; i < len; i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    idu = object.getInt(("iduser"));
                                    tentkhoan = object.getString("tenuser");
                                    email = object.getString("emailuser");
                                    mk2 = object.getString("password");
                                    quyenuser = object.getString("idrole");
                                    idclaa= object.getString("idlop");



                                    if(tentk != null  && mk != null){
                                        if (quyenuser.equals("1")) {
                                            Intent intent = new Intent(MainActivity.this, SV_DanhGiaActivity.class);
                                            intent.putExtra("info",idu.toString());
                                            startActivity(intent);
                                        } else if (quyenuser.equals("2")){
                                            Intent intent = new Intent(MainActivity.this, ShowPointGVActivity.class);
                                            intent.putExtra("info",idu.toString());
                                            intent.putExtra("lopid",idclaa.toString());
                                            startActivity(intent);
                                        }else if (quyenuser.equals("4")){
                                            Intent intent = new Intent(MainActivity.this, ShowPointActivity.class);
                                            intent.putExtra("info",idu.toString());
                                            startActivity(intent);
                                        }
                                        else if (quyenuser.equals("3")){
                                            Intent intent = new Intent(MainActivity.this, CTSVActivity.class);
                                            intent.putExtra("info",idu.toString());
                                            startActivity(intent);
                                        } else {
                                            Toast.makeText(MainActivity.this, "Sai ten dang nhap hoac mat khau! ", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                    else {
                                        Toast.makeText(MainActivity.this, "AAAAA", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(MainActivity.this, "xay ra loi", Toast.LENGTH_SHORT).show();
                            Log.d("aaa","loi!\n" + error.toString());
                        }
                    }) {
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> params = new HashMap<>();
                            params.put("emailuser", tentk);
                            params.put("password", mk);
                            return params;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void Anhxa() {
        edtuser=(EditText)findViewById(R.id.edittextuser);
        edtpassword=(EditText)findViewById(R.id.edittextpasssword);
        btndangnhap=(Button) findViewById(R.id.buttondangnhap);
        btnthoat=(Button) findViewById(R.id.buttonthoat);
    }
}
