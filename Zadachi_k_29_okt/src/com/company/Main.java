package com.company;

import com.company.cafe.CafeOS;
import com.company.worker.FixedPaymentWorker;
import com.company.worker.HourPaymentWorker;
import com.company.worker.Worker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        // Задание 1
        CafeOS cafe = new CafeOS();
        cafe.run();
        // Задание 2
        System.out.println("Задание 2");
        List<Worker> workers = new ArrayList<>();
        workers.add(new FixedPaymentWorker(12342, "John", 30.5));
        workers.add(new FixedPaymentWorker(46364, "Billy", 25.5));
        workers.add(new FixedPaymentWorker(41362, "Anton", 25.5));
        workers.add(new FixedPaymentWorker(86758, "Jeff", 50.0));
        workers.add(new HourPaymentWorker(28456, "Jonny", 5.0));
        workers.add(new HourPaymentWorker(24321, "Jane", 5.0));
        workers.add(new HourPaymentWorker(575467, "Bob", 8.5));
        // a)
        System.out.println("a)");
        workers.sort((o1, o2) -> {
            if (Objects.equals(o1.getMonthPayment(), o2.getMonthPayment())) {
                return o1.name.compareTo(o2.name);
            }
            return o2.getMonthPayment().compareTo(o1.getMonthPayment());
        });
        System.out.println(workers);
        // b)
        System.out.println("b)");
        for (int i = 0; i < 5; i++) {
            System.out.println(workers.get(i).name);
        }
        // c)
        System.out.println("c)");
        for (int i = workers.size() - 1; i > workers.size() - 4; i--) {
            System.out.println(workers.get(i).id);
        }
        // d) and e)
        System.out.println("d) and e)");
        List<Worker> workers_deserialized;
        try {
            FileInputStream fis = new FileInputStream("WorkerList");
            ObjectInputStream ois = new ObjectInputStream(fis);
            workers_deserialized = (List<Worker>) ois.readObject();
            System.out.println(workers_deserialized);
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException ioe) {
            ioe.printStackTrace();
        }

    }
}
