import { User } from '../types/user';
import httpBase from './HttpBaseService'

const login = (body: User) => {
    return httpBase.post('/user/login', body)
}

const methods = {
    login
}

export default methods;