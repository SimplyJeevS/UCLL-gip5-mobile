package be.ucll.java.mobile.gip5_mobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

import be.ucll.java.mobile.gip5_mobile.models.Persoon;
import be.ucll.java.mobile.gip5_mobile.models.Wedstrijd;
import be.ucll.java.mobile.gip5_mobile.recyclerview.MatchAdapter;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private static final String TAG = "main activity";
    private static final String WEBSERVICE_API = "http://ucll-team3-gip5-web.eu-west-1.elasticbeanstalk.com";
    private List<Wedstrijd> wedstrijdList;
    private RequestQueue queue;

    String s1[], s2[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.RvMatches);
        s1 = getResources().getStringArray(R.array.match_mock_data_name);
        s2 = getResources().getStringArray(R.array.match_mock_data_date);

        MatchAdapter matchAdapter = new MatchAdapter(this,wedstrijdList );
        recyclerView.setAdapter(matchAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        queue = Volley.newRequestQueue(this);
//  STILL HAVE TO PUT THE DATA FROM THE REQUEST IN A LIST LOOK AT MOVIE
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, WEBSERVICE_API + "/rest/v1/wedstrijd", null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {

                        // display response on Success
                        Log.d("Response", response.toString());
                        Log.d(TAG, "entered respone");
                        JSONObject jsono = (JSONObject) response;

                        // Log the output as debug information
                        Log.d(TAG, jsono.toString());

                        // Convert REST String to Pojo's using GSON libraries
                        Persoon persoon = new Gson().fromJson(jsono.toString(), Persoon.class);
                        Log.d("Person to string: ", persoon.toString());
                        System.out.println(persoon.getApi());

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.toString());

                    }
                }
        );
        queue.start();
        queue.add(req);

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