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

import com.example.heaven_motor.adapter.ViewpageAdapter;
import com.example.heaven_motor.fragment.DatHang_Fragment;
import com.example.heaven_motor.fragment.DoanhThu_Fragment;
import com.example.heaven_motor.fragment.Doi_Mat_Khau_Fragment;
import com.example.heaven_motor.fragment.LSDonHang_Fragment;
import com.example.heaven_motor.fragment.QLyLoaiXe_Fragment;
import com.example.heaven_motor.fragment.QLyNguoi_Dung_Fragment;
import com.example.heaven_motor.fragment.QLyXe_Fragment;
import com.example.heaven_motor.fragment.QlyDonHang_Fragment;
import com.example.heaven_motor.fragment.TopMuon_Fragment;
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
            pager.setAdapter(adapter);
            pager.setCurrentItem(1);
            toolbar.setTitle("Quản lí xe");
        }
        else if(id==R.id.QLDH){
            pager.setAdapter(adapter);
            pager.setCurrentItem(2);
            toolbar.setTitle("Quản lí đơn hàng");

        }
        else if(id==R.id.DatHang){
            toolbar.setTitle("Đặt hàng");
            pager.setAdapter(adapter);
            pager.setCurrentItem(3);
        }else if(id==R.id.LSDH){
            toolbar.setTitle("Những đơn đã đặt");
            pager.setAdapter(adapter);
            pager.setCurrentItem(4);

        }else if(id==R.id.topXe){
            toolbar.setTitle("Top xe được thuê nhiều nhất");
            pager.setAdapter(adapter);
            pager.setCurrentItem(5);
        } else if(id==R.id.doanhThu){
            toolbar.setTitle("Doanh thu");
            pager.setAdapter(adapter);
            pager.setCurrentItem(6);
        }
        else if(id==R.id.QLND){
            toolbar.setTitle("Quản lí người dùng");
            pager.setAdapter(adapter);
            pager.setCurrentItem(7);
        }
        else if(id==R.id.doiPass){
            toolbar.setTitle("Đổi mật khẩu");
            pager.setAdapter(adapter);
            pager.setCurrentItem(8);
        }
        else if (id == R.id.dangXuat ){
            startActivity(new Intent(MainActivity.this, Splash_screen_MainActivity2.class));

        }
        drawerLayout.closeDrawer(navigationView);
        return false;
    }
    public void addFragment(ViewPager viewPager){
        adapter = new ViewpageAdapter(getSupportFragmentManager());
        adapter.addFragment(new QLyLoaiXe_Fragment(),"Quản lý loại xe");
        adapter.addFragment(new QLyXe_Fragment(),"Quản lý xe");
        adapter.addFragment(new QlyDonHang_Fragment(),"Quản lý đơn hàng");
        adapter.addFragment(new DatHang_Fragment(),"Đặt hàng");
        adapter.addFragment(new LSDonHang_Fragment(),"Những đơn đã đặt");
        adapter.addFragment(new TopMuon_Fragment(),"Top xe được thuê nhiều nhất");
        adapter.addFragment(new DoanhThu_Fragment(),"Doanh thu");
        adapter.addFragment(new QLyNguoi_Dung_Fragment(),"Quản lý người dùng");
        adapter.addFragment(new Doi_Mat_Khau_Fragment(),"Đổi mật khẩu");
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