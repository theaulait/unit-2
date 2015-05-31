package nyc.c4q.jrod.exercises.chooser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ChooserActivity extends Activity {

    private EditText input;
    private ListView intents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        input = (EditText) findViewById(R.id.input);
        intents = (ListView) findViewById(R.id.intents);

        List<ResolveInfo> resolveInfos = findSendActionActivities();
        AppAdapter adapter =  new AppAdapter(this, resolveInfos);
        intents.setAdapter(adapter);

        intents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ResolveInfo resolveInfo = (ResolveInfo) intents.getItemAtPosition(position);
                ActivityInfo activityInfo = resolveInfo.activityInfo;

                Intent launchIntent = buildLaunchIntent(activityInfo);
                startActivity(launchIntent);
            }
        });
    }

    @NonNull
    private Intent buildLaunchIntent(ActivityInfo activityInfo) {
        return new Intent(Intent.ACTION_SEND)
                            .setType("text/plain")
                            .putExtra(Intent.EXTRA_TEXT, input.getText().toString())
                            .setClassName(activityInfo.packageName, activityInfo.name);
    }

    private List<ResolveInfo> findSendActionActivities() {
        PackageManager packageManager = getPackageManager();
        Intent queryIntent = new Intent(Intent.ACTION_SEND);
        queryIntent.setType("text/plain");
        return packageManager.queryIntentActivities(queryIntent, 0);
    }

    private class AppAdapter extends ArrayAdapter<ResolveInfo> {

        public AppAdapter(Context context, List<ResolveInfo> apps) {
            super(context, 0, apps);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                LayoutInflater vi = LayoutInflater.from(ChooserActivity.this);
                convertView = vi.inflate(R.layout.app_list_item, null);
            }

            ResolveInfo item = getItem(position);

            ImageView appIcon = (ImageView) convertView.findViewById(R.id.app_icon);
            TextView appName = (TextView) convertView.findViewById(R.id.app_name);

            appIcon.setImageDrawable(item.loadIcon(getPackageManager()));
            appName.setText(item.loadLabel(getPackageManager()));

            return convertView;
        }
    }
}
