package be.ucll.java.mobile.gip5_mobile.recyclerview;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.time.format.DateTimeFormatter;

import be.ucll.java.mobile.gip5_mobile.R;


import be.ucll.java.mobile.gip5_mobile.models.Wedstrijd;


public class MatchHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private static final String TAG = "MovieHolder";

    private TextView matchName;
    private TextView matchDate;

    private Wedstrijd wedstrijd;

    private final ClickHandler clickHandler;

    // Constructor
    public MatchHolder(View itemView, ClickHandler ch) {
        super(itemView);

        this.clickHandler = ch;

        matchName = itemView.findViewById(R.id.lblMatchName);
        matchDate = itemView.findViewById(R.id.lblMatchDate);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d(TAG, "Element " + getAdapterPosition() + " clicked.");
        clickHandler.onMatchClick(wedstrijd);
    }

    public void setWedstrijd(Wedstrijd w) {
        this.wedstrijd = w;
        if (wedstrijd != null) {

            // Set the movie title
            matchName.setText(w.getThuisploeg() +" \uD83C\uDD9A "+w.getTegenstander());

            // Set the movie year of release
            //matchDate.setText(w.getTijdstip().format(DateTimeFormatter.ofPattern("YYYY/MM/DD")));

        }
    }

}