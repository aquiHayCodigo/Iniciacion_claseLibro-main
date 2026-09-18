import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookDAO {
    Scanner sc = new Scanner(System.in);
    public String ruta;

    BookDAO(String ruta) {
        this.ruta = ruta;
    }

    // Create -- INSERT libro INTO Libro;
    // Update -- UPDATE libro INTO Libro;

    public void saveBook(Book book) throws Exception {
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f, true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(book.getIsbn() + ";" + book.getName());
        bw.newLine();
        bw.close();
        fw.close();
    }

    // READ -- SELECT * FROM Books

    public List<Book> getAllBooks() throws Exception {
        File f = new File(this.ruta);
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        List<Book> libreria = new ArrayList<>();
        while ((linea = br.readLine()) != null) {
            String[] libroStrings = linea.split(";");
            String isbn = libroStrings[0].trim();
            String nombre = libroStrings[1].trim();
            Book book = new Book(isbn, nombre);
            libreria.add(book);
        }
        fr.close();
        br.close();

        return libreria;
    }

    // READ -- SELECT * FROM Books WHERE isbn = {isbn}
    public Book getBookByIsbn(String isbn) throws Exception {
        List<Book> library = getAllBooks();
        boolean encontrado = false;
        String libroLeer = " ";
        for (Book libro : library) {
            if (isbn.equalsIgnoreCase(libro.getIsbn())) {
                libroLeer = libro.getName();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("\n Ese libro no lo tenemos");
        } else {
            System.out.println("Que disfrutes de -->" + libroLeer);
        }
        return null;
    }

    // UPDATE
    public void updateBookByIsbn(String isbn) throws Exception {
        List<Book> library = getAllBooks();
        boolean encontrado = false;
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Book libro : library) {
            if (isbn.equalsIgnoreCase(libro.getIsbn().trim())) {
                System.out.println("Cómo quieres llamar al libro con isbn: " + isbn);
                String nuevoNombre = sc.nextLine();
                System.out.println("Escribe un nuevo isbn si quieres: ");
                String nuevoIsbn = sc.nextLine();

                Book book = new Book(nuevoIsbn, nuevoNombre);
                bw.write(book.getIsbn() + ";" + book.getName());
                bw.newLine();
                encontrado = true;

            } else {
                bw.write(libro.getIsbn() + ";" + libro.getName());
                bw.newLine();
            } 
        }
        if (!encontrado) {
            System.out.println("No contamos con un libro con isbn: " + isbn);
        }
        bw.close();
        fw.close();
    }

    // DELETE
    public void deteleBook(String isbn) throws Exception {
        List<Book> library = getAllBooks();
        boolean encontrado = false;
        File f = new File(this.ruta);
        FileWriter fw = new FileWriter(f, false);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Book libro : library) {
            if (isbn.equalsIgnoreCase(libro.getIsbn())) {
                encontrado = true;
            }
        }

        if (encontrado) {
            for (Book libros : library) {
                if (!isbn.equalsIgnoreCase(libros.getIsbn())) {
                    bw.write(libros.getIsbn() + ";" + libros.getName());
                    bw.newLine();
                }
            }
        } else {
            System.out.println("No contamos con un libro con isbn: " + isbn);
        }
        bw.close();
        fw.close();

    }

}
