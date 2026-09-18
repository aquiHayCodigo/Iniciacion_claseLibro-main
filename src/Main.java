
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean menu = true;
        BookDAO bookDao = new BookDAO("Books.txt");

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
                    List<Book> library = bookDao.getAllBooks();
                    for (Book libro : library) {
                        System.out.println(libro.getIsbn() + " Libro: " + libro.getName());
                    }
                    System.out.print("Qué libro quieres leer? Escribe su isbn: ");
                    String eleccion = sc.nextLine();
                    boolean encontrado=false;
                    String libroLeer= " ";
                    for (Book libro : library) {
                        if (eleccion.equalsIgnoreCase(libro.getIsbn())) {
                            libroLeer= libro.getName();
                            encontrado=true;
                        } 
                    }
                    if(!encontrado){
                        System.out.println("\n Ese libro no lo tenemos");
                    }else{
                        System.out.println("\n Que disfrutes de: " + libroLeer);
                    }

                    break;

                case 3:
                    
                    break;
                case 4:

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
