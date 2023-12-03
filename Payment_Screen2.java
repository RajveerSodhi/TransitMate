package com.example.transitmate_paymentstep;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Payment_Screen2#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class Payment_Screen2 extends Fragment {


    Button submitButton;
    Button backButton;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Payment_Screen2.
     */
    // TODO: Rename and change types and number of parameters
    public static Payment_Screen2 newInstance(String param1, String param2) {
        Payment_Screen2 fragment = new Payment_Screen2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public Payment_Screen2() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        //Button submitButton = findViewById(R.id.button);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the NextActivity upon clicking the Submit button
                Intent intent = new Intent(requireContext(), Payment_Screen3.class);
                startActivity(intent);
            }
        });

       // Button backButton = findViewById(R.id.button3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the NextActivity upon clicking the Submit button
                Intent intent = new Intent(requireContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_payment__screen2, container, false);

        // Access views within the fragment layout using findViewById()
        // For example:
        submitButton = rootView.findViewById(R.id.button);
        backButton = rootView.findViewById(R.id.button3);
        //TextView textViewExample = rootView.findViewById(R.id.textViewExample);
        //textViewExample.setText("Hello, Fragment!");

        // Add any other view-related operations using findViewById()

        return rootView;
    }
}