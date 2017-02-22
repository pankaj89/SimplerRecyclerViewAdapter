package com.master.simplerrecyclerviewadapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * SimplerRecyclerViewAdapter
 * @Version   : 1.0
 * @Developer : Pankaj Sharma
 * @Description : SimplerRecyclerViewAdapter used to simplfy the adapter structure for RecyclerView,
 * you can create multiple viewholder for different-different View Type
 *
 * How to use?
 * ------------
 * SimplerRecyclerViewAdapter.SimplerViewHolder simplerViewHolder1 = new SimplerRecyclerViewAdapter.SimplerViewHolder<Student>() {
 *
 *      TextView txtName, txtDesignation;
 *
 *      @Override
 *      public void create(View itemView) {
 *          txtName = (TextView) itemView.findViewById(R.id.name);
 *          txtDesignation = (TextView) itemView.findViewById(R.id.designation);
 *      }
 *
 *      @Override
 *      public void bind(Student model) {
 *          txtName.setText(model.name);
 *          txtDesignation.setText(model.designation);
 *      }
 * };
 *
 * SimplerRecyclerViewAdapter adapter = new SimplerRecyclerViewAdapter();
 * adapter.addViewHolder(R.layout.row_item_1, simplerViewHolder1);
 * adapter.addViewHolder(R.layout.row_item_2, simplerViewHolder2);
 * adapter.setList(list);
 * <your_recycler_view>.setAdapter(adapter);
 *
 *
 */

public final class SimplerRecyclerViewAdapter<M> extends RecyclerView.Adapter<SimplerRecyclerViewAdapter.ViewHolder> {

    private ArrayList<M> mList;
    private ArrayList<Integer> resLayoutList;
    private ArrayList<SimplerViewHolder> viewHolderList;

    public SimplerRecyclerViewAdapter() {
        mList = new ArrayList<M>();
        resLayoutList = new ArrayList<Integer>();
        viewHolderList = new ArrayList<SimplerViewHolder>();
    }

    @Override
    public SimplerRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (resLayoutList.size() <= 0) {
            throw new RuntimeException("You forgot to add ViewHolder, please add view holder using SimplerRecyclerViewAdapter.addViewHolder() method");
        }
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(resLayoutList.get(viewType), parent, false), viewHolderList.get(viewType));
    }

    @Override
    public void onBindViewHolder(SimplerRecyclerViewAdapter.ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    @Override
    public int getItemViewType(int position) {
        if (viewHolderList != null) {
            int pos = 0;
            for (SimplerViewHolder simplerViewHolder : viewHolderList) {
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
    public void addViewHolder(int resLayout, SimplerViewHolder<M> simplerViewHolder) {
        this.resLayoutList.add(resLayout);
        this.viewHolderList.add(simplerViewHolder);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        SimplerViewHolder viewHolder;

        public ViewHolder(View itemView, SimplerViewHolder viewHolder) {
            super(itemView);
            this.viewHolder = viewHolder;
            this.viewHolder.create(itemView);
        }

        public void bind(M model) {
            viewHolder.bind(model);
        }
    }

    /**
     * Extend this class to make view holder that works with SimplerRecyclerViewAdapter
     * Override isMyViewType if you are using multiViewType Adapter for your recyclerView.
     * if your condition is satisfied then return true, else call super method like super.isMyviewType(model);
     *
     * @param <M>
     */
    public static abstract class SimplerViewHolder<M> {

        public SimplerViewHolder() {

        }

        public abstract void create(View view);

        public abstract void bind(M model);

        public boolean isMyViewType(M model) {
            return false;
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
     * Remove item at position
     *
     * @param position
     */
    public void removeItem(int position) {
        this.mList.remove(position);
        notifyDataSetChanged();
    }
}