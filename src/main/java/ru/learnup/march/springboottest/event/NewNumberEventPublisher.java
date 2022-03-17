package ru.learnup.march.springboottest.event;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class NewNumberEventPublisher implements ApplicationContextAware {

    private ApplicationContext context;

    public void publishEvent(int goal, int number) {
        context.publishEvent(new NewNumberEvent(context, goal, number));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}