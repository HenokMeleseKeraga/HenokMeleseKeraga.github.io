import java.util.ArrayList;
import java.util.List;

public class db {
    private List<User> db=new ArrayList<>();


//    public db() {
//
//        db.add(new User("henok" ,"123"));
//
//
//    }
    public void add (User user){
        db.add(user);
    }

    public List<User> getDb() {
        return db;
    }
}
