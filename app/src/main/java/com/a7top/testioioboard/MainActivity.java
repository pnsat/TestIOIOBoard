package com.a7top.testioioboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import ioio.lib.api.exception.ConnectionLostException;
import ioio.lib.util.BaseIOIOLooper;
import ioio.lib.util.IOIOLooper;
import ioio.lib.util.android.IOIOActivity;

public class MainActivity extends IOIOActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }  // Main Method


    class Looper extends BaseIOIOLooper {

        @Override
        protected void setup() throws ConnectionLostException, InterruptedException {
//            super.setup();

            //Check IOIO Connected
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, "Connected IOIO OK", Toast.LENGTH_LONG).show();
                    Log.d("9AugV1", "connected IOIO OK");
                }
            });


        }   // sutup

        @Override
        public void loop() throws ConnectionLostException, InterruptedException {
//            super.loop();

            try {

                Thread.sleep(100);

            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "e ==> " + e.toString(), Toast.LENGTH_LONG).show();
                Log.d("9AugV1", "e ==> " + e.toString());

            }

        }   //Loop



    }  //Looper Class


    protected IOIOLooper createIOIOLooper() {

        return new Looper();
    }



} //Main Class
