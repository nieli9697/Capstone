package com.game.web;

import com.game.service.EventService;
import com.game.service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {

    @Autowired
    private EventService eventService;

    @Autowired
    private ToolService toolService;


//    public int sum = 0;

    @PostMapping("/game")
    public String events(@PageableDefault(size = 7, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam String query, @RequestParam String check, @RequestParam String sum,
                         Model model) {
        if (query == "") {
            query = "1";
        }

        if (check == "") {
            check = "0";
        }

        if (sum == "") {
            sum = "0";
        }

        model.addAttribute("page", eventService.listEvent(Long.valueOf(query), pageable));
        model.addAttribute("curr", eventService.getEvent(Long.valueOf(query)+Long.valueOf(1)));
        model.addAttribute("tool", toolService.getTool(Long.valueOf(query)));

        int tmp = Integer.valueOf(query);
        query = String.valueOf(tmp+1);
        model.addAttribute("query", query);

        int tmp1 = Integer.valueOf(check);
        int tmp2 = Integer.valueOf(sum);
        tmp2 += tmp1;
        String currSum = String.valueOf(tmp2);
        //check = String.valueOf(sum);
        model.addAttribute("check", check);
        model.addAttribute("currSum", currSum);

        return "game";
    }
}
