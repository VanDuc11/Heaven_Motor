package com.example.heaven_motor.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.heaven_motor.R;
import com.example.heaven_motor.database.CategorisDao;
import com.example.heaven_motor.model.Categoris;

public class Thue_Xe_Activity extends AppCompatActivity {
    Intent intent;
    EditText edName,edDungtich,edGia,edLoaiXe;
    TextView tvMaXe,tvTenXe,
            tvLoaiXe,tvHang,
            tvTinhTrang,tvBKS,
            tvDungTich,tvNam,
            tvTienThue;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thue_xe);
        anhXa();
        insert();
    }
    public void anhXa(){
        edName = findViewById(R.id.frag_thue_xe_edName);
        edDungtich = findViewById(R.id.frag_thue_xe_edDungtich);
        edGia = findViewById(R.id.frag_thue_xe_edGia);
        edLoaiXe = findViewById(R.id.frag_thue_xe_edLoaiXe);

        tvMaXe = findViewById(R.id.frag_thue_xe_tvMaXe);
        tvTenXe = findViewById(R.id.frag_thue_xe_tvTenXe);
        tvLoaiXe = findViewById(R.id.frag_thue_xe_tvLoaiXe);
        tvHang = findViewById(R.id.frag_thue_xe_tvHang);
        tvDungTich = findViewById(R.id.frag_thue_xe_tvDungTich);
        tvTinhTrang = findViewById(R.id.frag_thue_xe_tvTinhTrang);
        tvBKS = findViewById(R.id.frag_thue_xe_tvBKS);
        tvNam = findViewById(R.id.frag_thue_xe_tvNam);
        tvTienThue = findViewById(R.id.frag_thue_xe_tvTienThue);
        imageView = findViewById(R.id.frag_thue_xe_imgView);
    }
    public void insert(){

        intent = getIntent();
        CategorisDao dao = new CategorisDao(this);
        Categoris c = dao.getID(intent.getStringExtra("categorie_id"));

        tvMaXe.setText("Mã Xe: "+intent.getStringExtra("id"));
        tvTenXe.setText("Tên Xe: "+intent.getStringExtra("name"));
        tvLoaiXe.setText("Tên Loại: "+c.getName());
        tvHang.setText("Nhà Sản Xuất: "+intent.getStringExtra("brand"));
        tvTinhTrang.setText("Tình Trạng: "+intent.getStringExtra("status")+"%");
        tvBKS.setText("BKS: "+intent.getStringExtra("BKS"));
        tvNam.setText("Năm Sản Xuất: "+intent.getStringExtra("year"));
        tvTienThue.setText("Giá Thuê: "+intent.getStringExtra("price")+"VND/Ngày");
        tvDungTich.setText("Dung Tích: "+intent.getStringExtra("capacity"));

//        byte xeImg = intent.getByteExtra("img", (byte) 0);
//        Bitmap bitmap = BitmapFactory.decodeFile(String.valueOf(xeImg));
//        imageView.setImageBitmap(bitmap);

        edName.setText(intent.getStringExtra("name"));
        edGia.setText(intent.getStringExtra("price"));
        edLoaiXe.setText(c.getName());
        edDungtich.setText(intent.getStringExtra("capacity")+"cc");
        edName.setEnabled(false);
        edGia.setEnabled(false);
        edLoaiXe.setEnabled(false);
        edDungtich.setEnabled(false);
    }
}