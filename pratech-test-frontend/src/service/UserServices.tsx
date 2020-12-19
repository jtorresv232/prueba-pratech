import { User } from '../types/user';
import httpBase from './HttpBaseService'

const login = (body: User) => {
    return httpBase.post('/user/login', body)
}

const signup = (body: User) => {
    return httpBase.post('/user/signup', body)
}

const methods = {
    login,
    signup
}

export default methods;