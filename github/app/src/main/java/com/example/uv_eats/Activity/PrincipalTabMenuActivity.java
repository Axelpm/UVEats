package com.example.uv_eats.Activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.uv_eats.Activity.Controller.PagerController;
import com.example.uv_eats.databinding.ActivityPrincipalTabMenuActivityBinding;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class PrincipalTabMenuActivity extends AppCompatActivity {

    private ActivityPrincipalTabMenuActivityBinding binding;
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabProduct, tabCart, tabRecord;
    PagerController pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalTabMenuActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.OptionsImage.setOnClickListener(v ->{
            startEmployeeOptions();
        });

        binding.ExitImage.setOnClickListener(v ->{
            startLogin();
        });

        tabLayout = binding.tabLayout;
        viewPager = binding.viewPager;
        tabProduct = binding.tabProducts;
        tabCart = binding.tabCart;
        tabRecord = binding.tabRecord;

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition() == 0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition() == 2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }

    private void startLogin() {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void startEmployeeOptions() {
        Intent intent = new Intent(this, EmployeeOptions.class);
        startActivity(intent);
    }

}