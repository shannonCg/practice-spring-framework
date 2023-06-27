package app.retry.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.retry.service.RetryTest1Service;
import app.retry.service.RetryTest2Service;

@RestController
@RequestMapping("retry")
public class RetryController {

    @Autowired
    private RetryTest1Service test1Service;

    @Autowired
    private RetryTest2Service test2Service;
    
    @GetMapping("test1")
	public String test1() {
        test1Service.test1("aaa");
        return "OK";
	}

    @GetMapping("test2")
	public String test2() throws IOException {
        test2Service.tt("bbb");
        return "OK";
	}
}
