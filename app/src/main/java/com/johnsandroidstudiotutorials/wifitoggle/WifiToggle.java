package com.johnsandroidstudiotutorials.wifitoggle;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class WifiToggle extends AppCompatActivity {

    // Declaring Variables
    WifiManager wifiManager;
    TextView wifiStatusTextView;
    ToggleButton toggleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_toggle);

        // Defining Variables
        wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        wifiStatusTextView = (TextView) findViewById(R.id.wifi_status_text_view);
        toggleButton = (ToggleButton) findViewById(R.id.wifi_toggle_toggle_button);

        /* Checking wifi state.
         * If wifi is enabled, display "wifi is on" and set toggle button to on position.
         * If Wifi is disabled, display "wifi is off" and set toggle button to off position.
         */
        if (wifiManager.isWifiEnabled()) {
            wifiStatusTextView.setText("Wifi is currently ON");
            toggleButton.setChecked(true);
        } else {
            wifiStatusTextView.setText("Wifi is currently OFF");
            toggleButton.setChecked(false);
        }

        /* adds listener to toggle button
         * If toggle is checked, wifi is enabled and "Wifi is on" is displayed.
         * If toggle is unchecked, wifi is enabled and "Wifi is off" is displayed.
         */
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                    wifiStatusTextView.setText("Wifi is currently ON");
                    Toast.makeText(WifiToggle.this, "Wifi may take a moment to turn on", Toast.LENGTH_LONG).show();
                } else {
                    wifiManager.setWifiEnabled(false);
                    wifiStatusTextView.setText("Wifi is currently OFF");
                }
            }
        });

    }
}