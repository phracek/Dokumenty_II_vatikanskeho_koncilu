package phracek.dokumenty_ii_vatikanskeho_koncilu;

/**
 * Created by phracek on 8/3/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
    private Context context;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_document, null);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view, context);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.name.setText(MainActivity.docuDb.get(position).document_name);
        holder.concil_document = MainActivity.docuDb.get(position).concil_document;
        holder.document_name = MainActivity.docuDb.get(position).document_name;
    }

    @Override
    public int getItemCount() {
        return MainActivity.docuDb.size();
    }
}