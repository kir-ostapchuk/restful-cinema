import React from "react";
import API from "../API";

export default class RetrieveUserComponent extends React.Component {
    state = {
        login: '',
        firstName: '',
        error: ''
    }

    handleChange = event => {
        this.setState({ login: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();

        API.get(`api/v1/users/${this.state.login}`)
            .then(res => {
                this.setState({movieName: res.data.name})
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
                        Login:
                        <input type="text" name="login" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Get One</button>
                    {this.state.movieName && <p>Got one: {this.state.movieName}</p>}
                    {this.state.error && <p>Exception - {this.state.error}</p>}
                </form>
            </div>
        )
    }

}