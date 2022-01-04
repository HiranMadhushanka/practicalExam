package com.hiran.dao;

import com.hiran.model.Card;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends MongoRepository<Card, String> {

    public Card findCardByParentCard(String id);
}
