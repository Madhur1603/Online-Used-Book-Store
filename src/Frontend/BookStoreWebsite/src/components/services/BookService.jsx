// src/services/BookService.jsx

import axios from 'axios';

const API_URL = '/api';

const BookService = {
  getAllBooks: async () => {
    const response = await axios.get(`${API_URL}/book/get-books`);
    return response.data;
  },

  getBooksByGenre: async (genre) => {
    const response = await axios.get(`${API_URL}/book/get-book/${genre}`);
    return response.data;
  },
};

export default BookService;
