import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.test.context.junit4.SpringRunner;
import repository.UserRepository;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Roma on 25.03.2018.
 */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryDBTest {


    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository repository;

    @Test
    public void testExample() throws Exception {
        User user = new User();
        user.setLogin("login1");
        user.setPassword("password1");

        this.entityManager.persistAndFlush(user);
        entityManager.clear();
        User repUser = this.repository.findByLogin("login1");
        assertThat(repUser.getLogin()).isEqualTo("login1");
        assertThat(user.getAtms().size()).isEqualTo(0);
    }


}
