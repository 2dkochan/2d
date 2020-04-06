package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public final int PLAY_CODE = 1;
    public final int VIEW_CODE = 2;
    Player p1 = new Player();
    Player p2 = new Player();


    Game game = new Game();

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i;
            switch (v.getId()) {
                case R.id.play:
                    i = new Intent(MainActivity.this, PlayMenu.class);
                    int[] hand = new int[game.action+1];
                    for (int j = 0; j <= game.action; j++) {
                        hand[j] = p1.getHand()[j].id;
                    }
                    i.putExtra("hand1", hand);
                    startActivityForResult(i, PLAY_CODE);
                    break;
            }
        }
    };

    public void set(TextView hp1, TextView hp2, TextView armor1, TextView armor2, TextView round,
                    TextView[] cards) {
        hp1.setText(String.valueOf(p1.getHp()));
        hp2.setText(String.valueOf(p2.getHp()));
        armor1.setText(String.valueOf(p1.getArmor()));
        armor2.setText(String.valueOf(p2.getArmor()));
        round.setText(String.valueOf(game.round));
        for (int i = 0; i <= game.action; i++) {
            cards[i].setText(String.valueOf(p1.getHand()[i].id));
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView round = (TextView) findViewById(R.id.round);
        TextView[] cards = new TextView[3];
        cards[0] = (TextView) findViewById(R.id.card1);
        cards[1] = (TextView) findViewById(R.id.card2);
        cards[2] = (TextView) findViewById(R.id.card3);
        TextView hp1 = (TextView) findViewById(R.id.your_hp);
        TextView hp2 = (TextView) findViewById(R.id.enemy_hp);
        TextView armor1 = (TextView) findViewById(R.id.your_armor);
        TextView armor2 = (TextView) findViewById(R.id.enemy_armor);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PLAY_CODE:
                    int play[] = data.getIntArrayExtra("play");
                    Card[] hand = p1.getHand();
                    for (int j = 0; j < game.action; j++) {
                        if (play[j] != 0) {
//                            if (p1.getHand()[play[j]].spell == 3 || p1.getHand()[play[j]].spell == 4) {
//                                Intent i = new Intent(this, ViewMenu.class);
//                                i.putExtra("type", play[j]);
//                                startActivity(i);
//                            } else {
                            p1.getHand()[play[j]].playCard(p1, p2);
                        }
                        hand[play[j]] = null;
                    }
                    p1.setHand(hand);
                    hand = p2.getHand();
                    for (int i = 0; i < game.action; i++) {
                        hand[i].playCard(p1, p2);
                        hand[i] = null;
                    }
            }
            game.startNewTurn(p1, p2);
            set(hp1, hp2, armor1, armor2, round, cards);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView round = (TextView) findViewById(R.id.round);
        TextView[] cards = new TextView[3];
        Button play = (Button) findViewById(R.id.play);
        cards[0] = (TextView) findViewById(R.id.card1);
        cards[1] = (TextView) findViewById(R.id.card2);
        cards[2] = (TextView) findViewById(R.id.card3);
        TextView hp1 = (TextView) findViewById(R.id.your_hp);
        TextView hp2 = (TextView) findViewById(R.id.enemy_hp);
        TextView armor1 = (TextView) findViewById(R.id.your_armor);
        TextView armor2 = (TextView) findViewById(R.id.enemy_armor);

        getSupportActionBar().hide();

        game.startGame(p1, p2);
        set(hp1, hp2, armor1, armor2, round, cards);
        play.setOnClickListener(listener);


    }


}

