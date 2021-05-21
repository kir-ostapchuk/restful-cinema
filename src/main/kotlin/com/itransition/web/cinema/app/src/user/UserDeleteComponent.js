import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'shards-ui/dist/css/shards.min.css';
import API from "../API";

export default class UserDeleteComponent extends React.Component {
    state = {
        login: ''
    }

    handleChange = event => {
        this.setState({ login: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();

        API.delete(`api/v1/users/${this.state.login}`)
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Login:
                        <input type="text" name="login" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Delete</button>
                </form>
            </div>
        )
    }
}

