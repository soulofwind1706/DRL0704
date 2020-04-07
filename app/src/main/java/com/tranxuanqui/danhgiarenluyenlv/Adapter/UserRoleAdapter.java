package com.tranxuanqui.danhgiarenluyenlv.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.Model.Userrole;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.List;

public class UserRoleAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Userrole> userroleList;

    public UserRoleAdapter() {
    }

    public UserRoleAdapter(Context context, int layout, List<Userrole> userroleList) {
        this.context = context;
        this.layout = layout;
        this.userroleList = userroleList;
    }

    public void updateListTitle(List<Userrole> titles) {
        userroleList = titles;
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return userroleList.size();
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
        UserRoleAdapter.ViewHolder holder;
        if(convertView==null){
            holder = new ViewHolder();
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faqs_role,null);
            holder.txtIdrole= convertView.findViewById(R.id.txtidrole);
            holder.txtTenrole= convertView.findViewById(R.id.txttenrole);
            convertView.setTag(holder);
        }else {
            holder= (UserRoleAdapter.ViewHolder)convertView.getTag();
        }
        Userrole userrole= userroleList.get(position);
        holder.txtIdrole.setText(""+userrole.getIdrole());
        holder.txtTenrole.setText(userrole.getTenrole());
        return convertView;
    }

    public class ViewHolder {
        TextView txtIdrole;
        TextView txtTenrole;
    }
}
