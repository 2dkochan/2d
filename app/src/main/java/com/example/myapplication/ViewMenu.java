//package com.example.myapplication;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//public class ViewMenu extends AppCompatActivity {
//
//
//    TextView[] cards=new TextView[8];
//    Game g;
//
//    View.OnClickListener listener=new View.OnClickListener() {
//        @Override
//        public void onClick(View v){
//            switch (v.getId())
//            {
//                case R.id.back:
//                 finish();
//            }
//        }
//    };
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.view_menu);
//
//        TextView banner=(TextView) findViewById(R.id.Banner);
//        cards[0]=(TextView) findViewById(R.id.card1);
//        cards[1]=(TextView) findViewById(R.id.card2);
//        cards[2]=(TextView) findViewById(R.id.card3);
//        cards[3]=(TextView) findViewById(R.id.card4);
//        cards[4]=(TextView) findViewById(R.id.card5);
//        cards[5]=(TextView) findViewById(R.id.card6);
//        cards[6]=(TextView) findViewById(R.id.card7);
//        cards[7]=(TextView) findViewById(R.id.card8);
//        Button back=(Button) findViewById(R.id.back);
//
//        Card a= Player1.hand[getIntent().getIntExtra("type", 0)];
//
//        if (a.spell==3)
//        {
//            for (int i=0; i<=a.value; i++)
//            {
//                cards[i].setVisibility(View.VISIBLE);
//                cards[i].setText(Player1.deck[i].id);
//            }
//        }
//        if (a.spell==4)
//        {
//            for (int i=0; i<=a.value; i++)
//            {
//                cards[i].setVisibility(View.VISIBLE);
//                cards[i].setText(Player1.deck[i].id);
//            }
//        }
//
//        for (int i=a.value; i<8; i++)
//        {
//            cards[i].setVisibility(View.INVISIBLE);
//        }
//    }
//}
