package com.shutup.myfast4android.listview_adapter_demo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.shutup.myfast4android.R;
import com.shutup.myfast4android.main_menu.Menu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shutup on 16/2/21.
 */
public class ListMenuAdapterUsePartUpdate extends ListMenuBaseAdapter{


    public ListMenuAdapterUsePartUpdate(List<Menu> data, Context mContext, ListView mListView) {
        super(data, mContext, mListView);
    }

    private class ViewHolder {
        public ViewHolder(View viewRoot) {
            txt = (TextView) viewRoot.findViewById(R.id.menu_title);
        }

        public TextView txt;
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return data == null ? 0 : data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.menu_item_layout, parent, false);
            ViewHolder holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        if (convertView != null && convertView.getTag() instanceof ViewHolder) {
            updateView((ViewHolder) convertView.getTag(), (Integer) getItem(position));
        }
        return convertView;
    }

    public void updateView(ViewHolder holder, Integer data) {
        if (holder != null && data != null) {
            holder.txt.setVisibility(View.VISIBLE);
            holder.txt.setText(data + "");
        }
    }

    public void notifyDataSetChanged(int position) {
        final int firstVisiablePosition = mListView.getFirstVisiblePosition();
        final int lastVisiablePosition = mListView.getLastVisiblePosition();
        final int relativePosition = position - firstVisiablePosition;
        if (position >= firstVisiablePosition && position <= lastVisiablePosition) {
            updateView((ViewHolder) mListView.getChildAt(relativePosition).getTag(), (Integer) getItem(position));
        } else {
            //不在可视范围内的listitem不需要手动刷新，等其可见时会通过getView自动刷新
        }
    }
}
