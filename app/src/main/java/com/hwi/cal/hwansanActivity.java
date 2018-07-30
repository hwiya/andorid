package com.hwi.cal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class hwansanActivity extends AppCompatActivity
{
    Spinner spinner4;
    Spinner spinner5;
    TextView text1;
    TextView text2;
    ArrayList<String > big = new ArrayList<>();
    ArrayList<String > small = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hwansan);

        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        String[] big1 = {"cm", "kg"};

        for(int j = 0;j<2;j++)
        {
            big.add(big1[j]+"");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, big
        );

        spinner4.setAdapter(adapter);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                Toast.makeText(hwansanActivity.this, "선택된아이템 = "+big.get(i), Toast.LENGTH_SHORT).show();
                if((big.get(i).equals("cm")))
                {
                    text1.setText("1cm");
                }
                else if((big.get(i).equals("kg")))
                {
                    text1.setText("1kg");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
        String[] small1 = {"mm", "g"};

        for(int j = 0;j<2;j++)
        {
            small.add(small1[j]+"");
        }
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_dropdown_item, small
        );

        spinner5.setAdapter(adapter1);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int k, long l)
            {
                Toast.makeText(hwansanActivity.this, "선택된아이템 = "+small.get(k), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });
    }
}
