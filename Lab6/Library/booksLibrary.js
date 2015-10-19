/**
 * Created by Mason on 10/19/15.
 */

/**
 * Constants used for testing
 * @type {string}
 */
Library.prototype.SHELF_SIZE_CONSTANT = 9;
Library.prototype.SHELF_NUM_CONSTANT = 4;
Library.prototype.shelfNames = ["S1", "S2", "S3"];
Library.prototype.books = [
    {name: "COM S", fiction: false, author: "Mitra"},
    {name: "My Book", fiction: true, author: "Mason"},
    {name: "Book3", fiction: true, author: "Berhenke"},
    {name: "Book4", fiction: false, author: "Ryan"},
    {name: "Book5", fiction: false, author: "Tigges"},
    {name: "Pajama Sam", fiction: true, author: "Mitra"},
    {name: "Pajama Sam", fiction: true, author: "Mitra"},
    {name: "Pajama Sam", fiction: true, author: "Mitra"},
    {name: "Pajama Sam", fiction: true, author: "Mitra"},
    {name: "Book7", fiction: false, author: "Gatsby"},
    {name: "Book7", fiction: false, author: "Gatsby"},
    {name: "Book7", fiction: false, author: "Gatsby"},
    {name: "Book7", fiction: false, author: "Gatsby"},
    {name: "Book8", fiction: true, author: "ABC"},
    {name: "Quickbooks", fiction: false, author: "123"},
    {name: "Book10", fiction: true, author: "Doh"},
    {name: "Book11", fiction: false, author: "Reh"},
    {name: "Singing 4 Dummies", fiction: true, author: "Mi"},
    {name: "Singing 4 Dummies", fiction: true, author: "Mi"},
    {name: "Singing 4 Dummies", fiction: true, author: "Mi"},
    {name: "Singing 4 Dummies", fiction: true, author: "Mi"},
    {name: "Book13", fiction: false, author: "Lathrop"},
    {name: "Some horror story", fiction: true, author: "Nguyen"},
    {name: "Book15", fiction: true, author: "Someone"},
    {name: "Testing Javascript 101", fiction: true, author: "Nickelback"},
    {name: "Book17", fiction: true, author: "Mason"},
    {name: "Book18", fiction: false, author: "Obama"},
    {name: "Book19", fiction: false, author: "Not Trump"},
    {name: "Book20", fiction: false, author: "The Who"},
    {name: "Book21", fiction: true, author: "Berhenke"},
    {name: "Putt Putt Saves the Zoo", fiction: false, author: "Putt Putt"}
];

/**
 * Main library constructor used in the test
 * @constructor
 */
function Library() {
    // Make books, make shelves, allocate books to shelves accordingly.
    var shelves = this.generateShelves();
    var books = this.generateBooks();
    this.books = books;
    var i = 0;
    for(var book in books){
        var max = this.SHELF_SIZE_CONSTANT;
        // Some checks to make sure we're not overfilling our shelves
        if (shelves[i].books.length == max) i++;
        if(shelves[i] == undefined) break;
        shelves[i].books.push(books[book]);
    }
    this.shelves = shelves;
    this.checkedOutBooks = [];
}

/**
 * A helper function to take care of generating the test cases for the Library class.
 * Didn't want to allow the option to upload a text file or anything like that.
 * @returns {Array} of books
 */
Library.prototype.generateBooks = function () {
    var booksArray = [];
    this.books.forEach(function (b) {
        booksArray.push(new Book(b.name, b.fiction, b.author, false, ""));
    });
    return booksArray;
};

/**
 * Helper for making shelves
 * @returns {Array}
 */
Library.prototype.generateShelves = function () {
    var shelves = [];
    for (var i = 0; i < this.shelfNames.length && i < this.SHELF_NUM_CONSTANT; i++) {
        shelves.push(new Shelf(this.shelfNames[i]));
    }
    return shelves;
};

/**
 * Checks if book is available
 * @param name The name of the book.
 * @returns {*} Returns false if it is not available, the index otherwise.
 */
Library.prototype.isBookAvailable = function (name) {
    var flag = false;
    var shelfIndex = "";
    for(var i = 0; i < this.shelves.length; i++){
        var shelf = this.shelves[i];
        for(var j = 0; j < shelf.length; j++){
            if(shelf[j].name == name) {
                shelfIndex = shelf.name;
                flag = true;
                break;
            }
        }
        if(flag) break;
    }
    return flag ? shelfIndex : flag;
};

/**
 * Gets the shelves. Depending on what value is set at a certain time, it slices the array
 * @returns {Array.<T>} The sliced of shelves.
 */
Library.prototype.getShelves = function(){
    return this.shelfNames.slice(0,this.SHELF_NUM_CONSTANT);
};

/**
 * Takes the given book and checks it out.
 * @param name
 * @param shelfIndex
 * @param customerName
 */
Library.prototype.checkOutBook = function (name, shelfIndex, customerName) {
    var shelf = this.shelves[shelfIndex];
    var bookIndex = 0;
    // Let's get the index of the book
    for (var b in shelf.books) {
        if (b.name == name) break;
        else bookIndex++;
    }
    // Remove it from the array in order to not show up in the shelf
    var book = shelf.books[bookIndex];
    shelf.books.splice(bookIndex, 1);
    book.checkedOut = true;
    book.checkedOutBy = customerName;
    this.checkedOutBooks.push(book);
};

/**
 * Creates a shelf for use in the library
 * @param name
 * @constructor
 */
function Shelf(name) {
    this.name = name;
    this.books = [];
}

/**
 * A constructor to create a book for use in our library
 * @param name The name of the book
 * @param fiction Boolean value. True for fiction, false for non-fiction
 * @param author The author of the book
 * @param checkedOut Boolean for if it is checked out or not.
 * @param checkedOutBy String for who has the book checked out.
 * @constructor
 */
function Book(name, fiction, author, checkedOut, checkedOutBy) {
    this.name = name;
    this.fiction = fiction;
    this.author = author;
    this.checkedOut = checkedOut;
    this.checkedOutBy = checkedOutBy;
}

