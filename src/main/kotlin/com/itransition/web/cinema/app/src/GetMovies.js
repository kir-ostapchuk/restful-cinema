import React from 'react';
import API from "./API";

export default class GetMovies extends React.Component {
    state = {
        movies: []
    }

    componentDidMount() {
        API.get('/api/v1/movies')
            .then(res => {
                const movies = res.data;
                this.setState({ movies });
            })
    }

    render() {
        return (
            <ul>
                {this.state.movies.map(movie => <li>{movie.id} - {movie.name}</li>)}
            </ul>
        )
    }
}