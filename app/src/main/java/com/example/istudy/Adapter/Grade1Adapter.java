package com.example.istudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.example.istudy.Grade1NotesActivity;
import com.example.istudy.Interface.TitleClickListener;
import com.example.istudy.NotesActivity;
import com.example.istudy.R;
import com.example.istudy.models.Classe;
import com.example.istudy.models.Grade1;

import java.util.ArrayList;
import java.util.List;

public class Grade1Adapter extends RecyclerView.Adapter<Grade1Adapter.grade1viewholder> {
    List<Grade1> mdata;
    private Context mContext;

    public Grade1Adapter(Context context, List<Grade1> mdata) {
        mContext = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public Grade1Adapter.grade1viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grade1_layout, parent, false);
        return new Grade1Adapter.grade1viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Grade1Adapter.grade1viewholder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(mdata.get(position).getDrawableResource())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder.img_class);
    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class grade1viewholder extends RecyclerView.ViewHolder {
        ImageView img_class;
        TextView title_class;

        public grade1viewholder(@NonNull View itemView) {
            super(itemView);
            img_class = itemView.findViewById(R.id.img_class);
            title_class = itemView.findViewById(R.id.title_grade1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, Grade1NotesActivity.class);
                    //intent.putExtra("position", itemPosition);
                    //intent.putExtra("movies", Parcels.wrap(mmovies));
                    mContext.startActivity(intent);
                }
            });
        }
    }
}
