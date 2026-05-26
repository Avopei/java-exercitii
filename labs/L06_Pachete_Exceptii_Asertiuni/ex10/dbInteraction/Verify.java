// Fisier original: ex10/dbInteraction/Verify.java

package dbInteraction;

public class Verify extends VerifyPerson{

    public boolean checkUserID(String userID){
        if(userID == null || userID.length() == 0){
            return false;
        }

        for(int i=0; i<userID.length(); i++){
            char c = userID.charAt(i);
            if(!Character.isLetterOrDigit(c) && c != '.'){
                return false;
            }
        }

        return true;
    }

    public boolean checkPassword(String password){
        boolean areLiteraMare = false;
        boolean areCaracterSpecial = false;

        if(password == null || password.length() < 8){
            return false;
        }

        for(int i=0; i<password.length(); i++){
            char c = password.charAt(i);

            if(Character.isUpperCase(c)){
                areLiteraMare = true;
            }

            if(!Character.isLetterOrDigit(c)){
                areCaracterSpecial = true;
            }
        }

        return areLiteraMare && areCaracterSpecial;
    }
}
