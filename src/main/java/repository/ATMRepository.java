package repository;

import model.ATM;
import model.compositeId.ATMId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Roma on 24.03.2018.
 */
public interface ATMRepository extends JpaRepository<ATM, ATMId> {


}
