package com.example.diceroller3;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class RollLengthDialogFragment extends DialogFragment {

    public interface OnRollLengthSelectedListener {
        public void onRollLengthClick(int which);
    }

    private OnRollLengthSelectedListener mListener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pick_roll_length);
        builder.setItems(R.array.length_array, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                mListener.onRollLengthClick(which);
            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (OnRollLengthSelectedListener) context;
    }
}

