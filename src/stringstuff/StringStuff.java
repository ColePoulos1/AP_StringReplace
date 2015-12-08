/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringstuff;
import java.util.*;
/**
 *
 * @author jeffreyyee
 */
public class StringStuff {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String val = StringUtil.apcsReplaceAll("to be or not to be","to","2");
        System.out.println(val);
        
        List<Person>  name = new ArrayList<Person>();
        name.add(new Person("John","C"));
        name.add(new Person("Robert","D"));
        
        String stuff = StringUtil.replaceNameNickName("John and Bill went to school with Robert",name);
        System.out.println(stuff);
    }
}
class Person
{
    String firstName;
    String nickName;
    Person(String _firstName,String _nickName)
    {
        firstName = _firstName;
        nickName = _nickName;
    }
    public String getFirstName()
    {
        return(firstName);
    }
    public String getNickname()
    {
        return(nickName);
    }
}
class StringUtil
{
    public static String apcsReplaceAll(String str,String oldStr,String newStr)
    {
        String ret = "";
        for(int i=0;i<str.length();i++)
        {
            if(i+oldStr.length() <= str.length() && str.substring(i,i+oldStr.length()).equals(oldStr))
            {
                ret+=newStr;
                i+=oldStr.length()-1;
            }
            else
                ret+=str.substring(i, i+1);
        }
        return ret;
    }
    public static String replaceNameNickName(String str,List<Person> people)
    {
        for(Person temp:people)
        {
            str = StringUtil.apcsReplaceAll(str, temp.getFirstName(), temp.getNickname());
        }
        return str;
    }
}