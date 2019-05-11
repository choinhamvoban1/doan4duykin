package com.example.shopee1.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.shopee1.R;
import com.example.shopee1.model.HoaDonBan;

import java.util.ArrayList;

public class adapter_dangiaohang extends BaseAdapter {
    ArrayList<HoaDonBan> listhoadonban;
    Context context;

    public adapter_dangiaohang(ArrayList<HoaDonBan> listhoadonban, Context context) {
        this.listhoadonban = listhoadonban;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listhoadonban.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class viewholder{  // tạo 1 class viewholder đầy đủ các thuộc tính của file dongkhach.xml
        TextView txthotenkh,txtngaylaphd,txtthanhtien;
        LinearLayout linearLayout;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewholder holder;
        if(convertView == null){ // kiểm tra nếu convertView == null
            holder=new viewholder(); // tạo 1 biến holder mới
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // cái này ko biết bắt buộc phải có
            convertView=inflater.inflate(R.layout.dong_dagiaohang,null); // nạp tài nguyên xml
            // ánh xạ view với cái tài nguyên xml
            holder.txthotenkh= convertView.findViewById(R.id.textViewhotenkh);
            holder.txtngaylaphd= convertView.findViewById(R.id.textViewngaylaphd);
            holder.txtthanhtien=convertView.findViewById(R.id.textViewtongtien);
            holder.linearLayout=convertView.findViewById(R.id.dongdanggiao);

            convertView.setTag(holder);
        }else{
            holder = (viewholder) convertView.getTag();
        }

        HoaDonBan hdb=listhoadonban.get(position);

        holder.txthotenkh.setText("họ tên:"+hdb.getHoTen());
        holder.txtthanhtien.setText("tổng tiền:"+hdb.getTongTien());
        holder.txtngaylaphd.setText("ngay lap hoa don:"+hdb.getNgayLapHd());
        if(position%2==0){
            holder.linearLayout.setBackgroundColor(Color.parseColor("#D81B60"));
        }

        return convertView;
    }
}
