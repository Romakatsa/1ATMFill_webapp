package model;

import lombok.Data;
import model.compositeId.ATMHourlyRecordId;

import javax.persistence.*;

/**
 * Created by Roma on 23.03.2018.
 */

@Entity
@Data
@Table(name="ATMHourlyRecord")
public class ATMHourlyRecord {


    @EmbeddedId
    private ATMHourlyRecordId id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "userLogin", referencedColumnName = "userLogin",insertable=false, updatable=false),
            @JoinColumn(name = "atmId", referencedColumnName = "id",insertable=false, updatable=false)
    })
    private ATM ATM;

    private int withdrawalsAmount;
    private int withdrawalsNumber;

}
