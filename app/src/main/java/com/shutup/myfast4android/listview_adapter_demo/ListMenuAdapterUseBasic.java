package com.shutup.myfast4android.listview_adapter_demo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shutup.myfast4android.R;
import com.shutup.myfast4android.main_menu.Menu;

import java.util.List;

/**
 * Created by shutup on 16/2/21.
 */
public class ListMenuAdapterUseBasic extends ListMenuBaseAdapter {


    public ListMenuAdapterUseBasic(List<Menu> data, Context mContext) {
        super(data, mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.menu_item_layout,null);
        TextView tv = (TextView) view.findViewById(R.id.menu_title);
        tv.setText(data.get(position).getTitle());
        return view;
    }
}
