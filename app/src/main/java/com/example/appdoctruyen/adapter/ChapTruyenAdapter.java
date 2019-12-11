package com.example.appdoctruyen.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.object.ChapTruyen;

import java.util.ArrayList;
import java.util.List;

public class ChapTruyenAdapter extends ArrayAdapter<ChapTruyen> {
    private Context ct;
    private ArrayList<ChapTruyen> arr;
    public ChapTruyenAdapter(@NonNull Context context, int resource, @NonNull List<ChapTruyen> objects) {
        super( context, resource, objects );
        this.ct = context;
        this.arr = new ArrayList<>( objects );
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView ==null){
            LayoutInflater inflater = (LayoutInflater)ct.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
            convertView=inflater.inflate( R.layout.item_chap_truyen,null );
        }
        if (arr.size()>0){
            TextView txvTenChaps,txvNgayNhap;
            txvTenChaps = convertView.findViewById( R.id.txvTenChaps );
            txvNgayNhap = convertView.findViewById( R.id.txtNgayNhap );

            ChapTruyen chapTruyen = arr.get( position );
            txvTenChaps.setText( chapTruyen.getTenChap() );
            txvNgayNhap.setText( chapTruyen.getNgayDang() );
        }
        return convertView;
    }
}
