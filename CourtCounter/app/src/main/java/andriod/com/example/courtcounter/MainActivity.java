package andriod.com.example.courtcounter;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int scoreForTeamA = 0;
    int scoreForTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayForTeamA(int scoreForTeamA) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_scoreForTeamA);
        scoreView.setText(String.valueOf(scoreForTeamA));
    }

    public void displayForTeamB(int scoreForTeamB) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_scoreForTeamB);
        scoreView.setText(String.valueOf(scoreForTeamB));
    }

    public void Add3(View view) {

        scoreForTeamA = scoreForTeamA + 3;
        displayForTeamA(scoreForTeamA);
    }

    public void Add2(View view) {
        scoreForTeamA = scoreForTeamA + 2;
        displayForTeamA(scoreForTeamA);
    }

    public void FreeThrow(View view) {
        scoreForTeamA = scoreForTeamA + 1;
        displayForTeamA(scoreForTeamA);
    }

    public void Add22teamB(View view) {
        scoreForTeamB = scoreForTeamB + 2;
        displayForTeamB(scoreForTeamB);
    }

    public void Add3toteamB(View view) {
        scoreForTeamB = scoreForTeamB + 3;
        displayForTeamB(scoreForTeamB);
    }

    public void FreeThrow2teamB(View view) {
        scoreForTeamB = scoreForTeamB + 1;
        displayForTeamB(scoreForTeamB);
    }

    public void Reset(View view) {
        int scoreForTeamA = 0;
        int scoreForTeamB = 0;
        displayForTeamB(scoreForTeamB);
        displayForTeamA(scoreForTeamA);
    }
}
