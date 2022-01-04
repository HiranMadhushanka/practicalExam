package com.hiran.service;

import com.hiran.dao.CardDao;
import com.hiran.model.Card;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CardService {

    private final CardDao cardDao;

    public CardService(CardDao cardDao) {
        this.cardDao = cardDao;
    }

    public Card insertCardData(Card card) {
        return cardDao.insertCardData(card);
    }

    public Collection<Card> getAllCardInformation() {
        return cardDao.getAllCardInformation();
    }

    public Optional<Card> getCardInformationUsingId(String id) {
        return cardDao.getCardInformationById(id);
    }

//    public Card getCardInformationByParentCard(String id) {
//        return cardDao.getCardInformationByParentCard(id);
//    }
//
    public void updateCardUsingId(String id, Card card) {
         cardDao.updateCardUsingId(id, card);
    }

    public void deleteCardUsingId(String id) {
        cardDao.deleteCardUsingId(id);
    }

}
