package com.example.fragmenttask;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements FirstFragment.FragmentListener {

    private EditText editText;
    private Button button;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        initFirstFragment();
        initSecondFragment();
    }

    @Override
    public void callback(String string) {
       /* if (secondFragment != null) {
            secondFragment.setText(string);
        } else {
            initSecondFragment();
            secondFragment.setText(string);
        }*/

       SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentSecond);
       secondFragment.textView.setText(string);
    }


    private void initFirstFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentFirst, FirstFragment.newInstance())
                .commit();
    }

    private void initSecondFragment() {
        secondFragment = SecondFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentSecond, secondFragment)
                .commit();
    }
}

