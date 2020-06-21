package com.game.service;

import com.game.po.Event;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventService {

    Event getEvent(Long id);

    Page<Event> listEvent(Long query, Pageable pageable);

}
