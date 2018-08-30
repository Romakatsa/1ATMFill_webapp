package repository;

import model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Roma on 24.03.2018.
 */
@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {


}
