package com.hiran.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.aggregation.VariableOperators;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Duration;


@Document(collection = "Card")
public class Card {

    private String id;
    private String name;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getParentCard() {
        return parentCard;
    }

    public void setParentCard(String parentCard) {
        this.parentCard = parentCard;
    }

    public VariableOperators.Map getArrayOfAttributes() {
        return arrayOfAttributes;
    }

    public void setArrayOfAttributes(VariableOperators.Map arrayOfAttributes) {
        this.arrayOfAttributes = arrayOfAttributes;
    }

    private String description;
    private String timeDuration;
    private String parentCard;
    private VariableOperators.Map arrayOfAttributes;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String role;

    public Card(@JsonProperty("id") String id,
                @JsonProperty("name") String name,
                    @JsonProperty("description") String description,
                        @JsonProperty("role") String role,
                            @JsonProperty("parentCard") String parentCard,
                                @JsonProperty("timeDuration") String timeDuration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.role = role;
        this.parentCard = parentCard;
        this.timeDuration = timeDuration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
