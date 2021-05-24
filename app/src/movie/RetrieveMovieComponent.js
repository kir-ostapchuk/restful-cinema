import React from "react";
import API from "../API";

export default class RetrieveMovieComponent extends React.Component {
    state = {
        id: '',
        movieName: '',
        error: ''
    }

    handleChange = event => {
        this.setState({id: event.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();

        API.get(`api/v1/movies/${this.state.id}`)
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
                        Movie ID:
                        <input type="text" name="id" onChange={this.handleChange}/>
                    </label>
                    <button type="submit">Get One</button>
                    {this.state.movieName && <p>Got one: {this.state.movieName}</p>}
                    {this.state.error && <p>Exception - {this.state.error}</p>}
                </form>
            </div>
        )
    }

}