package com.blackcat.springhibernatesandbox;

import com.blackcat.springhibernatesandbox.entity.Beach;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BeachRepository extends CrudRepository<Beach, Long> {

    @Query("select b from Beach b join fetch b.items i where :id = i.id")
    Beach findByItemId(@Param("id") Long id);
}
