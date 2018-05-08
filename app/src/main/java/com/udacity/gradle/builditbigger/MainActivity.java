package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.novembergave.jokelibrary.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.loading);
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

    public void tellJoke(View view) {
        // display loading
        progressBar.setVisibility(View.VISIBLE);

        EndpointsAsyncTask.OnTaskCompleted taskCompleted = this::displayJoke;
        // Execute task
        EndpointsAsyncTask movieTask = new EndpointsAsyncTask(taskCompleted);
        movieTask.execute();
    }

    private void displayJoke(String joke) {
        // hide loading
        progressBar.setVisibility(View.GONE);

        // start activity from Android library
        startActivity(JokeActivity.launchActivity(this, joke));
    }

}
