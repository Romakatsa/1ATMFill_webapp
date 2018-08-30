import config.AppInit;
import config.DataConfig;
import config.WebConfig;
import model.ATM;
import model.User;
import model.compositeId.ATMId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import repository.UserRepository;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Roma on 25.03.2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader=AnnotationConfigContextLoader.class,classes = {DataConfig.class})
@Transactional
@Rollback
public class UserRepositoryTest {


    @Autowired
    private UserRepository repository;

    @Autowired
    private JpaTransactionManager jpaTransactionManager;

    @Test
    public void testUserAdd() throws Exception {
        User user = new User();
        user.setLogin("login1");
        user.setPassword("password1");

        this.repository.saveAndFlush(user);
        jpaTransactionManager.getEntityManagerFactory().createEntityManager().clear();
        User repUser = this.repository.findByLogin("login1");
        assertThat(repUser.getLogin()).isEqualTo("login1");
        assertThat(repUser.getAtms().size()).isEqualTo(0);
    }


}
