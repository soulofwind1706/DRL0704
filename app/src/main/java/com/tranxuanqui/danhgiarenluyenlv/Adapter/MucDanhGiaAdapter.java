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

import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.ListDanhMucActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.UpdateDMActivity;
import com.tranxuanqui.danhgiarenluyenlv.Model.Mucdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.List;

public class MucDanhGiaAdapter extends BaseAdapter {
    private ListDanhMucActivity context;
    private int layout;
    private List<Mucdanhgia>mucdanhgiaList;

    public MucDanhGiaAdapter(ListDanhMucActivity context, int layout, List<Mucdanhgia> mucdanhgiaList) {
        this.context = context;
        this.layout = layout;
        this.mucdanhgiaList = mucdanhgiaList;
    }

    public MucDanhGiaAdapter() {
    }

    private class ViewHolder{
        TextView txtDanhmuc;
        TextView txtMaxdiemdm;
        Button btnUPDM,btnDELETEDM;
    }
    public void updateListTitle(List<Mucdanhgia> titles) {
        mucdanhgiaList = titles;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return mucdanhgiaList.size();
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
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faqs_danhmucad,null);
            holder.txtDanhmuc= convertView.findViewById(R.id.txtDMad);
            holder.txtMaxdiemdm= convertView.findViewById(R.id.txtmaxdiemdmad);
            holder.btnUPDM= convertView.findViewById(R.id.btnUpdanhmucad);
            holder.btnDELETEDM= convertView.findViewById(R.id.btnDeldanhmucad);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder)convertView.getTag();
        }
        final Mucdanhgia mucdanhgia= mucdanhgiaList.get(position);
        holder.txtDanhmuc.setText(mucdanhgia.getNoidung());
        holder.txtMaxdiemdm.setText(""+mucdanhgia.getMaxdiem());
        holder.btnUPDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, UpdateDMActivity.class);
                intent.putExtra("dm",mucdanhgia);
                context.startActivity(intent);

            }
        });
        holder.btnDELETEDM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaDM(mucdanhgia.getNoidung(),mucdanhgia.getIdmucdanhgia());
            }
        });
        return convertView;
    }

    private void XoaDM(String ten, final int id){
        AlertDialog.Builder dialogXoa= new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa danh mục " + ten +" không ?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DELETEDM(id);
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