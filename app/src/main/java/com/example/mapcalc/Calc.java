package com.example.mapcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calc extends AppCompatActivity {
    private EmissionsCalculator calculator;
    private Spinner vehicleTypeSpinner;
    private EditText distanceKmEditText;
    private Button calculateButton;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emissions);

        calculator = new EmissionsCalculator();


        String[] vehicleTypes = getResources().getStringArray(R.array.vehicle_types);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, vehicleTypes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        distanceKmEditText = findViewById(R.id.distance_km_edit_text);
        vehicleTypeSpinner = findViewById(R.id.vehicle_type_spinner);
        //EditText editText = findViewById(R.id.distance_km_edit_text);
        calculateButton = findViewById(R.id.calculate_button);
        resultTextView = findViewById(R.id.result_text_view);

        vehicleTypeSpinner.setAdapter(adapter);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (distanceKmEditText != null) {
                    String text = distanceKmEditText.getText().toString();
                    // ...
                }
                String vehicleType = vehicleTypeSpinner.getSelectedItem().toString();
                double distanceKm = Double.parseDouble(distanceKmEditText.getText().toString());

                double emissions = calculator.calculateEmissions(vehicleType, distanceKm);
                resultTextView.setText("Total emissions for " + distanceKm + " km: " + emissions + " grams of CO2");
            }
        });
    }
}