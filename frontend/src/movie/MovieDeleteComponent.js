import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import 'shards-ui/dist/css/shards.min.css';
import API from "../API";

export default class MovieDeleteComponent extends React.Component {
    state = {
        id: '',
    }

    handleChange = event => {
        this.setState({id: event.target.value});
    }

    handleSubmit = event => {
        event.preventDefault();

        API.delete(`api/v1/movies/${this.state.id}`)
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
                        Movie ID:
                        <input type="text" name="id" onChange={this.handleChange}/>
                    </label>
                    <button type="submit">Delete</button>
                </form>
            </div>
        )
    }
}

