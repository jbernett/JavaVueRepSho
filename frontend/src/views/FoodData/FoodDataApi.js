import axios from 'axios'
import authHeader from '@/services/auth-header';  
  
const SERVER_URL = 'http://localhost:8080';  
  
const instance = axios.create({  
  baseURL: SERVER_URL,  
  timeout: 1000 ,
  headers: authHeader() 
});  
  
export default {   
  getAll: () => instance.get('getFoodDataIngredients', {transformResponse: [function (data) {return data? JSON.parse(data) : data;  }]}), 
  searchForIngredient: (term) => instance.post('searchFoodDataIngredients',  term , {transformResponse: [function (data) {return data? JSON.parse(data) : data;  }]})   
}