package repository;

import model.ATMHourlyRecord;
import model.compositeId.ATMHourlyRecordId;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Roma on 24.03.2018.
 */
public interface ATMHourlyRecordRepository extends JpaRepository<ATMHourlyRecord, ATMHourlyRecordId> {


}
