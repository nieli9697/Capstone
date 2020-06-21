package com.game.service;

import com.game.dao.EventRepository;
import com.game.po.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImplementation implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public Event getEvent(Long id) {
        return eventRepository.getOne(id);
    }

    @Override
    public Page<Event> listEvent(Long query, Pageable pageable) {
        return eventRepository.findByQuery(query, pageable);
    }
}
