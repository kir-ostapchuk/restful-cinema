import React from "react";
import API from "../API";

export default class RetrieveUserComponent extends React.Component {
    state = {
        id: '',
        firstName: '',
        error: ''
    }

    handleChange = event => {
        this.setState({ id: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();

        API.get(`api/v1/users/${this.state.id}`)
            .then(res => {
                this.setState({firstName: res.data.firstName})
            })
            .catch((err) => {
                this.setState({error: err.name})
            });
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Id:
                        <input type="text" name="id" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Get One</button>
                    {this.state.firstName && <p>Got one: {this.state.firstName}</p>}
                    {this.state.error && <p>Exception - {this.state.error}</p>}
                </form>
            </div>
        )
    }

}