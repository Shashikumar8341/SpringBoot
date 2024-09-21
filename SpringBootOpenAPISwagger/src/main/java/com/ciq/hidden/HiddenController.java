package com.ciq.hidden;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Hidden
@RestController
@RequestMapping("/api/hidden")
public class HiddenController {

    @GetMapping("/hidden-example")
    public String hiddenExample() {
        return "This endpoint is hidden from API documentation";
    }
}
