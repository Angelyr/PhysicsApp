package thelawsofphysics.physicsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Favorite extends AppCompatActivity {
    ArrayList<String> favlist = new ArrayList<>();
    String[] list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        //when favorite equations button is clicked display all favorite equations
        Button favoriteEBtn = (Button)findViewById(R.id.FavoriteEBtn);
        favoriteEBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favlist.clear();
                try {
                    String message;
                    FileInputStream inputStream = openFileInput("Favorites");
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    while ((message=bufferedReader.readLine())!=null)
                    {
                        favlist.add(message);
                    }

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


                Intent startIntent = new Intent(getApplicationContext(), List.class);
                list =  favlist.toArray(new String[favlist.size()]);

                startIntent.putExtra("display",list);
                startActivity(startIntent);
            }
        });

        //when remove all favorites button is clicked, all favorites is removed
        Button favoriteRBtn = (Button)findViewById(R.id.FavoriteRBtn);
        favoriteRBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String equationWrite = "";
                String fname = "Favorites";
                try{
                    FileOutputStream outputStream = openFileOutput(fname,MODE_PRIVATE);
                    outputStream.write(equationWrite.getBytes());
                    outputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
