package com.company;

import com.company.cards.Card;
import com.company.cards.SocialCard;

public class Terminal {
    public Integer passages;
    public Integer tips;
    public Integer amount;

    public Terminal() {
        this.passages = 0;
        this.tips = 0;
        this.amount = 0;
    }

    public void checkIn(Card card) {
        if (card instanceof SocialCard) {
            if (((SocialCard) card).isActive) {
                this.passages += 1;
            } else {
                System.out.println("Нет средств для проохода");
            }
        } else if (card instanceof RegularCard) {
            if (((RegularCard) card).trips > 0) {
                ((RegularCard) card).trips -= 1;
                this.tips += 1;
                this.passages += 1;
            } else if (((RegularCard) card).amount > 50) {
                ((RegularCard) card).amount -= 50;
                this.amount += 50;
                this.passages += 1;
            } else {
                System.out.println("Нет средств для проохода");
            }
        }
    }
    public void getStat(){
        System.out.println("Статистика терминала:");
        System.out.println("Проходов:" + this.passages.toString());
        System.out.println("Поездок на терминале:" + this.tips.toString());
        System.out.println("Денег на терминале:" + this.amount.toString());

    }
}
