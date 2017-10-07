package com.example.android.virtualstockmarket;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class PortfolioActivity extends MainActivity {

    static int st1,st2,st3,st4,st5,st6;
    static int lpr,lps;
    static String s1="egg",s2="md",s3="eeg",s4="d",s5="efl",s6="eel",os1="d",os2="d",os3="d",os4="d",os5="d",os6="d";
    final int i1=1,i2=2,i3=3,i4=4,i5=5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio);
        String round="Round ";
        int r=getRound();
        switch(r)
        {
            case i1:
                TextView rounds1=(TextView) findViewById(R.id.textView2);
                rounds1.setText(round+r);
                LinearLayout ll=(LinearLayout) findViewById(R.id.cyborg_layout);
                ll.setVisibility(View.GONE);
                break;
            case i2:
                TextView rounds2=(TextView) findViewById(R.id.textView2);
                rounds2.setText(round+r);
                prevValue2();
                break;
            case i3:
                TextView rounds3=(TextView) findViewById(R.id.textView2);
                rounds3.setText(round+r);
                prevValue3();
                break;
            case i4:
                TextView rounds4=(TextView) findViewById(R.id.textView2);
                rounds4.setText(round+r);
                prevValue4();
                break;
        }
        init();
        new CountDownTimer(150000, 1000)
        {
            TextView mTextField = (TextView) findViewById(R.id.timer_text_view) ;
            public void onTick(long millisUntilFinished)
            {
                mTextField.setText("SECONDS REMAINING: " + millisUntilFinished / 1000);
            }
            public void onFinish()
            {
                setValues();
                calcProfit();
                setColor();
                finish();
            }
        }.start();
    }
    @Override
    public void onBackPressed()
    {
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        return true;
    }
    public void init()
    {
        TextView t;
        money=getMoney();
        int r=getRound();
        pps1=values(s1);
        pps2=values(s2);
        pps3=values(s3);
        pps4=values(s4);
        pps5=values(s5);
        pps6=values(s6);
        if(appInstalledOrNot("com.winit.starnews.hin") && getRound()==3)
        {
            money+=1000;
            netWorth+=1000;
            Toast toast = Toast.makeText(getApplicationContext(), "$1,000.00 added for ABP Live", Toast.LENGTH_SHORT);
            toast.show();
        }
        if(appInstalledOrNot("com.njlabs.showjava"))
        {
            money=0;
            Toast toast = Toast.makeText(getApplicationContext(), "Uninstall the decompiler", Toast.LENGTH_SHORT);
            toast.show();
        }
        setTextCol(R.id.pps1,values(s1),values(os1));
        setTextCol(R.id.pps2,values(s2),values(os2));
        setTextCol(R.id.pps3,values(s3),values(os3));
        setTextCol(R.id.pps4,values(s4),values(os4));
        setTextCol(R.id.pps5,values(s5),values(os5));
        setTextCol(R.id.pps6,values(s6),values(os6));
        displayMoney(R.id.textView3,money);
        displayMoney(R.id.pps1,(((~pps1)+1)*-1));
        displayMoney(R.id.pps2,(((~pps2)+1)*-1));
        displayMoney(R.id.pps3,(((~pps3)+1)*-1));
        displayMoney(R.id.pps4,(((~pps4)+1)*-1));
        displayMoney(R.id.pps5,(((~pps5)+1)*-1));
        displayMoney(R.id.pps6,(((~pps6)+1)*-1));
        displayStock(R.id.stock_Left1,st1);
        displayStock(R.id.stock_Left2,st2);
        displayStock(R.id.stock_Left3,st3);
        displayStock(R.id.stock_Left4,st4);
        displayStock(R.id.stock_Left5,st5);
        displayStock(R.id.stock_Left6,st6);
        switch(r)
        {
            case i1:
                setValuesForRound2();
                setLimitForRound(60,20);
                break;
            case i2:
                setValuesForRound3();
                setLimitForRound(80,30);
                break;
            case i3:
                setValuesForRound4();
                setLimitForRound(100,40);
                break;
            case i4:
                setValuesForRound5();
                setLimitForRound(120,50);
                break;
        }
        if(getRound()!=4)
        {
            String max1="MAX LIMIT PER ROUND: "+lpr+" ";
            String max2="MAX LIMIT PER STOCK: "+lps+" ";
            t=(TextView) findViewById(R.id.max_limit);
            t.setText(max1);
            t=(TextView) findViewById(R.id.max_limit1);
            t.setText(max2);
        }
        else
        {
            String max1="MAX LIMIT PER ROUND: no limit ";
            String max2="MAX LIMIT PER STOCK: no limit ";
            t=(TextView) findViewById(R.id.max_limit);
            t.setText(max1);
            t=(TextView) findViewById(R.id.max_limit1);
            t.setText(max2);
        }
    }
    public void setColor()
    {
        Intent a=new Intent(this,ColorActivity.class);
        startActivity(a);
    }
    public int getStock(int Rid)
    {
        EditText et=(EditText) findViewById(Rid);
        return Integer.parseInt(et.getText().toString());
    }
    public void increaseStock1()
    {
        if(checkLimitForMoney(money-getStock(R.id.stock1)*pps1))
        {
            if(getRound()!=4)
            {
                if(checkLimitForBuying(st1+st2+st3+st4+st5+st6+getStock(R.id.stock1),st1+getStock(R.id.stock1)) && getRound()!=4)
                {
                    st1=st1+getStock(R.id.stock1);
                    money=money-getStock(R.id.stock1)*pps1;
                }
            }
            else
            {
                st1=st1+getStock(R.id.stock1);
                money=money-getStock(R.id.stock1)*pps1;
            }
        }
        displayStock(R.id.stock_Left1,st1);
    }
    public void increaseStock2()
    {
        if(checkLimitForMoney(money-getStock(R.id.stock2)*pps2))
        {
            if(getRound()!=4)
            {
                if(checkLimitForBuying(st1+st2+st3+st4+st5+st6+getStock(R.id.stock2),st2+getStock(R.id.stock2)))
                {
                    money=money-getStock(R.id.stock2)*pps2;
                    st2=st2+getStock(R.id.stock2);
                }
            }
            else
            {
                money=money-getStock(R.id.stock2)*pps2;
                st2=st2+getStock(R.id.stock2);
            }
        }
        displayStock(R.id.stock_Left2,st2);
    }
    public void increaseStock3()
    {
        if(checkLimitForMoney(money-getStock(R.id.stock3)*pps3))
        {
            if(getRound()!=4)
            {
                if(checkLimitForBuying(st1+st2+st3+st4+st5+st6+getStock(R.id.stock3),st3+getStock(R.id.stock3)) && getRound()!=4)
                {
                    st3=st3+getStock(R.id.stock3);
                    money=money-getStock(R.id.stock3)*pps3;
                }
            }
            else
            {
                st3=st3+getStock(R.id.stock3);
                money=money-getStock(R.id.stock3)*pps3;
            }
        }
        displayStock(R.id.stock_Left3,st3);
    }
    public void increaseStock4()
    {
        if(checkLimitForMoney(money-getStock(R.id.stock4)*pps4))
        {
            if(getRound()!=4)
            {
                if(checkLimitForBuying(st1+st2+st3+st4+st5+st6+getStock(R.id.stock4),st4+getStock(R.id.stock4)) && getRound()!=4)
                {
                    st4=st4+getStock(R.id.stock4);
                    money=money-getStock(R.id.stock4)*pps4;
                }
            }
            else
            {
                st4=st4+getStock(R.id.stock4);
                money=money-getStock(R.id.stock4)*pps4;
            }
        }
        displayStock(R.id.stock_Left4,st4);
    }
    public void increaseStock5()
    {
        if(checkLimitForMoney(money-getStock(R.id.stock5)*pps5))
        {
            if(getRound()!=4)
            {
                if(checkLimitForBuying(st1+st2+st3+st4+st5+st6+getStock(R.id.stock5),st5+getStock(R.id.stock5)) && getRound()!=4)
                {
                    st5=st5+getStock(R.id.stock5);
                    money=money-getStock(R.id.stock5)*pps5;
                }
            }
            else
            {
                st5=st5+getStock(R.id.stock5);
                money=money-getStock(R.id.stock5)*pps5;
            }
        }
        displayStock(R.id.stock_Left5,st5);
    }
    public void increaseStock6()
    {
        if(checkLimitForMoney(money-getStock(R.id.stock6)*pps6))
        {
            if(getRound()!=4)
            {
                if(checkLimitForBuying(st1+st2+st3+st4+st5+st6+getStock(R.id.stock6),st6+getStock(R.id.stock6)) && getRound()!=4)
                {
                    st6=st6+getStock(R.id.stock6);
                    money=money-getStock(R.id.stock6)*pps6;
                }
            }
            else
            {
                st6=st6+getStock(R.id.stock6);
                money=money-getStock(R.id.stock6)*pps6;
            }
        }
        displayStock(R.id.stock_Left6,st6);
    }
    public void decreaseStock1()
    {
        if(checkLimitForSelling(st1-getStock(R.id.stock1)))
        {
            st1=st1-getStock(R.id.stock1);
            money=money+getStock(R.id.stock1)*pps1;
        }
        displayStock(R.id.stock_Left1,st1);
    }
    public void decreaseStock2()
    {
        if(checkLimitForSelling(st2-getStock(R.id.stock2)))
        {
            st2=st2-getStock(R.id.stock2);
            money=money+getStock(R.id.stock2)*pps2;
        }
        displayStock(R.id.stock_Left2,st2);
    }
    public void decreaseStock3()
    {
        if(checkLimitForSelling(st3-getStock(R.id.stock3)))
        {
            st3=st3-getStock(R.id.stock3);
            money=money+getStock(R.id.stock3)*pps3;
        }
        displayStock(R.id.stock_Left3,st3);
    }
    public void decreaseStock4()
    {
        if(checkLimitForSelling(st4-getStock(R.id.stock4)))
        {
            st4=st4-getStock(R.id.stock4);
            money=money+getStock(R.id.stock4)*pps4;
        }
        displayStock(R.id.stock_Left4,st4);
    }
    public void decreaseStock5()
    {
        if(checkLimitForSelling(st5-getStock(R.id.stock5)))
        {
            st5=st5-getStock(R.id.stock5);
            money=money+getStock(R.id.stock5)*pps5;
        }
        displayStock(R.id.stock_Left5,st5);
    }
    public void decreaseStock6()
    {
        if(checkLimitForSelling(st6-getStock(R.id.stock6)))
        {
            st6=st6-getStock(R.id.stock6);
            money=money+getStock(R.id.stock6)*pps6;
        }
        displayStock(R.id.stock_Left6,st6);
    }
    public void onClickBuy1(View view)
    {
        if(checkStock(R.id.stock1))
        {
            increaseStock1();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickBuy2(View view)
    {
        if(checkStock(R.id.stock2))
        {
            increaseStock2();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickBuy3(View view)
    {
        if(checkStock(R.id.stock3))
        {
            increaseStock3();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickBuy4(View view)
    {
        if(checkStock(R.id.stock4))
        {
            increaseStock4();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickBuy5(View view)
    {
        if(checkStock(R.id.stock5))
        {
            increaseStock5();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickBuy6(View view)
    {
        if(checkStock(R.id.stock6))
        {
            increaseStock6();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickSell1(View view)
    {
        if(checkStock(R.id.stock1))
        {
            decreaseStock1();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickSell2(View view)
    {
        if(checkStock(R.id.stock2))
        {
            decreaseStock2();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickSell3(View view)
    {
        if(checkStock(R.id.stock3))
        {
            decreaseStock3();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickSell4(View view)
    {
        if(checkStock(R.id.stock4))
        {
            decreaseStock4();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickSell5(View view)
    {
        if(checkStock(R.id.stock5))
        {
            decreaseStock5();
            displayMoney(R.id.textView3,money);
        }
    }
    public void onClickSell6(View view)
    {
        if(checkStock(R.id.stock6))
        {
            decreaseStock6();
            displayMoney(R.id.textView3,money);
        }
    }
    public void setLimitForRound(int limitPerRound,int limitPerStock)
    {
        lpr=limitPerRound;
        lps=limitPerStock;
    }
    public void displayStock(int Rid,int s)
    {
        TextView t=(TextView) findViewById(Rid);
        t.setText("# "+s);
    }
    public void displayMoney(int Rid,int s)
    {
        TextView t=(TextView) findViewById(Rid);
        t.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                .format(s));
    }
    public boolean checkLimitForBuying(int s1,int s2)
    {
        if(s1>=0 && s1<=lpr && s2>=0 && s2<=lps)
        {
            return true;
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Limit exceeded", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }
    public boolean checkLimitForSelling(int s)
    {
        if(s>=0)
        {
            return true;
        }
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Limit exceeded", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }
    public boolean checkLimitForMoney(int s)
    {
        if(s>=0)
            return true;
        else
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Check money!!", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
    }
    public boolean checkStock(int Rid)
    {
        EditText et=(EditText)findViewById(Rid);
        if(et.getText().toString().equals(""))
        {
            Toast toast = Toast.makeText(getApplicationContext(), "Check input!!", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        else
            return true;
    }
    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
    public void calcProfit()
    {
        profit=((values(s1)-pps1)*st1+(values(s2)-pps2)*st2+(values(s3)-pps3)*st3+(values(s4)-pps4)*st4+(values(s5)-pps5)*st5+(values(s6)-pps6)*st6);
        netWorth+=profit;
    }
    public void setValuesForRound2()
    {
        s1="jg";
        s2="mf";
        s3="eek";
        s4="edk";
        s5="ejj";
        s6="edf";
    }
    public void setValuesForRound5()
    {
        s1="jd";
        s2="ml";
        s3="ii";
        s4="ii";
        s5="jl";
        s6="emd";
    }
    public void setValuesForRound4()
    {
        s1="jd";
        s2="mj";
        s3="eji";
        s4="eig";
        s5="egl";
        s6="lf";
    }
    public void setValuesForRound3()
    {
        s1="lg";
        s2="mh";
        s3="eim";
        s4="egk";
        s5="egh";
        s6="mf";
    }
    public void setValues()
    {
        int r=getRound();
        switch(r)
        {
            case i1:
                setValuesForRound2();
                break;
            case i2:
                setValuesForRound3();
                break;
            case i3:
                setValuesForRound4();
                break;
            case i4:
                setValuesForRound5();
                break;
        }
    }
    public void setTextCol(int r,int newVal,int oldVal)
    {
        TextView tv=(TextView)findViewById(r);
        if(getRound()!=1)
        {
            if(newVal<oldVal && oldVal!=0)
                tv.setTextColor(Color.parseColor("#f44336"));
            else if(newVal>oldVal && oldVal!=0)
                tv.setTextColor(Color.parseColor("#4caf50"));
            else
                tv.setTextColor(Color.parseColor("#ffffff"));
        }
    }
    public void prevValue2()
    {
        os1="egg";
        os2="md";
        os3="eeg";
        os4="d";
        os5="efl";
        os6="eel";
    }
    public void prevValue3()
    {
        os1="jg";
        os2="mf";
        os3="eek";
        os4="edk";
        os5="ejj";
        os6="edf";
    }
    public void prevValue4()
    {
        os1="lg";
        os2="mh";
        os3="eim";
        os4="egk";
        os5="egh";
        os6="mf";
    }
}


