package mhlophetech.unitut.lite.MCQ;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import mhlophetech.unitut.lite.R;


public class HomeScreen extends AppCompatActivity {

    Button btnMaths, btnPhysics, btnGeography, btnMathsLit, btnDemo;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq__home_screen);

        //instantiate buttons
        btnGeography = findViewById(R.id.btnGeography);
        btnMaths =  findViewById(R.id.btnMaths);
        btnPhysics = findViewById(R.id.btnPhysics);
        btnMathsLit = findViewById(R.id.btnMathsLit);
        btnDemo = findViewById(R.id.btnDemo);

        btnDemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoSreen("Demo");
            }
        });

    }

    private void gotoSreen(String strTopic){
        Intent Home = new Intent(HomeScreen.this, QuestionScreen.class);
        Home.putExtra("topic", strTopic);
        startActivity(Home);
    }
}
