package vadim.com.lib.pkg;

import vadim.com.lib.pkg.library.Library;

import java.io.File;
import java.util.Scanner;

public class App {
    private String choose;
    private Library library = new Library();

    private void menu(){
        System.out.println("""
                    APP STRUCTURE:
                    1. print all books --> id + book name   --> O(n)
                    2. select book by id  --> O(1)
                    -------------------------> description + some action with this book :
                                               1. read
                                               2. edit
                                               3. save to file
                                               5. exit --> Go to the first menu
                                               6. show a short menu
                    3. add --> add new book in library --> O(1)
                    4. delete --> delete book from library --> O(1)
                    5. find book by Name --> O(n)
                    6. find by author --> O(n)
                    7. QUIT --> shutdown --> O(1)
                    8. Show a menu --> O(1)
                    """);
    }


    public App(){
        this.choose = "-1";
    }

    private void resetFromBD(){
        final File folder = new File("BD/");
        if (folder != null) {
            for (final File fileEntry : folder.listFiles()) {
                library.loadNewBookFromBD(fileEntry);
                //System.out.println(fileEntry.getName());
            }
        }
    }

    public void launch(){
         menu();

         //load books from BD file
        resetFromBD();

         Loop:
         while (true){
            Scanner in = new Scanner(System.in);
            try{
                choose = in.nextLine();
            }
            catch(Exception er){
                System.out.println(er.getMessage());
            }

            GAY:
            switch (choose){
                case("1"):{
                    library.printListOfBooks(); //printBook
                    break;
                }
                case("2"):{ //selectBookByID
                    try {
                        library.selectBookByID();
                        menu();
                        break;
                    }catch (java.lang.NullPointerException er) {
                        System.out.println("Something went wrong! Please check your input data -- ");
                        System.out.println(er + "\n");
                    }

                    break GAY;

                    //break;
                }
                case("3"):{ // addNewBook
                    library.addBook();
                    break;
                }
                case("4"):{ //deleteBook
                    try {
                        library.deleteBookByID();
                        break;
                    }catch (java.lang.NullPointerException er) {
                        System.out.println("Something went wrong! Please check your input data -- ");
                        System.out.println(er + "\n");
                    }
                    finally {
                        break GAY;
                    }
                    //break;
                }
                case("5"):{ //findBook
                    library.findBookByName();
                    break;
                }
                case("6"):{ //findBookByAuthor
                    library.findBookByAuthor();
                    break;
                }
                case("7"):{ //Exit
                    break Loop;
                }
                case("8"):{ //Show menu
                    menu();
                    break;
                }
                default:{
                    System.out.println("Please, input a relevant number ()_()");
                }
            }
        }
    }
}
