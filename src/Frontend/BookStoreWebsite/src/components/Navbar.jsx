
import React, { useState } from 'react';
import { NavLink } from 'react-router-dom';

function Navbar({ setGenre }) {
  const [isOpen, setIsOpen] = useState(false);
  const genres = ['All Genres', 'Fiction', 'Science Fiction', 'Mystery', 'Comedy', 'Horror'];

  const toggleDropdown = () => {
    setIsOpen(!isOpen);
  };

  const handleGenreSelect = (selectedGenre) => {
    console.log('Selected Genre:', selectedGenre);
    setGenre(selectedGenre); // Update genre state using the passed function
    setIsOpen(false); // Close dropdown after selection
  };

  return (
    <nav className="bg-gray-800 p-4 fixed top-0 left-0 w-full z-10">
      <div className="container mx-auto flex justify-between items-center pl-8">
        <div className="text-white text-2xl font-extrabold">
          <span className="text-purple-500">Book</span> Store
        </div>
        <div className="flex space-x-4">
          <NavLink to="/" exact activeClassName="text-purple-600" className="text-white hover:text-gray-400 px-4 py-2">
            Home
          </NavLink>
          <NavLink to="/cart" activeClassName="text-purple-600" className="text-white hover:text-gray-400 px-4 py-2">
            Shopping Cart
          </NavLink>
          <div className="relative inline-block">
            <button onClick={toggleDropdown} className="bg-purple-600 text-white px-4 py-2 rounded-md focus:outline-none hover:bg-purple-700">
              Select Genre ↓
            </button>
            {isOpen && (
              <div className="origin-top-right absolute right-0 mt-2 w-40 rounded-md shadow-lg bg-white ring-1 ring-black ring-opacity-5">
                <ul className="py-1">
                  {genres.map((genre) => (
                    <li key={genre}>
                      <NavLink
                        to="/genre"
                        onClick={() => handleGenreSelect(genre)}
                        className="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100"
                      >
                        {genre}
                      </NavLink>
                    </li>
                  ))}
                </ul>
              </div>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
}

export default Navbar;
