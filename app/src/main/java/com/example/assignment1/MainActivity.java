package com.example.assignment1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button pay_btn;
    public EditText hoursWorked;
    public EditText hourlyRate;
    public TextView pay;
    public TextView payTax;

    double hRate;
    double hWorked;
    double total;
    double taxTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pay_btn = findViewById(R.id.btnCalc);
        hoursWorked = findViewById(R.id.hWorked);
        hourlyRate = findViewById(R.id.hRate);
        pay = findViewById(R.id.pay);
        payTax = findViewById(R.id.payTax);

        pay_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numHours = hoursWorked.getText().toString();
                hWorked = Double.parseDouble(numHours);

                String hPay = hourlyRate.getText().toString();
                hRate = Double.parseDouble(hPay);

                if (hWorked <= 40) {
                    total = hWorked * hRate;
                }
                else {
                    total = (hWorked - 40) * hRate * 1.5 + 40 * hRate;
                }

                taxTotal = total * 0.18;

                pay.setText(String.valueOf(total));
                payTax.setText(String.valueOf(taxTotal));
            }

        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.aboutMe:
                Intent i = new Intent(this, AboutActivity.class);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
