package com.company.cards;

import com.company.cards.Card;

public abstract class SocialCard extends Card {
    public Boolean isActive;

    public SocialCard(Integer id) {
        this.ID = id;
        this.isActive = false;
    }

}

