package com.company;

public class Main {

    public static void main(String[] args) throws Exception {
        HashTable hashTable = new HashTable(2);

        System.out.println(hashTable.isEmpty());
        System.out.println(hashTable.put("0", 123));
        System.out.println(hashTable.put("1", 456));

        try {
            System.out.println(hashTable.put("2", 789));
        } catch (Exception e) {
            System.out.println("table已滿");
        }
        System.out.println(hashTable.get("1"));

        System.out.println(hashTable.remove("3"));
        System.out.println(hashTable.size());
    }
}
