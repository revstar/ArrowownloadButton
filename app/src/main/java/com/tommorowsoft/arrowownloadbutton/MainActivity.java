package com.tommorowsoft.arrowownloadbutton;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.fenjuly.library.ArrowDownloadButton;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity  {

    ArrowDownloadButton button;
    int count=0;
    int process=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button= (ArrowDownloadButton) findViewById(R.id.arrow_download_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((count%2)==0){
                    button.startAnimating();
                    Timer timer=new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    process+=1;
                                    button.setProgress(process);
                                }
                            });
                        }
                    },800,20);
                }
            }
        });
    }
}
