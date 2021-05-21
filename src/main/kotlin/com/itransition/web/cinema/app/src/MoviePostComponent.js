import React from "react";
import API from "./API";

export default class MoviePostComponent extends React.Component {
    state = {
        name: '',
        error: ''
    }

    handleChange = event => {
        this.setState({ name: event.target.value });
    }

    handleSubmit = event => {
        event.preventDefault();

        const movie = {
            name: this.state.name
        };
        API.post(`/api/v1/movies`, { name: movie.name })
            .then(res => {
                console.log(res);
                console.log(res.data);
            })
            .catch((err) => {
                this.setState( {error: err.name} )
            });
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <label>
                        Movie Name:
                        <input type="text" name="name" onChange={this.handleChange} />
                    </label>
                    <button type="submit">Add</button>
                    {this.state.error && <p>Exception - {this.state.error}</p>}
                </form>
            </div>
        )
    }
}