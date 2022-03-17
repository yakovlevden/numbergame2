package ru.learnup.march.springboottest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.march.springboottest.event.NewNumberEventPublisher;
import ru.learnup.march.springboottest.event.SuccessEvent;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

@SpringBootApplication
public class SpringBootTestApplication implements ApplicationListener<SuccessEvent> {

    static boolean success = false;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootTestApplication.class, args);

        NewNumberEventPublisher publisher = context.getBean(NewNumberEventPublisher.class);

        Scanner in = new Scanner(System.in);
        Random random = new Random();
        int goal = random.nextInt(1000);
        System.out.println(context.getMessage("hello", null, Locale.getDefault()));
        do {
            System.out.println(context.getMessage("turn", null, Locale.getDefault()));
            int num = in.nextInt();
            publisher.publishEvent(goal, num);
        } while (!success);
    }

    @Override
    public void onApplicationEvent(SuccessEvent event) {
        ApplicationContext context = event.getContext();
        System.out.println(context.getMessage("success", new Object[]{event.getNumber()}, Locale.getDefault()));
        success = true;
    }
}