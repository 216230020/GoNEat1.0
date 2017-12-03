package com.example.administrator.goneat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int tv1 = 0;
    int tv2 = 0;
    int tv3 = 0;
    int tv4 = 0;
    TextView mMainText1,mMainText2, mMainText3, mBackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainText1 = (TextView)findViewById(R.id.tv1);
        mMainText2 = (TextView)findViewById(R.id.tv2);
        mMainText3 = (TextView)findViewById(R.id.tv3);
        mBackText = (TextView)findViewById(R.id.tv4);

        BackRunnable runnable = new BackRunnable();
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
    }

    public void mOnClick(View v){
        tv1++;
        mMainText1.setText("추천 수: " + tv1);
        mBackText.setText("어플 실행 시간: " + tv4);
    }
    public void mOnClick2(View v){
        tv2++;
        mMainText2.setText("추천 수: " + tv2);
        mBackText.setText("어플 실행 시간: " + tv4);
    }
    public void mOnClick3(View v){
        tv3++;
        mMainText3.setText("추천 수: " + tv3);
        mBackText.setText("어플 실행 시간: " + tv4);
    }

    class BackRunnable implements Runnable{
        public void run(){
            while (true){
                tv4++;
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){;}
            }
        }
    }

    public void nextScene( View view ){
        Intent i = new Intent(this, Main2Activity.class);
        this.startActivity( i );
    }
    public void nextScene2( View view ){
        Intent i = new Intent(this, Main3Activity.class);
        this.startActivity( i );
    }
    public void nextScene3( View view ){
        Intent i = new Intent(this, Main4Activity.class);
        this.startActivity( i );
    }
}
