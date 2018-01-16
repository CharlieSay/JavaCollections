import java.util.*;

public class WhenToUseDifferentTypes {

    public static void main(String[] args) {
        WhenToUseDifferentTypes runner = new WhenToUseDifferentTypes();
        runner.WhenShouldIUseCollection();
    }

    private void WhenShouldIUseCollection(){
        ArrayList<Book> bookNamesArrayList = new ArrayList<>();
        bookNamesArrayList.add(new Book("The Lord Of The Rings",1954));
        bookNamesArrayList.add(new Book("The Silmarillion", 1977));
        bookNamesArrayList.add(new Book("Star Wars", 1976));
        bookNamesArrayList.add(new Book("The Lord Of The Rings", 1954)); //Duplicate Will be added

        for (Book book : bookNamesArrayList){
            System.out.println(book.toString()+ " : " + book.getDateMade() + " " + book.getBookName());
        }

        System.out.println("\n");

        HashMap<String, Book> bookNamesHashMap = new LinkedHashMap<>();
        bookNamesHashMap.put("The Lord Of The Rings", new Book("The Lord Of The Rings", 1954));
        bookNamesHashMap.put("The Silmarillion", new Book("The Silmarillion", 1977));
        bookNamesHashMap.put("The Lord Of The Rings", new Book("The Lord Of The Rings", 1954)); //Will be ignored, because its the KEY is a duplicate.
        bookNamesHashMap.put("Lordy Of The Ringo", new Book("The Lord Of The Rings", 1954)); // Wont be ignored, because KEY is different
        bookNamesHashMap.put("Star Wars", new Book("Star Wars", 1976));

        for (HashMap.Entry<String, Book> entry : bookNamesHashMap.entrySet()){
            System.out.println(entry.getKey().toString() + " : "  +entry.getValue().getDateMade() + " " + entry.getValue().getBookName());
        }

        System.out.println("\n");

        HashSet<Book> bookNamesHashSet = new LinkedHashSet<>();
        Book lotr = new Book("The Lord Of The Rings",1954);
        bookNamesHashSet.add(lotr);
        bookNamesHashSet.add(new Book("The Silmarillion", 1977));
        bookNamesHashSet.add(lotr); //Will be ignored because it is the same OBJECT
        bookNamesHashSet.add(new Book("The Lord Of The Rings", 1954));// Wont be ignored
        bookNamesHashSet.add(new Book("Star Wars", 1976));



        for (Book book : bookNamesHashSet){
            System.out.println(book.toString()+ " : " + book.getDateMade() + " " + book.getBookName());
        }


    }

    class Book{
        private String bookName;
        private Integer dateMade;

        Book(String bookName, Integer dateMade){
            this.bookName = bookName;
            this.dateMade = dateMade;
        }

        private Integer getDateMade() {
            return dateMade;
        }

        private String getBookName(){
            return this.bookName;
        }
    }


}
