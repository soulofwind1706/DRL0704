package com.tranxuanqui.danhgiarenluyenlv.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tranxuanqui.danhgiarenluyenlv.Model.Chitietdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.List;

public class UserGVAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> userList;

    public UserGVAdapter() {
    }

    public UserGVAdapter(Context context, int layout, List<User> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
//    public void updateListTitle(List<User> titles) {
//        userList = titles;
//        notifyDataSetChanged();
//    }

    private class ViewHolder{
        //TextView txtIduser;
        //TextView txtDiemsv;
        TextView txtTen;
        //TextView txtDiemgv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserGVAdapter.ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_chitietgv,null);
            //holder.txtIduser= (TextView)convertView.findViewById(R.id.txtiduser);
            //holder.txtDiemsv= (TextView) convertView.findViewById(R.id.txtdiemsv);
            holder.txtTen= (TextView) convertView.findViewById(R.id.txttengv);
            //holder.txtDiemgv= convertView.findViewById(R.id.txtdiemgv);
            convertView.setTag(holder);
        }else {
            holder= (UserGVAdapter.ViewHolder)convertView.getTag();
        }
        User userr= userList.get(position);

        //holder.txtIduser.setText("ID " + chitietdanhgia.getIduser());
        holder.txtTen.setText(userr.getTenuser());
        //holder.txtDiemsv.setText("" + chitietdanhgia.getDiem_sinhvien());
        //holder.txtDiemgv.setText(""+chitietdanhgia.getDiem_covan());
        return convertView;
    }
}
