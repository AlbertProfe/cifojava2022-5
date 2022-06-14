

const fetchBooks = () => {
    axios.get('http://localhost:8080/api/getBooks')
        .then(response => {
            //const books = response;
            const books = response.data;
            console.log(`GET all books list`, books);
            bookListInner.innerHTML = JSON.stringify(books);

        })
        .catch(error => console.error(error));
};

fetchBooks();