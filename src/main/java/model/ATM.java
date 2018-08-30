package model;

import lombok.Data;
import model.compositeId.ATMId;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Roma on 23.03.2018.
 */

@Entity
@Data
@Table(name="ATM")
public class ATM {

    @EmbeddedId
    private ATMId id;

    @ManyToOne
    @JoinColumn(name = "userLogin", referencedColumnName = "login", insertable=false, updatable=false)
    private User user;

    private String address;

    private double lat;

    private double lon;

    private int cash;

    private double minServiceLvl;

    @OneToMany(mappedBy = "atm")
    private List<RouteATM> routesAssoc;
}
