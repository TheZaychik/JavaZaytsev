package com.company.worker;

public class FixedPaymentWorker extends Worker {
    public Double payment;

    public FixedPaymentWorker(Integer id, String name, Double payment) {
        super(id, name);
        this.payment = payment;
    }

    @Override
    public Double getMonthPayment() {
        return this.payment;
    }
}
