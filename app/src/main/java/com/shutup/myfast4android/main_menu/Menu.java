package com.shutup.myfast4android.main_menu;

import android.content.Intent;

/**
 * Created by shutup on 16/2/21.
 */
public class Menu {
    private Intent intent;
    private String title;

    public Menu(String title) {
        this.title = title;
    }

    public Menu(String title, Intent intent) {
        this.title = title;
        this.intent = intent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Intent getIntent() {
        return intent;
    }

    public void setIntent(Intent intent) {
        this.intent = intent;
    }


}
