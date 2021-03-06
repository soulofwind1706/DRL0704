package com.tranxuanqui.danhgiarenluyenlv.Activity.SinhVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.ShowPointSV;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.CollapsibleTCAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Mucdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SV_DanhGiaActivity extends AppCompatActivity {

    ExpandableListView ExpandList;
    CollapsibleTCAdapter collapsibleTCAdapter;

    String urlADD= "http://192.168.43.217/server/addchitietdanhgia.php";
    final String SERVER = "http://192.168.43.217/server/";
    TextView Hoten, Email, Vaitro, ID;
    Button show,save;
    String idu;
    CheckBox chkDiem;
    public static TextView textDiem;

    public static List<Mucdanhgia> mucdanhgia = new ArrayList();
    public static HashMap<Integer, List<Tieuchi>> tieuchi = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sv__danh_gia);

        Intent intent = SV_DanhGiaActivity.this.getIntent();
        idu = intent.getStringExtra("info");
        Toast.makeText(SV_DanhGiaActivity.this,idu,Toast.LENGTH_LONG).show();
        addControl();
        addEvent();

    }
    private void addEvent() {
        collapsibleTCAdapter= new CollapsibleTCAdapter(this);
        ExpandList.setAdapter(collapsibleTCAdapter);
        getData();
        showInfo();
        LuuDL();
    }

    private void LuuDL() {

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                luuDiem(urlADD);
            }
        });
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SV_DanhGiaActivity.this, ShowPointSV.class);
                startActivity(intent);
            }
        });
    }
    private void luuDiem(String url){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(SV_DanhGiaActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                            //startActivity(new Intent(SV_DanhGiaActivity.this,ShowPointActivity.class));
                        }else{
                            Toast.makeText(SV_DanhGiaActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(SV_DanhGiaActivity.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                Log.d("AAA","Lỗi" + error.toString());
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("iduser",ID.getText().toString().trim());
                params.put("ten",Hoten.getText().toString().trim());
                params.put("diem_sinhvien",textDiem.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    public static void updateDiem(){
        int tong = 0;
        for (Mucdanhgia md : mucdanhgia){
            int tongtc =0;
            for(Tieuchi tc:tieuchi.get(md.getIdmucdanhgia())){
                if(tc.isCheck()){
                    tongtc += tc.getMaxdiem();
                }
                else{
                }
            }
            if(tongtc>md.getMaxdiem()){
                md.setDiem(md.getMaxdiem());
            }
            else{
                md.setDiem(tongtc);
            }
        }
        for (Mucdanhgia md : mucdanhgia){
            tong += md.getDiem();
        }
        textDiem.setText(tong+"");
    }
    private void getData(){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getmucdanhgia.php", null,
                new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {

                    for( int i=0; i < response.length();i++) {
                        Gson gson = new Gson();
                        try {
                            Mucdanhgia ri = gson.fromJson(response.getJSONObject(i).toString(), Mucdanhgia.class);
                            mucdanhgia.add(ri);
                            collapsibleTCAdapter.updateListTitle(mucdanhgia);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    getData1();
                }

             },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(SV_DanhGiaActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
             );
        requestQueue.add(jsonArrayRequest);
    }
    private void getData1(){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "gettieuchidanhgia.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(SV_DanhGiaActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                            Gson gson = new Gson();

                        for (Mucdanhgia mdg : mucdanhgia) {
                            tieuchi.put(mdg.getIdmucdanhgia(), new ArrayList<Tieuchi>());
                        }
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                Tieuchi tc = gson.fromJson(response.getJSONObject(i).toString(), Tieuchi.class);
                                if (tieuchi.get(tc.getIdmucdanhgia()) != null) {
                                    tieuchi.get(tc.getIdmucdanhgia()).add(tc);
                                    Log.d("aqq", tc.getNoidung());
                                }
                            }
                            collapsibleTCAdapter.updateListContent(tieuchi);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(SV_DanhGiaActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    private void showInfo() {
        RequestQueue requestQueue = Volley.newRequestQueue(SV_DanhGiaActivity.this);
        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // bien response chua chuoi Json cua Server tra ve
                try {

                    JSONArray jsonArray = new JSONArray(response);
                    int len = jsonArray.length();
                    for (int i = 0; i < len; i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        int mauser = object.getInt("iduser");
                        String tenuser = object.getString("tenuser");
                        String email = object.getString("emailuser");
                        String chucvu = object.getString("tenrole");
                        if(Integer.parseInt(idu) == mauser) {
                            ID.setText(""+mauser);
                            Hoten.setText(tenuser);
                            Email.setText(email);
                            Vaitro.setText(chucvu);
                            Toast.makeText(SV_DanhGiaActivity.this,chucvu,Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        // noi nhan dl tra ve ( String cho an toan )
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(
                        SV_DanhGiaActivity.this,
                        error.getMessage(),
                        Toast.LENGTH_LONG
                ).show();
            }
        };

        Uri.Builder builder = Uri.parse(SERVER + "getuser2.php").buildUpon();
        String url = builder.build().toString();
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                listener,
                errorListener
        );
        request.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
        ));
        requestQueue.add(request);
    }


    private void addControl() {

        ID = findViewById(R.id.tvIDuser);
        Hoten = findViewById(R.id.tvHoten);
        Email = findViewById(R.id.tvEmail);
        Vaitro = findViewById(R.id.tvVaitro);
        show = findViewById(R.id.btnShow);
        save= findViewById(R.id.btnSave);
        ExpandList = (ExpandableListView) findViewById(R.id.exDanhmuctieuchi);
        textDiem = (TextView) findViewById(R.id.txtdiem);
        chkDiem= findViewById(R.id.chkChon);

    }

//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_layout,menu);
//        return super.onCreateOptionsMenu(menu);
//
//    }

//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.user:
//                Intent intent = new Intent(SV_DanhGiaActivity.this,UserListActivity.class);
//                SV_DanhGiaActivity.this.startActivity(intent);
//                break;
//            case R.id.classs:
//                Intent intent2 = new Intent(SV_DanhGiaActivity.this,ClassListActivity.class);
//                SV_DanhGiaActivity.this.startActivity(intent2);
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

}
