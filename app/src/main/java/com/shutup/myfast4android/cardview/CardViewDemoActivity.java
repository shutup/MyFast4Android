package com.shutup.myfast4android.cardview;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.shutup.myfast4android.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CardViewDemoActivity extends AppCompatActivity {

    @Bind(R.id.radius_label)
    TextView radiusLabel;
    @Bind(R.id.corner_radius_seek_bar)
    SeekBar cornerRadiusSeekBar;
    @Bind(R.id.elevation_label)
    TextView elevationLabel;
    @Bind(R.id.elevation_seek_bar)
    SeekBar elevationSeekBar;
    @Bind(R.id.alpha_label)
    TextView alphaLabel;
    @Bind(R.id.alpha_seek_bar)
    SeekBar alphaSeekBar;
    @Bind(R.id.color_label)
    TextView colorLabel;
    @Bind(R.id.def)
    RadioButton def;
    @Bind(R.id.red)
    RadioButton red;
    @Bind(R.id.blue)
    RadioButton blue;
    @Bind(R.id.select_bg_color_radio)
    RadioGroup selectBgColorRadio;
    @Bind(R.id.face)
    ImageView face;
    @Bind(R.id.msg)
    ImageView msg;
    @Bind(R.id.cardView)
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_demo);
        ButterKnife.bind(this);
        initViews();
    }

    private void initViews() {
        cornerRadiusSeekBar.setProgress((int) cardView.getRadius());
        cornerRadiusSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        radiusLabel.setText(getResources().getText(R.string.Radius).toString() + " :" + cornerRadiusSeekBar.getProgress());

        elevationSeekBar.setProgress((int) cardView.getCardElevation());
        elevationSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        elevationLabel.setText(getResources().getText(R.string.Elevation).toString()+ " :" + elevationSeekBar.getProgress());

        alphaSeekBar.setProgress((int) (ViewCompat.getAlpha(cardView) * 255.f));
        alphaSeekBar.setOnSeekBarChangeListener(seekBarChangeListener);
        alphaLabel.setText(getResources().getText(R.string.Alpha).toString() +" :" + alphaSeekBar.getProgress() / 255.f);

        selectBgColorRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                cardView.setCardBackgroundColor(getResources().getColor( getColorId(checkedId)));
            }
        });

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            switch (seekBar.getId()){
                case R.id.corner_radius_seek_bar:
                    cardView.setRadius(progress);
                    radiusLabel.setText(getResources().getText(R.string.Radius).toString() + " :" + cornerRadiusSeekBar.getProgress());
                    break;
                case R.id.elevation_seek_bar:
                    cardView.setCardElevation(progress);
                    elevationLabel.setText(getResources().getText(R.string.Elevation).toString()+ " :" + elevationSeekBar.getProgress());
                    break;
                case R.id.alpha_seek_bar:
                    ViewCompat.setAlpha(cardView,progress /255.f);
                    alphaLabel.setText(getResources().getText(R.string.Alpha).toString() + " :" + alphaSeekBar.getProgress() / 255.f);
                    break;
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private int getColorId(int id) {
        switch (id) {

            case R.id.red:
                return R.color.card_red;
            case R.id.blue:
                return R.color.card_blue;

            default:
                return R.color.cardview_light_background;
        }
    }
}
