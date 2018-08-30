package model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Roma on 23.03.2018.
 */

@Entity
@Data
@Table(name="\"user\"")
public class User {

    @Id
    private String login;

    private String password;

    @OneToMany(mappedBy="user",cascade = CascadeType.ALL ,fetch = FetchType.EAGER)
    private List<ATM> atms = new ArrayList<>();

}
