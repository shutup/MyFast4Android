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
public class ListMenuAdapterUseConvertView extends ListMenuBaseAdapter {
    public ListMenuAdapterUseConvertView(List<Menu> data, Context mContext) {
        super(data, mContext);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.menu_item_layout,null);

        }
        TextView tv = (TextView) convertView.findViewById(R.id.menu_title);
        tv.setText(data.get(position).getTitle());
        return convertView;
    }
}
