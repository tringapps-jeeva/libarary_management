package user;
import admin.*;
import java.util.*;
public class user extends librarian 
{
Scanner s1=new Scanner(System.in);
int ch1;
boolean flag=false; 
int count=0;
String catergory_name="";
public void login()
{
    System.out.println("-----login----");
    System.out.println("Enter the given name:");
    String  uname=s1.next();
    System.out.println("Enter the given password:");
    String upass=s1.next();
    Iterator<userlist> i = ul.iterator();
    while(i.hasNext())
      {
          userlist ud=i.next();
          if(ud.getName().equals(uname) && ud.getPass().equals(upass))
          {
              System.out.println("login successfully");
              System.out.println("-------------------");
              flag=true;
              listshow();
          }
        }
          if(!flag){
              System.out.println("Invalid username or password");
              return;
          }     
}
public void listshow()
{
    System.out.println("1.Change Password");
    System.out.println("2. Browse Books By Category");
    System.out.println("3. Search Books By Author and Title");
    System.out.println("4. Rent Books");
    System.out.println("5. See Books rented with due date");
    System.out.println("6. logout");
    System.out.println("Enter your choice:");
    ch1=s1.nextInt();
    switch(ch1){
        case 1:   
        changePassword();   
        break;
        case 2:
        browse();
        break;
        case 3:
        searchbooks();
        break;
        case 4:
        rentBooks();
        break;
        case 5:
        break;
        case 6:
        return;
    }
}

public void changePassword()
{
    System.out.println("Enter the name:");
    String uname=s1.next();
    System.out.println("Enter the new password:");
    String upass=s1.next();
    ul.add(new userlist(uname,upass));
    System.out.println("Password reset successfully");
    listshow();
}

public void browse() {
    boolean char_found = false;
    System.out.println("Enter the category name:");
    catergory_name = s1.next();

    Iterator<addbooks> browse = booksadd.iterator();
    while (browse.hasNext()) {
        addbooks ad = browse.next();
        String books = ad.getcategoryName().toString();
        System.out.println(books);
        if (books.equals(catergory_name)) {
            System.out.println(ad);
            char_found = true;
        }
    }
    if (char_found) {
        System.out.println("no category found");
    }
    listshow();
}
public void searchbooks()
{
    boolean book_found=false;
    System.out.println("Enter the book-title:");
    String booktitle=s1.next();
    System.out.println("Enter the Author name:");
    String authorname=s1.next();
    Iterator<addbooks> browse = booksadd.iterator();
    while(browse.hasNext())
      {
          addbooks ad=browse.next();
          if((ad.getbookAuthor().equals(authorname))&&(ad.getbookTitle().equals(booktitle)))
          {
              System.out.println("Book is found");
              System.out.println(ad.getbookTitle());
              book_found=true;
          }
        }
          if(!book_found)
          {
              System.out.println("no book found");
          }  
          listshow(); 
}
public void rentBooks()
{
        System.out.println("enter the category name you want");
        String rentCategory = s1.next();
        boolean find = false;
        boolean bookDetailFound = false;
        boolean penaltyFound = false;

        String searchbookTitle = " ";
        int count = 0;
        int count2 = 0;
       String categorysName = ct.toString();
        System.out.println(categorysName);
        if (categorysName.contains(rentCategory)) {
            find = true;
            for (addbooks books : booksadd) {

                if (books.getcategoryName().toString().equals(rentCategory)) {
                    System.out.println(books);// if true , print the statement
                }

            }
            System.out.println("enter the book title");
            searchbookTitle = s1.next();
            for (addbooks books : booksadd) {
                if (books.getbookTitle().equals(searchbookTitle)) {
                    bookDetailFound = true;
                    System.out.println("How many quantity of  book you want to rent");
                    int userQuantity = s1.nextInt();
                    int Quantity = books.getbookquantity();
                    int rating = books.getrating();
                    if (userQuantity <= books.getbookquantity()) {

                        Quantity -= userQuantity;
                       // System.out.println(Quantity);
                        rating += 1;
                       // System.out.println(rating);
                        Iterator<addbooks> rentItr = booksadd.iterator();
                        while (rentItr.hasNext()) {
                            addbooks rentBooks = rentItr.next();
                            count2++;
                            if (rentBooks.getbookTitle().equals(searchbookTitle)) {
                                count += count2;
                            }
                        }
                        count -= 1;
                      //  System.out.println(count);
                        booksadd.set(count,
                                new addbooks(books.getcategoryName(), books.getbookTitle(), books.getbookAuthor(),
                                        books.getrating(),
                                        books.getbookquantity(), books.gettotalquantity(), books.getquantity()));
                        System.out.println("Book Rented Successfully");
                        penaltyFound = true;
                    } else {
                        System.out.println("Quantity you want is not available");
                    }
                }
            }
        }
}
}