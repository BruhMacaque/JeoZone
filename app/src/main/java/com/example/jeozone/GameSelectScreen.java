package com.example.jeozone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameSelectScreen extends AppCompatActivity {
    private Button returnToMenu;
    private int e = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select_screen);

        returnToMenu = (Button) findViewById(R.id.backButton);
        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMainMenu();
            }
        });
    }
    public void openMainMenu(){
        Intent intent = new Intent(this, MainActivity.class);
        e += 1;
        //startActivity(intent);
    }
}