package nyc.c4q.jrod.exercises.boot;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context.getApplicationContext(),
                "Boot completed!",
                Toast.LENGTH_LONG)
                .show();
    }
}
