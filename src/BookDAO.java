import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public String ruta;

    BookDAO(String ruta){
        this.ruta=ruta;
    }        
     
    //Create -- INSERT libro INTO Libro;
    //Update -- UPDATE libro INTO Libro;
    
    public void saveBook(Book book) throws Exception{
        File f= new File(this.ruta);
        FileWriter fw= new FileWriter(f, true);
        BufferedWriter bw= new BufferedWriter(fw);
        bw.write(book.getIsbn() + ";" + book.getName());
        bw.newLine();
        bw.close();
        fw.close();
    }

    //Read -- SELECT * FROM Books
    //Read -- SELECT * FROM Books WHERE isbn = {isbn}
    public List <Book> getAllBooks() throws Exception{
        File f= new File(this.ruta);
        FileReader fr= new FileReader(f);
        BufferedReader br= new BufferedReader(fr);
        String linea;
        List <Book> libreria= new ArrayList<>();
        while((linea= br.readLine())!=null){
            String[] libroStrings= linea.split(";");
            String isbn= libroStrings[0].trim();
            String nombre= libroStrings[1].trim();
            Book book= new Book(isbn, nombre);
            libreria.add(book);
        }
        fr.close();
        br.close();

        return libreria;
    } 
   
    public Book getBookByIsbn(String isbn){
        return null;
    }

    //Delete -- 

    public void deteleBook(String isbn){

    }


}
