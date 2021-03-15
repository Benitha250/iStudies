package com.example.istudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.istudy.R;
import com.example.istudy.SubjectActivity;
import com.example.istudy.models.Lesson;

import java.util.List;

public class LessonsAdapter extends RecyclerView.Adapter<LessonsAdapter.LessonViewHolder> {

        List<Lesson> lessonList;
        Context context;

public LessonsAdapter(Context context, List<Lesson> lessons){
        this.context = context;
        lessonList = lessons;
        }

@NonNull
@Override
public LessonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
        .inflate(R.layout.lessons_layout,parent,false);

        return new LessonViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull LessonViewHolder holder, int position) {

        Lesson lesson = lessonList.get(position);
        holder.name.setText(lesson.getName());
        //holder.description.setText(post.getDescription());
        }

@Override
public int getItemCount() {
        return lessonList.size();
        }

public class LessonViewHolder extends RecyclerView.ViewHolder{
    TextView name/*, description*/;

    public LessonViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.title_lesson);
        //description = itemView.findViewById(R.id.description);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int itemPosition = getLayoutPosition();
                Intent intent = new Intent(context, SubjectActivity.class);
                intent.putExtra("position", itemPosition);
                intent.putExtra("lesson_id",getItemId());
                //intent.putExtra("lessons", lessonList);
                context.startActivity(intent);

            }
        });
    }
}
}
