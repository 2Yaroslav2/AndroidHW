package com.example.hw4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.hw4.dummy.DummyContent;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateProductFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateProductFragment extends Fragment {

    public interface OnAddFragmentListener {
        void onBtnCreateClick();
    }

    private OnAddFragmentListener listener;

    EditText etPath, etName, etCount, etAvailable;
    Button btnCancel, btnSave;

    private static final int FILE_SELECT_CODE = 0;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateProductFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateProductFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateProductFragment newInstance(String param1, String param2) {
        CreateProductFragment fragment = new CreateProductFragment();
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
        View view = inflater.inflate(R.layout.fragment_create_product, container, false);

        etName = view.findViewById(R.id.etName);
        etAvailable = view.findViewById(R.id.etAvailable);
        etCount = view.findViewById(R.id.etCount);
        etPath = view.findViewById(R.id.etPhoto);

        btnCancel = view.findViewById(R.id.btnCancel);
        btnSave = view.findViewById(R.id.btnSave);

        btnCancel.setOnClickListener(v -> {
            listener.onBtnCreateClick();
        });

        btnSave.setOnClickListener(v -> {
            DummyContent.ITEMS.add(new DummyContent.DummyItem(
                    String.valueOf(DummyContent.ITEMS.size())
                    , etName.getText().toString()
                    , etPath.getText().toString()
                    , etCount.getTextAlignment()
                    , etAvailable.getText().toString()));
            listener.onBtnCreateClick();
        });

        return view;
    }

//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == FILE_SELECT_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                uri = data.getData();
//                Picasso.get().load(uri).into(ivAdd);
//            }
//        }
//    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnAddFragmentListener) {
            listener = (OnAddFragmentListener) context;
        }
    }
}