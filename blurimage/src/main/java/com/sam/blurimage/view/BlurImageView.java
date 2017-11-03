package com.sam.blurimage.view;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.sam.blurimage.blur.BlurPostprocessor;

/**
 * Created by sam on 2017/11/3.
 */

public class BlurImageView extends SimpleDraweeView {

    private BlurPostprocessor processor;
    private Context mContext;
    private int radius = 25;// default 25

    public BlurImageView(Context context) {
        this(context, null);
    }

    public BlurImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mContext = context;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setImageUrl(String url, boolean isOpenBlur) {

        try {
            if (isOpenBlur) {
                processor = new BlurPostprocessor(mContext);
                processor.setMaxRadius(radius);
                ImageRequest request =
                        ImageRequestBuilder.newBuilderWithSource(Uri.parse(url))
                                .setPostprocessor(processor)
                                .build();
                PipelineDraweeController controller =
                        (PipelineDraweeController) Fresco.newDraweeControllerBuilder()
                                .setImageRequest(request)
                                .setOldController(this.getController())
                                .build();
                this.setController(controller);
            } else {
                this.setImageURI(Uri.parse(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
