package com.shutup.myfast4android.recycler_view;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.shutup.myfast4android.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by shutup on 16/2/21.
 */
public class ItemArticleAdapter extends RecyclerView.Adapter<ItemArticleAdapter.ImageItemArticleViewHolder> {

    //新闻列表
    private List<ItemArticle> articleList;

    //context
    private Context context;

    private LayoutInflater mLayoutInflater;

    public ItemArticleAdapter(List<ItemArticle> articleList, Context context) {
        this.articleList = articleList;
        this.context = context;
        this.mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public ImageItemArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.recyclerview_item_article_layout, null);
        return new ImageItemArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ImageItemArticleViewHolder holder, int position) {
        ItemArticle article = articleList.get(position);
        holder.rcvArticleTitle.setText(article.getTitle());
        holder.rcvArticleDate.setText(article.getPublishDate());
        holder.rcvArticleSource.setText(article.getSource());
        //注意这个阅读次数是 int 类型，需要转化为 String 类型
        holder.rcvArticleReadtimes.setText(article.getReadTimes()+"次");
        holder.rcvArticlePreview.setText(article.getPreview());
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    static class ImageItemArticleViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.rcv_article_photo)
        ImageView rcvArticlePhoto;
        @Bind(R.id.rcv_article_title)
        TextView rcvArticleTitle;
        @Bind(R.id.rcv_article_date)
        TextView rcvArticleDate;
        @Bind(R.id.rcv_article_source)
        TextView rcvArticleSource;
        @Bind(R.id.rcv_article_readtimes)
        TextView rcvArticleReadtimes;
        @Bind(R.id.rcv_article_preview)
        TextView rcvArticlePreview;
        @Bind(R.id.cv_item)
        CardView cvItem;

        ImageItemArticleViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
