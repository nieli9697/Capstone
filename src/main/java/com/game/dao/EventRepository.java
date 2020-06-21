package com.game.dao;

import com.game.po.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where e.id <= ?1")
    Page<Event> findByQuery (Long query, Pageable pageable);
}
