import React from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import FormComponent from './components/form';
import LoginComponent from './components/login';
import RegisterList from './components/registerList';

function App() {
  return (
      <div className="w-100 full-height">
        <div className="page-header bg-primary d-flex row no-gutters justify-content-between px-2 py-4">
        <h1 className="m-0 ml-2">Listado de amigos</h1>
        <button className="btn bg-white mr-5">Logout</button>
      </div>
        <Switch>
          <Route exact path="/" component={RegisterList}></Route>
          <Route exact path="/form" component={FormComponent}></Route>
          <Route exact path="/form/:tryid" component={FormComponent}></Route>
          <Route exact path="/list" component={RegisterList}></Route>
          <Route exact path="/login" component={LoginComponent}></Route>
        </Switch>
      </div>
  );
}

export default App;
