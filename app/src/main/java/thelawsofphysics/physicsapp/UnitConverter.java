package thelawsofphysics.physicsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by yanlinzhu on 10/15/17.
 */

public class UnitConverter extends AppCompatActivity {

    EditText unit0;
    EditText unit1;
    EditText expression;
    EditText result;
    double value;
    String lengthUnits[];
    String areaUnits[];
    String powerUnits[];
    String pressureUnits[];
    String speedUnits[];
    String volumeUnits[];
    String weightUnits[];
    String temperatureUnits[];
    String alternativeUnits0[];
    String alternativeUnits1[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unit_converter);

        TextView title = (TextView) findViewById(R.id.UnitConverter);
        if(getIntent().hasExtra("equation")) {
            String equation = getIntent().getExtras().getString("equation");
            title.setText(equation);
        }

        unit0 = (EditText)findViewById(R.id.editUnit0);
        unit1 = (EditText)findViewById(R.id.editUnit1);
        expression = (EditText)findViewById(R.id.editExpression);
        result = (EditText)findViewById(R.id.convertresult);

        // read the unit data from string,xml
        lengthUnits = getResources().getStringArray(R.array.lengthUnits);
        areaUnits = getResources().getStringArray(R.array.areaUnits);
        powerUnits = getResources().getStringArray(R.array.powerUnits);
        pressureUnits = getResources().getStringArray(R.array.pressureUnits);
        speedUnits = getResources().getStringArray(R.array.speedUnits);
        volumeUnits = getResources().getStringArray(R.array.volumeUnits);
        weightUnits = getResources().getStringArray(R.array.weightUnits);
        temperatureUnits = getResources().getStringArray(R.array.temperatureUnits);
        alternativeUnits0 = getResources().getStringArray(R.array.alternativeUnits0);
        alternativeUnits1 = getResources().getStringArray(R.array.alternativeUnits1);
    }

    // convert the normal units
    public void convert(View v) {
        Boolean error = true;
        value = new Double(expression.getText().toString());

        String u0 = unit0.getText().toString();
        String u1 = unit1.getText().toString();
        u0 = formatUnit(u0);
        u1 = formatUnit(u1);
        error = findUnit(u0, u1, lengthUnits);
        if (error) {error = findUnit(u0, u1, areaUnits);}
        if (error) {error = findUnit(u0, u1, powerUnits);}
        if (error) {error = findUnit(u0, u1, pressureUnits);}
        if (error) {error = findUnit(u0, u1, speedUnits);}
        if (error) {error = findUnit(u0, u1, volumeUnits);}
        if (error) {error = findUnit(u0, u1, weightUnits);}
        if (error) {error = findTempUnit(u0, u1, temperatureUnits);}

        if (error) {
            result.setText("Invalid Input");
        }
        else {
            result.setText(String.format("Result:\n %.3f %s\n   =\n%.3f %s",
                           new Double(expression.getText().toString()), u0, new Double(value), u1));
        }
    }

    /**
     * find the normal units which can be calculated by ratio
     *
     * @param u0 First unit.
     * @param u1 Second unit.
     * @param units unit data
     * @return  if the unit is found and converted
     */
    private boolean findUnit(String u0, String u1, String []units) {
        Double value0;
        Double value1;
        if (Arrays.asList(units).contains(u0)) {
            value0 = new Double(units[Arrays.asList(units).indexOf(u0) + 1]);
            if (Arrays.asList(units).contains(u1)) {
                value1 = new Double(units[Arrays.asList(units).indexOf(u1) + 1]);
                value *= (value1 / value0);
                return false;
            }
        }
        return true;
    }

    /**
     * find the special units which cannot be calculated by ratio
     *
     * @param u0 First unit.
     * @param u1 Second unit.
     * @param units unit data
     * @return  if the unit is found and converted
     */
    private boolean findTempUnit(String u0, String u1, String []units) {
        Double value0;
        Double value1;
        if (u0.equals("fahrenheit")){
            value = (value-32)/1.8;
        }
        if (Arrays.asList(units).contains(u0)) {
            value0 = new Double(units[Arrays.asList(units).indexOf(u0) + 1]);
            if (Arrays.asList(units).contains(u1)) {
                value1 = new Double(units[Arrays.asList(units).indexOf(u1) + 1]);
                value += value0 - value1;
                if (u1.equals("fahrenheit")) {
                    value = value * 1.8 + 32;
                }
                return false;
            }
        }
        return true;
    }

    /**
     * convert non standard unit names to standard ones
     *
     * @param un the name of the unit given by the user
     * @return  the standard unit symbol
     */
    private String formatUnit(String un) {
        if (Arrays.asList(alternativeUnits1).contains(un)) {
            return alternativeUnits0[Arrays.asList(alternativeUnits1).indexOf(un)];
        }
        return un;
    }
}