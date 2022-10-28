package com.company.worker;

public class HourPaymentWorker extends Worker {
    public Double rate;

    public HourPaymentWorker(Integer id, String name, Double rate) {
        super(id, name);
        this.rate = rate;
    }

    @Override
    public Double getMonthPayment() {
        return 20.8 * 8 * this.rate;
    }

}
