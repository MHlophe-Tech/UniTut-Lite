package mhlophetech.unitut.lite.MCQ;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import mhlophetech.unitut.lite.Model.QuestionModel;
import mhlophetech.unitut.lite.R;

public class QuestionScreen extends AppCompatActivity {

    TextView txtTopic, txtScore, txtTime, txtQuestion;
    Button btnOption1, btnOption2, btnOption3, btnOption4, btnNext;
    ProgressBar progressBar;

    CountDownTimer timer = null;

    final static String TAG = "QuestionScreen";

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


        btnOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.callOnClick();
            }
        });

        btnOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.callOnClick();
            }
        });

        btnOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.callOnClick();
            }
        });

        btnOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnNext.callOnClick();
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                setAnswers();
                changeActive(true);
                timer.start();


            }
        });


    }

    private void highlightCorrectAnswer() {

        int intRight = getResources().getColor(R.color.btnCorrectAnswerColor);
        for (int i = 0; i < 4; i++) {
            boolean boolAnswer = (boolean) myQuestion.questionList
                    .get(myQuestion.count - 1).optionList
                    .get(i).get("isCorrect");

            if (boolAnswer) {
                switch (i) {
                    case 0:
                        btnOption1.setTextColor(intRight);
                        break;
                    case 1:
                        btnOption2.setTextColor(intRight);
                        break;
                    case 2:
                        btnOption3.setTextColor(intRight);
                        break;
                    case 3:
                        btnOption4.setTextColor(intRight);
                }
            }
        }
    }

    private void answerClicked(int intAnswer) {
        int intWrong = getResources().getColor(R.color.btnWrongColor);
        int intRight = getResources().getColor(R.color.btnCorrectAnswerColor);
        boolean boolAnswer = (boolean) myQuestion.questionList
                .get(myQuestion.count - 1).optionList
                .get(intAnswer - 1).get("isCorrect");


        changeActive(false);
        //stop the timer
        timer.cancel();
        // show the correct answer
        highlightCorrectAnswer();



        //what the user chose
        switch (intAnswer) {
            case 1:
                if (boolAnswer) {
                    btnOption1.setTextColor(intRight);
                    myQuestion.correct();
                    Log.d(TAG, "answerClicked: 1");
                } else {
                    Log.d(TAG, "answerClicked: wrong answer");

                    btnOption1.setTextColor(intWrong);

                }
                break;
            case 2:
                if (boolAnswer) {
                    btnOption2.setTextColor(intRight);
                    myQuestion.correct();
                    Log.d(TAG, "answerClicked: 2");
                } else {
                    Log.d(TAG, "answerClicked: wrong answer");
                    btnOption2.setTextColor(intWrong);

                }
                break;

            case 3:
                if (boolAnswer) {
                    btnOption3.setTextColor(intRight);
                    myQuestion.correct();
                    Log.d(TAG, "answerClicked: 3");
                } else {
                    Log.d(TAG, "answerClicked: wrong answer");
                    btnOption3.setTextColor(intWrong);
                }
                break;

            case 4:
                if (boolAnswer) {
                    Log.d(TAG, "answerClicked: 4");
                    btnOption4.setTextColor(intRight);
                    myQuestion.correct();
                } else {
                    btnOption4.setTextColor(intWrong);
                    Log.d(TAG, "answerClicked: wrong answer");
                }
                break;
        }
    }

    private void setDefaultColors() {
        int intRight = getResources().getColor(R.color.btnDefaultColor);
        btnOption1.setTextColor(intRight);
        btnOption2.setTextColor(intRight);
        btnOption3.setTextColor(intRight);
        btnOption4.setTextColor(intRight);
    }

    private void setAnswers() {


        txtScore.setText(myQuestion.getScore() + "/" + myQuestion.questionList.size());

        if (myQuestion.count < myQuestion.questionList.size()) {
            QuestionModel quiz = myQuestion.getQuestion();

            setDefaultColors();
            txtQuestion.setText(quiz.question);
            btnOption1.setText(quiz.optionList.get(0).get("answer").toString());
            btnOption2.setText(quiz.optionList.get(1).get("answer").toString());
            btnOption3.setText(quiz.optionList.get(2).get("answer").toString());
            btnOption4.setText(quiz.optionList.get(3).get("answer").toString());

            timer = new CountDownTimer(myQuestion.time * 1000, 1000) {

                int totalTime = myQuestion.time;

                @Override
                public void onTick(long l) {

                    myQuestion.time--;

                    int remTime = 100 - (100 / totalTime) * myQuestion.time;

                    txtTime.setText(myQuestion.time + "s");
                    progressBar.setProgress(remTime);
                }

                @Override
                public void onFinish() {

                    changeActive(false);
                    highlightCorrectAnswer();
                    progressBar.setProgress(100);

                }
            };

            btnOption1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answerClicked(1);
                }
            });

            btnOption2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answerClicked(2);
                }
            });

            btnOption3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answerClicked(3);
                }
            });

            btnOption4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    answerClicked(4);
                }
            });
        } else {
            btnNext.setText("check score");


            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent scoreIntent = new Intent(QuestionScreen.this, MCQScoreScreen.class);
                    scoreIntent.putExtra("subject", txtTopic.getText());
                    scoreIntent.putExtra("score", txtScore.getText());

                    startActivity(scoreIntent);
                }
            });

            btnNext.callOnClick();
        }

    }

    private void changeActive(boolean isActive) {

        btnOption1.setEnabled(isActive);
        btnOption2.setEnabled(isActive);
        btnOption3.setEnabled(isActive);
        btnOption4.setEnabled(isActive);
        btnNext.setEnabled(!isActive);
    }

}
