package pkg;

import Library.Library;
import Library.Book;

import javax.swing.*;
import java.io.File;
import java.util.Scanner;

public class App {
    private String choose;
    private Library library = new Library();

    private void menu(){
        System.out.println("APP STRUCTURE:\n" +
                "1. print all books --> id + book name   --> O(n)\n" +
                "    2. select book by id  --> O(1)\n" +
                "    -------------------------> description + some action with this book :\n" +
                "                               1. read\n" +
                "                               2. edit\n" +
                "                               3. save to file\n" +
                "                               5. exit --> Go to the first menu\n" +
                "                               6. show a short menu\n" +
                "    4. add --> add new book in library --> O(1)\n" +
                "    5. delete --> delete book from library --> O(1) \n " +
                "    6. find book by Name --> O(n)\n" +
                "    7. find by author --> O(n)\n" +
                "    8. QUIT --> shutdown --> O(1)\n" +
                "    9. Show a menu --> O(1)");
    }


    public App(){
        this.choose = "-1";
    }

    private void resetFromBD(){
        final File folder = new File("BD/");
        for (final File fileEntry : folder.listFiles()) {
            library.loadNewBookFromBD(fileEntry);
            //System.out.println(fileEntry.getName());
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
            catch(Error er){
                System.out.println(er.getMessage());
            }

            GAY:
            switch (choose){
                case("1"):{
                    library.printListOfBooks();
                    break;
                }
                case("2"):{
                    try {
                        library.selectBookByID();
                        menu();
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
                case("3"):{
                    ;
                    break;
                }
                case("4"):{
                    library.addBook();
                    break;
                }
                case("5"):{
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
                case("6"):{
                    library.findBookByName();
                    break;
                }
                case("7"):{
                    library.findBookByAuthor();
                    break;
                }
                case("8"):{
                    break Loop;
                }
                case("9"): {
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
