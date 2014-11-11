//Package
package com.gregorywlodarek.torontotransit.torontotransit;

//Imports
import android.app.Activity;
import android.os.Bundle;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

/**
 * Page that has all of the latest TTC alerts in the MISC tab.
 *
 * @version 1.0
 * @author Grzegorz Wlodarek
 */
public class TTCAlerts extends Activity {
    private static TextView alertsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttcalerts);

        alertsText = (TextView) findViewById(R.id.alertsText);
        alertsText.setMovementMethod(new ScrollingMovementMethod());
        new TTCAlertsResult();
    }

    public static void setAlertsText(String s) {
        alertsText.setText(s);
    }

    public static void setAlertsText(Spanned s) {
        alertsText.setText(s);
    }

    public static String getAlertsText() {
        return alertsText.getText().toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }
}
