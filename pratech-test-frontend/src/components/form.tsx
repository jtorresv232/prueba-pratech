import { Form, FormikErrors, FormikValues, withFormik } from 'formik';
import React, { FC, ReactElement, useEffect, useState } from 'react'
import { string } from 'yargs';
import FieldComponent from '../shared-components/FieldComponent';
import { Question } from '../types/question';
import questionServices from '../service/QuestionServices';



const FormHtml: FC<Question[] | any> = (props): ReactElement => {
    const {questions, touched, errors, isSubmitting} = props;
    return (
        <Form className="w-100">
            <div className="d-flex flex-wrap mb-5 text-left">
                {questions.map((question: Question, index: number) => <div key={index} className="col-md-6 col-12 mb-4">
                    <FieldComponent {...question}></FieldComponent>
                    {touched[question.id] && errors[question.id] && <div className="text-danger">{errors[question.id]}</div>}
                </div>)}
            </div>
            <button type="submit" className="btn btn-primary">click</button>
        </Form>
    )
}

const FormWithValidations = withFormik<any, any>({
    // Transform outer props into form values
    mapPropsToValues: props => {
        let newProps = props.ids.reduce((accu: {}, actual: any, index: number) => {
            return {...accu, [actual]: ''}
        }, {})
      return newProps;
    },
  
    // Add a custom validation function (this can be async too!)
    validate: (values: any) => {
      let errors: FormikErrors<any> = {};
      if (!values.email) {
        errors.email = 'El corre es requerido';
      }
      Object.keys(values).forEach(x => {
          if(!values[x] || values[x] === '') {
            errors[x] = 'Este campo es requerido'
          }
      })
      console.log(errors);
      return errors;
    },
  
    handleSubmit: values => {
      console.log(values)
    },
  })(FormHtml);

  /* let newProps = props.reduce((accu: {}, actual: any, index: number) => {
    return {...accu, [actual]: ''}
}, {}) */

const FormComponent = (): ReactElement => {
    const [questions, setquestions] = useState<Question[] | any>([]);

    useEffect(() => {
        async function getAllUsers() {
          const response = await (await questionServices.getAllQuestionsByForm(1)).data.data;
          setquestions(response);
        }
        getAllUsers();
      }, [])
      let ids = questions.map((x:Question) => x.id)
      console.log(questions);
    return (
        <div className="d-flex flex-column w-100 justify-content-center p-5 text-center">
                <div className="bg-primary text-white mb-5"><h2>Responde las preguntas</h2></div>
                {questions.length > 0 && ids.length > 0 &&
                <FormWithValidations questions={questions} ids={ids}></FormWithValidations>}
        </div>
    )
}

export default FormComponent
