package com.example.androidlaba2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        //searching button
        Button button = findViewById(R.id.confirm);

        // find all switch bottons
        Switch switch1 = findViewById(R.id.switch1);
        Switch switch2 = findViewById(R.id.switch2);
        Switch switch3 = findViewById(R.id.switch3);
        Switch switch4 = findViewById(R.id.switch4);
        Switch switch5 = findViewById(R.id.switch5);

        button.setOnClickListener(v -> {

            int generator = 0;


            // calculate all scores
            if(switch1.isChecked()) {
                generator = generator + 1;
            }

            if(switch2.isChecked()) {
                generator = generator + 2;
            }

            if(switch3.isChecked()) {
                generator = generator + 3;
            }

            if(switch4.isChecked()) {
                generator = generator + 4;
            }

            if(switch5.isChecked()) {
                generator = generator + 5;
            }

            // create empty intent
            Intent intent = new Intent();
            // adding data to intent
            intent.putExtra("result", generateBook(generator));

            // choose result
            setResult(RESULT_OK, intent);

            // close Activity
            finish();
        });
    }
    // method for generates a book choice
    private String generateBook(int generator) {
        return generator < 3 ? "Код Да Винчи" : generator < 6 ? "Букварь" : generator < 9 ? "Колобок" :
                generator < 13 ? "Кулинарная энциклопедия" : "Библия";
    }

    // method when user press back button
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
