package ru.learnup.march.springboottest.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class NewNumberEventListener implements ApplicationListener<NewNumberEvent> {

    @Override
    public void onApplicationEvent(NewNumberEvent event) {
        ApplicationContext context = event.getContext();
        if (event.getGoal() > event.getNumber()) {
            System.out.println(context.getMessage("higher", null, Locale.getDefault()));
        } else if (event.getGoal() < event.getNumber()) {
            System.out.println(context.getMessage("lesser", null, Locale.getDefault()));
        } else {
            context.publishEvent(new SuccessEvent(context, event.getNumber()));
        }
    }
}