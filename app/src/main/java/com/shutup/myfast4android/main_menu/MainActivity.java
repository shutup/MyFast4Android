package com.shutup.myfast4android.main_menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.shutup.myfast4android.R;
import com.shutup.myfast4android.cardview.CardViewDemoActivity;
import com.shutup.myfast4android.common.BaseActivity;
import com.shutup.myfast4android.listview_adapter_demo.ListMenuAdapterUseViewHolder;
import com.shutup.myfast4android.listview_adapter_demo.ListViewAdapterDemoActivity;
import com.shutup.myfast4android.recycler_view.RecyclerViewDemoActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Bind(R.id.listMenu)
    ListView listMenu;
    private List<Menu> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        addListMenuAdapter();
    }

    private void addListMenuAdapter() {
        addMenuItems();
        listMenu.setAdapter(new ListMenuAdapterUseViewHolder(data, this));
        listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position:" + position +",id:" +id, Toast.LENGTH_SHORT).show();
                startActivity(data.get(position).getIntent());
            }
        });
    }

    private void addMenuItems() {
        data = new ArrayList<Menu>();
        data.add(new Menu("GreenDao Test", getJumpIntent(MainActivity.class)));
        data.add(new Menu("ListView Adapter Test", getJumpIntent(ListViewAdapterDemoActivity.class)));
        data.add(new Menu("RecyclerView Test", getJumpIntent(RecyclerViewDemoActivity.class)));
        data.add(new Menu("CardVew Test",getJumpIntent(CardViewDemoActivity.class)));
    }

    @NonNull
    private Intent getJumpIntent(Class cls) {
        return new Intent(this,cls);
    }


}
