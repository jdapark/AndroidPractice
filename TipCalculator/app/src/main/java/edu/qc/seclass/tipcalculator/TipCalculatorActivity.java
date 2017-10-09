package edu.qc.seclass.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.daniel.tipcalculator.R;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }

    public void computeTip(View view) {
        try {
            EditText checkAmountValue = (EditText) findViewById(R.id.checkAmountValue);
            Double checkAmount = Double.parseDouble(checkAmountValue.getText().toString());

            if (checkAmount < 0) {
                Toast.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
                return;
            }
            EditText partySizeValue = (EditText) findViewById(R.id.partySizeValue);
            Integer partySize = Integer.parseInt(partySizeValue.getText().toString());

            if (partySize <= 0) {
                Toast.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
                return;
            }
            EditText fifteenPercentTipValue = (EditText) findViewById(R.id.fifteenPercentTipValue);
            EditText fifteenPercentTotalValue = (EditText) findViewById(R.id.fifteenPercentTotalValue);
            EditText twentyPercentTipValue = (EditText) findViewById(R.id.twentyPercentTipValue);
            EditText twentyPercentTotalValue = (EditText) findViewById(R.id.twentyPercentTotalValue);
            EditText twentyfivePercentTipValue = (EditText) findViewById(R.id.twentyfivePercentTipValue);
            EditText twentyfivePercentTotalValue = (EditText) findViewById(R.id.twentyfivePercentTotalValue);

            Integer fifteenPercentTip = 0;
            Integer fifteenPercentTotal = 0;
            Integer twentyPercentTip = 0;
            Integer twentyPercentTotal = 0;
            Integer twentyfivePercentTip = 0;
            Integer twentyfivePercentTotal = 0;

            fifteenPercentTip = (int)Math.round((checkAmount / partySize) * .15);
            fifteenPercentTipValue.setText("" + fifteenPercentTip);
            fifteenPercentTotal = (int)Math.round((checkAmount/partySize) + fifteenPercentTip);
            fifteenPercentTotalValue.setText("" + fifteenPercentTotal);

            twentyPercentTip = (int)Math.round((checkAmount / partySize) * .2);
            twentyPercentTipValue.setText("" + twentyPercentTip);
            twentyPercentTotal = (int)Math.round((checkAmount/partySize) + twentyPercentTip);
            twentyPercentTotalValue.setText("" + twentyPercentTotal);

            twentyfivePercentTip = (int)Math.round((checkAmount / partySize) * .25);
            twentyfivePercentTipValue.setText("" + twentyfivePercentTip);
            twentyfivePercentTotal = (int)Math.round((checkAmount/partySize) + twentyfivePercentTip);
            twentyfivePercentTotalValue.setText("" + twentyfivePercentTotal);
        } catch (Exception e) {
            //only when there is some sort of error
            Toast.makeText(TipCalculatorActivity.this, "Empty or incorrect value(s)!", Toast.LENGTH_SHORT).show();
        }
    }
}