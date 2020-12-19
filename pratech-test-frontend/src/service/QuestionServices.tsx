import { Answer } from '../types/answer'
import httpBase from './HttpBaseService'

const getAllQuestionsByForm = async (id: any) => {
    return await httpBase.get(`/questions/${id}`)
}

const answerAllQuestions = (answers: Answer[]) => {
    return httpBase.post('/questions/all/answer', answers);
}

const answerAllQuestionsByTry = (tryid: string) => {
    return httpBase.get(`/questions/byTry/${tryid}`);
}

const methods = {
    getAllQuestionsByForm,
    answerAllQuestions,
    answerAllQuestionsByTry
}

export default methods;