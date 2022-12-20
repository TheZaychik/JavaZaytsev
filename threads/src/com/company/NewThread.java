package com.company;

public class NewThread extends Thread {
    String tname;

    NewThread(String tname) {
        this.tname = tname;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(tname);
        }
    }

}
