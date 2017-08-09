package phracek.dokumenty_ii_vatikanskeho_koncilu;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class DocumentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        // Get the Intent that started this activity and extract the string
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("Document");
        setTitle(title);

        TextView textView = (TextView) findViewById(R.id.documentView);
        textView.setMovementMethod(new ScrollingMovementMethod());
        String concil_document = MainActivity.docuDb.getDocu("cs", title);
        textView.setText(Html.fromHtml(concil_document));
        // Capture the layout's TextView and set the string as its text
    }
}
