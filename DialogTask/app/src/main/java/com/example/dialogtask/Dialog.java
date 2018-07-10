package com.example.dialogtask;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.example.dialogtask.R;

/**
 * Created by ${Aina} on 10.07.2018.
 */
public class Dialog extends DialogFragment {

    EditText editText;

    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog,null);
        editText = view.findViewById(R.id.editText);

        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("titel").setView(view)
                .setMessage("message")
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })

                .setNegativeButton("not ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return adb.show();
    }
}
