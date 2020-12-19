import { Answer } from '../types/answer';
import {  } from '../types/user';
import httpBase from './HttpBaseService'

const getAllTries = async (id: any) => {
    return httpBase.get(`/tries/${id}`)
}

const deleteTry = (id: number) => {
    return httpBase.del(`/tries/${id}`);
}

const methods = {
    getAllTries,
    deleteTry
}

export default methods;