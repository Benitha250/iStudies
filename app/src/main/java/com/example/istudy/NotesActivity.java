package com.example.istudy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;


import com.example.istudy.Adapter.TitleAdapter;
import com.example.istudy.Interface.TitleClickListener;
import com.example.istudy.models.Constants;


public class NotesActivity extends AppCompatActivity {

    private static final String TAG ="ClassesActivity";
    private Context mContex;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        mContex = NotesActivity.this;
        titleList = new ArrayList<>();
        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLEB);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager= new LinearLayoutManager(mContex,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        TitleAdapter titleAdapter = new TitleAdapter(mContex, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemView, int position) {
                // Toast.makeText(mContex,"Title clicked"+position,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NotesActivity.this,NotesContentActivity.class);
                intent.putExtra("titles",titleList.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(titleAdapter);

    }
}
