package com.tranxuanqui.danhgiarenluyenlv.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.ListTieuChiActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.UpdateTCActivity;
import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.List;

public class TieuChiAdapter extends BaseAdapter {
    private ListTieuChiActivity context;
    private int layout;
    private List<Tieuchi> tieuchiList;

    public TieuChiAdapter() {
    }

    private class ViewHolder{
        TextView txtTieuchi;
        TextView txtMaxdiemtc;
        Button btnUPTC,btnDELETETC;
    }
    public TieuChiAdapter(ListTieuChiActivity context, int layout, List<Tieuchi> tieuchiList) {
        this.context = context;
        this.layout = layout;
        this.tieuchiList = tieuchiList;
    }

    public void updateListTitle(List<Tieuchi> titles) {
        tieuchiList = titles;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return tieuchiList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new TieuChiAdapter.ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faqs_tieuchiad,null);
            holder.txtTieuchi= convertView.findViewById(R.id.txtTCad);
            holder.btnUPTC= convertView.findViewById(R.id.btnUptieuchiad);
            holder.btnDELETETC= convertView.findViewById(R.id.btnDeltieuchiad);
            holder.txtMaxdiemtc= convertView.findViewById(R.id.txtmaxdiemtcad);
            convertView.setTag(holder);
        }else {
            holder= (TieuChiAdapter.ViewHolder)convertView.getTag();
        }
        final Tieuchi tieuchi= tieuchiList.get(position);
        holder.txtTieuchi.setText(tieuchi.getNoidung());
        holder.txtMaxdiemtc.setText(""+tieuchi.getMaxdiem());
        holder.btnUPTC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, UpdateTCActivity.class);
                intent.putExtra("tc",tieuchi);
                context.startActivity(intent);
            }
        });
        holder.btnDELETETC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaTC(tieuchi.getNoidung(),tieuchi.getIdtieuchi());
            }
        });
        return convertView;
    }
    private void XoaTC(String ten, final int id){
        AlertDialog.Builder dialogXoa= new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa tiêu chí " + ten +" không ?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DELETETC(id);
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialogXoa.show();

    }
}
