import React from "react";
import API from "../API";

export default class UserPostComponent extends React.Component {
    state = {
        login: '',
        password: '',
        firstName: '',
        age: '',
        error: ''
    }

    onChangeLogin = event => {
        this.setState({login: event.target.value});
    }

    onChangePassword = event => {
        this.setState({password: event.target.value});
    }

    onChangeFirstName = event => {
        this.setState({firstName: event.target.value});
    }

    onChangeAge = event => {
        this.setState({age: event.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();

        const user = {
            login: this.state.login,
            password: this.state.password,
            firstName: this.state.firstName,
            age: this.state.age
        };

        API.post(`/api/v1/users`, {
                login: user.login,
                password: user.password,
                firstName: user.firstName,
                age: user.age
            }
        )
            .then(res => {
                console.log(res);
                console.log(res.data);
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
                        <input type="text" name="login" onChange={this.onChangeLogin}/>
                        Password:
                        <input type="password" name="name" onChange={this.onChangePassword}/>
                        First name:
                        <input type="text" name="firstName" onChange={this.onChangeFirstName}/>
                        Age:
                        <input type="number" name="firstName" onChange={this.onChangeAge}/>
                    </label>
                    <button type="submit">Create user</button>
                    {this.state.error && <p>Exception - {this.state.error}</p>}
                </form>
            </div>
        )
    }
}