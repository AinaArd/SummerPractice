package com.example.fragmenttask;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;


public class SecondFragment extends Fragment {

    TextView textView;

    public static SecondFragment newInstance() {
        return new SecondFragment();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_second, container, false);

        textView = rootView.findViewById(R.id.textView);

        return rootView;
    }

   public void setText(String string) {
        textView.setText(string);
   }
}
