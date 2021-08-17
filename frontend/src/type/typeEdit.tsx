import {Component} from "react";

export class TypeEdit extends Component {

    emptyItem = {
        name: ''
    };

    constructor(props: any) {
        super(props);
        this.setState({item: this.emptyItem});

    }
}