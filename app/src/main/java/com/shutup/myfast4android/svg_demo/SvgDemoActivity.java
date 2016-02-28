package com.shutup.myfast4android.svg_demo;

import android.os.Bundle;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.shutup.myfast4android.R;
import com.shutup.myfast4android.common.BaseActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SvgDemoActivity extends BaseActivity {

    @Bind(R.id.svgImg)
    ImageView svgImg;
    @Bind(R.id.svgImgTextView)
    TextView svgImgTextView;
    @Bind(R.id.edittext_without_svg)
    EditText edittextWithoutSvg;
    @Bind(R.id.edittext_with_svg)
    EditText edittextWithSvg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg_demo);
        ButterKnife.bind(this);

        VectorDrawableCompat vectorDrawableCompat = VectorDrawableCompat.create(getResources(), R.drawable.girl, getTheme());
//        svgImg.setImageDrawable(vectorDrawableCompat);
        vectorDrawableCompat.setBounds(0, 0, getResources().getDimensionPixelSize(R.dimen.edittext_drawable_size), getResources().getDimensionPixelSize(R.dimen.edittext_drawable_size));
        edittextWithSvg.setCompoundDrawables(vectorDrawableCompat, null, null, null);
    }
}
