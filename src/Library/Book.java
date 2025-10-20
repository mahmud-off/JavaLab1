package Library;

import java.io.*;
import java.util.Scanner;

public class Book {
    private String name;
    private String author;
    private int id; // correct id is more than 1+

    private String path;


    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    //constructors
    public Book(){
        this.id = 0;
        this.author = "";
        this.name = "";
    }

    public Book(String auth, String name, int id){
        this.id = id;
        this.author = auth;
        this.name = name;
    }

    //methods
    public void printBookName(){
        System.out.println(this.name);
    }
    public void printBookAuthor(){
        System.out.println(this.author);
    }
    public void printBookText(){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(this.getPath()));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }

    public void editBook(){
        Scanner in = new Scanner(System.in);
        try {
            File file = new File(this.getPath());

            while (true) {
                System.out.println("Okey, give me a new book name:");
                this.setName(in.nextLine());
                System.out.println("Okey, give me a new author:");
                this.setAuthor(in.nextLine());

                this.setPath("BD/" + this.getAuthor() + "_" +  this.getName() + ".txt");

                File file2 = new File(this.getPath());
                if (file2.exists()) {
                    throw new java.io.IOException("file exists");
                }
                else{
                    file.renameTo(file2);
                    file2.delete();
                    break;
                }
            }


        }
        catch (Error er){
            System.out.println("Ошибка в чтении файла: " + er.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try(FileWriter writer = new FileWriter(this.getPath(), false))
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
            System.out.println("Book has been edited!!!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }


    }


    public void safeToFile(){

        Scanner in = new Scanner(System.in);
        System.out.println("OK, give me a path with <file_name.txt> (example: C:\\Users\\admin\\Desktop\\test.txt): ");
        String UserPath = in.nextLine();
        try(FileWriter writer = new FileWriter(UserPath, false))
        {
            writer.write(this.getName());
            writer.write("\n");
            writer.write(this.getAuthor());
            writer.write("\n");

            try {
                BufferedReader reader = new BufferedReader(new FileReader(this.getPath()));
                String line;
                //int lineNumber = 1;

                while ((line = reader.readLine()) != null) {
                    writer.write(line);
                    writer.write("\n");
                    //lineNumber++;
                }
                reader.close();
            } catch (IOException e) {
                System.out.println("Ошибка чтения файла: " + e.getMessage());
            }
            writer.close();

            System.out.println("File loaded!");
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
