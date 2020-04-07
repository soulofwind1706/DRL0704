package com.tranxuanqui.danhgiarenluyenlv.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;


import com.tranxuanqui.danhgiarenluyenlv.Model.Lop;
import com.tranxuanqui.danhgiarenluyenlv.Model.Mucdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.Model.User;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LopExpanAdapter extends BaseExpandableListAdapter {
    private int value;
    private Context mContext;
    // Child Items of the List
    private List<Lop> classList = new ArrayList<Lop>();
    // Child Items of the individual items of the List
    private HashMap<Integer, List<User>> userList = new HashMap<>();

    public LopExpanAdapter(Context context) {
        mContext = context;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void updateListTitle(List<Lop> titles) {

        classList = titles;
        notifyDataSetChanged();
    }

    public void updateListContent(HashMap<Integer, List<User>> contents) {
        userList = contents;
        notifyDataSetChanged();
    }
    @Override
    public int getGroupCount() {
        return classList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return userList.get(classList.get(groupPosition).getIdlop()).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return classList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return userList.get(classList.get(groupPosition).getIdlop()).get(childPosition);
    }

    @Override
    public long getGroupId(int groupId) {
        return groupId;
    }

    @Override
    public long getChildId(int groupId, int childId) {
        return childId;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView lop;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faqs_class, null);
        }
        // Fetching the view and binding the appropriate text to it
        lop = (TextView) convertView.findViewById(R.id.txtlop);
        lop.setText(classList.get(groupPosition).getTenlop());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        TextView txtTen;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.faqs_user, null);
        }
        txtTen = (TextView) convertView.findViewById(R.id.txttensv);
        if (groupPosition < classList.size()  && childPosition < userList.get(classList.get(groupPosition).getIdlop()).size()
                && userList.get(classList.get(groupPosition).getIdlop()).get(childPosition) != null) {
            txtTen.setText(userList.get(classList.get(groupPosition).getIdlop()).get(childPosition).getTenuser());
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
