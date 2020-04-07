package com.tranxuanqui.danhgiarenluyenlv.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.tranxuanqui.danhgiarenluyenlv.Activity.SinhVien.SV_DanhGiaActivity;
import com.tranxuanqui.danhgiarenluyenlv.Model.Mucdanhgia;
import com.tranxuanqui.danhgiarenluyenlv.Model.Tieuchi;
import com.tranxuanqui.danhgiarenluyenlv.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static java.lang.Integer.valueOf;

public class CollapsibleTCAdapter extends BaseExpandableListAdapter {

    private int value;
    private Context mContext;

    // Child Items of the List
    private List<Mucdanhgia> mucdanhgiaList = new ArrayList<Mucdanhgia>();
    // Child Items of the individual items of the List
    private HashMap<Integer, List<Tieuchi>> tieuchiList = new HashMap<>();

    public CollapsibleTCAdapter(Context context) {
        mContext = context;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void updateListTitle(List<Mucdanhgia> titles) {
        //mucdanhgiaList.clear();
        //mucdanhgiaList.addAll(titles);
        mucdanhgiaList = titles;
        notifyDataSetChanged();
    }

    public void updateListContent(HashMap<Integer, List<Tieuchi>> contents) {
        //tieuchiList.clear();
        //tieuchiList.putAll(contents);
        tieuchiList = contents;
        notifyDataSetChanged();
    }

    @Override
    public int getGroupCount() {
        return mucdanhgiaList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return tieuchiList.get(mucdanhgiaList.get(i).getIdmucdanhgia()).size();
    }

    @Override
    public Object getGroup(int i) {
        return mucdanhgiaList.get(i);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return tieuchiList.get(mucdanhgiaList.get(groupPosition).getIdmucdanhgia()).get(childPosition);
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
    public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {

        TextView listItemText;
        TextView diemdm;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.faqs_danhmuc, null);
        }
        // Fetching the view and binding the appropriate text to it
        listItemText = (TextView) convertView.findViewById(R.id.txtDM);
        listItemText.setText(mucdanhgiaList.get(i).getNoidung());
        diemdm = (TextView) convertView.findViewById(R.id.txtmaxdiemdm);
        diemdm.setText(String.valueOf(mucdanhgiaList.get(i).getMaxdiem()));
        return convertView;
    }


    @Override
    public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {

        final CheckBox chkdiem;
        TextView listChildItemText;
        TextView diemtc;


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.faqs_tieuchi, null);
        }
        diemtc = (TextView) convertView.findViewById(R.id.txtmaxdiemtc);
        chkdiem = (CheckBox) convertView.findViewById(R.id.chkChon);
        listChildItemText = (TextView) convertView.findViewById(R.id.txtTC);
        if (i < mucdanhgiaList.size()  && i1 < tieuchiList.get(mucdanhgiaList.get(i).getIdmucdanhgia()).size()
                && tieuchiList.get(mucdanhgiaList.get(i).getIdmucdanhgia()).get(i1) != null) {
                listChildItemText.setText(tieuchiList.get(mucdanhgiaList.get(i).getIdmucdanhgia()).get(i1).getNoidung());
                diemtc.setText(String.valueOf(tieuchiList.get(mucdanhgiaList.get(i).getIdmucdanhgia()).get(i1).getMaxdiem()));
        }
        final Tieuchi k =tieuchiList.get(mucdanhgiaList.get(i).getIdmucdanhgia()).get(i1);
        if(!k.isCheck()){
            chkdiem.setChecked(false);
        }
        else{
            chkdiem.setChecked(true);
        }
            chkdiem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(chkdiem.isChecked()){
                        k.setCheck(true);
                        SV_DanhGiaActivity.updateDiem();
                    }else {
                        k.setCheck(false);
                        SV_DanhGiaActivity.updateDiem();
                    }
                }
            });




        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        // Don't forget to set this true so that the child items are selectable
        return true;
    }

}