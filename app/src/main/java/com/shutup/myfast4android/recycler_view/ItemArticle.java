package com.shutup.myfast4android.recycler_view;

/**
 * Created by shutup on 16/2/21.
 */
public class ItemArticle {
    private int index;
    private String imageUrl;
    private String title;
    private String publishDate;
    private String source;
    private int readTimes;
    private String preview;

    public ItemArticle(int index, String imageUrl, String title, String publishDate, String source, int readTimes, String preview) {
        this.index = index;
        this.imageUrl = imageUrl;
        this.title = title;
        this.publishDate = publishDate;
        this.source = source;
        this.readTimes = readTimes;
        this.preview = preview;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getReadTimes() {
        return readTimes;
    }

    public void setReadTimes(int readTimes) {
        this.readTimes = readTimes;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }
}
