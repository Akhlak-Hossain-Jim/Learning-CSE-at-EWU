package com.lifeflow.app.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.lifeflow.app.R;
import com.lifeflow.app.ui.donor.DonorListFragment;
import com.lifeflow.app.ui.profile.ProfileFragment;
import com.lifeflow.app.ui.request.RequestsListFragment;

/**
 * Shell activity that hosts the 4-tab bottom navigation.
 * All main screens are Fragments swapped into fragmentContainer.
 */
public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bottomNav = findViewById(R.id.bottomNav);

        // Default tab: Home
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
            bottomNav.setSelectedItemId(R.id.nav_home);
        }

        bottomNav.setOnItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id == R.id.nav_home) {
                return loadFragment(new HomeFragment());
            } else if (id == R.id.nav_donors) {
                return loadFragment(new DonorListFragment());
            } else if (id == R.id.nav_requests) {
                return loadFragment(new RequestsListFragment());
            } else if (id == R.id.nav_profile) {
                return loadFragment(new ProfileFragment());
            }
            return false;
        });
    }

    /**
     * Replaces the fragment container content.
     */
    private boolean loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
        return true;
    }

    /**
     * Programmatically switch to a specific bottom nav tab.
     * Called by child fragments (e.g. HomeFragment "See All >" → Requests tab).
     */
    public void switchToTab(int navItemId) {
        bottomNav.setSelectedItemId(navItemId);
    }
}
