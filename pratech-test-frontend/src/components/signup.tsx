import React, { ReactElement } from 'react';
import { withFormik, FormikProps, FormikErrors, Form, Field } from 'formik';
import * as Yup from 'yup';
import userServices from '../service/UserServices';

interface FormValues {
    email: string,
    password: string,
    passwordConfirmation: string,
    name: string
}
const SignupFormHtml = (props: FormikProps<FormValues>) => {
    const { touched, errors } = props;
    return (
        <Form className="d-flex flex-column ml-4">
            <h1>Regístrate</h1>

            <label>Correo Electronico</label>
            <Field type="email" name="email" className="form-control" />
            {touched.email && errors.email && <div className="text-danger">{errors.email}</div>}

            <label>Nombre</label>
            <Field type="text" name="name" className="form-control" />
            {touched.name && errors.name && <div className="text-danger">{errors.name}</div>}

            <label>Contraseña</label>
            <Field type="password" name="password" className="form-control" />
            {touched.password && errors.password && <div className="text-danger">{errors.password}</div>}

            <label>Confirmar Contraseña</label>
            <Field type="password" name="passwordConfirmation" className="form-control" />
            {touched.passwordConfirmation && errors.passwordConfirmation && <div className="text-danger">{errors.passwordConfirmation}</div>}

            <button type="submit" className="mt-3 btn btn-primary">
                Submit
        </button>
        </Form>
    );
};

const SignupForm = withFormik<any, FormValues>({
    // Transform outer props into form values
    mapPropsToValues: (props) => {
        return {
            email: '',
            password: '',
            passwordConfirmation: '',
            name: ''
        };
    },

    // Add a custom validation function (this can be async too!)
    validate: (values) => {
        let errors: FormikErrors<FormValues> = {};
        if (!values.email) {
            errors.email = 'El corre es requerido';
        } else if (!Yup.string().email(values.email)) {
            errors.email = 'Invalid email address';
        }

        if (!values.password) {
            errors.password = 'La contraseña es requerida'
        }

        if (!values.name) {
            errors.name = 'El nombre es requerido'
        }

        if (!values.passwordConfirmation) {
            errors.passwordConfirmation = 'Es necesario confirmar la contraseña'
        }

        if (values.passwordConfirmation !== values.password) {
            errors.passwordConfirmation = 'Las contraseñas deben coincidir'
        }

        return errors;
    },

    handleSubmit: values => {
        userServices.signup({email: values.email, password: values.password, name: values.name}).then(res => {
            alert(res.data.data);
        }, error => {
            alert("El usuario ya ha sido creado anteriormente");
        })

    },
})(SignupFormHtml);

const SignupComponent = (): ReactElement => {

    return (
            <SignupForm></SignupForm>
    )
}

export default SignupComponent
