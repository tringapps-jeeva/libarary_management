package admin;
import user.*;
import java.util.*;
public class librarian
{
public 
static Collection<userlist> ul=new ArrayList<userlist>();
public
static Collection<category> ct=new ArrayList<category>();
public
static ArrayList<addbooks> booksadd=new ArrayList<addbooks>();
Scanner s1=new Scanner(System.in);
String username="jeeva";
String password="1234";
int choice;
int count=0;
int rating=1;
int quantity;
int totalquantity;

public void adduser()
{
System.out.println("Enter the user name:");
String uname=s1.next();
System.out.println("Enter the password");
String upass=s1.next();
ul.add(new userlist(uname,upass));
//System.out.println(ul);
System.out.print("----------------------\n");
Iterator<userlist> i=ul.iterator();
while(i.hasNext())
{
    userlist ul=i.next();
    System.out.print(ul);
}
System.out.print("\n-----------------------");
System.out.print("\n do u want to add more user: yes or no:");
String get=s1.next();
if(get.equals("YES")||get.equals("yes"))
{
adduser();
}
else
{
listshow();
}
}
public void listshow()
{
System.out.println("----------------------------");
System.out.println("1. Add category");
System.out.println("2. Add books");
System.out.println("3. Edit quantity of book");
System.out.println("4. Delete Books");
System.out.println("5. Set penalty");
System.out.println("6. Add user");
System.out.println("7. Show report for defaulter list");
System.out.println("8. Show report of books not returned");
System.out.println("9. Update user penalty amount and book return status");
System.out.println("10. update current date");
System.out.println("11. LOGOUT");
System.out.println("----------------------------");
System.out.print("Enter your choice:");
choice=s1.nextInt();
switch(choice)
{
case 1:
System.out.println("how many categories:");
int catergory_no=s1.nextInt();
category(catergory_no);
break;
case 2:
addBooks();
break;
case 3:
break;
case 4:
break;
case 5:
break;
case 6:
adduser();
break;   
case 7:
break;
case 8:
break;
case 9:
break;
case 10:
break;
case 11:
return;
}
}

public void category(int cat1)
 {
  for(int i=0; i<cat1; i++)
 {
  System.out.print("Enter the category name:");
  String cat=s1.next();
  ct.add(new category(cat));
  //System.out.print(ct);
 }
 System.out.println("Displaying Categories:");
Iterator<category> z = ct.iterator();
while(z.hasNext())
{
    category ct=z.next(); 
    System.out.print(ct);
}
System.out.println("\n");
listshow();
}

public void addBooks()
{
    System.out.println("\nCATEGORIES:");
    Iterator<category> z=ct.iterator();
    while(z.hasNext())
    {
        category ct=z.next(); 
        System.out.print(ct);
    }
    System.out.println("\nEnter the category name:");
    String cat_name=s1.next();
    Object category_name = " ";
    int flag=0;
    Iterator<category> i=ct.iterator();
    while(i.hasNext())
    {
        category catobj=i.next();
        if(catobj.getName().equals(cat_name))
        {
            category_name =catobj;
            flag=1;
        }
    }
    if(flag==0)
    {
        System.out.println("Catergory not found");
    }
    //System.out.println(cat_name);
    if(flag==1)
    {
        System.out.println("enter the book title");
        String book_title=s1.next();
        System.out.println("enter the book author");
        String book_author=s1.next();
        System.out.println("enter the book quantity:");
        int bookquantity=s1.nextInt();
        quantity=0;
        totalquantity=bookquantity;
        quantity+=totalquantity;
        booksadd.add(new addbooks(category_name,book_title,book_author,rating,bookquantity,totalquantity,quantity));
        System.out.println(booksadd);
    }
    System.out.println();
    listshow();   
}

public void login()
{
System.out.print("LIBRARIAN NAME:");
String username1=s1.nextLine();
System.out.print("PASSWORD:");
String password1=s1.nextLine();
if(username.equals(username1)&&password.equals(password1))
{
System.out.println("\n**login sucessfully**\n");
listshow();
}
else
{
System.out.println("invalid username or password");
return;
}
}
}


