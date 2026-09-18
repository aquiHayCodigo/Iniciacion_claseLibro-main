import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class LocalBookDao {
    String ruta;
    List<Book> libros;

    LocalBookDao(String ruta) throws Exception{
        this.ruta=ruta;
        this.libros= cargarDatos();
    }

    public List<Book> cargarDatos() throws Exception{
        File f= new File(this.ruta);
        FileReader fr= new FileReader(f);
        BufferedReader br= new BufferedReader(fr);
        String linea;
        while ((linea = br.readLine()) != null){
            String[] libros= linea.split(";");
            String isbn= libros[0];
            String nombre= libros[1];
            Book book= new Book(isbn, nombre);
            this.libros.add(book);
        }

        br.close();
        fr.close();

        return this.libros;
    }

    public void guardarDatos() throws Exception{

    }

    public void saveBook(Book libro){
        this.libros.add(libro);
    }

    public void updateBook(String isbn, String nuevoNombre){
        for (Book book : this.libros) {
            if(isbn.equals(book.getIsbn())){
                book.setName(nuevoNombre);
            }
        }
    }

    public void getAllBooks(){

    }

    public void getBookByIsbn(String isbn) throws Exception{
        for (Book book : this.libros) {
            if(isbn.equalsIgnoreCase(book.getIsbn())){
                System.out.println(book.getIsbn() + " " + book.getName());
            }
        }
    }

}
