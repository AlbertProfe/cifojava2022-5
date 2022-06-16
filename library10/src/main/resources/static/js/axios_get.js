
const fetchBooksAndPrintTable = () => {
    axios.get('http://localhost:8080/api/getBooks')
        .then(response => {
            const books = response.data;
            var tableToPrint = "";
            for (let i = 0; i < books.length; i++){
                tableToPrint = tableToPrint +
                "<tr>" +
                "<td>" + books[i].bookId + "</td>" +
                "<td>" + books[i].title + "</td>" +
                "<td>" + books[i].pages + "</td>" +
                "<td>" + books[i].publishedYear + "</td>" +
                "<td>" + books[i].isbn + "</td>" +
                 "<td>" + books[i].author + "</td>" +
                "</tr>" ;
            }
            tableToPrint =  "<table class='w3-table-all w3-hoverable'>" +  tableToPrint + "<t/able>";
            //console.log(`tableToPrint`, tableToPrint);
            bookTable.innerHTML = tableToPrint;
        })
        .catch(error => console.error(error));
};

fetchBooksAndPrintTable();

const fetchBooks = () => {
    axios.get('http://localhost:8080/api/getBooks')
        .then(response => {
            const books = response.data;
            console.log(`GET all books list`, books);
            //console.log(`GET all books list`, books);
            bookListInner.innerHTML = JSON.stringify(books);


        })
        .catch(error => console.error(error));
};



