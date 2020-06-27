package com.achmadqomarudin.animatedbottombar.activities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.achmadqomarudin.animatedbottombar.R;
import com.achmadqomarudin.animatedbottombar.fragments.AccountFragment;
import com.achmadqomarudin.animatedbottombar.fragments.BookFragment;
import com.achmadqomarudin.animatedbottombar.fragments.HomeFragment;

import org.jetbrains.annotations.NotNull;

import nl.joery.animatedbottombar.AnimatedBottomBar;

public class Example3Activity extends AppCompatActivity {
    private static final String TAG = Example3Activity.class.getSimpleName();
    AnimatedBottomBar animatedBottomBar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example3);
        setTitle("Example 3");

        animatedBottomBar = findViewById(R.id.animatedBottomBar);

        if (savedInstanceState == null) {
            animatedBottomBar.selectTabById(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment)
                    .commit();
        }

        animatedBottomBar.setOnTabSelectListener(new AnimatedBottomBar.OnTabSelectListener() {
            @Override
            public void onTabSelected(int lastIndex, @Nullable AnimatedBottomBar.Tab lastTab, int newIndex, @NotNull AnimatedBottomBar.Tab newTab) {
                Fragment fragment = null;
                switch (newTab.getId()) {
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.book:
                        fragment = new BookFragment();
                        break;
                    case R.id.account:
                        fragment = new AccountFragment();
                        break;
                }

                if (fragment != null) {
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment)
                            .commit();
                } else {
                    Log.e(TAG, "Error in creating Fragment");
                }
            }
        });
    }
}
