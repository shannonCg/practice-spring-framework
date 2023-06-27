package app.retry.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

@Service
public class RetryTest2Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryTest2Service.class);

    @Autowired
    private RetryTest1Service test1Service;
    
    int i = 0;
    
    @Retryable(exclude={NullPointerException.class})
    public void tt(String value) throws IOException{
        LOGGER.info("call tt start:"+value);
        test1Service.test1(value);
        LOGGER.info("call tt end:"+value);
        if(i > 0){
            // i++;
            List<String> list = null;
            list.add(value);//throw exception
        }
        throw new IOException();
    }

}
