package com.example.myapplication;

import java.util.Arrays;
import java.util.Random;

public class Game {
    public int round;
    public int action;
    static Random random = new Random();


    public void attack(int value, Player p) {
        if (p.getArmor() >= value) {
            p.setArmor(p.getArmor()-value);
        } else {
            value -= p.getArmor();
            p.setArmor(0);
            p.setHp(p.getHp()-value);
        }
    }

    public void deff(int value, Player p) {
        p.setArmor(p.getArmor()+value);
    }

    public void divine(int value, Player p) {
        p.setHp(p.getHp()-value);
    }

    public boolean endGame(Player p1, Player p2) {
        if (p1.getHp() <= 0) {

            return true;
        } else {
            if (p2.getHp() <= 0) {

                return true;
            } else {
                return false;
            }
        }


    }

    public void startNewTurn(Player p1, Player p2) {
        round++;
        if (action < 4) {
            action++;
        }

        Card[] hand=p1.getHand();
        Card[] deck=p1.getDeck();
        for (int i = 0; i <= action; i++) {
            if (hand[i] == null) {
                int j = 1;
                hand[i] = deck[0];
                while (deck[j - 1] != null) {
                    deck[j - 1] = deck[j];
                    j++;
                }
            }
        }
        p1.setHand(hand);
        p1.setDeck(deck);

        hand=p1.getHand();
        deck=p1.getDeck();
        for (int i = 0; i <= action; i++) {
            if (hand[i] == null) {
                int j = 1;
                hand[i] = deck[0];
                while (deck[j - 1] != null) {
                    deck[j - 1] = deck[j];
                    j++;
                }
            }
        }
        p1.setHand(hand);
        p1.setDeck(deck);


    }

    public void startGame(Player p1, Player p2) {
        round = 1;
        action = 2;

        p1.setHp(30);
        p2.setHp(30);
        p1.setArmor(0);
        p2.setArmor(0);

        Card[] hand1=new Card[7];
        Card[] deck1=new Card[7];
        Card[] hand2=new Card[7];
        Card[] deck2=new Card[7];


        for (int i = 0; i < 3; i++) {
            int card = random.nextInt(3);
            hand1[i] = new Card(Base.id[card], Base.spell[card], Base.value[card], Base.rarity[card]);
            card = random.nextInt(3);
            hand2[i] = new Card(Base.id[card], Base.spell[card], Base.value[card], Base.rarity[card]);
        }

        for (int i = 3; i < 7; i++) {

            hand1[i] = null;
            hand2[i] = null;
        }

        for (int i = 0; i < 6; i++) {
            int card = random.nextInt(3);
            deck1[i] = new Card(Base.id[card], Base.spell[card], Base.value[card], Base.rarity[card]);
            card = random.nextInt(3);
            deck2[i] = new Card(Base.id[card], Base.spell[card], Base.value[card], Base.rarity[card]);
        }
        deck1[6] = null;
        deck2[6] = null;

        p1.setHand(hand1);
        p2.setHand(hand2);
        p1.setDeck(deck1);
        p2.setDeck(deck2);
    }


}
