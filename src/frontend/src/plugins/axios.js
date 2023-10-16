import axios from 'axios';

const instance = axios.create({
  baseURL: 'http://localhost:8080/api/auth', // Replace with your backend base URL
  timeout: 1000,
  headers: {
    'Content-Type': 'application/json',
  }
});

export default instance;
