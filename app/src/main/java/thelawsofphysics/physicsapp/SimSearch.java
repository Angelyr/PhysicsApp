package thelawsofphysics.physicsapp;

import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class SimSearch extends AppCompatActivity {
    private EditText filterText;

    private MAdapter<String> listAdapter;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_similar);
        /*EditText title = (EditText) findViewById(R.id.eqnText);
        if(getIntent().hasExtra("equation")) {
            String equation = getIntent().getExtras().getString("equation");
            title.setText(equation);
        }*/
        filterText = (EditText)findViewById(R.id.eqnText);

        ListView itemList = (ListView)findViewById(R.id.simSearch);
        //Contains the array of equations
        Resources res = getResources();
        String [] listViewAdapterContent = res.getStringArray(R.array.equations);
        //Contains array of strings with variables
        String [] variablefilter = res.getStringArray(R.array.equations_variables);
        listAdapter = new MAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listViewAdapterContent, variablefilter, "similar");

        itemList.setAdapter(listAdapter);
        //SimSearch.this.listAdapter.getFilter().filter(getIntent().getExtras().getString("equation"));
        itemList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // make Toast when click
                Toast.makeText(getApplicationContext(), "Position " + position, Toast.LENGTH_LONG).show();
            }
        });
        filterText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                SimSearch.this.listAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        if(getIntent().hasExtra("equation")) {
            Bundle extras = getIntent().getExtras();
            if(extras != null)
            {
                String input = extras.getString("equation");
                filterText.setText(input);
                //SimSearch.this.listAdapter.getFilter().filter(input);
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }
}


