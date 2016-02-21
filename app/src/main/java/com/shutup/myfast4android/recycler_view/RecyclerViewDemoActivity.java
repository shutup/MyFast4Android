package com.shutup.myfast4android.recycler_view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shutup.myfast4android.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewDemoActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    private List<ItemArticle> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_demo);
        ButterKnife.bind(this);
        setRecyclerViewAdapter();
    }

    private void setRecyclerViewAdapter() {
        addData();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        DividerLine dividerLine = new DividerLine(DividerLine.VERTICAL);
        dividerLine.setSize(5);
        dividerLine.setColor(0xFFDDDDDD);
        recyclerView.addItemDecoration(dividerLine);
        recyclerView.setAdapter(new ItemArticleAdapter(data,this));
    }

    private void addData() {
        data = new ArrayList<>();
        ItemArticle storeInfo1 =
                new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                        "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
        ItemArticle storeInfo2 =
                new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                        "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
        ItemArticle storeInfo3 =
                new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                        "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
        ItemArticle storeInfo4 =
                new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                        "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
        ItemArticle storeInfo5 =
                new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                        "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
        ItemArticle storeInfo6 =
                new ItemArticle(20123, "http://i2.sinaimg.cn/ent/j/2012-05-20/U5912P28T3D3634984F328DT20120520152700.JPG", "关于举办《经典音乐作品欣赏与人文审美》讲座的通知", "2015-01-09", "科学研究院", 1129,
                        "讲座主要内容：以中、西方音乐历史中经典音乐作品为基础，通过作曲家及作品创作背景、相关音乐文化史知识及音乐欣赏常识...");
        data.add(storeInfo1);
        data.add(storeInfo2);
        data.add(storeInfo3);
        data.add(storeInfo4);
        data.add(storeInfo5);
        data.add(storeInfo6);
    }
}
