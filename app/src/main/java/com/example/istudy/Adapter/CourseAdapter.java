package com.example.istudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

//public class CourseAdapter {
    public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.LessonViewHolder> {


        List<Lesson> lessonsList;

        Context context;

        public CourseAdapter(Context context, List<Lesson> lessons){
            this.context = context;
            lessonsList = lessons;
        }

        @NonNull
        @Override
        public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.course_layout,parent,false);

            return new LessonViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {

            Lesson lessons = lessonsList.get(position);

            holder.name_course.setText(lessons.getSubject().getCourse().getName());
            //holder.description_course.setText(lessons.getSubject().getCourse().getDescription());
            holder.name_course.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Subject subject= lessonsList.get(position).getSubject();

                    String notes=lessonsList.get(position).getNotes();
                    String video= "https://res.cloudinary.com/demo/video/upload/a_90/dog.mp4";
                    Intent intent= new Intent(context, SubjectActivity.class);

                    Bundle bundle= new Bundle();
                    bundle.putParcelable("subject", Parcels.wrap(subject));
                    bundle.putParcelable("lesson", Parcels.wrap(lessons));
                    intent.putExtras(bundle);
                    intent.putExtra("notes", Parcels.wrap(notes));
                    intent.putExtra("video", Parcels.wrap(video));
                    //intent.putExtra("video", video);

                    context.startActivity(intent);

                }
            });
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
            TextView name_course,description_course,note_lesson, video_lesson;
            Button tosubject;

            public LessonViewHolder(@NonNull View itemView) {
                super(itemView);

                //tosubject= itemView.findViewById(R.id.tosubject);
                name_course=itemView.findViewById(R.id.name_course);
                //description_course=itemView.findViewById(R.id.description_course);
                note_lesson = itemView.findViewById(R.id.note_lesson);
                video_lesson=itemView.findViewById(R.id.video_lesson);

            }
        }
    }


