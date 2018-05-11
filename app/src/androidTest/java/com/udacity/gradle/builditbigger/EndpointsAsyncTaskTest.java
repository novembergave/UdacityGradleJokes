package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

  @Test
  public void asyncTaskAlwaysReturnsExpectedJokeWhenBackEndIsConnected() throws InterruptedException {
    final CountDownLatch signal = new CountDownLatch(1);
    EndpointsAsyncTask.OnTaskCompleted taskCompleted = joke -> {
      assertNotNull(joke);
      assertEquals("This is totally a funny joke", joke);
      signal.countDown();// notify the count down latch
    };

    EndpointsAsyncTask movieTask = new EndpointsAsyncTask(taskCompleted);
    getInstrumentation().runOnMainSync(movieTask::execute);
    signal.await();// wait for callback
  }
}