package com.tranxuanqui.danhgiarenluyenlv.Activity.CanBoPhongCTHSSV;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.ShowPointActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.CoVanHocTap.GiangVienActivity;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.ExpanCTSV;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.ExpanableGVAdapter;
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

public class ChamDiemCTSVActivity extends AppCompatActivity {

    ExpandableListView ExpandList;
    ExpanCTSV expanCTSV;

    String urlUP= "http://192.168.43.217/server/updatechitietdanhgia2.php";

    final String SERVER = "http://192.168.43.217/server/";
    TextView Hotenctsv, Emailctsv, Vaitroctsv, IDctsv;
    Button show,savectsv;
    String idu;


    public static TextView txtDiemgvctsv,txtDiemctsv;

    public static List<Mucdanhgia> mucdanhgia = new ArrayList();
    public static HashMap<Integer, List<Tieuchi>> tieuchi = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cham_diem_ctsv);
        Intent intent = ChamDiemCTSVActivity.this.getIntent();
        idu = intent.getStringExtra("info");
        Toast.makeText(ChamDiemCTSVActivity.this,idu,Toast.LENGTH_LONG).show();
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        addControl();
        addEvent();
    }
    private void addEvent() {
        expanCTSV= new ExpanCTSV(this);
        ExpandList.setAdapter(expanCTSV);
        getData();
        showInfo();
        LuuDL();
    }
    private void LuuDL() {

//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GiangVienActivity.this, ShowPointActivity.class);
//                GiangVienActivity.this.startActivity(intent);
//            }
//        });
        savectsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                luuDiem(idu,txtDiemctsv.getText().toString());
            }
        });
    }
    private void luuDiem(final String idctsv, final String diemctsv){
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        StringRequest stringRequest= new StringRequest(Request.Method.POST, urlUP,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("success")){
                            Toast.makeText(ChamDiemCTSVActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(ChamDiemCTSVActivity.this, CTSVActivity.class));
                        }else{
                            Toast.makeText(ChamDiemCTSVActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ChamDiemCTSVActivity.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();
                Log.d("AAA","Lỗi" + error.toString());
            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params= new HashMap<>();
                params.put("iduser",idctsv);
                params.put("diem_phongctsv",diemctsv);
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
        txtDiemctsv.setText(tong+"");
        
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
                                //Log.d("aqq", ri.getNoidung());
                                expanCTSV.updateListTitle(mucdanhgia);
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

                        Toast.makeText(ChamDiemCTSVActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
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
                            expanCTSV.updateListContent(tieuchi);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(ChamDiemCTSVActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    private void showInfo() {
        RequestQueue requestQueue = Volley.newRequestQueue(ChamDiemCTSVActivity.this);
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
                            IDctsv.setText(""+mauser);
                            Hotenctsv.setText(tenuser);
                            Emailctsv.setText(email);
                            Vaitroctsv.setText(chucvu);
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
                        ChamDiemCTSVActivity.this,
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

        IDctsv = findViewById(R.id.tvIDuserCTSV);
        Hotenctsv = findViewById(R.id.tvHotenCTSV);
        Emailctsv = findViewById(R.id.tvEmailCTSV);
        Vaitroctsv = findViewById(R.id.tvVaitroCTSV);
        savectsv= findViewById(R.id.btnSaveCTSV);
        ExpandList = (ExpandableListView) findViewById(R.id.exDanhmuctieuchiCTSV);
        txtDiemgvctsv = (TextView) findViewById(R.id.diemctsvitem);
        txtDiemctsv = (TextView) findViewById(R.id.txtdiemCTSV);
    }
}
