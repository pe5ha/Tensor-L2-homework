package com.tensor.homework;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {

        // Тест второго задания
//        testTask2();

        // Тест третьего задания
//        testTask3();

        // Тест четвертого задания
//        testTask4();

        // Тест пятого задания
        testTask5();

    }

    public static void testTask5() {
        File file = new File("reg.lam.ent.pdf", null);
        File file2 = new File("text.txt", null);
        File file3 = new File("text2.txt", null);

        ArrayList<FileSystemNode> files = new ArrayList<>();
        files.add(file);
        files.add(file2);
        files.add(file3);
        Folder folder = new Folder("myFolder", null, files);
        System.out.println("Расширение файла file: " + ((File) folder.getChildElements().get(0)).getExtension());

        files = new ArrayList<>();
        files.add(new File("img.png", null));
        Folder folder2 = new Folder("downloads", null, files);

        files = new ArrayList<>();
        files.add(folder);
        files.add(folder2);
        files.add(new File("code.java", null));
        Folder rootFolder = new Folder("root", null, files);

        System.out.println("Путь к файлу file: " + file.getPath());
        System.out.println("Дерево папок\n" + rootFolder);
    }

    public static void testTask4() {
        Deck deck = Deck.createDeck52();
        System.out.println(deck.toString());
//        Deck deck2 = Deck.createDeck54();
//        System.out.println(deck2.toString());
        ArrayList<Card> hand1 = deck.drawCard(10);
        System.out.println("карты игроку 1: " + hand1);
        System.out.println("карты игроку 2: " + deck.drawCard(25));
        ArrayList<Card> hand3 = deck.drawCard(7);
        System.out.println("карты игроку 3: " + hand3);
        System.out.println("В колоде осталось: " + deck);

        System.out.println(deck.addCard(hand3.remove(0)));
        System.out.println(deck.addCard(hand3.get(0)));
        System.out.println(deck.addCard(hand3.remove(0)));
        System.out.println(deck.addCard(hand3.remove(2)));
        System.out.println(deck.addCard(hand1));
        System.out.println(deck.addCard(hand1));

        System.out.println("hand3: " + hand3);
        System.out.println("В колоде осталось: " + deck);

        deck.shuffle();
        System.out.println("перемешана: " + deck);
        deck.sort();
        System.out.println("отсортирована: " + deck);

        while (deck.drawCard() != null) ;
        System.out.println(deck);

    }

    public static void testTask2() throws Exception {
        CardV3 card = new CardV3("hearts", 5);
        CardV3 card1 = new CardV3("hearts", 3);
        CardV3 card2 = new CardV3("diamonds");
        CardV3 card3 = new CardV3("hearts");
        System.out.println("card: " + card.toString());
        System.out.println("card1: " + card1.toString());
        System.out.println("card2: " + card2.toString());
        System.out.println("card3: " + card3.toString());
    }

    public static void testTask3() {
        Card card4 = new Card("hearts", 11);
        Card card5 = new Card("clubs", 13);
        Card card6 = new Card("hearts", 11);
        System.out.println();
        System.out.println(card4.toString());
        System.out.println(card5.toString());
        System.out.println("card4 == card5: " + card4.equals(card5));
        System.out.println("card4 == card6: " + card4.equals(card6));
        System.out.println(card4.hashCode());
        System.out.println(card5.hashCode());
        System.out.println(card6.hashCode());
        System.out.println();
        System.out.println("card5 is standart: " + Card.isStandartCard(card5));
        System.out.println("card4 is better then card6: " + card4.isBetterThen(card6));
        System.out.println("card4 > card5: " + card4.compare(card5));
        Card card7 = new Card("clubs", 3);
        Card card8 = new Card("clubs", 10);
        System.out.println("card7 > card8: " + Card.compare(card7, card8));
    }
}



