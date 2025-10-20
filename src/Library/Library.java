package Library;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Map;

public class Library {
    private Map<Integer, Book> books = new HashMap<Integer, Book>();
    private int countOfBooks;

    public Library(){
        this.countOfBooks = 0;
    }

    public void addBook(){
        Book newBook = new Book();
        newBook.setId(countOfBooks);

        Scanner in = new Scanner(System.in);
        System.out.println("OK, give me a book name: ");
        newBook.setName(in.nextLine());
        System.out.println("All right, then, give me an author: ");
        newBook.setAuthor(in.nextLine());

        newBook.setPath("BD/" + newBook.getAuthor() + "_" +  newBook.getName() + ".txt");

        try(FileWriter writer = new FileWriter(newBook.getPath(), false))
        {

            System.out.println("Cool, send me a book text: ");

            String txt = "";
            txt = in.nextLine();
            while( txt != ""){
                writer.write(txt);
                writer.write("\n");
                txt = in.nextLine();
            }
            writer.close();
            System.out.println("Book pushed!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        this.books.put(newBook.getId(), newBook);
        this.countOfBooks++;
    }

    public void loadNewBookFromBD(File file){
        Book newBook = new Book();
        newBook.setId(countOfBooks);

        //separate Author + name
        String[] fileNameSplited = file.getName().split("_");
        String auth = fileNameSplited[0];
        String name = fileNameSplited[1].split("\\.")[0];

        //System.out.println(auth + " " + name);

        newBook.setName(name);
        newBook.setAuthor(auth);
        newBook.setPath("BD/" + newBook.getAuthor() + "_" +  newBook.getName() + ".txt");
        this.books.put(newBook.getId(), newBook);
        this.countOfBooks++;
    }

    public void deleteBookByID(){
        int tmpID = -1;
        System.out.println("enter book id: ");
        Scanner in = new Scanner(System.in);

        tmpID = in.nextInt();
        try {
            File file = new File(books.get(tmpID - 1).getPath());
            boolean delete = file.delete();
            if (delete == true) {
                System.out.println("Book are removed!");
                this.books.remove(tmpID - 1);
            }
        }
        catch (Error er){
            System.out.println("Ошибка в чтении файла: " + er.getMessage());
        }
    }

    public void findBookByName(){
        //линейный поиск за O(n) --- n - кол-во книг
        String name = "";
        System.out.println("enter book name: ");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
        Boolean print = true;
        for( int i = 0; i < books.size(); i++){
            if(Objects.equals(name, books.get(i).getName())){
                System.out.println(i+1 + " " + books.get(i).getName());
                print = false;
            }
        }
        if(print) {
            System.out.println("There is not such book =(...");
        }
    }

    public void findBookByAuthor(){
        //линейный поиск за O(n) --- n - кол-во книг
        String author = "";
        System.out.println("enter book Author: ");
        Scanner in = new Scanner(System.in);
        author = in.nextLine();
        Boolean print = true;
        for( int i = 0; i < books.size(); i++){
            if(Objects.equals(author, books.get(i).getAuthor())){
                System.out.println(i+1 + " " + books.get(i).getName());
            }
        }
        if(print) {
            System.out.println("There is not such book =(...");
        }
    }

    private void showBookMenu(){
        System.out.println("1. read\n" +
                "        2. edit\n" +
                "        3. save to file\n" +
                "        4. load from file\n" +
                "        5. exit\n" +
                "        6. show menu");
    }

    public void selectBookByID(){
        int tmpID = -1;
        System.out.println("enter book id: ");
        Scanner in = new Scanner(System.in);

        tmpID = in.nextInt();
        Book selectedBook = this.books.get(tmpID - 1);

        System.out.println("Book is selected!\n");
        showBookMenu();

        String choose = "-1";
        Loop:
        while (true) {
            choose = in.nextLine();

            switch (choose) {
                case ("1"): {
                    selectedBook.printBookName();
                    selectedBook.printBookAuthor();
                    System.out.println();
                    selectedBook.printBookText();
                    break;
                }
                case ("2"): {
                    selectedBook.editBook();
                    break;
                }
                case ("3"): {
                    selectedBook.safeToFile();
                    break;
                }
                case ("4"): {
                    break;
                }
                case ("5"): {
                    break Loop;
                }
                case ("6"): {
                    showBookMenu();
                    break;
                }
                default:{
                    System.out.println("Please, enter a relevant value (-_-)");
                }
            }
        }
    }

    public void printListOfBooks(){
        Boolean print = true;
        for (int i = 0; i < books.size(); i++){
            System.out.println(i+1 + " " + books.get(i).getName());
            print = false;
        }
        if(print){
            System.out.println("There are not books... =-(");
        }
    }

}
