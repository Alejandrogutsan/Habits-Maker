package ca.georgebrown.comp3074.prototype2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    public DatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        handler = new DatabaseHandler(this, DatabaseHandler.DATABASE_NAME, null, DatabaseHandler.DATABASE_VERSION);
        final TextView habitName = findViewById(R.id.habit_name);
        final TextView dayNum = findViewById(R.id.day_num);
        Button btnDelete = findViewById(R.id.btnDelete);
        Button btnUpdate = findViewById(R.id.btnUpdate);
        final CheckBox checkBoxDone = findViewById(R.id.cb_done);
        final ProgressBar progressBar = findViewById(R.id.progressBar);

        dayNum.setText("DAY " + getIntent().getStringExtra("day_count"));
        habitName.setText(getIntent().getStringExtra("name"));

        progressBar.setMax(22);
        progressBar.setProgress(Integer.parseInt(getIntent().getStringExtra("day_count")));

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = habitName.getText().toString();
                handler.delete_habit(name);
                Intent i = new Intent();
                ((Activity) v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = getIntent().getStringExtra("name");
                int count = Integer.parseInt(getIntent().getStringExtra("day_count"));
                if (checkBoxDone.isChecked()) {

                    if (count < 22) {
                        count = count + 1;
                    }

                    progressBar.setProgress(count);
                }
                handler.update_habit(name, count);
                Intent i = new Intent();
                ((Activity) v.getContext()).setResult(Activity.RESULT_OK, i);
                finish();
            }
        });
    }


}
