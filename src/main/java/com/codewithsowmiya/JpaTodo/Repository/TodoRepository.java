package com.codewithsowmiya.JpaTodo.Repository;

import com.codewithsowmiya.JpaTodo.Model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository  extends JpaRepository<Todo,Integer> {
}
