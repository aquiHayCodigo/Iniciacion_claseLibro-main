public class Book implements Comparable<Book>{
    private String isbn; 
    private String name;
    
    /* libro(){}; */

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public String getIsbn(){
        return this.isbn;
    }
    public String getName(){
        return this.name;
    }

    public String toString(){
        String linea;
        linea = "El isbn: " + this.getIsbn() + ". Nombre: " + this.getName();
        return linea;
    }

    @Override 
    public int compareTo(Book book){
        return this.name.compareTo(book.getName());
    }



}
