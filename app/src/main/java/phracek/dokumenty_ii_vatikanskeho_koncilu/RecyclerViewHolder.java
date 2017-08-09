package phracek.dokumenty_ii_vatikanskeho_koncilu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Html;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Petr Hracek on 14.11.2015.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView name;
    public String concil_document;
    public String document_name;
    int position;
    Context c;

    public RecyclerViewHolder(View itemView, Context context) {
        super(itemView);

        //implementing onClickListener
        itemView.setOnClickListener(this);
        name = (TextView)itemView.findViewById(R.id.documentView);
        name.setTextSize(MainActivity.SIZE);
        c = context;
    }

    @Override
    public void onClick(View view) {
        final Intent intent;
        intent = new Intent(c, DocumentActivity.class);
        intent.putExtra("Document", document_name);
        c.startActivity(intent);
    }
}