import React, { ReactElement } from 'react';
import { withFormik, FormikProps, FormikErrors, Form, Field } from 'formik';
import * as Yup from 'yup';
import userServices from '../service/UserServices';
import SignupComponent from './signup';
import { useHistory } from 'react-router-dom';

interface FormValues {
    email: string,
    password: string
}
const LoginFormHtml = (props: FormikProps<FormValues>) => {
    const { touched, errors } = props;
    return (
      <Form className="d-flex flex-column mr-4">
        <h1>Inicia Sesión</h1>
        <label>Correo electronico</label>
        <Field type="email" name="email" className="mt-3 form-control"/>
        {touched.email && errors.email && <div className="text-danger">{errors.email}</div>}
      
        <label>Contraseña</label>
        <Field type="password" name="password" className="mt-3 form-control"/>
        {touched.password && errors.password && <div className="text-danger">{errors.password}</div>}
  
        <button type="submit" className="mt-3 btn btn-primary">
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
  
    handleSubmit: (values, bag) => {
        const {history} = bag.props;
        userServices.login({...values, name: ''}).then(res => {
            localStorage.setItem("pratech_id", res.data.data.id);
            history.push('/list')
        }, error => {
                alert("Contraseña o Correo equivocado");
        })
      
    },
  })(LoginFormHtml);

const LoginComponent = (): ReactElement => {

  let history = useHistory();
  if(localStorage.getItem('pratech_id')) history.push('/list');
    return (
        <div className="d-flex w-100 h-100 align-items-center justify-content-center bg-primary">
            <div className="d-flex p-3 bg-white z-depth-2 rounded flex-wrap">
                <LoginForm history={history}></LoginForm>
                <SignupComponent></SignupComponent>
            </div>
        </div>
    )
}

export default LoginComponent
