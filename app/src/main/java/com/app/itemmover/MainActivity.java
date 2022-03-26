package com.app.itemmover;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvTop, rvDown;
    FloatingActionButton shuffleBtn;
    AdapterDown adapterDown;
    AdapterTop adapterTop;
    onClickInterface onclickInterface;
    List<Item> listTop = new ArrayList<>(), listDown = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initList();
        onclickInterface = new onClickInterface() {
            @Override
            public void setClick(int idx) {
                listTop.add(listDown.get(idx));
                listDown.remove(idx);
                adapterDown.notifyDataSetChanged();
                adapterTop.notifyDataSetChanged();
            }
        };

        rvTop = findViewById(R.id.rvOne);
        rvDown = findViewById(R.id.rvTwo);

        rvDown.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        adapterDown = new AdapterDown(getApplicationContext(), listDown, onclickInterface);
        rvDown.setAdapter(adapterDown);

        rvTop.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        adapterTop = new AdapterTop(getApplicationContext(), listTop);
        rvTop.setAdapter(adapterTop);

        shuffleBtn = findViewById(R.id.shuffleBtn);
        shuffleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Collections.shuffle(listDown);
                adapterDown.notifyDataSetChanged();
            }
        });
    }

    public void initList() {
        listDown.add(new Item(R.drawable.avocado, "Avocado"));
        listDown.add(new Item(R.drawable.car, "Car"));
        listDown.add(new Item(R.drawable.cat, "Cat"));
        listDown.add(new Item(R.drawable.coffee, "Coffee"));
        listDown.add(new Item(R.drawable.fox, "Fox"));
        listDown.add(new Item(R.drawable.heart, "Heart"));
        listDown.add(new Item(R.drawable.hummingbird, "Hummingbird"));
        listDown.add(new Item(R.drawable.mountain, "Mountains"));
        listDown.add(new Item(R.drawable.sheep, "Sheep"));
        listDown.add(new Item(R.drawable.snowman, "Snowman"));
    }
}