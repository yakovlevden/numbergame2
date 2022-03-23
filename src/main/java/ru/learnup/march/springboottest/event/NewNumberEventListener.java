package ru.learnup.march.springboottest.event;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;
import ru.learnup.march.springboottest.MessageUtils;
import ru.learnup.march.springboottest.annotations.LogMethod;
import ru.learnup.march.springboottest.annotations.WorkTime;

import java.util.Locale;

@Service
public class NewNumberEventListener implements ApplicationListener<NewNumberEvent> {

    @Override
    @WorkTime
    public void onApplicationEvent(NewNumberEvent event) {
        ApplicationContext context = event.getContext();
        MessageUtils messages = context.getBean(MessageUtils.class);
        if (event.getGoal() > event.getNumber()) {
            System.out.println(messages.getMessage("higher"));
        } else if (event.getGoal() < event.getNumber()) {
            System.out.println(messages.getMessage("lesser"));
        } else {
            context.publishEvent(new SuccessEvent(context, event.getNumber()));
        }
    }
}