package com.example.quanlichitieu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.quanlichitieu.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(view);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        binding.viewPager.setAdapter(adapter);
        onChangeTab();
        onSlideTab();
    }

    public void onSlideTab() {
        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        binding.bottomNvbar.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        binding.bottomNvbar.getMenu().findItem(R.id.action_chi).setChecked(true);
                        break;
                    case 2:
                        binding.bottomNvbar.getMenu().findItem(R.id.action_thu).setChecked(true);
                        break;
                    case 3:
                        binding.bottomNvbar.getMenu().findItem(R.id.action_account).setChecked(true);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void onChangeTab() {
        binding.bottomNvbar.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.action_home) {
                    binding.viewPager.setCurrentItem(0);
                }
                if (item.getItemId() == R.id.action_chi) {
                    binding.viewPager.setCurrentItem(1);
                }
                if (item.getItemId() == R.id.action_thu) {
                    binding.viewPager.setCurrentItem(2);
                }
                if (item.getItemId() == R.id.action_account) {
                    binding.viewPager.setCurrentItem(3);
                }
                return true;
            }
        });
    }
}