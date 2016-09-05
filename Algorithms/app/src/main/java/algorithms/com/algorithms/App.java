package algorithms.com.algorithms;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by ciriti on 05/09/16.
 */

public class App extends Application {

    int count = 0;

    @Override
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                System.out.println("Live activity: " + (++count));
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {
                System.out.println("Live activity: " + (--count));
            }
        });
    }
}
