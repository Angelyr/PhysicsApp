package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Equation extends AppCompatActivity {

    EditText substituteEquation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equation);

        //Receives equation to set edit text
        Resources res = getResources();
        substituteEquation = (EditText) findViewById(R.id.substituteEquation);
        if(getIntent().hasExtra("substitute")) {
            String equation = getIntent().getExtras().getString("substitute");
            substituteEquation.setText(equation);
        }

        //Sends equation to unit converter
        Button converterBtn = (Button)findViewById(R.id.convertBtn);
        converterBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), UnitConverter.class);
                startIntent.putExtra("equation", substituteEquation.getText().toString());
                startActivity(startIntent);
            }
        });

        //Sends equation to calculator
        Button calculatorBtn = (Button)findViewById(R.id.solveBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CalculatorScreen.class);
                startIntent.putExtra("equation", substituteEquation.getText().toString());
                startActivity(startIntent);
            }
        });

        //adds equation to favorite equations
        Button addFavoriteBtn = (Button)findViewById(R.id.addFavoriteBtn);
        addFavoriteBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String equationWrite = substituteEquation.getText().toString() + "\n";
                String filename = "Favorites";
                try{
                    FileOutputStream outputStream = openFileOutput(filename, MODE_APPEND);
                    outputStream.write(equationWrite.getBytes());
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Intent startIntent = new Intent(getApplicationContext(), Favorite.class);
                startActivity(startIntent);
            }
        });
    }
}
