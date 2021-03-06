package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

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

        //Opens file to store recent equations
        try
        {
            FileOutputStream file = openFileOutput("Recent", MODE_APPEND);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Stores equation in recently used equations file if it is not already there
        try {
            //Reads in equations from file
            ArrayList<String> equations = new ArrayList<>();
            String aEquation;
            FileInputStream inputStream = openFileInput("Recent");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((aEquation = bufferedReader.readLine())!=null)
            {
                equations.add(aEquation);
            }
            //Makes sure equation is not in file
            if(!equations.contains(substituteEquation.getText().toString()))
            {
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput("Recent", MODE_APPEND);
                    aEquation = substituteEquation.getText().toString() + "\n";
                    outputStream.write(aEquation.getBytes());
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Makes sure there are only 10 strings in file
        try {
            //Reads in strings from file
            ArrayList<String> equations = new ArrayList<>();
            String aEquation;
            FileInputStream inputStream = openFileInput("Recent");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while ((aEquation = bufferedReader.readLine())!=null)
            {
                equations.add(aEquation);
            }

            //If there are more than 10 equations deletes the rest
            if(equations.size() > 10)
            {
                //deletes old file
                FileOutputStream outputStream;
                try {
                    outputStream = openFileOutput("Recent", MODE_PRIVATE);
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                //populate new file
                try {
                    outputStream = openFileOutput("Recent", MODE_APPEND);
                    for(int i = equations.size()-10; i < equations.size(); i++)
                    {
                        aEquation = equations.get(i) + "\n";
                        outputStream.write(aEquation.getBytes());
                    }
                    outputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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
                EditText result = (EditText)findViewById(R.id.favoriteResult);
                result.setText("");
                String equationWrite = substituteEquation.getText().toString() + "\n";

                // find if the equation is already added into the favorites
                ArrayList<String> flist = new ArrayList<>();
                try {
                    String message;
                    FileInputStream inputStream = openFileInput("Favorites");
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while ((message=bufferedReader.readLine())!=null)
                    {
                        flist.add(message);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (flist.contains(substituteEquation.getText().toString())) {
                    result.setText("Equation Already Added");
                }
                // add the equation to favorites
                else {
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
                    result.setText("Added To Favorites");
                    Intent startIntent = new Intent(getApplicationContext(), Favorite.class);
                    startActivity(startIntent);
                }
            }
        });

        //Goes to list of similar equations
        Button simBtn = (Button)findViewById(R.id.simBtn);
        simBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), SimSearch.class);
                startIntent.putExtra("equation", substituteEquation.getText().toString());
                startActivity(startIntent);
            }
        });
    }
}