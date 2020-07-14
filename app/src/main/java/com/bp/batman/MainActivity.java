package com.bp.batman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import com.bp.batman.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static int PERMISSION_REQUEST = 1001;

    FragmentManager manager;
    FragmentTransaction transaction;
    HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST);

            } else {

                // createFilePath();
                homeFragment=new HomeFragment();
                transaction.replace(R.id.fl_container, homeFragment);
                transaction.commit();
            }


        } else {

            //  createFilePath();
            homeFragment=new HomeFragment();
            transaction.replace(R.id.fl_container, homeFragment);
            transaction.commit();

        }





    }


//    private boolean isOnline() {
//        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//        assert connectivityManager != null;
//        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//        Boolean mobileInfo = networkInfo != null && networkInfo.isConnected();
//
//        networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        Boolean wifiInfo = networkInfo != null && networkInfo.isConnected();
//
//        return wifiInfo || mobileInfo;
//    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);


        if (requestCode == PERMISSION_REQUEST && grantResults.length > 0) {

            if (grantResults[0] >= 0) {


                //   createFilePath();
                homeFragment=new HomeFragment();
                transaction.replace(R.id.fl_container, homeFragment);
                transaction.commit();


            }
        }
    }

    @Override
    public void onBackPressed() {

        if (manager.getBackStackEntryCount() == 1) {

           manager.popBackStack();

           FragmentManager manager1= getSupportFragmentManager();
           FragmentTransaction transaction1 = manager1.beginTransaction();
           transaction1.replace(R.id.fl_container,new HomeFragment());
            transaction1.commit();

        } else {
            super.onBackPressed();
        }
    }
}