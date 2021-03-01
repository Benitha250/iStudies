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
import com.example.istudy.NotesActivity;
import com.example.istudy.R;
import com.example.istudy.models.Classe;

import java.util.List;

public class ClassesAdapter extends RecyclerView.Adapter<ClassesAdapter.classesviewholder> {
   List<Classe> mdata;

    private Context mContext;

    public ClassesAdapter(Context context, List<Classe> mdata) {
        mContext = context;
        this.mdata = mdata;
    }

    @NonNull
    @Override
    public classesviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.classes_layout,parent,false);


        return new classesviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull classesviewholder holder, int position) {
        Glide.with(holder.itemView.getContext()).load(mdata.get(position).getDrawableResource())
                .transform(new CenterCrop(),new RoundedCorners(16))
                .into(holder.img_class);
/*        if(mdata.size()==1){
            holder.title_class.setText("Lesson 1:English");

        }
        else if(mdata.size()==0){
            holder.title_class.setText("Lesson 2:Art");
        }*/

        //holder.title_class.setText("Lesson 1:English");
        //holder.title_class.setText("Lesson 2:Art");

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public class classesviewholder extends RecyclerView.ViewHolder{
        ImageView img_class;
        TextView title_class;
        public classesviewholder(@NonNull View itemView) {
            super(itemView);
            img_class = itemView.findViewById(R.id.img_class);
            title_class = itemView.findViewById(R.id.title_class);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(mContext, NotesActivity.class);
                    //intent.putExtra("position", itemPosition);
                    //intent.putExtra("movies", Parcels.wrap(mmovies));
                    mContext.startActivity(intent);

                }
            });
        }
    }
}