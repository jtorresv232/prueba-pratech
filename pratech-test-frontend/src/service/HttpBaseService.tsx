import axios, { AxiosRequestConfig } from 'axios';


const basicConfig: AxiosRequestConfig = {
        headers: {
          'content-type': 'application/json'
        },
        responseType: 'json'
      };

const urlBase = 'http://localhost:8080/test/'

const get = (relativeUrl: string) => {
    return axios.get(`${urlBase}${relativeUrl}`, basicConfig);
}

const post = (relativeUrl: string, bodyRequest: any) => {
    return axios.post(`${urlBase}${relativeUrl}`, bodyRequest, basicConfig);
}

const del = (relativeUrl: string) => {
  return axios.post(`${urlBase}${relativeUrl}`, basicConfig);
}

const httpBase = {
    get,
    post,
    del
}

export default httpBase;
