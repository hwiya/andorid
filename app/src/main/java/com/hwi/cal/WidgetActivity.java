package com.hwi.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.zip.CheckedInputStream;

public class WidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox cbApple;
    CheckBox cbBanana;
    CheckBox cbCherry;
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget);

        cbApple = (CheckBox) findViewById(R.id.cbApple);
        cbBanana = (CheckBox) findViewById(R.id.cbBanana);
        cbCherry = (CheckBox) findViewById(R.id.cbCherry);

        cbApple.setOnCheckedChangeListener(this);
        cbBanana.setOnCheckedChangeListener(this);
        cbCherry.setOnCheckedChangeListener(this);

        rg = (RadioGroup) findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int button_id)
            {
                switch(button_id)
                {
                    case R.id.rbAnaconda:
                        Toast.makeText(WidgetActivity.this,"Anaconda 라디오버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbBear:
                        Toast.makeText(WidgetActivity.this,"Bear 라디오버튼", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rbCat:
                        Toast.makeText(WidgetActivity.this,"Cat 라디오버튼", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton cb, boolean flag)
    {
        switch(cb.getId())
        {
            case R.id.cbApple:
                Toast.makeText(WidgetActivity.this, "사과체크="+flag, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbBanana:
                Toast.makeText(WidgetActivity.this, "바나나체크="+flag, Toast.LENGTH_SHORT).show();
                break;
            case R.id.cbCherry:
                Toast.makeText(WidgetActivity.this, "체리체크="+flag, Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
