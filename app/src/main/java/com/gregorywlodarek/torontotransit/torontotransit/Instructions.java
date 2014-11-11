package com.gregorywlodarek.torontotransit.torontotransit;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;

/**
 * Contains the information on how to use the application.
 * This page is no longer accessible since version 1.1
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class Instructions extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.instructions);

        ZoomableImageView touch = (ZoomableImageView)findViewById(R.id.instructionsImage);
        touch.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.guide));

    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
