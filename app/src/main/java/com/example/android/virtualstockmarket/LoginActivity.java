package com.example.android.virtualstockmarket;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    int t=0;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MainActivity ma=new MainActivity();
        if(ma.getRound()!=1)
        {
            Button button=(Button)findViewById(R.id.back);
            button.setVisibility(View.GONE);
        }
    }
    @Override
    public void onBackPressed()
    {
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        return true;
    }
    public void login(View view)
    {
        MainActivity ma=new MainActivity();
        int r=ma.getRound();
        EditText text = (EditText) findViewById(R.id.password);
        String p = text.getText().toString();
        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.audiofile);
        AudioManager am = (AudioManager)getSystemService(Context.AUDIO_SERVICE);
        switch(r)
        {
            case 1:
                if (p.equals("#helloguys")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent= new Intent(this,PortfolioActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a correct password!", Toast.LENGTH_SHORT);
                    toast.show();
                    t++;
                    if(t==3)
                    {
                        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                        mp.start();
                        mp.setLooping(true);
                    }
                }
                break;
            case 2:
                if (p.equals("round2")){
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent= new Intent(this,PortfolioActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a correct password!", Toast.LENGTH_SHORT);
                    toast.show();
                    t++;
                    if(t==3)
                    {
                        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                        mp.start();
                        mp.setLooping(true);
                    }
                }
                break;
            case 3:
                if (p.equals("@vsm2k17")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent= new Intent(this,PortfolioActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(this, "Enter a correct password!", Toast.LENGTH_SHORT);
                    toast.show();
                    t++;
                    if(t==3)
                    {
                        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                        mp.start();
                        mp.setLooping(true);
                    }
                }
                break;
            case 4:
                if (p.equals("aashay")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent= new Intent(this,PortfolioActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(this, "Enter a correct password!", Toast.LENGTH_SHORT);
                    toast.show();
                    t++;
                    if(t==3)
                    {
                        am.setStreamVolume(AudioManager.STREAM_MUSIC, am.getStreamMaxVolume(AudioManager.STREAM_MUSIC), 0);
                        mp.start();
                        mp.setLooping(true);
                    }
                }
                break;
            case 0:
                if (p.equals("bakchodi")) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Successful!", Toast.LENGTH_SHORT);
                    toast.show();
                    ma.setRound();
                    Intent intent= new Intent(this,WelcomeActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "Enter a correct password!", Toast.LENGTH_SHORT);
                    toast.show();
                }
                break;
        }
    }
    public void onClickBack(View view)
    {
        Intent intent=new Intent(this,WelcomeActivity.class);
        startActivity(intent);
    }
}
