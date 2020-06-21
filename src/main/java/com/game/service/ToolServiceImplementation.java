package com.game.service;

import com.game.dao.ToolRepository;
import com.game.po.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolServiceImplementation implements ToolService {

    @Autowired
    private ToolRepository toolRepository;

    @Override
    public Tool getTool(Long id) {
        return toolRepository.getOne(id);
    }
}
