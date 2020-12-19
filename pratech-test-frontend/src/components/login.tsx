import React, { ReactElement } from 'react';
import { withFormik, FormikProps, FormikErrors, Form, Field } from 'formik';
import * as Yup from 'yup';
import userServices from '../service/UserServices';

interface FormValues {
    email: string,
    password: string
}
const LoginFormHtml = (props: FormikProps<FormValues>) => {
    const { touched, errors, isSubmitting } = props;
    return (
      <Form className="d-flex flex-column">
        <h1>Inicia Sesión</h1>
        <Field type="email" name="email" className="mt-3 form-control"/>
        {touched.email && errors.email && <div className="text-danger">{errors.email}</div>}
  
        <Field type="password" name="password" className="mt-3 form-control"/>
        {touched.password && errors.password && <div className="text-danger">{errors.password}</div>}
  
        <button type="submit" disabled={isSubmitting} className="mt-3 btn btn-primary">
          Submit
        </button>
      </Form>
    );
  };

  

  const LoginForm = withFormik<any, FormValues>({
    // Transform outer props into form values
    mapPropsToValues: (props) => {
      return {
          email: '',
          password: ''
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

      if(!values.password) {
          errors.password = 'La contraseña es requerida'
      }
      return errors;
    },
  
    handleSubmit: values => {
        userServices.login(values).then(res => {
            localStorage.setItem("pratech_id", res.data.data.id);
        }, error => {
                alert("Contraseña o Correo equivocado");
        })
      
    },
  })(LoginFormHtml);

const LoginComponent = (): ReactElement => {

    return (
        <div className="d-flex w-100 h-100 align-items-center justify-content-center bg-primary">
            <div className="d-flex flex-column p-3 bg-white z-depth-2 rounded">
                <LoginForm></LoginForm>
            </div>
        </div>
    )
}

export default LoginComponent
