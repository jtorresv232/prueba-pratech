import React, { Component, ReactElement } from 'react';
import { FC } from 'react';
import { Route, Redirect} from 'react-router-dom';

const PrivateRoutes = ({component, ...rest} : any): ReactElement => {
    let isLogin = localStorage.getItem('pratech_id') != null? true : false;
    return (
        <Route {...rest} render={props => (
            isLogin? <Component {...props}></Component>
            : <Redirect to="/login"/>
        )}>
        </Route>
    )
}

export default PrivateRoutes
