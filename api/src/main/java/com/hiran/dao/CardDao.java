package com.hiran.dao;

import com.hiran.model.Card;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

@Component
public class CardDao {

    private final CardRepository cardRepository;

    public CardDao(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card insertCardData(Card card) {
        return cardRepository.insert(card);
    }

    public Collection<Card> getAllCardInformation() {
        return cardRepository.findAll();
    }

    public Optional<Card> getCardInformationById(String id) {
        return cardRepository.findById(id);
    }

    public Card updateCardUsingId(String id, Card card) {
        Optional<Card> findCardQuery = cardRepository.findById(id);
        Card cardValues = findCardQuery.get();
        cardValues.setId(card.getId());
        cardValues.setParentCard(card.getParentCard());
        return cardRepository.save(cardValues);
    }

    public void deleteCardUsingId(String id) {
        try {
            cardRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

}
