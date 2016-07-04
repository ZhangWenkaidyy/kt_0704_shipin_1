package com.kevin.zwk.kt_0704_shipin_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.vov.vitamio.Vitamio;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Vitamio.isInitialized(getApplication());
        setContentView(R.layout.activity_main);

    }
}
