package com.srm.user.repository;

import com.srm.user.model.UserClass;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserClass,Integer> {
    UserClass findById(int id);
    UserClass findByEmail(String email);
}
