package thelawsofphysics.physicsapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class EquationsScreen extends AppCompatActivity {

    ListView listView;
    String[] mechanicsEquations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equations_screen);

        Resources res = getResources();
        listView = (ListView) findViewById(R.id.listView);
        mechanicsEquations = res.getStringArray(R.array.mechanicsEquations);

        EquationAdapter equationsAdapter = new EquationAdapter(this, mechanicsEquations);
        listView.setAdapter(equationsAdapter);
    }
}
