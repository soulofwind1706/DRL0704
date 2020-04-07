package com.tranxuanqui.danhgiarenluyenlv.Activity.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.tranxuanqui.danhgiarenluyenlv.Adapter.LopExpanAdapter;
import com.tranxuanqui.danhgiarenluyenlv.Model.Lop;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LopListActivity extends AppCompatActivity {

    ExpandableListView ExpandList;
    LopExpanAdapter lopExpanAdapter;
    final String SERVER = "http://192.168.43.217/server/";
    public static List<Lop> lops = new ArrayList();
    public static HashMap<Integer, List<User>> users = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lop_list);
        addControl();
        addEvent();
    }

    private void addEvent() {
        lopExpanAdapter= new LopExpanAdapter(this);
        ExpandList.setAdapter(lopExpanAdapter);
        getData();
    }

    private void getData() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getlop.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        for( int i=0; i < response.length();i++) {
                            Gson gson = new Gson();
                            try {
                                Lop ri = gson.fromJson(response.getJSONObject(i).toString(), Lop.class);
                                lops.add(ri);
                                lopExpanAdapter.updateListTitle(lops);
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

                        Toast.makeText(LopListActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void getData1() {
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, SERVER + "getuser2.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //Toast.makeText(SV_DanhGiaActivity.this,response.toString(),Toast.LENGTH_SHORT).show();
                        Gson gson = new Gson();

                        for (Lop mlop : lops) {
                            users.put(mlop.getIdlop(), new ArrayList<User>());
                        }
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                User us = gson.fromJson(response.getJSONObject(i).toString(), User.class);
                                if (users.get(us.getIdlop()) != null) {
                                    users.get(us.getIdlop()).add(us);
                                    Log.d("aqq", us.getTenuser());
                                }
                            }
                            lopExpanAdapter.updateListContent(users);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(LopListActivity.this,"Lỗi!!!",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    private void addControl() {
        ExpandList = (ExpandableListView) findViewById(R.id.expanlistlop);
    }

}
