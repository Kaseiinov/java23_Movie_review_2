package kg.attractor.movie_review_java23.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("world", "world");
        return "index";
    }
}
