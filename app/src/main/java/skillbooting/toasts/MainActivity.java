package skillbooting.toasts;

//http://developer.android.com/guide/topics/ui/notifiers/toasts.html
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Context context;
    CharSequence text;
    Toast toast;
    int duration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show_normal_toast(View v)
    {

        context = getApplicationContext();
        text = "Example Toast";
        duration = Toast.LENGTH_SHORT;
        toast = Toast.makeText(context, text, duration);
        toast.show();

        //You can also write the above as
        //Toast.makeText(context, text, duration).show();
    }

    // the toast should appear in the top-left corner,
    public void show_different_location_toast(View v)
    {
        context = getApplicationContext();
        text = "Example Toast";
        duration = Toast.LENGTH_SHORT;
        toast = Toast.makeText(context, text, duration);

        toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        //setGravity(int, int, int) method.
        // This accepts three parameters: a Gravity constant, an x-position offset, and a y-position offset.
        //If you want to nudge the position to the right, increase the value of the second parameter.
        // To nudge it down, increase the value of the last parameter.
        toast.show();
    }

    public void show_custom_layout_toast(View v)
    {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));
        //inflate(int, ViewGroup). The first parameter is the layout resource ID and the second is the root View.

        TextView text = (TextView) layout.findViewById(R.id.text);
        text.setText("This is a custom toast");

        toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
