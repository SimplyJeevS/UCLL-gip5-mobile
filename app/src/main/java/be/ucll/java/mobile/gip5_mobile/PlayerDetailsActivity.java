package be.ucll.java.mobile.gip5_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONObject;

import be.ucll.java.mobile.gip5_mobile.models.Persoon;
import be.ucll.java.mobile.gip5_mobile.models.Wedstrijd;

public class PlayerDetailsActivity extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {
    private static final String TAG = "PlayerDetaials activity";
    private static final String WEBSERVICE_API = "http://ucll-team3-gip5-web.eu-west-1.elasticbeanstalk.com";
    private RequestQueue queue;
    private SharedPreferences preferences;
    private TextView matchName, matchDate, matchLocation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details);

        matchName = findViewById(R.id.lblDtMatchName);
        matchDate = findViewById(R.id.lblDtMatchTime);
        matchLocation = findViewById(R.id.lblDtMatchLocation);

        preferences = getSharedPreferences("PREFERENCE", 0);

        queue = Volley.newRequestQueue(this);
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, WEBSERVICE_API + "/rest/v1/wedstrijdMetPloegen/100?api=" + preferences.getString("ApiPref","Undefined") , null, this, this);

        queue.start();
        queue.add(req);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.d("Error.Response", error.toString());
    }

    @Override
    public void onResponse(JSONObject response) {
        // display response on Success
        Log.d("Response", response.toString());
        Log.d(TAG, "entered respone");
        JSONObject jsono = (JSONObject) response;

        // Log the output as debug information
        Log.d(TAG, jsono.toString());

        // Convert REST String to Pojo's using GSON libraries
        Wedstrijd wedstrijd = new Gson().fromJson(jsono.toString(), Wedstrijd.class);
        Log.d("Person to string: ", wedstrijd.toString());

        matchName.setText(wedstrijd.getThuisploeg() +" \uD83C\uDD9A "+wedstrijd.getTegenstander());
        matchDate.setText(wedstrijd.getTijdstip());
        matchLocation.setText(wedstrijd.getLocatie());
    }
}