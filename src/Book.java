public class Book {

    //hidden encapsulated data
   private int id;
   private String title;
   private String author;
   private String genre;

    //constructor
    public Book(int id, String title, String author, String genre) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    //Create "Setters" and "Getters"

    public int getId() {

        return this.id;

    }

    public void setId(int newId) {

        this.id = newId;

    }

    public void setTitle(String newTitle) {

        this.title = newTitle;
    }


    public String getTitle() {

        return this.title;
    }

    public void setAuthor(String newAuthor) {

        this.author = newAuthor;
    }

    public String getAuthor() {

        return this.author;
    }

    public String getGenre() {

        return this.genre;
    }

    public void setGenre(String newGenre) {

        this.genre = newGenre;

    }


    //Override toString() method
    public String toString() {

        return "[ID: " + id + " |" + " Title: " + title + " |" + " Author: " + author + " |" + " Genre: " + genre + "]";

    }


}
