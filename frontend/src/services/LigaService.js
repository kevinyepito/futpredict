import api from "./api";

export const getLigas = async () => {

    const response = await api.get('/ligas')
    return response.data
}

export const getLigaById = async (id) => {
    const response = await api.get(`/ligas/${id}`)
    return response.data
}