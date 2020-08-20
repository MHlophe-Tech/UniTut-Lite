package mhlophetech.unitut.lite.MCQ;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mhlophetech.unitut.lite.R;

public class MCQScoreScreen extends AppCompatActivity {

    TextView lblSubject, lblScore;
    Button btnAnswerMore, btnChangeSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcqscore_screen);

        Intent myIntent = this.getIntent();

        final String strSubject = myIntent.getStringExtra("subject");
        String strScore = myIntent.getStringExtra("score");

        //get the references
        lblScore = findViewById(R.id.lblScoreMCQ);
        lblSubject = findViewById(R.id.lblSubjectMCQ);
        btnAnswerMore = findViewById(R.id.btnAnswerMoreMCQ);
        btnChangeSubject = findViewById(R.id.btnChangeSubjectMCQ);

        lblSubject.setText(strSubject);
        lblScore.setText(strScore);

        btnChangeSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeIntent = new Intent(MCQScoreScreen.this, HomeScreen.class);
                startActivity(changeIntent);
            }
        });

        btnAnswerMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizIntent = new Intent(MCQScoreScreen.this, QuestionScreen.class);
                quizIntent.putExtra("topic", strSubject);
                startActivity(quizIntent);
            }
        });
    }
}
