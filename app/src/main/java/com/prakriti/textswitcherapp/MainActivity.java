package com.prakriti.textswitcherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextSwitcher;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
// Text Switcher can switch between two strings

    private String texts[] = new String[] {"The First String", "The Second String"};
    private TextSwitcher textSwitcher;

    // for fonts
    Typeface myFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myFont = Typeface.createFromAsset(getAssets(), "fonts/CaneletterScript_PersonalUse.otf");

        textSwitcher = findViewById(R.id.textSwitcher);
        ImageButton btnNextImage = findViewById(R.id.btnNextImage);
        ImageButton btnPreviousImage = findViewById(R.id.btnPreviousImage);

        btnNextImage.setOnClickListener(this);
        btnPreviousImage.setOnClickListener(this);

        // add textview to text switcher, put this in a separate method for multiple text switchers
        for (int i = 0; i < texts.length; i++) {
            TextView textView = new TextView(this);
            textView.setText(texts[i]);
            textView.setTextSize(60);
            textView.setPadding(50, 50, 50 ,50);
            textView.setTextColor(Color.MAGENTA);
            textView.setTypeface(myFont);
            textSwitcher.addView(textView);
        }

        textSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        textSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnNextImage:
                textSwitcher.showNext();
                break;
            case R.id.btnPreviousImage:
                textSwitcher.showPrevious();
                break;
        }
    }
}