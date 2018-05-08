package com.novembergave.jokelibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

  private static final String CLASS = JokeActivity.class.getSimpleName();
  private static final String EXTRA_JOKE = CLASS + ".extra_joke";

  public static Intent launchActivity(Context context, String joke) {
    Intent intent = new Intent(context, JokeActivity.class);
    intent.putExtra(EXTRA_JOKE, joke);
    return intent;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke);

    // get joke from intent and set it in the TextView
    String joke = getIntent().getStringExtra(EXTRA_JOKE);
    ((TextView) findViewById(R.id.text_view)).setText(joke);
  }
}
