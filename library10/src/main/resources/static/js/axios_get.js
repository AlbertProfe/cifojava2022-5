
const createBookRow = (book) => {
    const bookRow = document.createElement('td');
    // add book fields to table-data td
    bookRow.textContent = `${book.bookId} ${book.title} ${book.isbn} ${book.pages} ${book.publishedYear}`;
    return bookRow;
};

const sendToView = (books) => {
    const bookRow = document.querySelector('tr');
    //for-each over all books and for each book
    //map creates a row
    books.map(book => {
        bookRow.appendChild(createBookRow(book));
    });
};

const fetchBooks = () => {
    axios.get('http://localhost:8080/api/getBooks')
        .then(response => {
            //const books = response;
            console.log(`response`, response);
            const books = response.data;
            console.log(`GET all books list`, books);
            //bookListInner.innerHTML = JSON.stringify(books);
            sendToView(books);

        })
        .catch(error => console.error(error));
};

const sendBook = (book) => {
    axios.post('http://localhost:8080/api/createBook', book)
        .then(response => {
            const createdBook = response.data;
            console.log(`POST: book created`, createdBook);
            // send to view, refresh just the table with users
            sendToView([createdBook]);
            //and after that we need to hide the form so
            //click the toggle button
            document.getElementsByTagName('button')[0].click();
            console.log(`VIEW: sent to view and toggle clicked`);
        })
        .catch(error => console.error(error));
};

const sendToController = (event) => {
  //create a book JSON and send to Controller via axios.post
  event.preventDefault();
  //get all field to create a BOOK via querySelector
  const title = document.querySelector('#title').value;
  const isbn = document.querySelector('#isbn').value;
  const pages = document.querySelector('#pages').value;
  const author = document.querySelector('#author').value;
  const publishedYear = document.querySelector('#publishedYear').value;
  //create a book with all the fields
  const book = { title, isbn, pages, author, publishedYear };
  console.log("CREATED: book json ", book);
  //call sendBook axios with BOOk object
  console.log(`TO SEND: about to submit! Time stamp: ${event.timeStamp}`);
  sendBook(book);
};

//querySelector to catch the form
const form = document.querySelector('form');
//with the form we listen WHEN someone clicks the submit BUTTON
//ant then call sendToController
const formEvent = form.addEventListener('submit', sendToController);
