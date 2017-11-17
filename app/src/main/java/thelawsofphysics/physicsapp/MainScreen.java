package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
//import java.util.List;

public class MainScreen extends AppCompatActivity {

    String[] list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        final Resources res = getResources();
        //when equations button is clicked creates list of equations
        Button equationsBtn = (Button)findViewById(R.id.equationsBtn);
        equationsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list = res.getStringArray(R.array.equations);
                startIntent.putExtra("display",list);
                startActivity(startIntent);
            }
        });
        //when variables button is pressed creates list of variables
        Button variablesBtn = (Button)findViewById(R.id.variablesBtn);
        variablesBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list = res.getStringArray(R.array.variables);
                startIntent.putExtra("display", list);
                startActivity(startIntent);
            }
        });
        //when constants button is pressed creates list of constants
        Button constantsBtn = (Button)findViewById(R.id.constantsBtn);
        constantsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list = res.getStringArray(R.array.constants);
                String[] values = res.getStringArray(R.array.constantValues);
                for(int i = 0; i < list.length; i++)
                {
                    list[i] += " = " + values[i];
                }
                startIntent.putExtra("display", list);
                startActivity(startIntent);
            }
        });

        Button converterBtn = (Button)findViewById(R.id.converterBtn);
        converterBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), UnitConverter.class);
                startActivity(startIntent);
            }
        });

        Button calculatorBtn = (Button)findViewById(R.id.calculatorBtn);
        calculatorBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), CalculatorScreen.class);
                startActivity(startIntent);
            }
        });

        Button searchBtn = (Button)findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SearchPage.class);
                startActivity(startIntent);
            }
        });

        Button problemBtn = (Button)findViewById(R.id.problemBtn);
        problemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), ProblemSearch.class);
                startActivity(startIntent);
            }
        });

    }
}
