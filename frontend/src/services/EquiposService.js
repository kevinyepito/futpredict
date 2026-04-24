import api from "./api";

export const getEquipos = async () => {
    const response = await api.get('/equipos');
    return response.data
}