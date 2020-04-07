package com.tranxuanqui.danhgiarenluyenlv.Activity.CanBoPhongCTHSSV;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.ShowPointActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.CoVanHocTap.GiangVienActivity;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.ChiTietDanhGiaAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Chitietdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class CTSVActivity extends AppCompatActivity {
    final String SERVER = "http://192.168.43.217/server/";
    ListView lvChitietCTSV;
    List<Chitietdanhgia> chitietdanhgiaList = new ArrayList();
    ChiTietDanhGiaAdapter chiTietDanhGiaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctsv);
        addControl();
        addEvent();
        chiTietDanhGiaAdapter= new ChiTietDanhGiaAdapter(CTSVActivity.this,R.layout.activity_show_point,chitietdanhgiaList);
        lvChitietCTSV.setAdapter(chiTietDanhGiaAdapter);
        lvChitietCTSV.setTextFilterEnabled(true);
        lvChitietCTSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(CTSVActivity.this, ChamDiemCTSVActivity.class);
                String id2=""+chitietdanhgiaList.get(position).getIduser();
                intent.putExtra("info",id2);
                startActivity(intent);
            }
        });
    }
    private void addEvent() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getchitietdanhgia.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for( int i=0; i < response.length();i++) {
                            Gson gson = new Gson();
                            try {
                                Chitietdanhgia ri = gson.fromJson(response.getJSONObject(i).toString(), Chitietdanhgia.class);
                                chitietdanhgiaList.add(ri);
                                chiTietDanhGiaAdapter.updateListTitle(chitietdanhgiaList);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(CTSVActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }
    private void addControl() {
        lvChitietCTSV= findViewById(R.id.listchitietctsv);
    }
}
