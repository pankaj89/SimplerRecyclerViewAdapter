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

    SimplerRecyclerViewAdapter.SimplerViewHolder simplerViewHolder1 = new SimplerRecyclerViewAdapter.SimplerViewHolder<Student>() {

        TextView txtName, txtDesignation;

        @Override
        public void create(View itemView) {
            txtName = (TextView) itemView.findViewById(R.id.name);
            txtDesignation = (TextView) itemView.findViewById(R.id.designation);
        }

        @Override
        public void bind(Student model) {
            txtName.setText(model.name);
            txtDesignation.setText(model.designation);
        }
    };
    SimplerRecyclerViewAdapter.SimplerViewHolder simplerViewHolder2 = new SimplerRecyclerViewAdapter.SimplerViewHolder<Student>() {

        TextView txtName, txtDesignation, txtCompany;

        @Override
        public void create(View itemView) {
            txtName = (TextView) itemView.findViewById(R.id.name);
            txtDesignation = (TextView) itemView.findViewById(R.id.designation);
            txtCompany = (TextView) itemView.findViewById(R.id.company);
        }

        @Override
        public void bind(Student model) {
            txtName.setText(model.name);
            txtDesignation.setText(model.designation);
            txtCompany.setText(model.company);
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
        list.add(new Student("Pankaj", "Android", "Openxcell"));
        list.add(new Student("Sumit", "Web", ""));
        list.add(new Student("Ronak", "Php", "SkyInfoSys"));
        list.add(new Student("Dipen", "RxJava", "SmartWebtech"));
        list.add(new Student("Ravindra", "Google Go", null));
        return list;
    }
}
