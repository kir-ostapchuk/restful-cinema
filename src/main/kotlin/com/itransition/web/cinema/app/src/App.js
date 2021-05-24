import React from 'react';
import RetrieveAllUsersComponent from "./user/RetrieveAllUsersComponent";
import UserDeleteComponent from "./user/UserDeleteComponent";
import UserPostComponent from "./user/UserPostComponent";
import RetrieveUserComponent from "./user/RetrieveUserComponent";

class App extends React.Component {

    render() {
        return (
            <>
                {/*<MovieDeleteComponent/>*/}
                {/*<RetrieveMovieComponent/>*/}
                {/*<RetrieveAllMoviesComponent/>*/}
                {/*<MoviePostComponent/>*/}

                <UserDeleteComponent/>
                <RetrieveUserComponent/>
                <RetrieveAllUsersComponent/>
                <UserPostComponent/>
            </>
        );
    }
}

export default App;