package com.example.timetablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar numberSeek = (SeekBar) findViewById(R.id.numberSeek);

        numberSeek.setMax(20);

        numberSeek.setMin(1);
        final ListView numberTable = (ListView) findViewById(R.id.numberTable);

        final ArrayList<Integer> table = new ArrayList<Integer>();
        int currProgress = numberSeek.getProgress();
        for(int i=1;i<=100;i++){
            table.add(i*currProgress);
        }
        final ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this,android.R.layout.simple_list_item_1,table);


        numberTable.setAdapter(arrayAdapter);

        numberSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                arrayAdapter.clear();
                for(int i=1;i<=100;i++){
                    int newVal=i*progress;
                    table.add(newVal);
                }



                numberTable.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
