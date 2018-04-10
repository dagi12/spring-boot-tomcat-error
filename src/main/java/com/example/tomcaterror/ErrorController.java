package com.example.tomcaterror;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Stworzone przez Eryk Mariankowski dnia 10.04.18.
 */
@RequestMapping("/test")
@RestController
public class ErrorController {

    @RequestMapping(method = RequestMethod.GET)
    public void test() throws Exception {
        throw new Exception("test exception");
    }

}
