package com.example.sculptorj;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    ImageView sculpture;
    public int count = 999999;
    int score_gold = 0;
    ProgressBar pb;
    private SharedPreferences count_pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window w = getWindow();
        w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION); //скрываем нижнюю панель навигации
        // | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);//появляется поверх игры и исчезает
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);// выключим ночную тему
        setContentView(R.layout.activity_main);

        count_pref = getSharedPreferences("Count_pref", MODE_PRIVATE);
        count = count_pref.getInt("save_key_count", count);

        TextView txt_count = findViewById(R.id.text_count);
        txt_count.setText(count+"");

        TextView gold_txt = findViewById(R.id.gold_txt);
        gold_txt.setText(getString(R.string.txt_gold)+" " +score_gold);
        pb = findViewById(R.id.progress);
        pb.setProgress(count);

        FloatingActionButton goto_shop = findViewById(R.id.goto_shop);
        goto_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,
                        Plus.class));
            }
        });


        sculpture = findViewById(R.id.sculpture);
        imgSet();
        sculpture.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction()==MotionEvent.ACTION_DOWN) {
                    //если коснуться картинки сработает этот код
                    count-=10000;
                    txt_count.setText(count+"");
                    score_gold +=1;
                    gold_txt.setText(getString(R.string.txt_gold)+" " +score_gold);
                    pb.setProgress(count);
                    view.animate().scaleX(0.99f).scaleY(0.99f).setDuration(0);
                    imgSet();
                    //String txt_skreen = String.valueOf(count);

                }else if( motionEvent.getAction()==MotionEvent.ACTION_UP){
                    //если отпустил палец сработает этот код
                    view.animate().scaleX(1).scaleY(1).setDuration(0);
                }
                return true;
            }
        });

        CardView tools = findViewById(R.id.tools);
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = count_pref.edit();
                editor.putInt("save_key_count", count);
                editor.commit();
            }
        });

    }
    //метод с условием смены картинок - начало
    public void imgSet(){
        if (count>999499){sculpture.setImageResource(R.drawable.img_20);}
        if (count<=999499 & count>998099){sculpture.setImageResource(R.drawable.img_19);}
        if (count<=998099 & count>995499){sculpture.setImageResource(R.drawable.img_18);}
        if (count<=995499 & count>990899){sculpture.setImageResource(R.drawable.img_17);}
        if (count<=990899 & count>983499){sculpture.setImageResource(R.drawable.img_16);}
        if (count<=983499 & count>972499){sculpture.setImageResource(R.drawable.img_15);}
        if (count<=972499 & count>957099){sculpture.setImageResource(R.drawable.img_14);}
        if (count<=957099 & count>936499){sculpture.setImageResource(R.drawable.img_13);}
        if (count<=936499 & count>909899){sculpture.setImageResource(R.drawable.img_12);}
        if (count<=909899 & count>876499){sculpture.setImageResource(R.drawable.img_11);}
        if (count<=876499 & count>835499){sculpture.setImageResource(R.drawable.img_10);}
        if (count<=835499 & count>786099){sculpture.setImageResource(R.drawable.img_9);}
        if (count<=786099 & count>727499){sculpture.setImageResource(R.drawable.img_8);}
        if (count<=727499 & count>658899){sculpture.setImageResource(R.drawable.img_7);}
        if (count<=658899 & count>579499){sculpture.setImageResource(R.drawable.img_6);}
        if (count<=579499 & count>488499){sculpture.setImageResource(R.drawable.img_5);}
        if (count<=488499 & count>385099){sculpture.setImageResource(R.drawable.img_4);}
        if (count<=385099 & count>268499){sculpture.setImageResource(R.drawable.img_3);}
        if (count<=268499 & count>137899){sculpture.setImageResource(R.drawable.img_2);}
        if (count<=137899 & count>0){sculpture.setImageResource(R.drawable.img_1);}
        if (count<=0){sculpture.setImageResource(R.drawable.img_0);}


    }
    //метод с условием смены картинок - конец





}