import axios from 'axios'  
  
const SERVER_URL = 'http://localhost:8080';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000  
});  
  
export default {
  createNew: (text) => instance.post('ingredients', { "Name" : text })  , 
  getAll: () => instance.get('ingredients', {transformResponse: [function (data) {return data? JSON.parse(data) : data;  }]}), 
  updateForId: (id, text) => instance.put('ingredients/'+id, {name: text}), 
  removeForId: (id) => instance.delete('ingredients/'+id)  
}