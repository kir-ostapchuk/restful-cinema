import React from 'react';
import DeleteById from './DeleteById';
import API from "./API";
import GetMovies from "./GetMovies";
import GetMovieById from "./GetMovieById";
import Post from "./Post";


// for getAll

// class App extends React.Component {
//   constructor(props) {
//     super(props);
//     this.state = {
//       isLoading: true,
//       // name: null
//       movies: null
//     };
//   }
//
//   render() {
//     const {isLoading, movies} = this.state;
//     // const {isLoading, name} = this.state;
//     return (
//         // <DeleteById isLoading={isLoading} name={name}/>
//         <GetMovies isLoading={isLoading} movies={movies}/>
//     );
//   }

  class App extends React.Component {
  // constructor(props) {
  //   super(props);
  //   this.state = {
  //     isLoading: true,
  //     // name: null
  //     id: null
  //   };
  // }

  render() {
    // const {isLoading, movies} = this.state;
    // const {isLoading, name} = this.state;
    return (
        <>
          <DeleteById/>
          <GetMovieById/>
          <GetMovies/>
          <Post/>
        </>
    );
  }

















  // bad code!!!!!!!!!!

  // async componentDidMount() {
  //
  //   // let movieData = await API.get('/api/v1/movies/34');
  //   let movieData = await API.get('/api/v1/movies/34');
  //   // console.log(movieData)
  //
  //   movieData = movieData.data;
  //
  //   const name = `${movieData.name}`;
  //   this.setState({
  //     ...this.state, ...{
  //       isLoading: false,
  //       name
  //     }
  //   });
  // }
}


//
// class App extends React.Component {
//   render() {
//     return (
//         <Router>
//           <Switch>
//             <Route path='api/v1/movies/34' exact={true} component={DeleteById}/>
//             <Route path='api/v1/movies' exact={true} component={GetMovies}/>
//             {/*<Route path='/clients/:id' component={ClientEdit}/>*/}
//           </Switch>
//         </Router>
//     )
//   }
// }

export default App;