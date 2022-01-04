import React, { Component } from 'react';
import PropTypes from 'prop-types';

export class AddCard extends Component {
  state = {
    name: '',
    description: '',
    fromDate: '',
    toDate: '',
    arrayOfAttributes: '',
    role: ''
  }

  onSubmit = (e) => {
    e.preventDefault();
    this.props.addCard(this.state.name,this.state.description, this.state.fromDate,this.state.toDate,this.state.arrayOfAttributes,this.state.role);
    this.setState({ name: '',
      description: '',
      fromDate: '',
      toDate: '',
      arrayOfAttributes: '',
      role: ''});
  }

  onChange = (e) => this.setState({ [e.target.name]: e.target.value });

  render() {
    return (
      <form onSubmit={this.onSubmit} style={{ display: 'flex' }}>
        <input 
          type="text" 
          name="name"
          style={{ flex: '10', padding: '5px' }}
          placeholder="name"
          value={this.state.name}
          onChange={this.onChange}
        /> &nbsp;&nbsp;
          <input
              type="text"
              name="description"
              style={{ flex: '10', padding: '5px' }}
              placeholder="description"
              value={this.state.description}
              onChange={this.onChange}
          />
        &nbsp;&nbsp;From &nbsp;&nbsp;
          <input
              type="date"
              name="fromDate"
              placeholder="from"
              style={{ flex: '10', padding: '5px' }}
              value={this.state.fromDate}
              onChange={this.onChange}
          />
        &nbsp;&nbsp;To &nbsp;&nbsp;
          <input
              type="date"
              name="toDate"
              placeholder="to"
              style={{ flex: '10', padding: '5px' }}
              value={this.state.toDate}
              onChange={this.onChange}
          />&nbsp;&nbsp;
        <input
            type="text"
            name="role"
            style={{ flex: '10', padding: '5px' }}
            placeholder="role"
            value={this.state.role}
            onChange={this.onChange}
        />&nbsp;&nbsp;
        <input 
          type="submit" 
          value="Add"
          className="btn"
          style={{flex: '1'}}
        />
      </form>
    )
  }
}

// PropTypes
AddCard.propTypes = {
  addCard: PropTypes.func.isRequired
}

export default AddCard
