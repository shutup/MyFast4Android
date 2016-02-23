package com.shutup.myfast4android.listview_adapter_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.shutup.myfast4android.R;
import com.shutup.myfast4android.common.BaseActivity;
import com.shutup.myfast4android.main_menu.Menu;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListViewAdapterDemoActivity extends BaseActivity {

    @Bind(R.id.btnBasic)
    Button btnBasic;
    @Bind(R.id.btnConvertView)
    Button btnConvertView;
    @Bind(R.id.btnViewHolder)
    Button btnViewHolder;
    @Bind(R.id.listview)
    ListView listview;
    private List<Menu> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_adapter_demo);
        ButterKnife.bind(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewAdapterDemoActivity.this, "clicked position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewAdapterDemoActivity.this, "long clicked position:" + position, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void setListViewAdapter(int btnId) {
        addData(btnId);
        ListMenuBaseAdapter baseAdapter = null;
        switch (btnId){
            case R.id.btnBasic:
                baseAdapter = new ListMenuAdapterUseBasic(data,this);
                listview.setAdapter(baseAdapter);
                baseAdapter.notifyDataSetChanged();
                break;
            case R.id.btnConvertView:
                baseAdapter = new ListMenuAdapterUseConvertView(data,this);
                listview.setAdapter(baseAdapter);
                baseAdapter.notifyDataSetChanged();
                break;
            case R.id.btnViewHolder:
                baseAdapter = new ListMenuAdapterUseViewHolder(data,this);
                listview.setAdapter(baseAdapter);
                baseAdapter.notifyDataSetChanged();
                break;
        }

    }

    private void addData(int btnId) {
        data = new ArrayList<>();
        switch (btnId){
            case R.id.btnBasic:
                for (int i =0;i <100; i++){
                    data.add(new Menu("listViewAdapterBasic "+i));
                }
                break;
            case R.id.btnConvertView:
                for (int i =0;i <100; i++){
                    data.add(new Menu("listViewAdapterConvertView "+i));
                }
                break;
            case R.id.btnViewHolder:
                for (int i =0;i <100; i++){
                    data.add(new Menu("listViewAdapterViewHolder "+i));
                }
                break;
        }
    }

    @OnClick({R.id.btnBasic, R.id.btnConvertView, R.id.btnViewHolder})
    public void onClick(View view) {
        setListViewAdapter(view.getId());
    }
}
