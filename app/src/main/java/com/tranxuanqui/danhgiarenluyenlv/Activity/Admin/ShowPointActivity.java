package com.tranxuanqui.danhgiarenluyenlv.Activity.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.ChiTietDanhGiaAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Chitietdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class ShowPointActivity extends AppCompatActivity {

    final String SERVER = "http://192.168.43.217/server/";
    ListView lvThongtin;
    List<Chitietdanhgia> chitietdanhgiaList = new ArrayList();
    ChiTietDanhGiaAdapter chiTietDanhGiaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_point);
        addControl();
        addEvent();
        chiTietDanhGiaAdapter= new ChiTietDanhGiaAdapter(ShowPointActivity.this,R.layout.activity_show_point,chitietdanhgiaList);
        lvThongtin.setAdapter(chiTietDanhGiaAdapter);
        lvThongtin.setTextFilterEnabled(true);
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

                        Toast.makeText(ShowPointActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_layout,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.user:
                Intent intent = new Intent(ShowPointActivity.this, UserListActivity.class);
                ShowPointActivity.this.startActivity(intent);
                break;
            case R.id.classs:
                Intent intent2 = new Intent(ShowPointActivity.this, LopListActivity.class);
                ShowPointActivity.this.startActivity(intent2);
                break;
            case R.id.roleu:
                Intent intent3 = new Intent(ShowPointActivity.this, ListRoleActivity.class);
                ShowPointActivity.this.startActivity(intent3);
                break;
            case R.id.danhmuca:
                Intent intent4 = new Intent(ShowPointActivity.this, ListDanhMucActivity.class);
                ShowPointActivity.this.startActivity(intent4);
                break;
            case R.id.tieuchia:
                Intent intent5 = new Intent(ShowPointActivity.this, ListTieuChiActivity.class);
                ShowPointActivity.this.startActivity(intent5);
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void addControl() {
        lvThongtin= findViewById(R.id.listThongtin);
    }
}
