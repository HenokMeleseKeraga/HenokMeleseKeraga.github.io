import java.util.List;

public class Validate {

    public static boolean userValidate(List<User> allUser ,User user){
        for(User u: allUser){
            if(u.getUsername().equals(user.getUsername())&&(u.getPassword().equals(user.getPassword()))){
                return true;
            }
        }

        return false;
    }
}
