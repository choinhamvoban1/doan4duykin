package com.example.shopee1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shopee1.GioHangActivity;
import com.example.shopee1.R;
import com.example.shopee1.model.SanPham;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapter_giohang extends BaseAdapter implements Filterable {
    ArrayList<SanPham> listsanpham;
    ArrayList<SanPham> listsanphamorigin;
    Context context;

    SanPham sp;

    public adapter_giohang(ArrayList<SanPham> listsanpham, Context context) {
        this.listsanpham = listsanpham;
        this.context = context;
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                final FilterResults oReturn = new FilterResults();
                final ArrayList<SanPham> results = new ArrayList<SanPham>();
                if (listsanphamorigin == null)
                    listsanphamorigin = listsanpham;
                if (constraint != null) {
                    if (listsanphamorigin != null && listsanphamorigin.size() > 0) {
                        for (final SanPham g : listsanphamorigin) {
                            if (g.getTenSp().toLowerCase()
                                    .contains(constraint.toString()))
                                results.add(g);
                        }
                    }
                    oReturn.values = results;
                }
                return oReturn;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                listsanpham = (ArrayList<SanPham>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    @Override
    public int getCount() {
        return listsanpham.size();
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
        TextView txttensp,txtgiasp,txtsize;
        ImageView imghinhsanpham;
        ImageView btncong,btntru;
        TextView txtsl;

    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final viewholder holder;
        if(convertView == null){ // kiểm tra nếu convertView == null
            holder=new viewholder(); // tạo 1 biến holder mới
            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); // cái này ko biết bắt buộc phải có
            convertView=inflater.inflate(R.layout.donggiohang,null); // nạp tài nguyên xml
            // ánh xạ view với cái tài nguyên xml
            holder.txttensp= convertView.findViewById(R.id.txttensp);
            holder.txtgiasp= convertView.findViewById(R.id.txtgiasp);
            holder.txtsize=convertView.findViewById(R.id.txtsize);
            holder.imghinhsanpham= convertView.findViewById(R.id.imageViewsanpham);
            holder.btncong=convertView.findViewById(R.id.btncong);
            holder.btntru=convertView.findViewById(R.id.btntru);
            holder.txtsl=convertView.findViewById(R.id.edtsoluong);

            convertView.setTag(holder);
        }else{
            holder = (viewholder) convertView.getTag();
        }

         sp=listsanpham.get(position);

        holder.txttensp.setText(""+sp.getTenSp());
        holder.txtgiasp.setText("giá: "+sp.getGiaSp());
        holder.txtsize.setText("size: "+sp.getSize());
        Picasso.with(context).load(""+sp.getHinhAnh()).into(holder.imghinhsanpham);

        holder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               int sl= Integer.parseInt(holder.txtsl.getText().toString());
               sl=sl+1;
               holder.txtsl.setText(""+sl);
                GioHangActivity.tongtien=0;
                listsanpham.get(position).setSoLuong(sl);
                Toast.makeText(context, "sl="+sp.getSoLuong(), Toast.LENGTH_SHORT).show();
                GioHangActivity.tinhtong();
            }
        });

        holder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int sl= Integer.parseInt(holder.txtsl.getText().toString());
                sl=sl-1;
                holder.txtsl.setText(""+sl);
                GioHangActivity.tongtien=0;
                listsanpham.get(position).setSoLuong(sl);
                Toast.makeText(context, "sl="+sp.getSoLuong(), Toast.LENGTH_SHORT).show();
                GioHangActivity.tinhtong();

            }
        });






        return convertView;
    }
}
