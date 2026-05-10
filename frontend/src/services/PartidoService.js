import api from './api'

export const getPartidos = async () => {
    const response = await api.get('/partidos')
    return response.data
}

export const getPartidoById = async (id) => {
    const response = await api.get(`/partidos/${id}`)
    return response.data
}