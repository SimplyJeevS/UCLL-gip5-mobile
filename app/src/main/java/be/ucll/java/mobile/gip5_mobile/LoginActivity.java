package be.ucll.java.mobile.gip5_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "login activity";

    TextView usernameField;
    TextView passwordField;
    Button loginButton;
    String hasLoggedIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("PREFERENCE", 0);

        hasLoggedIn = preferences.getString("UsernamePref","Undefined");


        Log.d(TAG,  "hasLoggedIn is " + hasLoggedIn);

        if (!hasLoggedIn.equals("Undefined")) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }

        usernameField = findViewById(R.id.fldName);
        passwordField = findViewById(R.id.fldPassword);
        loginButton = findViewById(R.id.btnLogin);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d(TAG, "Button has been clicked " +  "UserString is " + usernameField.getText().toString());

                // Set preference to has logged in before.

                SharedPreferences.Editor editor = preferences.edit();
                // move this to the login click handler later
                editor.putString("UsernamePref", usernameField.getText().toString());
                editor.apply();
                hasLoggedIn = preferences.getString("UsernamePref", "Undefined");


                Log.d(TAG, "Preference has been changed");
                // switching activity and checking if there has been logged in before
                if (!hasLoggedIn.equals("Undefined"))
                {
                    Log.d(TAG, "hasLoggedIn in if statement is " + hasLoggedIn);
                    Log.d(TAG, "usernameString in if statement is " + usernameField.getText().toString());
                    Log.d(TAG, "UsernamePref has been entered");
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

}