package com.company;

import com.company.cards.Card;

public class RegularCard extends Card {
    public Integer amount;
    public Integer trips;

    public RegularCard(Integer id) {
        this.ID = id;
        this.amount = 0;
        this.trips = 0;
    }

}
