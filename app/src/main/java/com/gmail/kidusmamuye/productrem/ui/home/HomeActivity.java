package com.gmail.kidusmamuye.productrem.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.gmail.kidusmamuye.productrem.R;
import com.gmail.kidusmamuye.productrem.base.view.BaseActivity;
import com.gmail.kidusmamuye.productrem.ui.login.LoginActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KidusMT on 12/22/2017.
 */

public class HomeActivity extends BaseActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager = findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //TODO: STRINGS HAVE TO BE CHANGED FROM THE RESOURCE VALUE FOLDER - STRING
        adapter.addFragment(new FragmentTab(), getResources().getString(R.string.home_tab_0_label));
        adapter.addFragment(new FragmentTab(), getResources().getString(R.string.home_tab_1_label));

        viewPager.setAdapter(adapter);
    }

    //for logout from navigationDrawer
    public void logout(){
        startActivity(new Intent(this, LoginActivity.class));
    }

    //CONTROLS THE SELECTION AND SWIPE FOR THE TABS
    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
