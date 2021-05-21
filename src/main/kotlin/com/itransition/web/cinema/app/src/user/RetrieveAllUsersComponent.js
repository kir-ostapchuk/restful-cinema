import React from 'react';
import API from "../API";

export default class RetrieveAllUsersComponent extends React.Component {
    state = {
        users: []
    }

    handleSubmit = event => {
        event.preventDefault();
        API.get('/api/v1/users')
            .then(res => {
                const users = res.data;
                this.setState({users});
            })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <button type="submit">Get users</button>
                    <ul>
                        {this.state.users.map(user => <li>{user.id} - {user.login} - {user.password} - {user.age}</li>)}
                    </ul>
                </form>
            </div>

        )
    }
}