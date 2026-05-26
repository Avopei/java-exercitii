// Fisier original: ex10/dbInteraction/VerifyPerson.java

package dbInteraction;

public abstract class VerifyPerson extends Person{

    public boolean checkName(String name){
        if(name == null || name.length() == 0 || name.length() > 50){
            return false;
        }

        for(int i=0; i<name.length(); i++){
            char c = name.charAt(i);
            if(!Character.isLetter(c)){
                return false;
            }
        }

        return true;
    }

    public boolean checkSurname(String surname){
        if(surname == null || surname.length() == 0 || surname.length() > 50){
            return false;
        }

        for(int i=0; i<surname.length(); i++){
            char c = surname.charAt(i);
            if(!Character.isLetter(c)){
                return false;
            }
        }

        return true;
    }

    public boolean checkEmail(String email){
        if(email == null){
            return false;
        }

        return email.matches("[a-zA-Z._]+@[a-zA-Z.]+\\.[a-zA-Z]{2,5}");
    }

    public abstract boolean checkUserID(String userID);
    public abstract boolean checkPassword(String password);
}
