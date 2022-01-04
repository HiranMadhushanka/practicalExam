package com.hiran.controller;

import com.hiran.model.Card;
import com.hiran.model.Request;
import com.hiran.service.CardService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController

@CrossOrigin(origins = "http://localhost:3001")
@RequestMapping("card")
public class CardController {

    private final CardService cardService;
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping
    public Collection<Card> create(@RequestBody Request request) throws ParseException {

        String parentId = request.getId();
        String id = "0";

        List<Card> cardList = (List<Card>) cardService.getAllCardInformation();
        int size = cardList.size();
        for (int i = size; i>Integer.parseInt(parentId); i--){
            Optional<Card> card = cardService.getCardInformationUsingId(String.valueOf(i));
            if(!card.isEmpty()){
                Card _card = card.get();
                _card.setId(String.valueOf(i+1));
                _card.setParentCard(String.valueOf(i));
                cardService.updateCardUsingId(String.valueOf(i),_card);
                cardService.deleteCardUsingId(String.valueOf(i));
            }
        }

        if(parentId.equals("0")) {
            id = "1";
            parentId = null;
        }else{
            id = String.valueOf(Integer.parseInt(parentId)+1);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String duration = "";

        if(request.getFromDate() != "" && request.getToDate() != "") {

            LocalDate fromDate = LocalDate.parse(request.getFromDate(), formatter);
            LocalDate toDate = LocalDate.parse(request.getToDate(), formatter);

            Period period = Period.between(fromDate, toDate);
            int years = Math.abs(period.getYears());
            int months = Math.abs(period.getMonths());
            int days = Math.abs(period.getDays());
            duration = duration.concat((years > 0 ? String.valueOf(years) + " year"+(years>1 ? "s " : " ") : "") + ((months > 0 ? String.valueOf(months) + " month"+(months>1 ? "s " : " ") : "")) + (days > 0 ? String.valueOf(days) + " day"+(days>1 ? "s " : " ") : ""));
        }

        Card card = new Card(id,request.getName(),request.getDescription(),request.getRole(),parentId,duration);
        cardService.insertCardData(card);

        return read();
    }

    @GetMapping
    public Collection<Card> read() {
        List<Card> cardList = new ArrayList<>(cardService.getAllCardInformation());
        Collections.sort(cardList, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return Integer.parseInt(o1.getId())-
                        Integer.parseInt(o2.getId());
            }
        });
        return cardList;
    }

}
