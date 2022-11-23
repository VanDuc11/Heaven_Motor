package com.example.heaven_motor;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.example.heaven_motor.adapter.ViewpageAdapter;
//import com.example.heaven_motor.databinding.ActivityMainBinding;
import com.example.heaven_motor.fragment.DatHang_Fragment;
import com.example.heaven_motor.fragment.DoanhThu_Fragment;
import com.example.heaven_motor.fragment.Doi_Mat_Khau_Fragment;
import com.example.heaven_motor.fragment.HomeFragment;
import com.example.heaven_motor.fragment.LSDonHang_Fragment;
import com.example.heaven_motor.fragment.QLyLoaiXe_Fragment;
import com.example.heaven_motor.fragment.QLyNguoi_Dung_Fragment;
import com.example.heaven_motor.fragment.QLyXe_Fragment;
import com.example.heaven_motor.fragment.QlyDonHang_Fragment;
import com.example.heaven_motor.fragment.TinTucFragment;
import com.example.heaven_motor.fragment.ToiFragment;
import com.example.heaven_motor.fragment.TopMuon_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
    ViewPager pager;
    ViewpageAdapter adapter;
//    ActivityMainBinding binding;
    HomeFragment homeFragment = new HomeFragment();
    ToiFragment toiFragment  =new ToiFragment();
    TinTucFragment tinTucFragment  =new TinTucFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        binding = ActivityMainBinding.inflate(getLayoutInflater());
//        setContentView(binding.getRoot());
//        binding.navtionBottom.setOnItemSelectedListener(item ->{
//            switch (item.getItemId()){
//                case R.id.trangChu:
//                    rp(new QLyXe_Fragment());
//                    break;
//                case R.id.toi:
//                    rp(new ToiFragment());
//                    break;
//            }
//            return true;
//        });

        drawerLayout = findViewById(R.id.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navtion);
        bottomNavigationView = findViewById(R.id.bottom);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.pagerTrangchu,homeFragment).commit();
                        pager.setAdapter(adapter);
                        pager.setCurrentItem(9);
//                        Toast.makeText(MainActivity.this, "lên", Toast.LENGTH_SHORT).show();
                        return true;
                    case R.id.TinTuc:
                        getSupportFragmentManager().beginTransaction().replace(R.id.pagerTrangchu,tinTucFragment).commit();
                        pager.setAdapter(adapter);
                        pager.setCurrentItem(10);
//                        Toast.makeText(MainActivity.this, "lên", Toast.LENGTH_SHORT).show();
                        return true;
                case R.id.toi:
                    getSupportFragmentManager().beginTransaction().replace(R.id.pagerTrangchu,toiFragment).commit();
                    pager.setAdapter(adapter);
                    pager.setCurrentItem(11);
//                    Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                    return true;
            }
                return false;
            }
        });
        pager = findViewById(R.id.pagerTrangchu);
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
        else if(id==R.id.home){
            toolbar.setTitle("Home");
            pager.setAdapter(adapter);
            pager.setCurrentItem(9);
        }
        else if(id==R.id.TinTuc){
            toolbar.setTitle("Tin tức");
            pager.setAdapter(adapter);
            pager.setCurrentItem(10);
        }
        else if(id==R.id.toi){
            toolbar.setTitle("Tài khoản");
            pager.setAdapter(adapter);
            pager.setCurrentItem(11);
        }
        else if (id == R.id.dangXuat ){

            startActivity(new Intent(MainActivity.this, Login_MainActivity2.class));
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
        adapter.addFragment(new HomeFragment(),"Home");
        adapter.addFragment(new TinTucFragment(),"Tài khoản");
        adapter.addFragment(new ToiFragment(),"Tài Khoản");
        pager.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(drawerLayout.isDrawerOpen(navigationView)){
            drawerLayout.closeDrawer(navigationView);
        }
        else{
            super.onBackPressed();
        }
    }
    private void rp(Fragment fragment){
        FragmentManager fragmentManager  =getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.pagerTrangchu,fragment);
        fragmentTransaction.commit();

    }
}