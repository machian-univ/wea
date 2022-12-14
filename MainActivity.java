package com.example.myapplication2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.wear.widget.WearableRecyclerView;

import com.example.myapplication2.databinding.ActivityMainBinding;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class MainActivity extends Activity {

    private ActivityMainBinding binding;

    private WearableRecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // bookList = db.bookDao().getAll();

        mRecyclerView = binding.myRecyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setHasFixedSize(true);
// --------------------------------------------------------------------
        mRecyclerView.setCircularScrollingGestureEnabled(true);
        mRecyclerView.setEdgeItemsCenteringEnabled(true);
// --------------------------------------------------------------------
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        BooksAdapter adapter = new BooksAdapter(this, (List<Book>) bookList);
        mRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}





