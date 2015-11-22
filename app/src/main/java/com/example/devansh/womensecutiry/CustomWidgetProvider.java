package com.example.devansh.womensecutiry;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by Devansh on 11/21/2015.
 */
public class CustomWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;
            Log.i("devWs","one");
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i = 0; i < N; i++) {
            int appWidgetId = appWidgetIds[i];
            Log.i("devWs","three" + appWidgetId);
            // Create an Intent to launch ExampleActivity
            Intent intent = new Intent(context, ActionActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


            Intent intentTwo = new Intent(context, ActionTwoActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            Intent intentThree = new Intent(context, ActionThreeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            Intent intentFour = new Intent(context, ActionFourActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Get the layout for the App Widget and attach an on-click listener
            // to the button

//            String url = "http://www.tutorialspoint.com";
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
            PendingIntent pendingIntentTwo = PendingIntent.getActivity(context, 0, intentTwo, 0);
            PendingIntent pendingIntentThree = PendingIntent.getActivity(context, 0, intentThree, 0);
            //PendingIntent pendingIntentFour = PendingIntent.getActivity(context, 0, intentFour, 0);
//            Log.i("pending intent",pendingIntent.toString());
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
            Log.i("views", views.toString());
            views.setOnClickPendingIntent(R.id.imageButton, pendingIntent);
            Toast.makeText(context,"AFDAFad",Toast.LENGTH_LONG);
            views.setOnClickPendingIntent(R.id.imageButton2, pendingIntentTwo);
            views.setOnClickPendingIntent(R.id.imageButton3, pendingIntentThree);
            views.setOnClickPendingIntent(R.id.imageButton4, pendingIntentThree);
            appWidgetManager.updateAppWidget(appWidgetId, views);
            Log.i("devWs", "two");
        }
    }
}
