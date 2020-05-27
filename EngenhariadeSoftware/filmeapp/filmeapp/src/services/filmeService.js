import api from '../environment/environment';

class filmeService {

  getAll() {
    return api.get("/filmes");
  }

  get(id) {
    return api.get(`/filmes/${id}`);
  }

  create(data) {
    return api.post("/filmes", data);
  }

  update(id, data) {
    console.log('update: ', data);
    return api.put(`/filmes/${id}`, data);
  }

  delete(id) {
    return api.delete(`/filmes/${id}`);
  }
  
}

export default new filmeService();