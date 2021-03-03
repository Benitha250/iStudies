package com.example.istudy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.istudy.R;
import com.example.istudy.models.Courses;

import java.util.List;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.PostViewHolder> {

    List<Courses> coursesList;
    Context context;

    public CoursesAdapter(Context context, List<Courses> courses){
        this.context = context;
        coursesList = courses;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.courses_layout,parent,false);

        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {

        Courses courses = coursesList.get(position);
        holder.name.setText(courses.getName());
        holder.description.setText(courses.getDescription());
    }

    @Override
    public int getItemCount() {
        return coursesList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder{
        TextView name, description;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            description = itemView.findViewById(R.id.description);
        }
    }
}
