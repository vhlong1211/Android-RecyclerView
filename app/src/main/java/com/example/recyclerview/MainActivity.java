package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewClickInterface{

    private static final String TAG = "MainActivity";

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;

    List<String> mailList;

    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mailList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerAdapter = new RecyclerAdapter(mailList, this);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

        mailList.add("Iron Man");
        mailList.add(" Hulk");
        mailList.add("Iron Man 2");
        mailList.add("Thor");
        mailList.add("Captain America");
        mailList.add("The Avengers");
        mailList.add("Iron Man 3");
        mailList.add("INCC");
        mailList.add("Cap");
        mailList.add("Guardians of the Galaxy");
        mailList.add(" Ultron");
        mailList.add("Ant-Man");
        mailList.add("CaptainVN");
        mailList.add("Doctor Strange");
        mailList.add("Mantis");
        mailList.add("Spider-Man");
        mailList.add(" Ragnarok");
        mailList.add("Black Panther");
        mailList.add(" War");
        mailList.add(" Wasp");
        mailList.add("Captain Marvel");

        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//
                recyclerAdapter.notifyDataSetChanged();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }



//    These are the interface Methods from our custom RecyclerViewClickInterface
    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("MOVIE_NAME", mailList.get(position));
        startActivity(intent);
    }

    @Override
    public void onLongItemClick(final int position) {
        mailList.remove(position);
        recyclerAdapter.notifyItemRemoved(position);
    }
}
