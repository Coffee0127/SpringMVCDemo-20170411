package service.impl;

import org.springframework.stereotype.Service;

import service.TestService;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public void testMethod() {
        System.out.println("This is a dummy test method!!");
    }

}
