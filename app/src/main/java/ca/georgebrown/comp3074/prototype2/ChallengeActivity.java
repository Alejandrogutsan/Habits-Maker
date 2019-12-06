package ca.georgebrown.comp3074.prototype2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChallengeActivity extends AppCompatActivity {

    protected Button btnContact;
    ImageButton home;
    ImageButton profile;
    ImageButton goals;
    ImageButton challenge;
    ImageButton settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        home= (ImageButton) findViewById(R.id.imageButtonHome);
        profile=(ImageButton) findViewById(R.id.imageButtonProfile);
        goals =(ImageButton) findViewById(R.id.imageButtonGoals);
        challenge=(ImageButton) findViewById(R.id.imageButtonChallenge);
        settings=(ImageButton) findViewById(R.id.imageButtonSettings);
        btnContact = findViewById(R.id.btnContact);

        btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(),ContactListActivity.class);
                startActivity(i);
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProfilePage.class);
                startActivity(intent);
            }
        });

        goals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GoalsActivity.class);
                startActivity(intent);
            }
        });

        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Settings.class);
                startActivity(intent);
            }
        });
    }
}
