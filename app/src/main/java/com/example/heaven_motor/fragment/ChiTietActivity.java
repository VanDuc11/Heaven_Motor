package com.example.heaven_motor.fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.heaven_motor.R;
import com.example.heaven_motor.model.Categoris;
import com.example.heaven_motor.model.Vehicle;

import java.io.ByteArrayOutputStream;

public class ChiTietActivity extends AppCompatActivity {
    TextView tvmaXe,tvTenXe,tvLoaiXe,tvHangXe,tvDungTich,tvGiaThue,tvBKS,tvTrangThai,tvNam;
    ImageView img;
    Vehicle obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet);
        tvmaXe = findViewById(R.id.tvMaXe);
        tvTenXe = findViewById(R.id.tvTenXe);
        tvLoaiXe = findViewById(R.id.tvLoaiXe);
        tvHangXe = findViewById(R.id.tvHangXe);
        tvDungTich = findViewById(R.id.tvDungTich);
        tvGiaThue = findViewById(R.id.tvTienThue);
        tvBKS = findViewById(R.id.tvBKS);
        tvTrangThai = findViewById(R.id.tvTrangThai);
        tvNam = findViewById(R.id.tvNam);
        img = findViewById(R.id.imgXeChiTiet);
        Intent intent = getIntent();
        tvmaXe.setText(intent.getStringExtra("ma"));
        tvTenXe.setText(intent.getStringExtra("ten"));
        tvLoaiXe.setText(intent.getStringExtra("loai"));
        tvHangXe.setText(intent.getStringExtra("hang"));
        tvDungTich.setText(intent.getStringExtra("dt")+" CC");
        tvGiaThue.setText(intent.getStringExtra("gt")+ "VNĐ/Ngày");
        tvBKS.setText(intent.getStringExtra("bks"));
        tvTrangThai.setText(intent.getStringExtra("tt")+ " %");
        tvNam.setText(intent.getStringExtra("nam"));
//        Bundle bundle = getIntent().getExtras();
//        int res_img = bundle.getInt("img");
//        img.setImageResource(res_img);

//        if (getIntent().hasExtra("anh")){
//            Bitmap bitmap = BitmapFactory.decodeByteArray(getIntent().getByteArrayExtra("anh"),0,
//                    getIntent().getByteArrayExtra("anh").length);
//                    img.setImageBitmap(bitmap);
//        }else {
//            Toast.makeText(this, "Không có", Toast.LENGTH_SHORT).show();
//        }


    }
    private byte[] imgViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable) image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}