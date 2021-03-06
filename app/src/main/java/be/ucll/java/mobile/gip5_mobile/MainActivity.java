package be.ucll.java.mobile.gip5_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import be.ucll.java.mobile.gip5_mobile.recyclerview.MatchAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    //private static final String WEBSERVICE_API = "localhost:8180/gip5";

    String s1[], s2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RvMatches);
        s1 = getResources().getStringArray(R.array.match_mock_data_name);
        s2 = getResources().getStringArray(R.array.match_mock_data_date);

        MatchAdapter matchAdapter = new MatchAdapter(this, s1, s2);
        recyclerView.setAdapter(matchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent i = new Intent(this, SettingsActivity.class);
            startActivity(i);
            return true;
        } else if (id == R.id.action_website){
            // Replace with website url to front end ?
            Intent web = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ucll.be"));
            startActivity(web);
        }

        return super.onOptionsItemSelected(item);
    }
}