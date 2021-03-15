package com.example.istudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.istudy.NotesLessonActivity;
import com.example.istudy.NotesVideoActivity;
import com.example.istudy.R;
import com.example.istudy.SubjectActivity;
import com.example.istudy.models.Lesson;
import com.example.istudy.models.Subject;

import org.parceler.Parcels;

import java.util.List;

public class LessonAdapter extends RecyclerView.Adapter<LessonAdapter.LessonViewHolder> {


    List<Lesson> lessonsList;

    Context context;

    public LessonAdapter(Context context, List<Lesson> lessons){
        this.context = context;
        lessonsList = lessons;
    }

    @NonNull
    @Override
    public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.lesson_layout,parent,false);

        return new LessonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {

        Lesson lessons = lessonsList.get(position);
        holder.name.setText(lessons.getSubject().getCourse().getName());


        /*holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Subject subject= lessonsList.get(position).getSubject();

                Intent intent= new Intent(context, SubjectActivity.class);

                Bundle bundle= new Bundle();
                bundle.putParcelable("subject", Parcels.wrap(subject));
                intent.putExtras(bundle);

                context.startActivity(intent);

            }
        });*/
        holder.note_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notes=lessonsList.get(position).getNotes();
                Intent intent= new Intent(context, NotesLessonActivity.class);
                intent.putExtra("notes", Parcels.wrap(notes));
                context.startActivity(intent);

            }
        });
        holder.video_lesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String video= "https://res.cloudinary.com/demo/video/upload/a_90/dog.mp4";
                Intent intent= new Intent(context, NotesVideoActivity.class);
                intent.putExtra("video", Parcels.wrap(video));
                //intent.putExtra("video", video);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return lessonsList.size();
    }

    public class LessonViewHolder extends RecyclerView.ViewHolder{
        TextView name,note_lesson, video_lesson;
        ImageView img_lesson;
        public LessonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_lesson_);
            note_lesson = itemView.findViewById(R.id.note_lesson);
            video_lesson=itemView.findViewById(R.id.video_lesson);
            img_lesson =itemView.findViewById(R.id.img_lesson);



        }
    }
}
