package com.eapteka.eaptekatests;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new TestResultFragment(), "000")
                .addToBackStack(null)
                .commitAllowingStateLoss();*/
    }


}