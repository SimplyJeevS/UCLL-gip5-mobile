package be.ucll.java.mobile.gip5_mobile.recyclerview;

import android.content.Context;
import android.service.autofill.FieldClassification;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import be.ucll.java.mobile.gip5_mobile.R;

public class MatchAdapter extends RecyclerView.Adapter<MatchAdapter.MatchHolder> {

    String data1[], data2[];
    int images[];
    Context context;

    public MatchAdapter(Context ct, String matchName[], String matchDate[], int img[]){
        context = ct;
        data1 = matchName;
        data2 = matchDate;
        images = img;
    }
    @NonNull
    @Override
    public MatchHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.match_item, parent, false);
        return new MatchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchHolder holder, int position) {
        holder.matchName.setText(data1[position]);
        holder.matchDate.setText(data2[position]);
        holder.matchImage.setImageResource(images[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MatchHolder extends RecyclerView.ViewHolder {

        TextView matchName, matchDate;
        ImageView matchImage;

        public MatchHolder(@NonNull View itemView) {
            super(itemView);
            matchName = itemView.findViewById(R.id.lblMatchName);
            matchDate = itemView.findViewById(R.id.lblMatchDate);
            matchImage = itemView.findViewById(R.id.imgMatch);

        }
    }
}
