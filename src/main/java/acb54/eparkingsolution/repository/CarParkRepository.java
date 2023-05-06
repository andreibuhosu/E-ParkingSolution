package acb54.eparkingsolution.repository;

import acb54.eparkingsolution.model.CarPark;
import acb54.eparkingsolution.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarParkRepository extends JpaRepository<CarPark, Integer> {
    List<CarPark> findByUser(User user);
    List<CarPark> findByUserId(int userId);
//    List<CarPark> findByUserId(Integer userId);

    public Page<CarPark> findAll(Pageable pageable);

    Page<CarPark> findByUserId(Integer userId, Pageable pageable);




}

