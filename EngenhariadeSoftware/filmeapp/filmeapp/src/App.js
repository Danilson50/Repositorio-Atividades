import React, { Component } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import filmeAdd from './conponents/filme/filmeAdd';
import filmeEdit from './conponents/filme/filmeEdit';
import filmeList from './conponents/filme/filmeList';

export default class App extends Component {
  
  render() {
    return (
      <Router>
        <div>
          <nav className="navbar navbar-expand navbar-dark bg-dark">
            <ul className="navbar-nav mr-auto">
              <li className="nav-item">
                <Link to={"/filmes"} className="nav-link">Filmes</Link>
              </li>
              <li className="nav-item">
                <Link to={"/add"} className="nav-link">Adiciona</Link>
              </li>
            </ul>
          </nav>

          <div className="container mt-3">
            <Switch>
              <Route exact path={["/", "/filmes"]} component={filmeList} />
              <Route exact path="/add" component={filmeAdd} />
              <Route path="/filmes/:id" component={filmeEdit} />
            </Switch>
          </div>          
        </div>
      </Router>
    );
  }
}