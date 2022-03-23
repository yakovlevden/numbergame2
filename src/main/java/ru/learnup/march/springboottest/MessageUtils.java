package ru.learnup.march.springboottest;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.learnup.march.springboottest.annotations.LogMethod;

import java.util.Locale;

@Component
public class MessageUtils implements ApplicationContextAware {

    private ApplicationContext context;

    @LogMethod
    public String getMessage(String code) {
        return getMessage(code, null, Locale.getDefault());
    }

    public String getMessage(String code, Object[] args) {
        return getMessage(code, args, Locale.getDefault());
    }

    public String getMessage(String code, Object[] args, Locale locale) {
        return context.getMessage(code, args, locale);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
