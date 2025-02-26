import com.adrar.sqlcda.db.Bdd;
import com.adrar.sqlcda.model.User;
import com.adrar.sqlcda.repository.UserRepository;

public class Main {
    public static void main(String[] args) {
        User newUser = new User(
                "Quentin",
                "Petit",
                "quentin@gmail.com",
                "123456"
        );
        boolean exist = UserRepository.isExist("quentin@gmail.com");
        if(exist) {
            System.out.println("Le compte existe");
        }
        else {
            System.out.println("Le compte n'existe pas");
        }
    }
}