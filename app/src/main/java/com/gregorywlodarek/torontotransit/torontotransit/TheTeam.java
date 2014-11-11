//Package
package com.gregorywlodarek.torontotransit.torontotransit;

//Imports
import android.app.Activity;
import android.os.Bundle;

/**
 * Page that holds the team info.
 * No longer used since version 1.1
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class TheTeam extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }


}
