package com.engineerkunle.tabmaterial;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.engineerkunle.tabmaterial.Adapter.ViewPagerAdapter;
import com.engineerkunle.tabmaterial.Fragment.OneFragment;
import com.engineerkunle.tabmaterial.Fragment.ThreeFragment;
import com.engineerkunle.tabmaterial.Fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private int[] tabIcons = {
            R.drawable.ic_android_white_24dp,
            R.drawable.ic_extension_white_18dp,
            R.drawable.ic_grade_white_24dp
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    private void setUpViews() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(mViewPager);

        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.setupWithViewPager(mViewPager);
        setTabIcons();
    }

    private void setTabIcons() {
        int j = 0;
        for(int icons : tabIcons) {
            mTabLayout.getTabAt(j++).setIcon(icons);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "One");
        adapter.addFragment(new TwoFragment(), "Two");
        adapter.addFragment(new ThreeFragment(), "Three");
        viewPager.setAdapter(adapter);
    }
}
