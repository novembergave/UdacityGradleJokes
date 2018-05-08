package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

  @Test
  public void asyncTaskAlwaysReturnsExpectedJoke() {
    EndpointsAsyncTask.OnTaskCompleted taskCompleted = joke -> {
      assertNotNull(joke);
      assertEquals("This is totally a funny joke", joke);
    };
    // Execute task
    EndpointsAsyncTask movieTask = new EndpointsAsyncTask(taskCompleted);
    movieTask.execute();
  }

}