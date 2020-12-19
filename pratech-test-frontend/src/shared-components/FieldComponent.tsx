import { Field, FormikProps, FormikValues } from 'formik'
import React, { FC, ReactElement } from 'react'
import { Question } from '../types/question'


const FieldHml = (props:Question) => {
    const {id, question, type, answer, validations} = props;
    return (
        <>
            <label htmlFor={id.toString()}>{question}</label>
            <Field className="form-control" type={type} name={id}></Field>
        </>
    )
}

const FieldComponent: FC<Question> = (props: Question):ReactElement => {
    return (
        <FieldHml {...props}></FieldHml>
    )
}

export default FieldComponent
