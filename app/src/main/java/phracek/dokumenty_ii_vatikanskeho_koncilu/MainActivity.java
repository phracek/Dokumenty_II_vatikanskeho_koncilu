package phracek.dokumenty_ii_vatikanskeho_koncilu;

import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "phracek.dokumenty_ii_vatikanskeho_koncilu.MESSAGE";
    public static final int SIZE = 30;
    public static DocumentDb docuDb = new DocumentDb();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        loadDocumentDb();
        loadOtherItems();

        // specify an adapter (see also next example)
        RecyclerViewAdapter mAdapter = new RecyclerViewAdapter(this);
        mRecyclerView.setAdapter(mAdapter);

    }
    private void loadDocumentDb() {
        /*
        List of documents were taken from address
        http://www.vatican.va/archive/hist_councils/ii_vatican_council/index.htm
         */
        String language = "cs";
        try {
            InputStream input= this.getClass().getClassLoader().getResourceAsStream("res/raw/database");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = null;
            while((line = reader.readLine()) != null){
                String [] val = line.split("::");
                if (val[0].equals(language)) {
                    docuDb.addToDb(val[1], val[0], val[2]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void showAbout() {
        // Inflate the about message contents
        final Intent intent;
        intent = new Intent(this, AboutApplication.class);
        this.startActivity(intent);

    }
    private void loadOtherItems() {
        String language = "cs";
        docuDb.addToDb("Nastaveni", language, "None");
        docuDb.addToDb("O aplikaci", language, "None");
    }
    public static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private String[] mDataset;

        // Provide a reference to the views for each data item
        // Complex data items may need more than one view per item, and
        // you provide access to all the views for a data item in a view holder
        public static class ViewHolder extends RecyclerView.ViewHolder {
            // each data item is just a string in this case
            public TextView mTextView;
            public ViewHolder(TextView v) {
                super(v);
                mTextView = v;
            }
        }

        // Provide a suitable constructor (depends on the kind of dataset)
        public MyAdapter(String[] myDataset) {
            mDataset = myDataset;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
            // create a new view
            TextView v = (TextView) LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.activity_document, parent, false);
            // set the view's size, margins, paddings and layout parameters
            v.setTextSize(MainActivity.SIZE);
            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.mTextView.setText(mDataset[position]);

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mDataset.length;
        }
    }
}
