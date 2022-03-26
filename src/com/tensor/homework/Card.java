package com.tensor.homework;

import java.util.Objects;

// Задача 3
class Card implements Comparable<Card> {
    private String suit;
    private int rank;

    public static final String[] suits = {"hearts", "spades", "diamonds", "clubs"};
    private static final String[] cardNames = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Joker"};

    public Card(String suit, int rank) {
        if (isCardRank(rank)) this.rank = rank;
        else System.out.println("Ошибка: " + rank + " не является рангом карты");
        if (isCardSuit(suit)) this.suit = suit;
        else System.out.println("Ошибка: " + suit + " не является типом карты");
    }

    public static boolean isCardSuit(String suit) {
        for (String c : suits) if (suit.equals(c)) return true;
        return false;
    }

    public static boolean isCardRank(int rank) {
        return rank >= 1 && rank <= 14;
    }

    public static boolean isStandartCard(Card card) {
        return isCardRank(card.rank) && isCardSuit(card.suit);
    }

    public boolean isBetterThen(Card card) {
        return suit.equals(card.suit) && rank > card.rank;
    }

    public int compare(Card card) { // >0 if this card better, =0 if equal, <0 if this card weaker
        if (suit.equals(card.suit)) return rank - card.rank;
        else {
            for (String s : suits) {
                if (s.equals(suit)) return 1;
                if (s.equals(card.suit)) return -1;
            }
        }
        return -1000;
    }

    public static int compare(Card card, Card card1) { // >0 if card better then card1, =0 if equal, <0 otherwise
        if (card.suit.equals(card1.suit)) return card.rank - card1.rank;
        else {
            for (String s : suits) {
                if (s.equals(card.suit)) return 1;
                if (s.equals(card1.suit)) return -1;
            }
        }
        return -1000;
    }

    @Override
    public String toString() {
        return suit + "-" + cardNames[rank - 1];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && Objects.equals(suit, card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public int compareTo(Card o) {
        return compare(o);
    }
}


// Задача 2 реализация "c"
class CardV3 {
    private String suit;
    private int rank;

    private static final int[] maxRanks = {0, 0, 0, 0};
    private static final String[] suits = {"diamonds", "clubs", "hearts", "spades"};

    public CardV3(String suit, int rank) throws Exception {
        this.rank = rank;
        if (isCardSuit(suit)) this.suit = suit;
        else throw new Exception("Ошибка: " + suit + " не является типом карты");
        saveMaxRank(this.suit, this.rank);
    }

    public CardV3(String suit) throws Exception {
        if (isCardSuit(suit)) this.suit = suit;
        else throw new Exception("Ошибка: " + suit + " не является типом карты");
        this.rank = getMaxRank(suit) + 1;
        saveMaxRank(this.suit, this.rank);
    }

    private void saveMaxRank(String suit, int rank) {
        for (int i = 0; i < suits.length; i++) {
            if (suits[i].equals(suit)) {
                if (maxRanks[i] < rank) maxRanks[i] = rank;
                return;
            }
        }
    }

    private int getMaxRank(String suit) {
        for (int i = 0; i < suits.length; i++) {
            if (suits[i].equals(suit)) return maxRanks[i];
        }
        return 0;
    }

    public static boolean isCardSuit(String suit) {
        for (String c : suits) if (suit.equals(c)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}


// Задача 2 реализация "b"
class CardV2 {
    private int rank;
    private String suit;

    public CardV2(int rank, String suit) {
        this.rank = rank;
        if (isCardSuit(suit))
            this.suit = suit;
        else
            System.out.println("Ошибка: " + suit + " не является типом карты");
    }

    public static boolean isCardSuit(String suit) {
        String[] suits = {"diamonds", "clubs", "hearts", "spades"};
        for (String c : suits) if (suit.equals(c)) return true;
        return false;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }
}

// Задача 2 реализация "a"
class CardV1 {
    public int rank;
    public String suit;
}
