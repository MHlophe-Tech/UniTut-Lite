package mhlophetech.unitut.lite.MCQ;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import mhlophetech.unitut.lite.R;

public class QuestionScreen extends AppCompatActivity {

    TextView txtTopic, txtScore, txtTime, txtQuestion;
    Button btnOption1, btnOption2, btnOption3, btnOption4, btnNext;
    ProgressBar progressBar;

    Question myQuestion = new Question();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_screen);



        Intent myIntent = this.getIntent();
       String topic = myIntent.getStringExtra("topic");


       //reference the views
       txtScore = findViewById(R.id.txtScore);
       txtTime = findViewById(R.id.txtTime);
       txtTopic = findViewById(R.id.txtTopic);
       txtQuestion = findViewById(R.id.txtQuestionMCQ);
       btnOption1 = findViewById(R.id.btnOption1MCQ);
        btnOption2 = findViewById(R.id.btnOption2MCQ);
        btnOption3 = findViewById(R.id.btnOption3MCQ);
        btnOption4 = findViewById(R.id.btnOption4MCQ);
        btnNext = findViewById(R.id.btnNextMCQ);
        progressBar = findViewById(R.id.progressBar);


        //set defaults
       txtTopic.setText(topic);
       btnOption1.setText("yes");
       btnOption2.setText("no, I'm very ready :)");
       btnOption3.setText("I guess I am");
       btnOption4.setText("Let's start already");

        final CountDownTimer timer = new CountDownTimer(30000, 1000) {
          
            @Override
            public void onTick(long l) {
                myQuestion.time--;
                txtTime.setText(myQuestion.time +"s");
                progressBar.setProgress(30-myQuestion.time);
            }

            @Override
            public void onFinish() {

            }
        };

       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               HashMap nq = myQuestion.getNext();
               txtQuestion.setText(nq.get("question").toString());
               timer.start();
           }
       });


    }


}
