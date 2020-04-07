package com.tranxuanqui.danhgiarenluyenlv.Adapter;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import com.tranxuanqui.danhgiarenluyenlv.Model.Chitietdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public class ChiTietDanhGiaAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Chitietdanhgia> chitietdanhgiaList;

    public ChiTietDanhGiaAdapter() {
    }

    public ChiTietDanhGiaAdapter(Context context, int layout, List<Chitietdanhgia> chitietdanhgiaList) {
        this.context = context;
        this.layout = layout;
        this.chitietdanhgiaList = chitietdanhgiaList;
    }


    @Override
    public int getCount() {
        return chitietdanhgiaList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public void updateListTitle(List<Chitietdanhgia> titles) {
        chitietdanhgiaList = titles;
        notifyDataSetChanged();
    }

    private class ViewHolder{
        TextView txtIduser;
        TextView txtDiemsv;
        TextView txtTen;
        TextView txtDiemgv, diemCtsvitem;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chitiet,null);
            holder.txtIduser= (TextView)convertView.findViewById(R.id.txtiduser);
            holder.txtDiemsv= (TextView) convertView.findViewById(R.id.txtdiemsv);
            holder.txtTen= (TextView) convertView.findViewById(R.id.txtten);
            holder.txtDiemgv= convertView.findViewById(R.id.txtdiemgv);
            holder.diemCtsvitem= convertView.findViewById(R.id.diemctsvitem);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder)convertView.getTag();
        }
        Chitietdanhgia chitietdanhgia= chitietdanhgiaList.get(position);

        holder.txtIduser.setText("" + chitietdanhgia.getIduser());
        holder.txtTen.setText(chitietdanhgia.getTen());
        holder.txtDiemsv.setText(""+ chitietdanhgia.getDiem_sinhvien());
        holder.txtDiemgv.setText(""+chitietdanhgia.getDiem_covan());
        holder.diemCtsvitem.setText(""+chitietdanhgia.getDiem_phongctsv());
        return convertView;
    }
}
