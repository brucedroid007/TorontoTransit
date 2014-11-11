//Package
package com.gregorywlodarek.torontotransit.torontotransit;

//Imports
import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;



/**
 * Page that holds the subway map in MISC
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class SubwayMap extends Activity
{

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subway_map);
        ZoomableImageView touch = (ZoomableImageView)findViewById(R.id.subwayMap);
        touch.setImageBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.subwaymap));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


}
