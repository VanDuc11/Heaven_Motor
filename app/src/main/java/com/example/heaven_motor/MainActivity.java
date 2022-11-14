package com.example.heaven_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.example.heaven_motor.Fragment.DatHangFragment;
import com.example.heaven_motor.Fragment.DoanhThuFragment;
import com.example.heaven_motor.Fragment.DoiMatKhauFragment;
import com.example.heaven_motor.Fragment.LichSuDonHangFragment;
import com.example.heaven_motor.Fragment.QuanLiDonHangFragment;
import com.example.heaven_motor.Fragment.QuanLiLoaiXeFragment;
import com.example.heaven_motor.Fragment.QuanLiNguoiDungFragment;
import com.example.heaven_motor.Fragment.QuanLiXeFragment;
import com.example.heaven_motor.Fragment.TopXeFragment;
import com.example.heaven_motor.adapter.ViewpageAdapter;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ViewPager pager;
    ViewpageAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navtion);
        pager = findViewById(R.id.page);
        addFragment(pager);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.openDWR,R.string.closeDWR);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        onContextMenuClosed();
    }

    private void onContextMenuClosed() {
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        if(id==R.id.QLLX){
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);
            toolbar.setTitle("Quản lí loại xe");

        }else if(id==R.id.QLX){
//            replaceFragement(QuanLiXeFragment.newInstance());
            pager.setAdapter(adapter);
            pager.setCurrentItem(1);
            toolbar.setTitle("Quản lí xe");
        }
        else if(id==R.id.QLDH){
//            replaceFragement(QuanLiDonHangFragment.newInstance());
            pager.setAdapter(adapter);
            pager.setCurrentItem(2);
            toolbar.setTitle("Quản lí đơn hàng");

        }
        else if(id==R.id.DatHang){
//            replaceFragement(DatHangFragment.newInstance());
            toolbar.setTitle("Đặt hàng");
            pager.setAdapter(adapter);
            pager.setCurrentItem(3);
        }else if(id==R.id.LSDH){
//            replaceFragement(LichSuDonHangFragment.newInstance());
            toolbar.setTitle("Những đơn đã đặt");
            pager.setAdapter(adapter);
            pager.setCurrentItem(4);

        }else if(id==R.id.topXe){
//            replaceFragement(TopXeFragment.newInstance());
            toolbar.setTitle("Top xe được thuê nhiều nhất");
            pager.setAdapter(adapter);
            pager.setCurrentItem(5);
        } else if(id==R.id.doanhThu){
//           replaceFragement(DoanhThuFragment.newInstance());
            toolbar.setTitle("Doanh thu");
            pager.setAdapter(adapter);
            pager.setCurrentItem(6);
        }
        else if(id==R.id.QLND){
//            replaceFragement(QuanLiNguoiDungFragment.newInstance());
            toolbar.setTitle("Quản lí người dùng");
            pager.setAdapter(adapter);
            pager.setCurrentItem(7);
        }
        else if(id==R.id.doiPass){
//            replaceFragement(DoiMatKhauFragment.newInstance());
            toolbar.setTitle("Đổi mật khẩu");
            pager.setAdapter(adapter);
            pager.setCurrentItem(8);
        }
        else{
            startActivity(new Intent(MainActivity.this, Splash_screen_MainActivity2.class));

        }
        drawerLayout.closeDrawer(navigationView);
        return false;
    }
    public void addFragment(ViewPager viewPager){
        adapter = new ViewpageAdapter(getSupportFragmentManager());
        adapter.addFragment(new QuanLiLoaiXeFragment(),"Quản lí loại xe");
        adapter.addFragment(new QuanLiXeFragment(),"Quản lí xe");
        adapter.addFragment(new QuanLiDonHangFragment(),"Quản lí đơn hàng");
        adapter.addFragment(new DatHangFragment(),"Đặt hàng");
        adapter.addFragment(new LichSuDonHangFragment(),"Những đơn đã đặt");
        adapter.addFragment(new TopXeFragment(),"Top xe được thuê nhiều nhất");
        adapter.addFragment(new DoanhThuFragment(),"Doanh thu");
        adapter.addFragment(new QuanLiNguoiDungFragment(),"Quản lí người dùng");
        adapter.addFragment(new DoiMatKhauFragment(),"Đổi mật khẩu");
        pager.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(navigationView);
        }else{
            super.onBackPressed();
        }
    }
}