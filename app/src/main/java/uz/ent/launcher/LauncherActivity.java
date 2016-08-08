package uz.ent.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import uz.ent.serialportapi.SerialPort;
import uz.ent.serialportapi.SerialPortFinder;


public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

    }

    @Override
    public void onResume() {
        super.onResume();
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public void fullClick(View v) {
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
    }

    public void rebootClick(View v) {
        SerialPortFinder serialPortFinder = new SerialPortFinder();
        String[] sAllDevices = serialPortFinder.getAllDevices();
        String[] sAllDevicesPath = serialPortFinder.getAllDevicesPath();

        for (int i = 0; i < sAllDevicesPath.length; i++) {
            System.out.println(sAllDevicesPath[i]);
        }

        try {
            SerialPort mSerialPort = new SerialPort(new File("/dev/ttyS0"), 9600, 0);
            OutputStream outputStream = mSerialPort.getOutputStream();
            InputStream inputStream = mSerialPort.getInputStream();


        } catch (IOException e) {
            e.printStackTrace();
        }
//
//        OutputStream outputStream = mSerialPort.getOutputStream();
//        InputStream inputStream = mSerialPort.getInputStream();


//        UsbDevice device = deviceList.get("deviceName");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            // your code
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }
}
