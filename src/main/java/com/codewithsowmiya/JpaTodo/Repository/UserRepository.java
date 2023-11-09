package com.codewithsowmiya.JpaTodo.Repository;

import com.codewithsowmiya.JpaTodo.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT U FROM User U WHERE U.name=:name AND U.password=:password")
    User findUserByNameAndPassword(@Param("name") String name,@Param("password") String password);
}
