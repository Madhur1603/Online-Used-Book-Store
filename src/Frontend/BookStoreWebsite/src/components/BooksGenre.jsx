import { useState, useEffect } from 'react';
import BookService from './services/BookService';
import CartService from './services/CartService';

function BooksGenre({ genre }) {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    async function fetchBooksByGenre() {
      if (genre && genre !== 'All Genres') {
        try {
          const fetchedBooks = await BookService.getBooksByGenre(genre);
          setBooks(fetchedBooks);
        } catch (error) {
          console.error('Error fetching books by genre:', error);
        }
      } else {
        try {
          const fetchedBooks = await BookService.getAllBooks();
          setBooks(fetchedBooks);
        } catch (error) {
          console.error('Error fetching all books:', error);
        }
      }
    }

    fetchBooksByGenre();
  }, [genre]);

  const addToCart = async (shoppingCartId, bookId) => {
    try {
      await CartService.addBookToCart(shoppingCartId, bookId);
      setBooks((prevBooks) =>
        prevBooks.map((book) =>
          book.book_id === bookId ? { ...book, addedToCart: true } : book
        )
      );
    } catch (error) {
      console.error('Error adding to cart:', error);
    }
  };

  return (
  <div style={{margin:'4rem'}}>
    <div className="container mx-auto mt-5">
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
            {books.map((book) => (
              <div
                className="bg-white rounded-lg shadow-lg overflow-hidden flex flex-col justify-between h-full"
                key={book.id}
              >
                <div className="p-5">
                  <img
                    src={book.book_img}
                    alt="{book.bookName}"
                    className="w-full h-96 object-cover mb-4" // Increased height to h-96
                  />
                  <h5 className="text-xl font-bold mb-2">{book.bookName}</h5>
                  <p className="text-gray-700 mb-2">Author: {book.author}</p>
                  <p className="text-gray-700 mb-2">Genre: {book.genre}</p>
                  <p className="text-gray-700 mb-2">Rating: {book.rating}</p>
                  <a href={book.book_url} className="text-blue-500 hover:underline">
                    Read Book
                  </a>
                  <h5 className="text-lg font-bold">Price: ₹{book.price}</h5>
                </div>
                <button
                  onClick={() => addToCart(1, book.book_id)}
                  className={`m-5 inline-block py-2 px-4 rounded hover:bg-blue-700 self-center ${
                    book.addedToCart ? 'bg-red-500' : 'bg-blue-500 text-white hover:bg-blue-700'
                  }`}
                >
                  {book.addedToCart ? 'Added to Cart' : 'Add to Cart'}
                </button>
              </div>
            ))}
          </div>
        </div>
        </div>
  );
}

export default BooksGenre;
