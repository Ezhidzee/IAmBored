package com.example.iambored;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Context MainActivityContext;
    Spinner typesSpinner, participantsSpinner;
    TextView activityTv;
    final String[] type = {"random"};
    final String[] countOfParticipants = {"1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityContext = MainActivity.this;
        typesSpinner = findViewById(R.id.types);
        participantsSpinner = findViewById(R.id.participants);
        activityTv = findViewById(R.id.activityTv);

        String[] types = new String[]{"random", "education", "recreational", "social", "diy", "charity",
                "cooking", "relaxation", "music", "busywork"};
        ArrayAdapter<String> typesSpinnerAdapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item, types);
        typesSpinnerAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        typesSpinner.setAdapter(typesSpinnerAdapter);

        typesSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type[0] = types[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] participants = new String[]{"1", "2", "3", "4", "5", "8", "random"};
        ArrayAdapter<String> participantsSpinnerAdapter = new ArrayAdapter<>(this,
                R.layout.custom_spinner_item, participants);
        participantsSpinnerAdapter.setDropDownViewResource(R.layout.custom_spinner_dropdown_item);
        participantsSpinner.setAdapter(participantsSpinnerAdapter);

        participantsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                countOfParticipants[0] = participants[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public static Context getContext() {
        return MainActivityContext;
    }

    BoredApiHelper.BoredResult boredResult = new BoredApiHelper.BoredResult() {
        @Override
        public void gotActivity(String activity) {
            if (activity != null) {
                activityTv.setText(activity);
            } else {
                activityTv.setText("No activity for the selected parameters");
            }
        }
    };

    public void getActivity(View view) {
        BoredApiHelper boredApiHelper = new BoredApiHelper(type[0],
                countOfParticipants[0], boredResult);
        boredApiHelper.getActivity();
    }
}