package com.example.platzigram.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.platzigram.R;
import com.example.platzigram.view.fragments.HomeFragment;
import com.example.platzigram.view.fragments.ProfileFragment;
import com.example.platzigram.view.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ContainerActivity extends AppCompatActivity {

    private BottomNavigationView Bottonbar;
    private HomeFragment home;
    private ProfileFragment profile;
    private SearchFragment search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        UIConfig();
        home = new HomeFragment();
        profile = new ProfileFragment();
        search = new SearchFragment();

        setFragment(home);

        Bottonbar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.search:
                        setFragment(search);
                        return true;
                    case R.id.home:
                        setFragment(home);
                        return true;
                    case R.id.profile:
                        setFragment(profile);
                        return true;
                }
                return false;
            }
        });
    }

    public void UIConfig(){
        Bottonbar = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
    }

    private void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }
}
