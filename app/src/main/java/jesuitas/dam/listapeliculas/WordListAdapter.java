package jesuitas.dam.listapeliculas;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<String> mWordList;
    private final LinkedList<String> genero;
    private LayoutInflater mInflater;
    private final Context context;

    public WordListAdapter(Context context, LinkedList<String> wordList, LinkedList<String> mWordList2){
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
        this.genero =  mWordList2;
        this.context = context;
    }

    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public final ImageView imageView;
        public final TextView textView1;
        public final TextView textView2;
        final WordListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, WordListAdapter adapter) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView1 = itemView.findViewById(R.id.textView);
            textView2 = itemView.findViewById(R.id.textView2);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.imdb.com/"));
            context.startActivity(intent);
        }
    }

    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        String mCurrent2 = genero.get(position);
        holder.textView1.setText(mCurrent);
        holder.textView2.setText(mCurrent2);
    }

    @Override
    public int getItemCount() {
        return genero.size();
    }
}
