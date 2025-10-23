class Book
{
    String name;

    Book(String name)
    {
        this.name = name;
    }
}

class Library
{
    // Aggregation: books are independent objects passed from outside
    Book[] books;

    Library(Book[] books)
    {
        this.books = books;
    }

    void showBooks()
    {
        for (Book b : books)
        {
            System.out.println("Book: " + b.name);
        }
    }
}

public class Aggregation
{
    public static void main(String[] args)
    {
        Book b1 = new Book("1984");
        Book b2 = new Book("The Hobbit");

        // books exist even without library
        Book [] array = {b1,b2};
        Library lib = new Library(array);
        lib.showBooks();
        System.out.println(lib.toString());
        System.out.println(b1.toString());

    }
}
