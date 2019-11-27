package ca.georgebrown.comp3074.prototype2;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class GoalsActivity extends AppCompatActivity {

    protected ProgressBar pb1,pb2,pb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goals);

        GoalFragment newGoalFragment = new GoalFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container2,newGoalFragment).commit();
    }
}
