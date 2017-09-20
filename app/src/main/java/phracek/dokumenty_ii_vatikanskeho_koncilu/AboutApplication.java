package phracek.dokumenty_ii_vatikanskeho_koncilu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AboutApplication extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_application);

        TextView textView = (TextView) findViewById(R.id.aboutView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        Log.e("test", "texxt");
        textView.setText(R.string.version_1_0);
    }
}
