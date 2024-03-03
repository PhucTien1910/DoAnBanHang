package com.example.doanbanhang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.doanbanhang.fragment.CartFragment;
import com.example.doanbanhang.fragment.HomeFragment;
import com.example.doanbanhang.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bottomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }
void loadFragment(Fragment fmNew){
    FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
    fmTran.replace(R.id.main_frame,fmNew);
    fmTran.addToBackStack(null);
    fmTran.commit();
}
    private void addEvents() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                //load Fragment
                //khi chọn item menu Navigation sẽ load fragment
                Fragment fmNew;
                if(item.getItemId()==R.id.bottomHome){
                    fmNew = new HomeFragment();
                    loadFragment(fmNew);
                    return true;
                }
                if(item.getItemId()==R.id.bottomCart){
                    fmNew = new CartFragment();
                    loadFragment(fmNew);
                    return true;
                }
                if(item.getItemId()==R.id.bottomProfile){
                    fmNew = new ProfileFragment();
                    loadFragment(fmNew);
                    return true;
                }
                return true;
            }
        });
    }

    private void addControls() {
        bottomNav = findViewById(R.id.bottomNav);
    }
}