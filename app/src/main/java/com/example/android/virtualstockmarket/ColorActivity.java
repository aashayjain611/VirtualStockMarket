package com.example.android.virtualstockmarket;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.text.NumberFormat;
import java.util.Locale;

import static android.R.attr.key;
import static android.icu.text.RelativeDateTimeFormatter.Direction.NEXT;

public class ColorActivity extends MainActivity {

    int i=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        setBackColor();
        setRound();
        TextView t=(TextView)findViewById(R.id.note);
        t.setText("note: please don't press \"NEXT\" key unless told");
    }
    @Override
    public void onBackPressed()
    {
    }
    public void setBackColor()
    {
        int r=getRound();
        switch(r)
        {
            case 1:
                if(profit>=600)
                    setColor("#ffeb3b");
                else if(profit>=300)
                    setColor("#2196f3");
                else if(profit>=0)
                    setColor("#4caf50");
                else
                    setColor("#f44336");
                break;
            case 2:
                if(profit>=1400)
                    setColor("#4caf50");
                else if(profit>=500)
                    setColor("#ffeb3b");
                else if(profit>=0)
                    setColor("#2196f3");
                else
                    setColor("#f44336");
                break;
            case 3:
                if(profit>=600)
                    setColor("#2196f3");
                else if(profit>=300)
                    setColor("#4caf50");
                else if(profit>=0)
                    setColor("#ffeb3b");
                else
                    setColor("#f44336");
                break;
            case 4:
                if(profit>=12000)
                    setColor("#f44336");
                else if(profit>=6000)
                    setColor("#ffeb3b");
                else if(profit>=0)
                    setColor("#2196f3");
                else
                    setColor("#4caf50");
                break;
        }
    }
    public void next(View view)
    {
        TextView t;
        if(i==2)
        {
            if(profit>=0)
            {
                t=(TextView) findViewById(R.id.profit_text_view);
                t.setText("Profit");
                t=(TextView) findViewById(R.id.number_text_view);
                t.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                        .format(profit));
                t=(TextView) findViewById(R.id.money_text_view);
                t.setText("Net Worth");
                t=(TextView)findViewById(R.id.amount);
                t.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                        .format(netWorth));
                i++;
            }
            else
            {
                t=(TextView) findViewById(R.id.profit_text_view);
                t.setText("Loss");
                t=(TextView) findViewById(R.id.number_text_view);
                t.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                        .format(profit*-1));
                t=(TextView) findViewById(R.id.money_text_view);
                t.setText("Net Worth");
                t=(TextView)findViewById(R.id.amount);
                t.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US"))
                        .format(netWorth));
                i++;
            }
        }
        else if(i==3)
        {
            if(getRound()==5)
            {
                Intent a=new Intent(this,ThankyouActivity.class);
                startActivity(a);
            }
            else
            {
                Intent a=new Intent(this,LoginActivity.class);
                startActivity(a);
            }
            finish();
        }
    }
    public void setColor(String str)
    {
        RelativeLayout r=(RelativeLayout)findViewById(R.id.color);
        r.setBackgroundColor(Color.parseColor(str));
        i++;
    }
}