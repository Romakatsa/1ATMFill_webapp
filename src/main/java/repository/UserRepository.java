package repository;

import model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roma on 24.03.2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findByLogin(String login);

}

