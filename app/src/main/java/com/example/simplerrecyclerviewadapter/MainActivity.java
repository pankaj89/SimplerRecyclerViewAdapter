package com.example.simplerrecyclerviewadapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.master.simplerrecyclerviewadapter.SimplerRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));

        SimplerRecyclerViewAdapter adapter = new SimplerRecyclerViewAdapter();
        adapter.addViewHolder(R.layout.row_item_1, simplerViewHolder1);
        adapter.addViewHolder(R.layout.row_item_2, simplerViewHolder2);
        adapter.setList(getDummyList());
        recyclerView.setAdapter(adapter);
    }

    SimplerRecyclerViewAdapter.SimplerRowHolder simplerViewHolder1 = new SimplerRecyclerViewAdapter.SimplerRowHolder<Student>() {

        @Override
        public SimplerViewHolder getAdapter(View view) {
            return new SimplerViewHolder(view) {

                TextView txtName, txtDesignation;

                @Override
                public void create() {
                    txtName = links(R.id.name);
                    txtDesignation = links(R.id.designation);
                }

                @Override
                public void bind(Student model) {
                    isMyViewType(model);
                    txtName.setText(model.name);
                    txtDesignation.setText(model.designation);
                }
            };
        }
    };

    SimplerRecyclerViewAdapter.SimplerRowHolder simplerViewHolder2 = new SimplerRecyclerViewAdapter.SimplerRowHolder<Student>() {

        @Override
        public SimplerViewHolder getAdapter(View view) {
            return new SimplerViewHolder(view) {

                TextView txtName, txtDesignation;

                @Override
                public void create() {
                    txtName = links(R.id.name);
                    txtDesignation = links(R.id.designation);
                }

                @Override
                public void bind(Student model) {
                    isMyViewType(model);
                    txtName.setText(model.name);
                    txtDesignation.setText(model.designation);
                }
            };
        }

        @Override
        public boolean isMyViewType(Student model) {
            if (!TextUtils.isEmpty(model.company)) {
                return true;
            }
            return super.isMyViewType(model);
        }
    };

    private ArrayList<Student> getDummyList() {
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(new Student("1", "Web", ""));
        list.add(new Student("2", "Android", "Openxcell"));
        list.add(new Student("3", "Php", "SkyInfoSys"));
        list.add(new Student("4", "CakePHP", "SmartWebtech"));
        list.add(new Student("5", "Google Go", "TCS"));
        list.add(new Student("6", "Google Go", null));
        list.add(new Student("7", "Android", "Wipro"));
        list.add(new Student("8", "Android", null));
        list.add(new Student("9", "Web", ""));
        list.add(new Student("10", "Web", ""));
        list.add(new Student("11", "Web", ""));
        list.add(new Student("12", "Android", "Openxcell"));
        list.add(new Student("13", "Php", "SkyInfoSys"));
        list.add(new Student("14", "CakePHP", "SmartWebtech"));
        list.add(new Student("15", "Google Go", "TCS"));
        list.add(new Student("16", "Google Go", null));
        list.add(new Student("17", "Android", "Wipro"));
        list.add(new Student("18", "Android", null));
        list.add(new Student("19", "Web", ""));
        list.add(new Student("20", "Android", "Openxcell"));
        list.add(new Student("21", "Php", "SkyInfoSys"));
        list.add(new Student("22", "CakePHP", "SmartWebtech"));
        list.add(new Student("23", "Google Go", "TCS"));
        list.add(new Student("24", "Google Go", null));
        list.add(new Student("25", "Android", "Wipro"));
        list.add(new Student("26", "Android", null));
        list.add(new Student("27", "Web", ""));
        list.add(new Student("28", "Android", "Openxcell"));
        list.add(new Student("29", "Php", "SkyInfoSys"));
        list.add(new Student("30", "CakePHP", "SmartWebtech"));
        list.add(new Student("31", "Google Go", "TCS"));
        list.add(new Student("32", "Google Go", null));
        list.add(new Student("33", "Android", "Wipro"));
        list.add(new Student("34", "Android", null));
        list.add(new Student("35", "Web", ""));
        list.add(new Student("36", "Android", "Openxcell"));
        list.add(new Student("37", "Php", "SkyInfoSys"));
        list.add(new Student("38", "CakePHP", "SmartWebtech"));
        list.add(new Student("39", "Google Go", "TCS"));
        list.add(new Student("40", "Google Go", null));
        list.add(new Student("41", "Android", "Wipro"));
        list.add(new Student("42", "Android", null));

        return list;
    }
}
