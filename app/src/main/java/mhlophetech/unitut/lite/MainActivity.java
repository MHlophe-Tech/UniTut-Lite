package mhlophetech.unitut.lite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import mhlophetech.unitut.lite.MCQ.HomeScreen;

public class MainActivity extends AppCompatActivity {
    Button btnGoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGoto = findViewById(R.id.btnGoto);




        btnGoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MCQ = new Intent(MainActivity.this, HomeScreen.class);

                startActivity(MCQ);
            }
        });


    }
}
