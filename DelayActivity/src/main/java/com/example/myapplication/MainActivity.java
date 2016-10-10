package com.example.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private long openTime= 30000L;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView= (TextView) findViewById(R.id.tv_delay_open);
        countDownTimer.start();
    }
    //倒计时10S 每隔1秒就会调用onTick

    private CountDownTimer countDownTimer=new CountDownTimer(openTime,1000) {
        @Override
        public void onTick(long l) {
            textView.setText(formatDuring(l));
            openTime=l;
            Log.e("CrazyMO", String.valueOf(l / 1000));
        }

        @Override
        public void onFinish() {
            Log.e("CrazyMO","Finish?");
        }
    };

    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " days " + hours + " hours " + minutes + " minutes "
                + seconds + " seconds ";
    }

    /**
     *
     * @param begin 时间段的开始
     * @param end   时间段的结束
     * @return  输入的两个Date类型数据之间的时间间格用* days * hours * minutes * seconds的格式展示
     */
    public static String formatDuring(Date begin, Date end) {
        return formatDuring(end.getTime() - begin.getTime());
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        new CountDownTimer(openTime,1000) {
            @Override
            public void onTick(long l) {
                textView.setText(formatDuring(l));
                Log.e("CrazyMO", String.valueOf(l / 1000));
            }

            @Override
            public void onFinish() {
                Log.e("CrazyMO","Finish?");
            }
        }.start();
    }
}
