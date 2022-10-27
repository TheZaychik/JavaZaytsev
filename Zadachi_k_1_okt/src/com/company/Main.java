package com.company;

import java.util.*;

public class Main {
    public static Random rnd = new Random();

    public static <T> Collection<T> removeDuplicates(Collection<T> collection) {
        return new HashSet<>(collection);
    }


    public static void addRandomMillion(ArrayList<Integer> arrayList, LinkedList<Integer> linkedList) {
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(rnd.nextInt(10000));
            linkedList.add(rnd.nextInt(10000));
        }
    }

    public static void getOHT(ArrayList<Integer> arrayList) {
        for (int i = 0; i < 100000; i++) {
            arrayList.get(rnd.nextInt(arrayList.size()));
        }
    }

    public static void main(String[] args) {
        // Задание 1
        System.out.println("Задание 1");
        Integer[][] nums = {{5, 7, 3, 17}, {7, 0, 1, 12}, {8, 1, 2, 3}};
        CustomIter<Integer> customInterNums = new CustomIter<>(nums);
        while (customInterNums.hasNext()) {
            System.out.println(customInterNums.next());
        }

        // Задание 2
        System.out.println("Задание 2");
        CustomIter<Integer> customInterNums2 = new CustomIter<>(nums);
        CustomIter<Integer> customInterNums3 = new CustomIter<>(nums);
        OverCustomIter<Integer> overCustomIter = new OverCustomIter<>(customInterNums2, customInterNums3);
        while (overCustomIter.hasNext()) {
            System.out.println(overCustomIter.next());
        }

        // Задание 3-4
        System.out.println("Задание 3-4");
        ArrayList<String> stringArrayList = new ArrayList<String>();
        stringArrayList.add("1");
        stringArrayList.add("2");
        stringArrayList.add("3");
        Iterator<String> stringIterator = stringArrayList.iterator();
        FlatIter flatIter = new FlatIter(stringIterator);
        while (flatIter.hasNext()) {
            System.out.println(flatIter.next());
        }

        // Задание 5
        System.out.println("Задание 5");
        Collection<String> stringCollection = new ArrayList<>();
        stringCollection.add("a");
        stringCollection.add("a");
        stringCollection.add("b");
        stringCollection.add("b");
        System.out.println(stringCollection);
        stringCollection = removeDuplicates(stringCollection);
        System.out.println(stringCollection);

        // Задание 6
        System.out.println("Задание 6");
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        System.out.println("addRandomMillion start");
        addRandomMillion(integerArrayList, integerLinkedList);
        System.out.println("addRandomMillion end");
        ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        integerArrayList2.add(1);
        integerArrayList2.add(2);
        integerArrayList2.add(3);
        System.out.println("getOHT start");
        getOHT(integerArrayList2);
        System.out.println("getOHT end");
        // addRandomMillion быстрее

        // Задание 7
        System.out.println("Задание 7");
        FrequencyDictionary fd = new FrequencyDictionary();
        fd.analyze("еду еду еду да не доеду");
        System.out.println(fd.getDictionary());

        // Задание 8
        System.out.println("Задание 8");
        RegularCard regularCard = new RegularCard(234124);
        SchoolCard schoolCard = new SchoolCard(75537393);
        StudentCard studentCard = new StudentCard(87563893);
        ATM.replenishSocialCard(schoolCard, 100);
        ATM.replenishRegularCard(regularCard, 125);
        MobileATM.replenishSocialCard(studentCard, 200);
        System.out.println(schoolCard.isActive);
        System.out.println(studentCard.isActive);
        Terminal t = new Terminal();
        t.checkIn(regularCard);
        t.checkIn(schoolCard);
        t.checkIn(studentCard);
        t.getStat();


    }

}
