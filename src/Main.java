
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        BookDAO bookDao = new BookDAO("Books.txt");
        List<Book> library;

        while (menu) {
            System.out.println("1. Crear Libro");
            System.out.println("2. Leer Libro");
            System.out.println("3. Actualizar Libro");
            System.out.println("4. Eliminar Libro");
            System.out.println("0. Salir");

            int opc = sc.nextInt(); sc.nextLine();

            switch (opc) {
                case 1:
                    System.out.print("INTRODUCE EL ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("INTRODUCE EL NOMBRE: ");
                    String name = sc.nextLine();

                    Book book = new Book(isbn, name);
                    bookDao.saveBook(book);

                    break;

                case 2:
                    library = bookDao.getAllBooks();
                    for (Book libro : library) {
                        System.out.println(libro.getIsbn() + " Libro: " + libro.getName());
                    }
                    System.out.print("Qué libro quieres leer? Escribe su isbn: ");
                    String eleccion = sc.nextLine();

                    bookDao.getBookByIsbn(eleccion);

                    break;

                case 3:
                    library = bookDao.getAllBooks();
                    for (Book libro : library) {
                        System.out.println(libro.getIsbn() + " Libro: " + libro.getName());
                    }
                    System.out.print("Qué libro quieres actualizar? Escribe su isbn: ");
                    String eleccionUpdate = sc.nextLine();
                    eleccionUpdate.toLowerCase().trim();

                    bookDao.updateBookByIsbn(eleccionUpdate);
                    break;
                case 4:
                    library = bookDao.getAllBooks();
                    for (Book libro : library) {
                        System.out.println(libro.getIsbn() + " Libro: " + libro.getName());
                    }
                    System.out.print("Qué libro quieres eliminar? Escribe su isbn: ");
                    String eleccionDelete = sc.nextLine();
                    eleccionDelete.toLowerCase().trim();
  
                    bookDao.deteleBook(eleccionDelete);
                    break;
                case 0:
                    menu = false;
                    break;
                default:
                    throw new AssertionError();
            }

        }
        sc.close();
    }
}
