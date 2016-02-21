package com.shutup.myfast4android.listview_adapter_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.shutup.myfast4android.main_menu.Menu;

import java.util.List;

/**
 * Created by shutup on 16/2/21.
 */
public class ListMenuBaseAdapter extends BaseAdapter {
    protected List<Menu> data;
    protected Context mContext;
    protected LayoutInflater layoutInflater;
    protected ListView mListView;

    public ListMenuBaseAdapter(List<Menu> data,Context mContext) {
        this.data = data;
        this.mContext = mContext;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public ListMenuBaseAdapter(List<Menu> data, Context mContext, ListView mListView) {
        this.data = data;
        this.mContext = mContext;
        this.mListView = mListView;
        layoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return this.data.size();
    }

    @Override
    public Object getItem(int position) {
        return this.data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }


}
