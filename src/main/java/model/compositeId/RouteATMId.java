package model.compositeId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Roma on 24.03.2018.
 */

@Embeddable
public class RouteATMId implements Serializable{

    @Column(name = "userLogin")
    private String userLogin;

    @Column(name = "routeId")
    private int routeId;

    @Column(name = "atmId")
    private String atmId;

}
