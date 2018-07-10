package com.example.dialogtask2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by ${Aina} on 10.07.2018.
 */
public class Dialog extends DialogFragment {

    EditText editTextLogin;
    EditText editTextMail;
    MyListener myListener;

    public android.app.Dialog onCreateDialog(@Nullable Bundle saveInstanceState) {
        super.onCreateDialog(saveInstanceState);
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog, null);
        editTextLogin= view.findViewById(R.id.editTextLogin);
        editTextMail = view.findViewById(R.id.editTextMail);


        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle("fill").setView(view)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String login = editTextLogin.getText().toString();
                        String eMail = editTextMail.getText().toString();
                        myListener.mListener(login, eMail);

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

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            myListener = (MyListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragment1DataListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        myListener = null;
    }
}
