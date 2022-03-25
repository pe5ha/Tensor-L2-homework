package com.tensor.homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Deck {
    private ArrayList<Card> deck;

    private Deck(ArrayList<Card> deck){
        this.deck = deck;
    }

    public static Deck createDeck52(){
        ArrayList<Card> newDeck = new ArrayList<>();
        for(String suit : Card.suits) {
            for (int rank = 1; rank <= 13; rank++) {
                newDeck.add(new Card(suit,rank));
            }
        }
        return new Deck(newDeck);
    }

    public static Deck createDeck54(){
        ArrayList<Card> newDeck = new ArrayList<>();
        for(String suit : Card.suits) {
            for (int rank = 1; rank <= 13; rank++) {
                newDeck.add(new Card(suit,rank));
            }
        }
        newDeck.add(new Card(Card.suits[0],14 ));
        newDeck.add(new Card(Card.suits[1],14 ));
        return new Deck(newDeck);
    }

    public static Card getRandomCard(){
        return new Card(Card.suits[(int)(Math.random()*4)],(int)((Math.random()*(14-1))+1));
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    public void sort(){
        Collections.sort(deck);
    }


    public Card drawCard(){
        if(isEmpty()) return null;
        Card card = deck.get(deck.size()-1);
        deck.remove(deck.size()-1);
        return card;
    }
    public ArrayList<Card> drawCard(int n){
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(isEmpty()) break;
            cards.add(deck.get(deck.size()-1));
            deck.remove(deck.size()-1);
        }
        return cards;
    }

    public boolean isEmpty(){
        return deck.isEmpty();
    }

    public int addCard(Card card){
        for(Card c : deck) if(card.equals(c)) return deck.size();
        deck.add(card);
        return deck.size();
    }
    public int addCard(ArrayList<Card> cards){
        for(Card c : cards) addCard(c);
        return deck.size();
    }

    @Override
    public String toString() {
        String stringDeck = "Deck:\n";
        for(Card c : deck) stringDeck+=c+"\n";
        stringDeck+=deck.size()+" cards\n";
        return stringDeck;
    }
}
