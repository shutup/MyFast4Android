package com.shutup.myfast4android.listview_adapter_demo;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.shutup.myfast4android.BuildConfig;
import com.shutup.myfast4android.R;
import com.shutup.myfast4android.main_menu.Menu;

import java.util.List;

/**
 * Created by shutup on 16/2/21.
 */
public class ListMenuAdapterUseViewHolder extends ListMenuBaseAdapter {
    public ListMenuAdapterUseViewHolder(List<Menu> data, Context mContext) {
        super(data, mContext);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            convertView = layoutInflater.inflate(R.layout.menu_item_layout, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
//            Toast.makeText(mContext, "not found convertView", Toast.LENGTH_SHORT).show();
            if (BuildConfig.DEBUG) Log.d("ListMenuAdapterUseViewH", "not found ! position:" + position);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            if (BuildConfig.DEBUG) Log.d("ListMenuAdapterUseViewH", "found ! position:" + position);
//            Toast.makeText(mContext, "found convertView", Toast.LENGTH_SHORT).show();
        }

        viewHolder.menu_title.setText(data.get(position).getTitle());

        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView menu_title;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.menu_title = (TextView) rootView.findViewById(R.id.menu_title);
        }

    }
}
