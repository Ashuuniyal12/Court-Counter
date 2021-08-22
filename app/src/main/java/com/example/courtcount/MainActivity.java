package com.example.courtcount;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int scoreA = 0;
    int scoreB = 0;
    EditText teamAName;
    String NameOfTeamA;
    EditText teamBName;
    String NameOfTeamB;
    TextView showResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView =findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePoint(View view) {
        scoreA = scoreA + 3;
        displayForTeamA(scoreA);
    }

    public void twoPoint(View view) {
        scoreA = scoreA + 2;
        displayForTeamA(scoreA);
    }

    public void freePoint(View view) {
        scoreA = scoreA + 1;
        displayForTeamA(scoreA);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointB(View view) {
        scoreB = scoreB + 3;
        displayForTeamB(scoreB);
    }

    public void twoPointB(View view) {
        scoreB = scoreB + 2;
        displayForTeamB(scoreB);
    }

    public void freePointB(View view) {
        scoreB = scoreB + 1;
        displayForTeamB(scoreB);
        //reset everything
    }

    public void resetScore(View view) {
        scoreA = 0;
        scoreB = 0;
        teamAName.setText(" ");
        teamBName.setText(" ");
        showResult.setText(" ");
        displayForTeamA(scoreA);
        displayForTeamB(scoreB);
    }

    // Take input from the  team a and team b name fields
    public void result(View viwe) {
        teamAName = findViewById(R.id.team_A_name);
        NameOfTeamA = teamAName.getText().toString();

        teamBName = findViewById(R.id.team_B_name);
        NameOfTeamB = teamBName.getText().toString();
            if (scoreA > scoreB) {
                displayResultForA(NameOfTeamA);
            } else if (scoreB > scoreA) {
                displayResultForB(NameOfTeamB);
            } else {
                TextView showResult = findViewById(R.id.result_show);
                showResult.setText("MATCH DRAW");
            }
    }

    // Display the result for a team
    public void displayResultForA(String NameOfTeamA) {
        TextView showResult = findViewById(R.id.result_show);
        String message = NameOfTeamA + " won by " + (scoreA - scoreB) + " points";
        showResult.setText(message);
    }

    // Display the result for b team
    public void displayResultForB(String NameOfTeamB) {
        showResult =findViewById(R.id.result_show);
        String message = NameOfTeamB + " won by " + (scoreB - scoreA) + " points";
        showResult.setText(message);
    }
}