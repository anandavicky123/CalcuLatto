package com.softgasm.calculatto;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.appodeal.ads.Appodeal;
import com.google.android.material.navigation.NavigationView;
import com.softgasm.calculatto.databinding.ActivityMainBinding;
import com.softgasm.calculatto.system.App;

import java.lang.ref.WeakReference;
import java.util.Objects;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    public static boolean AdsIsShown = false;
    public static WeakReference<MainActivity> weakActivity;
    NavController navController;
    View navigationHeader;

    TextView appstatus;

    com.appodeal.ads.BannerView adlayoutreplacement;
    private AppBarConfiguration mAppBarConfiguration;

    public static MainActivity getmInstanceActivity() {
        return weakActivity.get();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.softgasm.calculatto.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        navigationView.setItemIconTintList(null);
        navigationHeader = navigationView.getHeaderView(0);


        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.general, R.id.nav_unit, R.id.health, R.id.geometry, R.id.advanced)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        appstatus = navigationHeader.findViewById(R.id.appstatus);
        adlayoutreplacement = findViewById(R.id.adlayout);
        premiumorfree();


        weakActivity = new WeakReference<>(MainActivity.this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.action_about) {
            navController.navigate(R.id.about);
        } else if (item.getItemId() == R.id.action_setting) {
            navController.navigate(R.id.settings);
        } else if (item.getItemId() == R.id.action_premium) {
            navController.navigate(R.id.premium);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!App.SubscriptionStatus(this)) {
            loadads();
        }
    }

    public void loadads() {
        general.loadgeneralads(this);
        advanced.loadadvancedads(this);
        geometry.loadgeometryads(this);
        health.loadhealthads(this);
    }

    public void premiumorfree() {

        if (App.SubscriptionStatus(this)) {
            adlayoutreplacement.setVisibility(View.GONE);
            appstatus.setText("Premium");
        } else {
            adlayoutreplacement.setVisibility(View.VISIBLE);
            appstatus.setText("Free");
//            if (BuildConfig.DEBUG) {
//                Appodeal.setTesting(true);
//            }
            Appodeal.setBannerViewId(R.id.adlayout);
            Appodeal.initialize(this, "c531f9916cbe142e3ce97d712fcc2a4ca7e1f05071c1c764", Appodeal.INTERSTITIAL | Appodeal.REWARDED_VIDEO | Appodeal.BANNER, errors -> {
                // Appodeal initialization finished
            });
            AdsIsShown = true;
            Appodeal.show(this, Appodeal.BANNER_VIEW);
        }
    }

    public void goRecreate() {
        MainActivity.this.recreate();
    }
}