package com.tranxuanqui.danhgiarenluyenlv.Activity.CoVanHocTap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.UserGVAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowPointGVActivity extends AppCompatActivity {

    final String SERVER = "http://192.168.43.217/server/";
    ListView lvGVSV;
    TextView tenU;
    String urlgeta= "http://192.168.43.217/server/getuser3.php";
    String idu,idclaaa;
    List<User> userList = new ArrayList();
    UserGVAdapter userGVAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_point_gv);
        Intent intent = ShowPointGVActivity.this.getIntent();
        idu = intent.getStringExtra("info");
        idclaaa=intent.getStringExtra("lopid");
        addControl();

        userGVAdapter= new UserGVAdapter(ShowPointGVActivity.this,R.layout.activity_show_point_gv,userList);
        addEvent();



        lvGVSV.setAdapter(userGVAdapter);
    }

    private void addEvent() {
        Getdataa(urlgeta);
        lvGVSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(ShowPointGVActivity.this, GiangVienActivity.class);
                String id2=""+userList.get(position).getIduser();
                intent.putExtra("info",id2);
                startActivity(intent);
            }
        });
    }


    private void Getdataa(String url) {
        final RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //Toast.makeText(ShowPointGVActivity.this, response.toString(), Toast.LENGTH_SHORT).show()
                        try {
                            JSONArray array=new JSONArray(response);

                            for (int i = 0; i < array.length(); i++)
                            {
                                //Toast.makeText(ShowPointGVActivity.this,""+ch[i].,Toast.LENGTH_SHORT).show();
                                JSONObject object=array.getJSONObject(i);

                                String tenuser=object.getString("tenuser");
                                userList.add(new User(object.getInt("iduser"),object.getString("tenuser"),object.getString("emailuser"),
                                        object.getString("password"),object.getInt("idrole"),object.getInt("idlop")));
                                userGVAdapter.notifyDataSetChanged();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowPointGVActivity.this, "Xảy ra  lỗi", Toast.LENGTH_SHORT).show();
                Log.d("AAA","Lỗi" + error.toString());
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("idlop",idclaaa);
              //  params.put("iduser",idu);
                //params.put("diem_sinhvien",textDiem.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }




    private void addControl() {
        lvGVSV= findViewById(R.id.listgvsv);
        tenU= findViewById(R.id.txttengv);
    }
}
