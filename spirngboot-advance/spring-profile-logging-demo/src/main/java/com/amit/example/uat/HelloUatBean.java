package com.amit.example.uat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Component
@Profile("uat")
class HelloUatBean {

  private static final Logger logger = LoggerFactory.getLogger(HelloUatBean.class);

  HelloUatBean(@Value("${hello.message}") String helloMessage) {
    logger.info(helloMessage);
  }

}