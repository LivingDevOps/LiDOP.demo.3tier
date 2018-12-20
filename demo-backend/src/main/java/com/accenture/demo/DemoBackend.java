
package com.accenture.demo;

import com.accenture.demo.com.accenture.demo.util.WordGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@CrossOrigin
public class DemoBackend {
    @RequestMapping("/")
    public String home() {
        String answer = "Hello World ";
        Long timeMillis = System.currentTimeMillis();
        answer = answer.concat(timeMillis.toString());
        return answer;
    }

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String getField(@RequestParam(value = "name", defaultValue = "anonymous", required = false) final String name) {
        String answer = "Hello ".concat(name);
        return answer;
    }

    @RequestMapping("/api")
    public String api() {
        String answer = "Hello ".concat(WordGenerator.generateWord());
        return answer;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoBackend.class, args);
    }
}
