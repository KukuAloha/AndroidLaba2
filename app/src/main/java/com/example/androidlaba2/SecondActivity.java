package com.example.androidlaba2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.appcompat.app.AppCompatActivity;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        // search checkboxes for menu items
        Button button = findViewById(R.id.confirm);

        RatingBar ratingBar1 = findViewById(R.id.rate1);

        RatingBar ratingBar2 = findViewById(R.id.rate2);


        button.setOnClickListener(v -> {
            // getting chosen rates stars
            String generalRate = String.valueOf( (ratingBar1.getRating() + ratingBar2.getRating())/2);

            // empty intent
            Intent intent = new Intent();
            // addind date to intent
            intent.putExtra("result", generalRate);

            // getting result
            setResult(RESULT_OK, intent);

            // closing Activity
            finish();
        });
    }

    // method when user click back
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        setResult(RESULT_CANCELED);
    }
}
