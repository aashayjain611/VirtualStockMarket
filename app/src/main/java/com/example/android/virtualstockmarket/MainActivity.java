package com.example.android.virtualstockmarket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    static int i,money=10000,profit,pps1,pps2,pps3,pps4,pps5,pps6;
    static int netWorth=10000;
    String prev_value[]= {"12345","23456","34567","45678","56789"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onBackPressed()
    {
    }
    void setRound()
    {
        MainActivity ma=new MainActivity();
        ma.i+=1;
    }
    int getRound()
    {
        MainActivity ma=new MainActivity();
        return ma.i;
    }
    public void onClickNext(View view)
    {
        Intent a=new Intent(this,LoginActivity.class);
        startActivity(a);
        finish();
    }
    public int getMoney()
    {
        return money;
    }
    public int values(String str)
    {
        int i=0;
        for(int j=0;j<str.length();j++)
        {
            i=i*10;
            i+=(~(str.charAt(j)-100)+1)*-1;
        }
        return i;
    }
}
