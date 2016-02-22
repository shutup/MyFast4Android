package com.shutup.myfast4android.toast_demo;

import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.shutup.myfast4android.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ToastDemoActivity extends AppCompatActivity {

    @Bind(R.id.toast_with_pic)
    Button toastWithPic;
    @Bind(R.id.toast_normal_short)
    Button toastNormalShort;
    @Bind(R.id.toast_normal_long)
    Button toastNormalLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast_demo);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.toast_normal_short, R.id.toast_normal_long, R.id.toast_with_pic})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toast_with_pic:
                LayoutInflater layoutInflater = LayoutInflater.from(this);
                View toastView = layoutInflater.inflate(R.layout.toast_with_pic_layout,null);
                Toast toast = new Toast(this);
                toast.setView(toastView);
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.toast_normal_short:
                Toast.makeText(this, "short :" + getResources().getText(R.string.toastDemoNormalShort), Toast.LENGTH_SHORT).show();
                break;
            case R.id.toast_normal_long:
                Toast.makeText(this, "long :" + getResources().getText(R.string.toastDemoNormalLong), Toast.LENGTH_LONG).show();
                break;
        }
    }
}
