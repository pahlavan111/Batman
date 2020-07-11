package com.bp.batman;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;

import com.bp.batman.home.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private static int PERMISSION_REQUEST = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {


            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST);

            } else {

                // createFilePath();
            }


        } else {

            //  createFilePath();

        }


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.fl_container, new HomeFragment());
        transaction.commit();
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


            }
        }
    }

}