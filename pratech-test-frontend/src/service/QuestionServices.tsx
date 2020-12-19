import httpBase from './HttpBaseService'

const getAllQuestionsByForm = async (id: any) => {
    return await httpBase.get(`/questions/${id}`)
}

const methods = {
    getAllQuestionsByForm
}

export default methods;