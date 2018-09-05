package aaa.xplo.ekushlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xlib.ekush.MyBanglaSupport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //MyBanglaSupport.isDeviceSupportBangla();
    }
}
