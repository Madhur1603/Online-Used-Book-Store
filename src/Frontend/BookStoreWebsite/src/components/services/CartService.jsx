// src/services/UserService.jsx

import axios from 'axios';

// const API_URL = 'http://localhost:8090'; // Replace with your backend URL
const API_URL = '/api';

const CartService = {
  addBookToCart: async (shoppingCartId, bookId) => {
    const response = await axios.post(`${API_URL}/api/shoppingCarts/${shoppingCartId}/books/${bookId}`);
    return response.data;
  },

  removeBookFromCart: async (shoppingCartId, bookId) => {
    const response = await axios.delete(`${API_URL}/api/shoppingCarts/${shoppingCartId}/books/${bookId}`);
    return response.data;
  },

  getShoppingCartById: async (shoppingCartId) => {
    const response = await axios.get(`${API_URL}/api/shoppingCarts/${shoppingCartId}`);
    return response.data;
  },

  // Implement other methods as needed
};

export default CartService;
