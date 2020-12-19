import { Form, FormikErrors, withFormik } from 'formik';
import React, { FC, ReactElement, useEffect, useState } from 'react'
import FieldComponent from '../shared-components/FieldComponent';
import { FormQuestion } from '../types/question';
import questionServices from '../service/QuestionServices';
import { Validation } from '../types/validation';
import { AnswerSent } from '../types/answer';
import { useHistory, useParams } from 'react-router-dom';


// Form and Fields creation
const FormHtml: FC<FormQuestion[] | any> = (props): ReactElement => {
  const { questions, touched, errors } = props;
  return (
    <Form className="w-100">
      <div className="d-flex flex-wrap mb-5 text-left ">
        {questions.map((question: FormQuestion, index: number) => <div key={index} className="col-md-6 col-12 mb-4 d-flex flex-column justify-content-center">
          <FieldComponent {...question}></FieldComponent>
          {touched[question.id] && errors[question.id] && <div className="text-danger">{errors[question.id]}</div>}
        </div>)}
      </div>
      <button type="submit" className="btn btn-primary">Terminar</button>
    </Form>
  )
}


// Form Validations
const FormWithValidations = withFormik<any, any>({
  mapPropsToValues: props => {
    const {ids, questions} = props;
    console.log(questions);
    let newProps = ids.reduce((accu: {}, actual: any, index: number) => {
      return { ...accu, [actual]: questions.find((quest: FormQuestion) => quest.id === actual)?.answer?.answer || '' }
    }, {})
    return newProps;
  },

  validate: (values: any, props) => {
    let errors: FormikErrors<any> = {};
    Object.keys(values).forEach(x => {
      let message = getValidationMessage(values[x], props.questions.find((question: FormQuestion) => question.id.toString() === x).validations)
      if (message !== '') errors[x] = message
    })
    return errors;
  },

  handleSubmit: (values, bag) => {
    const {questions, tryid, history} = bag.props;
    let answers: AnswerSent[]; 
    if(!tryid) {
      answers = questions.map((question: FormQuestion) => (
        {
        id: question.id,
        userId: parseInt(localStorage.getItem('pratech_id') as string, 10),
        answer: values[question.id]
      }));
    } else {
      answers = questions.map((question: FormQuestion) => (
        {
        id: question.id,
        userId: parseInt(localStorage.getItem('pratech_id') as string, 10),
        answer: values[question.id],
        usertry: parseInt(tryid, 10),
        answerId: question.answer.id
      }));
      console.log(answers);
    }
    questionServices.answerAllQuestions(answers);
    setTimeout(() => {
      history.push('/list');
    }, 500);
  },
})(FormHtml);

const getValidationMessage = (value: any, validations: Validation[]) => {
  let message = '';
  validations.forEach(validation => {
    switch (validation.type) {
      case 'required':
        message += ((!value || value === '') && `Este campo es requerido. `) || ''
        break;
      case 'minLength':
        message += (parseInt(validation.value) > value.length && `La longitud mínima debe ser ${validation.value}. `) || ''
        break;
      case 'maxLength':
        message += (parseInt(validation.value) < value.length && `La longitud máxima debe ser ${validation.value}. `) || ''
        break;
      case 'email':
        const emailRegex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
        message += (!emailRegex.test(value) && `No cumple con el formato de correo. `) || ''
        break;
      default:
        message = ''
        break;
    }
  })
  return message;
}
interface ParamTypes {
  tryid: string
}

// Load Data and render form
const FormComponent = (): ReactElement => {
  const [questions, setquestions] = useState<FormQuestion[] | any>([]);
  let { tryid } = useParams<ParamTypes>();
  useEffect(() => {
    async function getQuestionsByForm() {
      const response = await (await questionServices.getAllQuestionsByForm(1)).data.data;
      setquestions(response);
    }

    async function getQuestionsByTry(tr: string) {
      const response = await (await questionServices.answerAllQuestionsByTry(tr)).data.data;
      setquestions(response);
    }
    
    if(!tryid) {
      getQuestionsByForm();
    }else {
      getQuestionsByTry(tryid)
      console.log(questions);
    }
  }, [])
  let history = useHistory();
  if(!localStorage.getItem('pratech_id')) history.push('/login');
  let ids = questions.map((x: FormQuestion) => x.id)
  return (
    <div className="d-flex flex-column w-100 justify-content-center p-5 text-center">
      <div className="bg-primary text-white mb-5"><h2>Agrega un amigo</h2></div>
      {questions.length > 0 && ids.length > 0 &&
        <FormWithValidations questions={questions} ids={ids} tryid={tryid} history={history}></FormWithValidations>}
    </div>
  )
}

export default FormComponent
