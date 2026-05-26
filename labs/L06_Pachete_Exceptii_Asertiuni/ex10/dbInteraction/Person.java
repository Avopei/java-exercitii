// Fisier original: ex10/dbInteraction/Person.java

package dbInteraction;

public class Person{
    private String name;
    private String surname;
    private String email;
    private String userID;
    private String password;

    public Person(){
        name = "";
        surname = "";
        email = "";
        userID = "";
        password = "";
    }

    public Person(String name, String surname, String email, String userID, String password){
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.userID = userID;
        this.password = password;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setUserID(String userID){
        this.userID = userID;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getEmail(){
        return email;
    }

    public String getUserID(){
        return userID;
    }

    public String getPassword(){
        return password;
    }

    public String toString(){
        return name + " " + surname + " - " + email + " - " + userID;
    }
}
