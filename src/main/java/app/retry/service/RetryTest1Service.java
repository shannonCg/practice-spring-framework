package app.retry.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.stereotype.Service;

@Service
public class RetryTest1Service {
    private static final Logger LOGGER = LoggerFactory.getLogger(RetryTest1Service.class);

    int i = 0;

    @Retryable(backoff = @Backoff(multiplier = 2))
    public void test1(String value){
        LOGGER.info("call test1 "+value);
        test2(value);
    }

    public void test2(String value){
        LOGGER.info("call test2 "+value);
        test3(value);
    }

    public void test3(String value){
        LOGGER.info("call test3 "+value);
        if(i > 0){
            // i++;
            List<String> list = null;
            list.add(value);//throw exception
        }
    }
}
