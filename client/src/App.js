import React, { Component } from 'react'
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Header from './components/layout/Header';
import Cards from './components/Cards';
import AddCard from './components/AddCard';
import uuid from 'uuid';
import axios from 'axios';

import './App.css';

class App extends Component {
  state = {
    cards: []
  };

  componentDidMount() {
    axios
      .get('http://localhost:8080/card')
      .then(res => this.setState({ cards: res.data }));
  }

  // Add Card
  addCard = (id,name,description,fromDate,toDate,arrayOfAttributes,role) => {
      let idValue = id;
      let nameValue = name;
      let descriptionValue = description;
      let fromDateValue = fromDate;
      let toDateValue = toDate;
      let arrayValue = arrayOfAttributes;
      let roleValue = role;
      if(isNaN(id)){
          idValue="0";
          nameValue=id;
          descriptionValue=name;
          fromDateValue=description;
          toDateValue=fromDate;
          roleValue=arrayOfAttributes;
      }

    axios
      .post('http://localhost:8080/card', {
        "id": idValue,
        "name":nameValue,
        "description": descriptionValue,
        "role":roleValue,
        "fromDate":fromDateValue,
        "toDate":toDateValue
      })
      .then(res =>
          this.componentDidMount()
      );
  };

  render() {
    return (
      <Router>
        <div className="App">
          <div className="container">
            <Header />
            <Route
              exact
              path="/"
              render={props => (
                <React.Fragment>
                  <AddCard addCard={this.addCard}/>
                  <Cards
                    cards={this.state.cards}
                    addCard={this.addCard}
                  />
                </React.Fragment>
              )}
            />
          </div>
        </div>
      </Router>
    );
  }
}

export default App;
