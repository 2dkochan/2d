package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PlayMenu extends AppCompatActivity{


    View.OnClickListener listener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int[] hand= getIntent().getIntArrayExtra("hand1");
            EditText[] Play=new EditText[6];
            Play[0]=(EditText) findViewById(R.id.play1);
            Play[1]=(EditText) findViewById(R.id.play2);
            Play[2]=(EditText) findViewById(R.id.play3);
            Play[3]=(EditText) findViewById(R.id.play4);
            Play[4]=(EditText) findViewById(R.id.play5);
            Play[5]=(EditText) findViewById(R.id.play6);
            Intent i = new Intent();
            int[] play=new int[hand.length-1];
            for (int j=0; j<hand.length-1; j++)
            {
                if (Play[j].getText().toString()=="")
                {
                    play[j]=0;
                }
                else
                {
                    play[j] = Integer.parseInt(Play[j].getText().toString());
                }
            }
            i.putExtra("play",play);
            setResult(RESULT_OK, i);
            finish();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play_menu);
        int[] hand= getIntent().getIntArrayExtra("hand1");
        Button button = (Button) findViewById(R.id.button);
        TextView Banner=(TextView) findViewById(R.id.Banner);
        EditText[] Play=new EditText[6];
        TextView[] Cards=new TextView[6];

        Play[0]=(EditText) findViewById(R.id.play1);
        Play[1]=(EditText) findViewById(R.id.play2);
        Play[2]=(EditText) findViewById(R.id.play3);
        Play[3]=(EditText) findViewById(R.id.play4);
        Play[4]=(EditText) findViewById(R.id.play5);
        Play[5]=(EditText) findViewById(R.id.play6);

        Cards[0]=(TextView) findViewById(R.id.card1);
        Cards[1]=(TextView) findViewById(R.id.card2);
        Cards[2]=(TextView) findViewById(R.id.card3);
        Cards[3]=(TextView) findViewById(R.id.card4);
        Cards[4]=(TextView) findViewById(R.id.card5);
        Cards[5]=(TextView) findViewById(R.id.card6);

        for (int i=0; i<6; i++)
        {
            if (i<hand.length)
            {
                Play[i].setVisibility(View.VISIBLE);
                Cards[i].setVisibility(View.VISIBLE);
                Cards[i].setText(String.valueOf(hand[i]));
            }
            else
            {
                Play[i].setVisibility(View.INVISIBLE);
                Cards[i].setVisibility(View.INVISIBLE);
            }
        }


        button.setOnClickListener(listener);
    }

    }




