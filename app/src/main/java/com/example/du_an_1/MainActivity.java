package com.example.du_an_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.du_an_1.adapter.ViewpageAdapter;
import com.example.du_an_1.fragment.DatHangFragment;
import com.example.du_an_1.fragment.DoanhThuFragment;
import com.example.du_an_1.fragment.DoiMatKhauFragment;
import com.example.du_an_1.fragment.LichSuDatHangFragment;
import com.example.du_an_1.fragment.QuanLiDonHangFragment;
import com.example.du_an_1.fragment.QuanLiLoaiXeFragment;
import com.example.du_an_1.fragment.QuanLiNguoiDungFragment;
import com.example.du_an_1.fragment.QuanLiXeFragment;
import com.example.du_an_1.fragment.TopXeFragment;
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
    public void replaceFragement(Fragment fragment){
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.page,fragment);
        transaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.QLLX){
            pager.setAdapter(adapter);
            pager.setCurrentItem(0);
            toolbar.setTitle("Qu???n l?? lo???i xe");

        }else if(id==R.id.QLX){
//            replaceFragement(QuanLiXeFragment.newInstance());
            pager.setAdapter(adapter);
            pager.setCurrentItem(1);
            toolbar.setTitle("Qu???n l?? xe");
        }
        else if(id==R.id.QLDH){
//            replaceFragement(QuanLiDonHangFragment.newInstance());
            pager.setAdapter(adapter);
            pager.setCurrentItem(2);
            toolbar.setTitle("Qu???n l?? ????n h??ng");

        }
        else if(id==R.id.DatHang){
//            replaceFragement(DatHangFragment.newInstance());
            toolbar.setTitle("?????t h??ng");
            pager.setAdapter(adapter);
            pager.setCurrentItem(3);
        }else if(id==R.id.LSDH){
//            replaceFragement(LichSuDonHangFragment.newInstance());
            toolbar.setTitle("Nh???ng ????n ???? ?????t");
            pager.setAdapter(adapter);
            pager.setCurrentItem(4);

        }else if(id==R.id.topXe){
//            replaceFragement(TopXeFragment.newInstance());
            toolbar.setTitle("Top xe ???????c thu?? nhi???u nh???t");
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
           toolbar.setTitle("Qu???n l?? ng?????i d??ng");
            pager.setAdapter(adapter);
            pager.setCurrentItem(7);
        }
        else if(id==R.id.doiPass){
//            replaceFragement(DoiMatKhauFragment.newInstance());
            toolbar.setTitle("?????i m???t kh???u");
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
        adapter.addFragment(new QuanLiLoaiXeFragment(),"Qu???n l?? lo???i xe");
        adapter.addFragment(new QuanLiXeFragment(),"Qu???n l?? xe");
        adapter.addFragment(new QuanLiDonHangFragment(),"Qu???n l?? ????n h??ng");
        adapter.addFragment(new DatHangFragment(),"?????t h??ng");
        adapter.addFragment(new LichSuDatHangFragment(),"Nh???ng ????n ???? ?????t");
        adapter.addFragment(new TopXeFragment(),"Top xe ???????c thu?? nhi???u nh???t");
        adapter.addFragment(new DoanhThuFragment(),"Doanh thu");
        adapter.addFragment(new QuanLiNguoiDungFragment(),"Qu???n l?? ng?????i d??ng");
        adapter.addFragment(new DoiMatKhauFragment(),"?????i m???t kh???u");
        pager.setAdapter(adapter);

    }
}