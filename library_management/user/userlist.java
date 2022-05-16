package user;
public class userlist
{
String uname;
String upass;
public userlist(String uname,String upass)
{
this.uname=uname;
this.upass=upass;
}
public String getName()
{
    return uname;
}
public String getPass()
{
    return upass;
}
public String toString()
{
return uname+ " " + upass + "\n";
}
}
