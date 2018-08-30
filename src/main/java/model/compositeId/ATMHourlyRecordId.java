package model.compositeId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Roma on 24.03.2018.
 */

@Embeddable
public class ATMHourlyRecordId implements Serializable {

    @Column(name = "userLogin")
    private String userLogin;

    @Column(name = "atmId")
    private String atmId;

    @Column(name="dateTime")
    private LocalDateTime dateTime;

}
