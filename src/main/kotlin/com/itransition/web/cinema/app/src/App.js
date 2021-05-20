import React from 'react';
import MovieDeleteComponent from './MovieDeleteComponent';
import RetrieveAllMoviesComponent from "./RetrieveAllMoviesComponent";
import RetrieveMovieComponent from "./RetrieveMovieComponent";
import MoviePostComponent from "./MoviePostComponent";

  class App extends React.Component {

      render() {
          return (
              <>
                  <MovieDeleteComponent/>
                  <RetrieveMovieComponent/>
                  <RetrieveAllMoviesComponent/>
                  <MoviePostComponent/>
              </>
          );
      }
  }

export default App;