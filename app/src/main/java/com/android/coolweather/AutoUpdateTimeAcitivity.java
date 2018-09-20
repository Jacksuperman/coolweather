package com.android.coolweather;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.coolweather.service.AutoUpdateService;


public class AutoUpdateTimeAcitivity extends AppCompatActivity implements View.OnClickListener{
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button5;
    private Button button10;
    private Button button0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_update_time);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("更新频率");
        }
        button0 = (Button)findViewById(R.id.hour0);
        button1 =(Button)findViewById(R.id.hour1);
        button2 = (Button)findViewById(R.id.hour2);
        button3 = (Button)findViewById(R.id.hour3);
        button5 = (Button)findViewById(R.id.hour5);
        button10 = (Button)findViewById(R.id.hour10);
        button0.setOnClickListener(this);
        button2.setOnClickListener(this);
        button1.setOnClickListener(this);
        button3.setOnClickListener(this);
        button5.setOnClickListener(this);
        button10.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this)
                .edit();
        switch (view.getId()){
            case R.id.hour0:
                editor.putBoolean("isUpdateTime", false);
                break;
            case R.id.hour1:
                editor.putBoolean("isUpdateTime",true);
                editor.putInt("autoUpdateTime", 60);
                break;
            case R.id.hour2:
                editor.putBoolean("isUpdateTime",true);
                editor.putInt("autoUpdateTime", 120);
                break;
            case R.id.hour3:
                editor.putBoolean("isUpdateTime",true);
                editor.putInt("autoUpdateTime", 180);
                break;
            case R.id.hour5:
                editor.putBoolean("isUpdateTime",true);
                editor.putInt("autoUpdateTime", 300);
                break;
            case R.id.hour10:
                editor.putBoolean("isUpdateTime",true);
                editor.putInt("autoUpdateTime", 600);
                break;
            default:

        }
        editor.apply();
        Intent intent = new Intent(this, AutoUpdateService.class);
        startService(intent);
        Toast.makeText(AutoUpdateTimeAcitivity.this,"设置成功",Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
            default:
        }
        return true;
    }
}
