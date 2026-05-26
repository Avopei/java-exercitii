// Fisier original: ex10/dbInteraction/DBOperations.java

package dbInteraction;

public interface DBOperations{
    boolean createUser(Person p);
    boolean deleteUser(Person p);
    boolean login(String userID, String password);
}
