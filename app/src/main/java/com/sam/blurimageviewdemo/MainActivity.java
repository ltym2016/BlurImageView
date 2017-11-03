package com.sam.blurimageviewdemo;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.facebook.drawee.view.SimpleDraweeView;
import com.sam.blurimage.view.BlurImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BlurImageView biv_test = (BlurImageView)findViewById(R.id.biv_test);
        biv_test.setRadius(40);
        String url = "res://" + this.getPackageName() + "/" + R.mipmap.test;
        biv_test.setImageUrl(url,true);
    }
}
