package model;

import model.compositeId.RouteATMId;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Roma on 24.03.2018.
 */
@Entity
@Table(name = "RouteATM")
public class RouteATM {


    @EmbeddedId
    private RouteATMId id;


    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "id",insertable=false, updatable=false)
    private Route route;


    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "atmId", referencedColumnName = "id",insertable=false, updatable=false),
            @JoinColumn(name = "userLogin", referencedColumnName = "userLogin",insertable=false, updatable=false)
    })
    private ATM atm;

    @Column(name = "dateTime")
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateTime;

}
