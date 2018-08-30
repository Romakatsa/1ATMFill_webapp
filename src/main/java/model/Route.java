package model;

import lombok.Data;

import javax.persistence.*;
import java.time.*;
import java.util.List;

/**
 * Created by Roma on 23.03.2018.
 */

@Entity
@Data
@Table(name="Route")
public class Route {

    @Id
    private int id;

    @ManyToOne
    @JoinColumn(name="userLogin", referencedColumnName = "login")
    private User user;

    //@Temporal(TemporalType.DATE)
    private LocalDate date;

    @OneToMany(mappedBy = "route")
    private List<RouteATM> ATMAssoc;

}
