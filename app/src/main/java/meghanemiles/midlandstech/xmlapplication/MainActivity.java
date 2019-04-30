package meghanemiles.midlandstech.xmlapplication;


import android.content.Entity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String URL
            = "https://www.cnet.com/rss/android-update/";
    private ListView listView;
    private String userName;
    private String continent;
    ParseTask parseTask;


    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        listView = findViewById( R.id.listView );
        ParseTask task = new ParseTask( this );
        task.execute( URL );
    }

    public void displayList( ArrayList<Countries> country ) {

        if( country != null ) {
            // Build ArrayList of names to display
            ArrayList<String> names = new ArrayList<>( );
            for( Countries countries : country )
                names.add(countries.getName());

            ArrayAdapter<String> adapter = new ArrayAdapter<>( this,
                    android.R.layout.simple_list_item_1, names );
            listView.setAdapter( adapter );

        } else
            Toast.makeText( this, "Sorry - No data found",
                    Toast.LENGTH_LONG ).show( );
    }
    public void btnLoginClicked(View view){
        userName = "IST235message";
        TextView c = findViewById(R.id.continent);
        continent = c.getText().toString();
        parseTask = new ParseTask(this);


    }

}

