import { useState } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import './App.css';
import Books from './components/Books';
import BooksGenre from './components/BooksGenre';
import Navbar from './components/Navbar';
import ShoppingCart from './components/ShoppingCart';

function App() {
  const [genre, setGenre] = useState('All Genres');

  console.log('Current Genre:', genre);

  return (
    <BrowserRouter>
      <Navbar setGenre={setGenre} />
      <Routes>
        <Route exact path="/" element={<Books />} />
        <Route exact path="/cart" element={<ShoppingCart />} />
        <Route exact path="/genre" element={<BooksGenre genre={genre} />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
