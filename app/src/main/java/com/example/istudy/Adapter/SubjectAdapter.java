package com.example.istudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.istudy.CourseActivity;
import com.example.istudy.LessonActivity;
import com.example.istudy.NotesActivity;
import com.example.istudy.R;
import com.example.istudy.models.Course_;
import com.example.istudy.models.Lesson;
import com.example.istudy.models.Subject;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.List;

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.SubjectViewHolder> {



    List<Subject> subjectsList;
    List<Lesson> lessonsList;
    Context context;

    public SubjectAdapter(Context context, List<Subject> subjects){
        this.context = context;
        subjectsList = subjects;
    }

    @NonNull
    @Override
    public SubjectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.subject_layout,parent,false);

        return new SubjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubjectViewHolder holder, int position) {

        Subject subjects = subjectsList.get(position);


        holder.name_subject.setText(subjects.getName());
        holder.tolesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Course_ course= subjectsList.get(position).getCourse();
                //Lesson lesson= Lesson();
                //Subject subject= subjectsList;
                //lessonsList= Parcels.unwrap(getIntent().getParcelableExtra("subject"));


                Intent intent= new Intent(context, CourseActivity.class);

                Bundle bundle= new Bundle();
                bundle.putParcelable("course", Parcels.wrap(course));
                intent.putExtras(bundle);

                context.startActivity(intent);

            }
        });

        String imageUri = "https://res.cloudinary.com/dllcm941d/image/upload/v1614819085/pexels-magda-ehlers-1337382_dzh8kp.jpg";
        // String image_url =subjects.getImage();

        Picasso.get().load(imageUri).into(holder.img_subject);
    }

    @Override
    public int getItemCount() {
        return subjectsList.size();
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder{
        TextView name_subject;
        ImageView img_subject;
        Button tolesson;

        public SubjectViewHolder(@NonNull View itemView) {
            super(itemView);

            name_subject =itemView.findViewById(R.id.name_subject);
            img_subject =itemView.findViewById(R.id.img_subject);
            tolesson=itemView.findViewById(R.id.tolessson);


        }
    }
}