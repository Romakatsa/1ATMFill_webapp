package model.compositeId;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Roma on 24.03.2018.
 */

@Embeddable
public class ATMId implements Serializable{

    public ATMId(String id, String login) {
        this.id = id;
        this.userLogin = login;
    }

    public ATMId() {
    }

    @Column(name = "id")
    private String id;

    @Column(name = "userLogin")
    private String userLogin;

}
