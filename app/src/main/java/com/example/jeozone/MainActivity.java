package com.example.jeozone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button button;
private Button toGameSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.instructionsButton);
        toGameSelection = (Button) findViewById(R.id.playButton);

        button.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
               openInstuctions();
           }
        });
        toGameSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameSelection();
            }
        });
    }

    public void openInstuctions(){
        Intent intent = new Intent(this, InstructionsPage.class);
        startActivity(intent);
    }

    public void openGameSelection(){
        Intent intent = new Intent(this, GameSelectScreen.class);
        startActivity(intent);
    }
}