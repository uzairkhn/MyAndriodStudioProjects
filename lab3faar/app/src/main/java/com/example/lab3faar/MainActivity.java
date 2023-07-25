package com.example.lab3faar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    int scoreTeamA = 0;
    int wicketsTeamA = 0;
    int scoreTeamB = 0;
    int wicketsTeamB = 0;

    private View decorView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeScoreTeamA(View view) {
        scoreTeamA++;
        displayScoreTeamA(scoreTeamA);
    }

    public void changeWicketsTeamA(View view) {
        wicketsTeamA++;
        displayWicketsTeamA(wicketsTeamA);
    }

    public void resetTeamA(View view) {
        scoreTeamA = 0;
        wicketsTeamA = 0;
        displayScoreTeamA(scoreTeamA);
        displayWicketsTeamA(wicketsTeamA);
    }

    public void changeScoreTeamB(View view) {
        scoreTeamB++;
        displayScoreTeamB(scoreTeamB);
    }

    public void changeWicketsTeamB(View view) {
        wicketsTeamB++;
        displayWicketsTeamB(wicketsTeamB);
    }

    public void resetTeamB(View view) {
        scoreTeamB = 0;
        wicketsTeamB = 0;
        displayScoreTeamB(scoreTeamB);
        displayWicketsTeamB(wicketsTeamB);
    }

    public void wholeReset(View view) {
        scoreTeamA = 0;
        wicketsTeamA = 0;
        scoreTeamB = 0;
        wicketsTeamB = 0;
        displayScoreTeamA(scoreTeamA);
        displayWicketsTeamA(wicketsTeamA);
        displayScoreTeamB(scoreTeamB);
        displayWicketsTeamB(wicketsTeamB);
    }


    private void displayScoreTeamA(int scoreTeamA) {
        if (wicketsTeamA < 11) {
            TextView score = findViewById(R.id.idScoreTeamA);
            score.setText("" + scoreTeamA);
        } else
            Toast.makeText(this, "Team A lost all wickets Innings Ended", Toast.LENGTH_SHORT).show();
    }

    private void displayScoreTeamB(int scoreTeamB) {
        if (wicketsTeamB < 11) {
            TextView score = findViewById(R.id.idScoreTeamB);
            score.setText("" + scoreTeamB);
        } else
            Toast.makeText(this, "Team B lost all wickets Innings Ended", Toast.LENGTH_SHORT).show();
    }

    private void displayWicketsTeamA(int wicketsTeamA) {
        if (wicketsTeamA < 11) {
            TextView wickets = findViewById(R.id.idWicketsTeamA);
            wickets.setText("" + wicketsTeamA);
        } else
            Toast.makeText(this, "Team A lost all wickets Innings Ended", Toast.LENGTH_SHORT).show();
    }

    private void displayWicketsTeamB(int wicketsTeamB) {
        if (wicketsTeamB < 11) {
            TextView wickets = findViewById(R.id.idWicketsTeamB);
            wickets.setText("" + wicketsTeamB);
        } else
            Toast.makeText(this, "Team B lost all wickets Innings Ended", Toast.LENGTH_SHORT).show();
    }

}



