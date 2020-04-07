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

import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.UpdateUserActivity;
import com.tranxuanqui.danhgiarenluyenlv.Activity.Admin.UserListActivity;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    private UserListActivity context;
    private int layout;
    private List<User> userList;

    public UserAdapter(UserListActivity context, int layout, List<User> userList) {
        this.context = context;
        this.layout = layout;
        this.userList = userList;
    }

    public UserAdapter() {
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

    public void updateListTitle(List<User> titles) {
        userList = titles;
        notifyDataSetChanged();
    }

    private class ViewHolder{
        TextView txtTenchinh;
        TextView txtChucvuchinh;
        Button btnUP,btnDELETE;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserAdapter.ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faqs_userchinh,null);
            holder.txtTenchinh= (TextView)convertView.findViewById(R.id.txttenuserc);
            holder.btnUP= convertView.findViewById(R.id.btnupdateuser);
            holder.txtChucvuchinh= (TextView) convertView.findViewById(R.id.txtchucvuc);
            holder.btnDELETE= convertView.findViewById(R.id.btndeleteuser);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        final User userss= userList.get(position);
        holder.txtTenchinh.setText(userss.getTenuser());
        holder.txtChucvuchinh.setText(""+userss.getIdrole());
        holder.btnUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context, UpdateUserActivity.class);
                intent.putExtra("info",userss);
                context.startActivity(intent);
            }
        });
        holder.btnDELETE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                XoaSV(userss.getTenuser(),userss.getIduser());
            }
        });
        return convertView;
    }
    private void XoaSV(String ten, final int id){
        AlertDialog.Builder dialogXoa= new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa user " + ten +" không ?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                context.DELETE(id);
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
