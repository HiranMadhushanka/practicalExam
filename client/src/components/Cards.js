import React, { Component } from 'react';
import Card from './Card';
import PropTypes from 'prop-types';
import AddCard from "./AddCard";

class Cards extends Component {
  render() {
    return this.props.cards.map((card) => (
        <div>
          <Card key={card.id} card={card} addCard={this.props.addCard} />
          <AddCard key={card.id} addCard={this.props.addCard.bind(this,card.id)}/>
          <br/>
        </div>
    ));
  }
}

// PropTypes
Cards.propTypes = {
  cards: PropTypes.array.isRequired,
  addCard: PropTypes.func.isRequired
}

export default Cards;