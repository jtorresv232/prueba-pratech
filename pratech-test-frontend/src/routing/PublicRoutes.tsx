import React, { Component, ReactElement } from 'react'
import { Redirect, Route } from 'react-router-dom';

const  PublicRoutes = ({component, restricted, ...rest} : any): ReactElement => {
    let isLogin = localStorage.getItem('pratech_id') != null? true : false;
    return (
        <Route {...rest} render={props => (
            isLogin && restricted? <Component {...props}></Component>
            : <Redirect to="/list"/>
        )}>
        </Route>
    )
}

export default PublicRoutes
