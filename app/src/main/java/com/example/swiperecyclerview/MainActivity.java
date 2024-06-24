package com.example.swiperecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.swiperecyclerview.adapter.MyAdapter;
import com.example.swiperecyclerview.adapter.MyViewHolder;
import com.example.swiperecyclerview.helper.MyButtonClickListener;
import com.example.swiperecyclerview.helper.MySwipeHelper;
import com.example.swiperecyclerview.model.Item;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MyAdapter adapter;
    LinearLayoutManager layoutManager;
    List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        recyclerView = (RecyclerView) findViewById(R.id.recycler_test);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        MySwipeHelper swipeHelper = new MySwipeHelper(this, recyclerView, 200) {
            @Override
            public void instantiateMyButton(RecyclerView.ViewHolder viewHolder, List<MySwipeHelper.MyButton> buffer) {
                buffer.add(new MyButton(MainActivity.this,
                        "Delete",
                        30,
                        0,
                        Color.parseColor("#FF3C30"),
                             new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "Delete click", Toast.LENGTH_SHORT).show();


                            }
                        }
                ));

                buffer.add(new MyButton(MainActivity.this,
                        "Update",
                        30,
                        R.drawable.edit_white,
                        Color.parseColor("#FF9502"),
                        new MyButtonClickListener() {
                            @Override
                            public void onClick(int pos) {
                                Toast.makeText(MainActivity.this, "Update click", Toast.LENGTH_SHORT).show();
                            }
                        }
                ));
            }
        };

        generateItem();
    }


    private void generateItem() {

        for (int i = 0; i < 50; i++) {
            itemList.add(new Item("Pie 0" + (++i), "100.000$", R.drawable.cartinka));
        }


        adapter = new MyAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
    }


}