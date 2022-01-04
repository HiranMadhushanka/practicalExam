import React, { Component } from "react";
import PropTypes from "prop-types";
import AddCard from "./AddCard";

export class Card extends Component {
  getStyle = () => {
    return {
      background: "#f4f4f4",
      padding: "10px",
      borderBottom: "1px #ccc dotted",
      textDecoration: this.props.card.completed ? "line-through" : "none",
    };
  };

  componentDidMount = (props) => {
    console.log(this.props.card);
  };

  render() {
    const { id, name, description ,parentCard,timeDuration, arrayOfAttributes ,role} = this.props.card;
    return (
      <div style={this.getStyle()}>
        <p>

          id : {id}
          <br></br>
          name : {name}
          <br></br>
          description : {description}
          <br></br>
          time duration : {timeDuration}
          <br></br>
          parent card : {parentCard != null ? parentCard : "null"}
          <br></br>
          array of attributes : {arrayOfAttributes}
          <br></br>
          role : {role}
          <br></br>
          {/*<button onClick={this.props.addCard.bind(this, id)} style={btnStyle}>*/}
          {/*  +*/}
          {/*</button>*/}
        </p>
      </div>
    );
  }
}

// PropTypes
Card.propTypes = {
  card: PropTypes.object.isRequired,
  addCard: PropTypes.func.isRequired
};

const btnStyle = {
  background: "#0040ff",
  color: "#fff",
  border: "none",
  padding: "5px 9px",
  borderRadius: "50%",
  cursor: "pointer",
  float: "right",
};

export default Card;
