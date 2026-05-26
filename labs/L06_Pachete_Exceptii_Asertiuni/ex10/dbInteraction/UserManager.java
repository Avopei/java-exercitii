// Fisier original: ex10/dbInteraction/UserManager.java

package dbInteraction;

public class UserManager extends Verify implements DBOperations{
    private Person persoane[];
    private int nrPersoane;

    public UserManager(){
        persoane = new Person[10];
        nrPersoane = 0;
    }

    public boolean createUser(Person p){
        if(nrPersoane >= persoane.length){
            System.out.println("Lista este plina.");
            return false;
        }

        if(!checkName(p.getName())){
            System.out.println("Nume incorect.");
            return false;
        }

        if(!checkSurname(p.getSurname())){
            System.out.println("Prenume incorect.");
            return false;
        }

        if(!checkEmail(p.getEmail())){
            System.out.println("Email incorect.");
            return false;
        }

        if(!checkUserID(p.getUserID())){
            System.out.println("UserID incorect.");
            return false;
        }

        if(!checkPassword(p.getPassword())){
            System.out.println("Parola incorecta.");
            return false;
        }

        for(int i=0; i<nrPersoane; i++){
            if(persoane[i].getUserID().equals(p.getUserID())){
                System.out.println("Exista deja un utilizator cu acest userID.");
                return false;
            }
        }

        persoane[nrPersoane] = p;
        nrPersoane++;
        return true;
    }

    public boolean deleteUser(Person p){
        for(int i=0; i<nrPersoane; i++){
            if(persoane[i].getUserID().equals(p.getUserID())){
                for(int j=i; j<nrPersoane-1; j++){
                    persoane[j] = persoane[j+1];
                }
                persoane[nrPersoane-1] = null;
                nrPersoane--;
                return true;
            }
        }

        return false;
    }

    public boolean login(String userID, String password){
        for(int i=0; i<nrPersoane; i++){
            if(persoane[i].getUserID().equals(userID) && persoane[i].getPassword().equals(password)){
                return true;
            }
        }

        return false;
    }

    public void displayUsers(){
        if(nrPersoane == 0){
            System.out.println("Nu exista utilizatori.");
            return;
        }

        for(int i=0; i<nrPersoane; i++){
            System.out.println(persoane[i]);
        }
    }
}
