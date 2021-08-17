import React, {Component} from 'react';
import './App.css';
import TypeList from "./type/typeList";
import {BrowserRouter} from "react-router-dom";

class App extends Component {
    render() {
        return <BrowserRouter >
            <TypeList/>
        </BrowserRouter>
    }
}

export default App;
