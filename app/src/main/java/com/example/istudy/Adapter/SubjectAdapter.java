package com.example.istudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.istudy.NotesActivity;
import com.example.istudy.R;
import com.example.istudy.models.Lesson;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {

    List<Lesson> lessonList;
    Context context;

    public SubjectAdapter(Context context, List<Lesson> lessons){
        this.context = context;
        lessonList = lessons;
    }
    /*public static SubjectAdapter newInstance(Lesson lesson) {

        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(lesson));

       //SubjectAdapter subjectAdapter = new SubjectAdapter( );
        //subjectAdapter.setArguments(args);
       // return subjectAdapter;
    }*/


    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.subject_layout,parent,false);
        //lessonList = Parcels.unwrap(getArguments().getParcelable("lessons"));

        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {

        Lesson lesson = lessonList.get(position);
        holder.name.setText(lesson.getSubject().getName());
        //holder.description.setText(post.getDescription());
    }

    @Override
    public int getItemCount() {
        return lessonList.size();
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder{
        TextView name/*, description*/;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.title_lesson);
            //description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int itemPosition = getLayoutPosition();
                    Intent intent = new Intent(context, NotesActivity.class);

                    context.startActivity(intent);

                }
            });
        }
    }
}
