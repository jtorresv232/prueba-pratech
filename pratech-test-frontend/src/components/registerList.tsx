import React, { ReactElement, useEffect, useState } from 'react'
import { Try } from '../types/try';
import tryServices from '../service/TryServices';
import { FormQuestion } from '../types/question';
import { useHistory } from 'react-router-dom';

const RegisterList = (): ReactElement => {
    let history = useHistory();
    if(!localStorage.getItem('pratech_id')) history.push('/login');
    const [tries, setTries] = useState<Try[]>([])

    const handleDelete = (id: number) => {
        tryServices.deleteTry(id).then(res => {
            setTries(state => state.filter((utry: Try) => utry.id !== id));
        })
    }

    const handleEdit = (id: number) => {
        history.push(`/form/${id}`);
    }

    useEffect(() => {
        async function getAllTryes() {
            tryServices.getAllTries(parseInt(localStorage.getItem('pratech_id') as string, 10)).then(res => {
                let data = res;
                let usertries = data.data;
                let mytries = usertries.data;
                setTries(state => [...mytries]);
            })
        }
        if (!(tries.length > 0)) {
            getAllTryes();
        }
    }, [tries.length])

    console.log(tries);
    return (
        <div className="d-flex w-100 h-100 flex-column">
            <div className="bg-primary text-white mb-5 text-center"><h2>Registros</h2></div>

            <table className="table">
                <thead>
                    <tr>
                        {tries?.length > 0 &&
                            <>
                                <th scope="col">Id</th>
                                {tries[0].questions.sort((a: FormQuestion, b: FormQuestion) => {
                                if (a.id < b.id) {
                                    return -1;
                                  }
                                  if (a.id > b.id) {
                                    return 1;
                                  }
                                  return 0;
                            }).map((question: FormQuestion) => {
                                    return <th scope="col" key={`h-${question.id}`}>{question.question}</th>
                                })}
                            </>
                        }
                    </tr>
                </thead>
                <tbody>
                    {tries.map((usertry: Try) => {
                        return <>
                        <tr key={`try-${usertry.id}`}>
                            <td>{usertry.id}</td>
                            {usertry.questions.sort((a: FormQuestion, b: FormQuestion) => {
                                if (a.id < b.id) {
                                    return -1;
                                  }
                                  if (a.id > b.id) {
                                    return 1;
                                  }
                                  return 0;
                            }).map((question: FormQuestion) => {
                                console.log(question.answer);
                                return <td key={`a-${question.id}-${usertry.id}`}>{question.answer.answer}</td>
                            })
                            
                            }
                        <td><div className="bi bi-trash text-danger cursor-pointer" onClick={() => handleDelete(usertry.id)}>Borrar</div></td>
                        <td><div className="bi bi-trash text-danger cursor-pointer" onClick={() => handleEdit(usertry.id)}>Editar</div></td>
                        </tr>
                        </>
                    })}
                </tbody>
            </table>

            <div className="w-100 text-center">
                <button className="btn mt-5 btn-primary" onClick={() => history.push('/form')}>Crear nuevo registro</button>
            </div>
        </div>
    )
}

export default RegisterList
