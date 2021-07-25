import React, {Component} from 'react';
import './App.css';

class App extends Component {
    state = {
        types: Array<any>()
    };

    async componentDidMount() {
        const response = await fetch('/types');
        const body = await response.json();
        this.setState({types: body});

    }

    render() {
        const types = this.state?.types;

        return <div className="App">
            <header className="App-header">
                <div className="App-intro">
                    <h2>Types:</h2>
                    {types.map(type =>
                        <div key={type.id}>
                            {type.name}
                        </div>
                    )}
                </div>

            </header>
        </div>
    }
}

export default App;
