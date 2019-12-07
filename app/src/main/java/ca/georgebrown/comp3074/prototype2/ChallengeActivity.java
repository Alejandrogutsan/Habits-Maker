package ca.georgebrown.comp3074.prototype2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ChallengeActivity extends AppCompatActivity {

    protected Button btnShare;
    ImageButton home;
    ImageButton profile;
    ImageButton goals;
    ImageButton challenge;
    ImageButton settings;
    CheckBox habit1;
    CheckBox habit2;
    CheckBox habit3;
    EditText msg;
    String toShare = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);

        home= (ImageButton) findViewById(R.id.imageButtonHome);
        profile=(ImageButton) findViewById(R.id.imageButtonProfile);
        goals =(ImageButton) findViewById(R.id.imageButtonGoals);
        challenge=(ImageButton) findViewById(R.id.imageButtonChallenge);
        settings=(ImageButton) findViewById(R.id.imageButtonSettings);
        btnShare = findViewById(R.id.btnShare);
        habit1 = findViewById(R.id.cbHabit1);
        habit2 = findViewById(R.id.cbHabit2);
        habit3 = findViewById(R.id.cbHabit3);
        msg = findViewById(R.id.etMessage);

        btnShare.setOnClickListener(new View.OnClickListener() {
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

    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch(view.getId()) {
            case R.id.cbHabit1:
                if (checked){
                    toShare.concat('"' + habit1.getText().toString() + '"'+"\n");
                }
                else

                break;
            case R.id.cbHabit2:
                if (checked){
                    toShare.concat('"' + habit2.getText().toString() + '"'+"\n");
                }
                else

                break;
            case R.id.cbHabit3:
                if (checked){
                    toShare.concat('"' + habit3.getText().toString() + '"'+"\n");
                }
                else

                break;
            default:
                toShare = msg.getText().toString() + toShare;
        }
    }
}
