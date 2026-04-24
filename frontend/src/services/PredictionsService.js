import api from './api';

//async: la funcion es asincrona (tarda en responder)
export const getPredictions = async() => {
    const response = await api.get('/predicciones');
    return response.data;
}