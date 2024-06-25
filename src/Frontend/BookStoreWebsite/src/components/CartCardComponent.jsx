
import { useState, useEffect } from 'react';
import CartService from './services/CartService'

function CartCardComponent() {
  const [cart, setCart] = useState({ books: [] });

  // Fetch the shopping cart on component mount
  useEffect(() => {
    async function fetchShoppingCart() {
      try {
        const cartData = await CartService.getShoppingCartById(1);
        console.log(cartData); // Log the fetched cart data
        setCart(cartData);
      } catch (error) {
        console.error('Error fetching cart:', error);
      }
    }
    fetchShoppingCart();
  }, []);


  const removeFromCart = async (shoppingCartId, bookId) => {
    try {
      await CartService.removeBookFromCart(shoppingCartId, bookId);
      window.location.reload(); // Reload the page to show the updated cart
    } catch (error) {
      console.error('Error removing cart item:', error);
    }
  };

 return (
     <div className="container mx-auto mt-5">
       <div className="flex justify-end mb-4">
         <div className="bg-green-400 p-4 rounded flex items-center space-x-2">
           <h2 className="text-lg font-bold">Total Price:</h2>
           <p className="text-lg font-bold">₹{cart.total_price}</p>
         </div>
       </div>
       <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
         {cart.books.map((book) => (
           <div className="bg-white rounded-lg shadow-lg overflow-hidden flex flex-col justify-between h-full" key={book.id}>
             <div className="p-5 flex flex-col h-full">
               <img
                 src={book.book_img}
                 alt="{book.bookName}"
                 className="w-full h-96 object-cover mb-4" // Increased height to h-96
               />
               <h5 className="text-xl font-bold mb-2">{book.bookName}</h5>
               <p className="text-gray-700 mb-2">Author: {book.author}</p>
               <p className="text-gray-700 mb-2">Genre: {book.genre}</p>
               <p className="text-gray-700 mb-2">Rating: {book.rating}</p>
               <a href={book.book_url} className="text-blue-500 hover:underline mb-2">Read Book</a>
               <h5 className="text-lg font-bold">Price: ₹{book.price}</h5>
             </div>
             <button onClick={() => removeFromCart(1,book.book_id)} className="m-5 inline-block bg-red-500 text-white py-2 px-4 rounded hover:bg-blue-700 self-center">
               Remove From Cart
             </button>
           </div>
         ))}
       </div>
     </div>



   );
 }

export default CartCardComponent;
