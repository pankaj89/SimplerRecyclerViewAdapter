package com.master.simplerrecyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * SimplerRecyclerViewAdapter
 *
 * @Version : 1.1
 * @Developer : Pankaj Sharma
 * @Description : SimplerRecyclerViewAdapter used to simplfy the adapter structure for RecyclerView,
 * you can create multiple viewholder for different-different View Type
 * <p>
 * How to use?
 * ------------
 * SimplerRecyclerViewAdapter.SimplerRowHolder simplerViewHolder = new SimplerRecyclerViewAdapter.SimplerRowHolder<Student>() {
 * @Override public SimplerViewHolder getAdapter(View view) {
 * return new SimplerViewHolder(view) {
 * <p>
 * TextView txtName, txtDesignation;
 * @Override public void create() {
 * txtName = links(R.id.name);
 * txtDesignation = links(R.id.designation);
 * }
 * @Override public void bind(Student model) {
 * isMyViewType(model);
 * txtName.setText(model.name);
 * txtDesignation.setText(model.designation);
 * }
 * };
 * }
 * };
 * <p>
 * SimplerRecyclerViewAdapter adapter = new SimplerRecyclerViewAdapter();
 * adapter.addViewHolder(R.layout.row_item_1, simplerViewHolder1);
 * adapter.setList(list);
 * <your_recycler_view>.setAdapter(adapter);
 */


public final class SimplerRecyclerViewAdapter<M> extends RecyclerView.Adapter<SimplerRecyclerViewAdapter.SimplerRowHolder.SimplerViewHolder> {

    private ArrayList<M> mList;
    private ArrayList<Integer> resLayoutList;
    private ArrayList<SimplerRowHolder> viewHolderList;

    public SimplerRecyclerViewAdapter() {
        mList = new ArrayList<M>();
        resLayoutList = new ArrayList<Integer>();
        viewHolderList = new ArrayList<SimplerRowHolder>();
    }

    @Override
    public SimplerRowHolder.SimplerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int res = resLayoutList.get(viewType);
        View view = LayoutInflater.from(parent.getContext()).inflate(res, parent, false);
        SimplerRowHolder.SimplerViewHolder viewHolder = viewHolderList.get(viewType).getAdapter(view);
        viewHolder.create();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimplerRowHolder.SimplerViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (viewHolderList != null) {
            int pos = 0;
            for (SimplerRowHolder simplerViewHolder : viewHolderList) {
                if (simplerViewHolder.isMyViewType(getItem(position)))
                    return pos;
                pos++;
            }
        }
        return super.getItemViewType(position);
    }

    public M getItem(int position) {
        return mList.get(position);
    }

    /**
     * Add a layout resource and ViewHolder that binds to this layout.
     *
     * @param resLayout
     * @param simplerViewHolder
     */
    public void addViewHolder(int resLayout, SimplerRowHolder<M> simplerViewHolder) {
        this.resLayoutList.add(resLayout);
        this.viewHolderList.add(simplerViewHolder);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    /**
     * Extend this class to make view holder that works with SimplerRecyclerViewAdapter
     * Override isMyViewType if you are using multiViewType Adapter for your recyclerView.
     * if your condition is satisfied then return true, else call super method like super.isMyviewType(model);
     *
     * @param <M>
     */
    public abstract static class SimplerRowHolder<M> {

        int adapterPosition;

        public SimplerRowHolder() {

        }

        public boolean isMyViewType(M model) {
            return false;
        }

        public abstract SimplerViewHolder getAdapter(View view);

        public abstract class SimplerViewHolder extends RecyclerView.ViewHolder {

            int adapterPosition;

            public SimplerViewHolder(View view) {
                super(view);
            }

            public abstract void create();

            public abstract void bind(M model);

            public <V extends View> V links(int res) {
                return (V) itemView.findViewById(res);
            }

        }
    }


    //User defined Methods start

    /**
     * Used to set list, it will clear list first and add new data.
     *
     * @param list
     */
    public void setList(ArrayList<M> list) {
        this.mList.clear();
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * Add list to existing list.
     *
     * @param list
     */
    public void addList(ArrayList<M> list) {
        this.mList.addAll(list);
        notifyDataSetChanged();
    }

    /**
     * Update item at position with model
     *
     * @param position
     * @param model
     */
    public void updateItem(int position, M model) {
        this.mList.set(position, model);
        notifyDataSetChanged();
    }

    /**
     * Resmove item at position
     *
     * @param position
     */
    public void removeItem(int position) {
        this.mList.remove(position);
        notifyDataSetChanged();
    }
}
