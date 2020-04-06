package com.example.myapplication;


public class Card implements Comparable<Card>{
    public int id;
    public String name;
    public int spell;
    public int value;
    public int rarity;
    public int image;

    Game game;

    public Card(int id,  int spell, int value, int rarity)
    {
        this.id=id;
        this.spell=spell;
        this.value=value;
        this.rarity=rarity;

    }

    public void playCard(Player p1, Player p2)
    {
        int spell=this.spell;
        int value=this.value;
        switch(spell)
        {
            case 1:
                game.attack(value, p2);
                break;
            case 2:
                game.deff(value, p1);
                break;
            case 3:
                game.divine(value, p2);
                break;


        }

    }

    @Override
    public int compareTo(Card card) {
        return this.rarity-card.rarity;
    }

}

