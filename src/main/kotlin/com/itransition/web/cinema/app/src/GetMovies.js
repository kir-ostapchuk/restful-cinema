import React from 'react';
import API from "./API";

export default class GetMovies extends React.Component {
    state = {
        movies: []
    }

    handleSubmit = event => {
        event.preventDefault();
        API.get('/api/v1/movies')
            .then(res => {
                const movies = res.data;
                this.setState({movies});
            })
    }

    render() {
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <button type="submit">Get movies</button>
                    <ul>
                        {this.state.movies.map(movie => <li>{movie.id} - {movie.name}</li>)}
                    </ul>
                </form>
            </div>

        )
    }
}