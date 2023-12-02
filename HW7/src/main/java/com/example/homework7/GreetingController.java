package com.example.homework7;

import com.example.homework7.domain.Message;
import com.example.homework7.repository.UseDataBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Controller
public class GreetingController {

    private UseDataBase messageRepo = new UseDataBase();

    @GetMapping
    public String greeting(@RequestParam(name="name", required=false,
            defaultValue="User") String name, Map <String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/messages")
    public String main(Map<String, Object> model){
        Iterable<Message> messages = messageRepo.getListObject();
        model.put("messages", messages);
        return "main";
    }

    @PostMapping("messages")
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model){
        Message message = new Message(text, tag);

        messageRepo.save(message);

        Iterable<Message> messages = messageRepo.getListObject();

        model.put("messages", messages);

        return "main";
    }


    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Message> messages;

        if (filter != null && !filter.isEmpty()) {
            messages = messageRepo.searchForName(filter);
        } else {
            messages = messageRepo.getListObject();
        }

        model.put("messages", messages);

        return "main";
    }
}
