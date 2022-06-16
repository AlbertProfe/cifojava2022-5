//by default when the html is loaded
//<body onload="fetchBooks() "> the body calls fetchBooks
//and we hid toggle button button [0]
document.getElementsByTagName('button')[0].click();

const sendToView = (books) => {
    //https://developer.mozilla.org/en-US/docs/Web/API/Document_Object_Model/Traversing_an_HTML_table_with_JavaScript_and_DOM_Interfaces
    //https://www.w3schools.com/jsref/dom_obj_table.asp
    var table = document.getElementById("booksTable2");
    books.map(book => {
        var tr = document.createElement('TR');
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(book.bookId));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(book.title));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(book.author));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(book.isbn));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(book.pages));
        tr.appendChild(td);
        var td = document.createElement('TD');
        td.appendChild(document.createTextNode(book.publishedYear));
        tr.appendChild(td);
        table.appendChild(tr);
    });
    booksTable.appendChild(table);

};




const fetchBooks = () => {
    axios.get('http://localhost:8080/api/getBooks')
        .then(response => {
            //const books = response;
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

//to-do
const deleteBook = (id) => {
    axios.delete('http://localhost:8080/api/deleteBook/${id}')
        .then(response => {
            console.log(`DELETE: book deleted`, id);
            // remove elem from table
            //to-do
        })
        .catch(error => console.error(error));
};

//to-do
const updateBook = (id, book) => {
    axios.post('http://localhost:8080/api/updateBook/${id}', book)
        .then(response => {
            const updatedBook = response.data;
            console.log(`PUT: book updated`, updatedBook);
            // send to view, refresh just the table with users
            //to-do, delete book to update
            //to-do, send book updated
            //sendToView([createdBook]);
            //and after that we need to hide the form so
            //click the toggle button
            //to-do: hide update form
            //document.getElementsByTagName('button')[0].click();
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
