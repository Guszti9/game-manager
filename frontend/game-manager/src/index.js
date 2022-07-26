import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import Encounter from "./encounter/Encounter";
import reportWebVitals from './reportWebVitals';
import Registration from "./registration/Registration"

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/*<Encounter id={19}/>*/}
    <Registration/>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
