package com.company;

public class HashTable {
    private final Cell[] table;
    private int size;
    private final int N;

    public HashTable(int N) {
        size = 0;
        this.N = N;
        table = new Cell[N];
    }

    public Integer get(String key) {
        int hashValue = hashFunction(key);
        int p = 0;

        while (p < N) {
            Cell cell = table[hashValue];
            if (cell == null) {
                return null;
            } else if (cell.getKey().equals(key)) {
                return cell.getValue();
            } else {
                p++;
                hashValue = (hashValue + 1) % N;
            }
        }

        return null;
    }

    public Integer put(String key, int value) throws Exception {
        int hashValue = hashFunction(key);
        int p = 0;

        while (p < N) {
            Cell cell = table[hashValue];
            if (cell == null) {
                table[hashValue] = new Cell(value, key);
                size++;
                return null;
            } else if (cell.getKey().equals(key)) {
                return cell.getValue();
            } else {
                p++;
                hashValue = (hashValue + 1) % N;
            }
        }


        //如果table滿了
        throw new Exception();
    }

    public Integer remove(String key) {
        int hashValue = hashFunction(key);
        int p = 0;

        while (p < N) {
            Cell cell = table[hashValue];
            if (cell == null) {
                return null;
            } else if (cell.getKey().equals(key)) {
                size--;
                table[hashValue] = null;
                return cell.getValue();
            } else {
                p++;
                hashValue = (hashValue + 1) % N;
            }
        }

        return null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int hashFunction(String x) {
        return Integer.parseInt(x) % N;
    }

}


