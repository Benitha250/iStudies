package com.example.istudy.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.istudy.Interface.TitleClickListener;
import com.example.istudy.R;
import java.util.ArrayList;

public class Grade1TitleAdapter extends RecyclerView.Adapter<Grade1TitleAdapter.MyViewHolder> {
    private Context mContex;
    private ArrayList<String> titleList;
    private TitleClickListener clickListener;
    public Grade1TitleAdapter(Context mContex, ArrayList<String> titleList, TitleClickListener clickListener) {
        this.mContex = mContex;
        this.titleList = titleList;
        this.clickListener = clickListener;
    }
    @NonNull
    @Override
    public Grade1TitleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContex).inflate(R.layout.grade1notes_layout,viewGroup,false);
        final Grade1TitleAdapter.MyViewHolder myViewHolder  = new Grade1TitleAdapter.MyViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(v,myViewHolder.getPosition());
            }
        });
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull Grade1TitleAdapter.MyViewHolder myViewHolder, int i) {
        myViewHolder.title.setText(titleList.get(i).replace("",""));
    }
    @Override
    public int getItemCount() {
        return titleList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}