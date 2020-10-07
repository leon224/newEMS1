package com.example.ycx36.newems.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ycx36.newems.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class activity_from_carHistory_vcu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_from_car_history_vcu);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.RL_1,R.id.tv_header_back})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.RL_1:
                startActivity(new Intent(activity_from_carHistory_vcu.this,DataChartActivity.class));
                break;

            case R.id.tv_header_back:
                finish();
                break;
        }
    }
}