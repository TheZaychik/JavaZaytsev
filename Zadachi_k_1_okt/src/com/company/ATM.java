package com.company;

import com.company.cards.SocialCard;

public class ATM {
    public static void replenishSocialCard(SocialCard card, Integer money) {
        if (card instanceof SchoolCard) {
            if (money < 100) {
                System.out.println("Не хватает средств");
                return;

            }
        } else if (card instanceof StudentCard) {
            if (money < 200) {
                System.out.println("Не хватает средств");
                return;

            }
        }
        card.isActive = true;
    }

    public static void replenishRegularCard(RegularCard card, Integer money) {
        if (money < 50) {
            card.amount += money;
            return;
        }
        card.trips = money / 50;
        card.amount += money % 50;

    }
}
