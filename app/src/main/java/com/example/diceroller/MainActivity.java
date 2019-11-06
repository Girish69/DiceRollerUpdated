package com.example.diceroller;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int Number = 0;
    TextView results;
    TextView Counter;
    EditText UserInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        UserInput = findViewById(R.id.UserInput);
        results = this.findViewById(R.id.CounterView);
        Counter = this.findViewById(R.id.Counter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void on_button_click(View view) {
        TextView results = this.findViewById(R.id.CounterView);
        TextView tv = this.findViewById(R.id.button);
        Random r = new Random();
        int number = r.nextInt(6) + 1;
        tv.setText(Integer.toString(number));
        int n = Integer.parseInt(UserInput.getText().toString());
        try {
            if (n < 1 || n > 6) {
                    Toast.makeText(this,"This is invalid input, Please ensure the number is between 1 and 6!", Toast.LENGTH_SHORT).show();
                } else if (n == number) {
                Toast.makeText(this, "Congratulations!", Toast.LENGTH_SHORT).show();
                Number = Number + 1;
                results.setText(Integer.toString(Number));
            }

            }catch (Exception e) {
                Log.e("Error", e.toString());
            }
    }
    public void dicebreaker(View view) {
            TextView Questions = this.findViewById(R.id.Questions);
            String question1 = "If you could go anywhere in the world, where would you go?";
            String question2 = "If you were stranded on a desert island, what three things would you want to take with you?";
            String question3 = "If you could eat only one food for the rest of your life, what would that be?";
            String question4 = "If you won a million dollars, what is the first thing you would buy?";
            String question5 = "If you could spend the day with one fictional character, who would it be?";
            String question6 = "If you found a magic lantern and a genie gave you three wishes, what would you wish?";

            Random rand = new Random();
            int RandQuestions = rand.nextInt((6-1)+1)+1;
            switch (RandQuestions) {
                case 1:
                    Questions.setText(question1);
                    break;
                case 2:
                    Questions.setText(question2);
                    break;
                case 3:
                    Questions.setText(question3);
                    break;
                case 4:
                    Questions.setText(question4);
                    break;
                case 5:
                    Questions.setText(question5);
                    break;
                case 6:
                    Questions.setText(question6);
                    break;
                default:
                    Questions.setText("");
                    break;
            }

    }
}