package com.example.hw2_11;

import static android.content.DialogInterface.BUTTON_NEGATIVE;
import static android.content.DialogInterface.BUTTON_NEUTRAL;
import static android.content.DialogInterface.BUTTON_POSITIVE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hw2_11.data.Data;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final int REQUEST_DATE = 0;
    private static final String DIALOG_TITLE = "DialogTitle";

    private Button mEditButton;
    private Button mDeleteButton;
    private TextView mTextView;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Data data;

    public FragmentList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentList.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentList newInstance(String param1, String param2) {
        FragmentList fragment = new FragmentList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        data = new Data("Shalva");
        mTextView = (TextView) view.findViewById(R.id.textView);
        mTextView.setText(data.getTitle());

        mDeleteButton = (Button) view.findViewById(R.id.deleteButton);
        mDeleteButton.setOnClickListener(deleteButtonClick);

        mEditButton = (Button) view.findViewById(R.id.editButton);
        mEditButton.setOnClickListener(editButtonClick);
    }

    private View.OnClickListener editButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final View contentView = requireActivity().getLayoutInflater()
                    .inflate(R.layout.fragment_edit,null);
            AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
            builder.setTitle("Edit")
                    .setView(contentView)
            .setPositiveButton(R.string.edit_save, null);
            builder.show();
        }
    };
    private View.OnClickListener deleteButtonClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
            dialog.setTitle("Delete")
                    .setMessage("Do you realy want to Delete?")
                    .setPositiveButton("OK", okclick)
                    .setNegativeButton("Cancel", okclick)
                    .show();
        }

    };

    private DialogInterface.OnClickListener okclick = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch(which) {
                case BUTTON_POSITIVE:
                Toast.makeText(getContext(), "Click ok delete which: " + which, Toast.LENGTH_SHORT)
                        .show();
                return;
                case BUTTON_NEGATIVE:
                Toast.makeText(getContext(),"Click Cancel delete which:"+which,Toast.LENGTH_SHORT)
                        .show();
                dialog.cancel();
                return;
                case BUTTON_NEUTRAL:
                    Toast.makeText(getContext(),"Click Neutral delete which:"+which,Toast.LENGTH_SHORT)
                            .show();
                    return;
                default: Toast.makeText(getContext(),"No Click Button delete which:"+which,Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };

    private DialogInterface.OnClickListener cancelClick=new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            dialog.cancel();
            Toast.makeText(getContext(),"Click Cancel delete which:"+which,Toast.LENGTH_SHORT)
                    .show();
        }
    };


}