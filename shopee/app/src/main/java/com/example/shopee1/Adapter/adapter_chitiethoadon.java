package com.example.shopee1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shopee1.R;
import com.example.shopee1.model.ChiTietHoaDonBan;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter_chitiethoadon extends BaseAdapter {
    ArrayList<ChiTietHoaDonBan> list;
    Context context;

    public adapter_chitiethoadon(ArrayList<ChiTietHoaDonBan> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class viewholder1{  // tạo 1 class viewholder đầy đủ các thuộc tính của file dongkhach.xml
        TextView txttensp,txtthanhtien;
        ImageView imghinhsanpham;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewholder1 holder;
        if(convertView == null){ // kiểm tra nếu convertView == null
            holder=new viewholder1(); // tạo 1 biến holder mới
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // cái này ko biết bắt buộc phải có
            convertView=inflater.inflate(R.layout.dong_chitiethoadon,null); // nạp tài nguyên xml
            // ánh xạ view với cái tài nguyên xml
            holder.txttensp= convertView.findViewById(R.id.txttensp);
            holder.txtthanhtien=convertView.findViewById(R.id.txtthanhtien);
            holder.imghinhsanpham= convertView.findViewById(R.id.imageView3);


            convertView.setTag(holder);
        }else{
            holder = (viewholder1) convertView.getTag();
        }
       ChiTietHoaDonBan hd=list.get(position);
        Picasso.with(context).load(""+hd.getHinhAnh()).into(holder.imghinhsanpham);
        holder.txttensp.setText(""+hd.getTenSp());
        holder.txtthanhtien.setText("tổng tiền"+hd.getDonGia()+"*"+hd.getSoLuong()+"="+hd.getThanhTien());
        return convertView;
    }
}
