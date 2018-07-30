package com.hwi.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.CheckedInputStream;

public class WidgetActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    CheckBox cbApple;
    CheckBox cbBanana;
    CheckBox cbCherry;
    RadioGroup rg;
    Spinner sp;
    SeekBar sb;
    TextView seekTV;
    ArrayList<String> months = new ArrayList<>();

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

        sb = (SeekBar) findViewById(R.id.seekBar);
        seekTV = (TextView) findViewById(R.id.seekTV);
        sb.setOnSeekBarChangeListener((new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
            {
                seekTV.setText(progress+""); //중요 : setText 함수 값에 숫자만 넘기면 다운됨.
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        }));

        sp = (Spinner) findViewById(R.id.sp);
        //데이터는 올해부터~100년전까지
        for(int i=2018;i>2018-100;i--)
        {
            months.add(i + "");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, months
                //컨텍스트,           스피너에서 사용할 레이아웃
        );
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
                                  {
                                      @Override
                                      public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id)
                                      {
                                            Toast.makeText(WidgetActivity.this, "선택된아이템="+months.get(position), Toast.LENGTH_SHORT).show();
                                      }

                                      @Override
                                      public void onNothingSelected(AdapterView<?> adapterView)
                                      {

                                      }
                                  });

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
