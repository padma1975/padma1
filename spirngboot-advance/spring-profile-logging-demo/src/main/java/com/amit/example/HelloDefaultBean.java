package com.amit.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
class HelloDefaultBean {

  private static final Logger logger = LoggerFactory.getLogger(HelloDefaultBean.class);

  HelloDefaultBean(@Value("${hello.message}") String helloMessage) {
    logger.info(helloMessage);
  }

}
