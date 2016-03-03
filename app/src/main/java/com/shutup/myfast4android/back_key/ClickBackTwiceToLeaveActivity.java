package com.shutup.myfast4android.back_key;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.TextView;
import android.widget.Toast;

import com.shutup.myfast4android.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ClickBackTwiceToLeaveActivity extends AppCompatActivity {

    boolean isQuit = false;
    @Bind(R.id.pressKeyInfo)
    TextView pressKeyInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_back_twice_to_leave);
        ButterKnife.bind(this);
    }


    @Override
    public void onBackPressed() {
        if (isQuit) {
            pressKeyInfo.setText("second press!");
            super.onBackPressed();
        } else {
            pressKeyInfo.setText("first press!");
            Toast toast = Toast.makeText(getApplicationContext(), "back key clicked!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
            isQuit = true;
            Handler handler = new Handler(Looper.getMainLooper());
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isQuit = false;
                    pressKeyInfo.setText("");
                }
            }, 2000);
        }

    }
}
