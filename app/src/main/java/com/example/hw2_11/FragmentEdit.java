package com.example.hw2_11;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.hw2_11.data.Data;

public class FragmentEdit extends DialogFragment {

    private EditText mEditText;
    private Button mSaveButton;
    private Button mCancelButton;
    public static FragmentEdit newInstance(String title){
        FragmentEdit fragment = new FragmentEdit();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.fragment_edit,null);

        mEditText = (EditText) view.findViewById(R.id.dataTitle);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle(R.string.edit_title)
                .setPositiveButton(R.string.edit_save, (DialogInterface.OnClickListener) saveBtn)
                .create();
    }



    private View.OnClickListener saveBtn = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getContext(),"Save data." + mEditText.getText(),Toast.LENGTH_SHORT)
                    .show();
        }
    };
}
