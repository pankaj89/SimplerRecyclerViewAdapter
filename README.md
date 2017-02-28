# Simpler Recycler View Adapter

SimplerRecyclerViewAdapter used to simplfy the adapter structure for RecyclerView.
  - Easy to use
  - No need to create adapter (Seperate java files)
  - Works with multiple view types
  - View holders are inside Activity or Fragment, so easily call methods of activity on row click.

### Latest Version (1.1)
  - Solved issue with multiple data and while scrolling (Changed structure for ViewHolder, See "Creating View Holder" Section).

### Download
Include the following dependency in your apps build.gradle file.
```
compile 'com.master.android:simpler-recycler-view-adapter:1.1'
```

### Creating View Holder
```java
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
```

### Adding View Holder to RecyclerView
```java
SimplerRecyclerViewAdapter adapter = new SimplerRecyclerViewAdapter();
adapter.addViewHolder(R.layout.row_item_1, simplerViewHolder1);
adapter.addViewHolder(R.layout.row_item_2, simplerViewHolder2);
adapter.setList(list);
recyclerView.setAdapter(adapter);
```

### Comming Soon!!!
  - Add HeaderView (That will be available on top of recycler view.)
  - Add FooterView (That will be available on bottom of recycler view.)View

### License
```
Copyright 2017 Pankaj Sharma

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
