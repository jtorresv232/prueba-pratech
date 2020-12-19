import { Field, FormikProps, FormikValues } from 'formik'
import React, { FC, ReactElement } from 'react'
import { FormQuestion } from '../types/question'


const FieldHml = (props:FormQuestion) => {
    const {id, question, type, answer, validations} = props;
    return (
        <>
            {type !== 'checkbox'? 
            <>
                <label htmlFor={id.toString()}>{question}</label>
                <Field className={'form-control'} type={type} name={id}></Field>
            </>
            :
            <div className="d-flex align-items-center">
                <Field className="mr-2" type={type} name={id}></Field>
                <label className="m-0" htmlFor={id.toString()}>{question}</label>
            </div>}
        </>
    )
}

const FieldComponent: FC<FormQuestion> = (props: FormQuestion):ReactElement => {
    return (
        <FieldHml {...props}></FieldHml>
    )
}

export default FieldComponent
