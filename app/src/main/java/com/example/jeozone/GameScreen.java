package com.example.jeozone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Button;

public class GameScreen extends AppCompatActivity {
    private Questions questions = new Questions("China"); //Of course this will change.
    public String answer;
    public int tries;
    public int points = 0;
    public int round = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen);
        resetGame();
    }

    public void resetGame() {
        //At the beginning of each game, the number of tries are reset, the round # increases, and new options are loaded.
        tries = 3;
        this.answer = questions.generate();
        setContentOfTextView(R.id.option1, questions.getCurrentPlace()[0]);
        setContentOfTextView(R.id.option2, questions.getCurrentPlace()[1]);
        setContentOfTextView(R.id.option3, questions.getCurrentPlace()[2]);
        setContentOfTextView(R.id.tries, "" + tries);
        setContentOfTextView(R.id.round, "" + round++);
        setMainImage(questions.getCurrentImage());
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setMainImage(int id) {
        View view = findViewById(R.id.mainImage);
        ImageView iv = (ImageView) view;
        iv.setImageDrawable(getResources().getDrawable(id));

    }

    public void onClick(View daButton) {
        String message; //Note that this will be moved to a popup window once implemented
        if (tries > 0) {
            Button pressed = findViewById(daButton.getId());
            if (pressed.getText().equals(answer)) {
                switch (tries) {
                    case 3:
                        points += 50;
                        message = "First try, what a Jeochamp!";
                        break;
                    case 2:
                        points += 25;
                        message = "Well done!";
                        break;
                    case 1:
                        points += 10;
                        message = "Well, it was the only one left, so here is your consolation prize.";
                        break;
                    default:
                        points += 0;
                        message = "That's all, folks.";
                }
                //Updates the points and congrats message:
                setContentOfTextView(R.id.points, "" + points);

                setContentOfTextView(R.id.message, message);
                //PopupWindow continue = new PopupWindow(View view); //If a popup window is being used, then it will be used here.
            }
            else {
               message = "GAME OVER";
               setContentOfTextView(R.id.message, message);
            }
            endOfRound();
        }
    }

    public void endOfRound() {
        if (round < 6) {
            resetGame();
        }
        else {
            //If the game is over, then a button sends you back to the home screen.
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    private void setContentOfTextView(int id, String result) {
        View view = findViewById(id);
        TextView tv = (TextView) view;
        tv.setText(result);
    }
}
