package com.example.tarea4;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.example.tarea4.R;
import com.example.tarea4.fragments.FragmentElectronics;
import com.example.tarea4.fragments.FragmentHome;
import com.example.tarea4.fragments.FragmentTechnology;
import com.example.tarea4.tools.Constants;


public class MainActivity extends AppCompatActivity {
    FloatingActionButton floatBtn;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private FragmentTechnology fragmentTechnology;
    private FragmentHome fragmentHome;
    private FragmentElectronics fragmentElectronics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        floatBtn = findViewById(R.id.activity_main_floatBtn);

        floatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityItem.class);
                startActivity(intent);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch(requestCode){
            case 1:
                if(resultCode == Activity.RESULT_OK){
                    fragmentTechnology.onActivityResult(requestCode, resultCode, data);
                }
                break;
            case 2:
                if(resultCode == Activity.RESULT_OK){
                    fragmentHome.onActivityResult(requestCode, resultCode, data);
                }
                break;
            case 3:
                if(resultCode == Activity.RESULT_OK){
                    fragmentElectronics.onActivityResult(requestCode, resultCode, data);
                }
                break;
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_privacy_policy) {
            Intent intent = new Intent(MainActivity.this,PrivacyPolicyActivity.class);
            startActivity(intent);
            return true;
        }

        if (id == R.id.action_LogOut) {
            SharedPreferences settings = getSharedPreferences(Constants.MAIN_PACKAGE, MODE_PRIVATE);
            settings.edit().clear().commit();

            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }


    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }




        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if(fragmentTechnology == null){
                        fragmentTechnology = new FragmentTechnology();
                    }
                    return fragmentTechnology;
                case 1:
                    if(fragmentHome == null){
                        fragmentHome = new FragmentHome();
                    }
                    return fragmentHome;
                case 2:
                    if(fragmentElectronics == null){
                        fragmentElectronics = new FragmentElectronics();
                    }
                    return fragmentElectronics;
                default:
                    return new FragmentTechnology();
            }
        }
        /*public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }*/



        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        //añadir elementos al tab
        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0: return getApplicationContext().getResources().getString( R.string.first_section_tab);
                case 1: return getApplicationContext().getResources().getString( R.string.second_section_tab);
                case 2: return getApplicationContext().getResources().getString( R.string.third_section_tab);

            }
            return null;
        }
    }
}
