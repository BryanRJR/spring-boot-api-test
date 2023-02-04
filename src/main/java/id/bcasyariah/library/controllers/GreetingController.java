package id.bcasyariah.library.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class GreetingController {
    // request param
    @GetMapping
    // /hello?name=bryan
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    // path variable
    @PostMapping("/post/{sapa}/{number}")
    // /post/selamat/100
    public String helloPost(@PathVariable("sapa") String sapa, @PathVariable("number") Integer number) {
        return "ini method dari hello post mapping" + sapa + " " + number;
    }

    // request body
    @PutMapping("/put")
    public String helloPut(@RequestBody String kalimat) {
        return "ini dari hello put mapping " + kalimat;
    }

}
