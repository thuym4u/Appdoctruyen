package com.example.appdoctruyen;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.appdoctruyen.adapter.TruyenTranhAdapter;
import com.example.appdoctruyen.object.TruyenTranh;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    GridView gdvDSTruyen;
    TruyenTranhAdapter adapter;
    ArrayList<TruyenTranh> truyenTranhArrayList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        anhXa();
        setUp();
        setClink();
    }
    private void init(){
        truyenTranhArrayList = new ArrayList<>();
        truyenTranhArrayList.add(new TruyenTranh("Overlord Official Comic A La Carte","Chap 001","https://cdn.truyentranh.net/upload/image/comic/20191121/Overlord-Official-Comic-A-La-Carte-5dd6a6a1ca933-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Hệ Thống Tu Tiên Mạnh Nhất","Chap 039","https://cdn.truyentranh.net/upload/image/comic/20190901/He-Thong-Tu-Tien-Manh-Nhat-5d6be2139c787-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Kokou No Hito","Chap 116","https://cdn.truyentranh.net/upload/image/comic/20150318/kokou-no-hito-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("NARUTO FULL COLOR EDITION","Chap 86","https://cdn.truyentranh.net/upload/image/comic/20190701/NARUTO-FULL-COLOR-EDITION-5d19a87bcf655-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("CAO ĐẲNG LINH HỒN","Chap 46","https://cdn.truyentranh.net/upload/image/comic/20190401/CAO-DANG-LINH-HON-5ca1e1de916bd-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("TU CHÂN GIẢ TẠI DỊ THẾ","Chap 212","https://cdn.truyentranh.net/upload/image/comic/20190201/TU-CHAN-GIA-TAI-DI-THE-5c53edb643eef-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("The New Gate","Chap 55","https://cdn.truyentranh.net/upload/image/comic/20150710/the-new-gate-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Dragon Ball Super","Chap 54","https://cdn.truyentranh.net/upload/image/comic/20151229/dragon-ball-super-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("Kiếm Thần Tuyệt Thế","Chap 54","https://cdn.truyentranh.net/upload/image/comic/20190922/Kiem-Than-Tuyet-The-5d87888373543-thumbnail-176x264.jpg"));
        truyenTranhArrayList.add(new TruyenTranh("One Piece","Chap 979","https://cdn.truyentranh.net/upload/image/comic/20150318/one-piece-58b523ebcdb90-593cb3925a43c-thumbnail-176x264.jpg"));
     adapter = new TruyenTranhAdapter(this,0,truyenTranhArrayList);
    }
    private void anhXa(){
        gdvDSTruyen = findViewById(R.id.gdvDSTruyen);
    }

    private void setUp(){
        gdvDSTruyen.setAdapter(adapter);
    }

    private void setClink(){}
}
