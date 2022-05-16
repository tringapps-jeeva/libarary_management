//import java.io.*;
import java.util.*;
import admin.*;
import user.*;
public class library_management
{
static Scanner  s1 = new Scanner(System.in);
public static void main(String args[])
{
int ch;
do{
System.out.println("--------------");
System.out.println("1. LIBRARIAN");
System.out.println("2. USER");
System.out.println("3. EXIT");
System.out.println("--------------\n");
System.out.print("Enter the choice:");
ch=s1.nextInt();
switch(ch)
{
case 1:
librarian lb=new librarian();
lb.login();
break;
case 2:
user us=new user();
us.login();
break;
case 3:
System.out.print("Exiting..");
System.exit(0);
default:
System.out.println("invalid choice");
break;
}
}while(ch<=2);
}
}

