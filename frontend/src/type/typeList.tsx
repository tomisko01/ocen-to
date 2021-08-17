import React, {Component} from "react";
import {Button, ButtonGroup, Modal, Table} from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

export class TypeList extends Component {

    state = {
        types: Array<any>(),
        isOpen: false
    }

    openModal = () => this.setState({isOpen: true});
    closeModal = () => this.setState({isOpen: false});

    async componentDidMount() {
        const response = await fetch('/types');
        const body = await response.json();
        this.setState({types: body});
    }

    async remove(id: string) {
        await fetch(`/types/${id}`, {
            method: 'DELETE',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            }
        }).then(() => {
            let updatedTypes = [...this.state.types].filter(i => i.id !== id);
            this.setState({types: updatedTypes});
        });
    }


    render() {
        const types = this.state?.types;

        const typesList = types.map(type => {
            return <tr key={type.id}>
                <td style={{whiteSpace: 'nowrap'}}>{type.name}</td>
                <td>
                    <ButtonGroup>
                        <Button size="sm" color="danger" onClick={() => this.openModal()}>Edit</Button>

                        <Button size="sm" color="danger" onClick={() => this.remove(type.id)}>Delete</Button>
                    </ButtonGroup>
                </td>
            </tr>

        });

        return <>
            <Table>
                <thead>
                <tr>
                    <th colSpan={6}>Name</th>
                    <th colSpan={6}>Actions</th>
                </tr>
                </thead>
                <tbody>
                {typesList}
                </tbody>
            </Table>
            <Modal show={this.state.isOpen} onHide={this.closeModal} animation={false}>
                <Modal.Header closeButton>
                    <Modal.Title>Edit element</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    tutaj będziemy edytować
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={this.closeModal}>
                        Close
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    }

}

export default TypeList;