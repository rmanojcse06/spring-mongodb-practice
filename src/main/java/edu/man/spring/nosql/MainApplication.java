package edu.man.spring.nosql;

import edu.man.spring.nosql.models.Person;
import edu.man.spring.nosql.repository.PersonRepository;
import edu.man.spring.nosql.service.FamilyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainApplication {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private FamilyService familyService;

    public static void main(String[] args) {
        log.info("Hello, Spring NoSQL World!");
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext("edu.man.spring.nosql");

        context.registerShutdownHook();
    }

    @EventListener(ContextRefreshedEvent.class)
    public void runAfterStartup() {
        log.info("Running after application startup...");

        Person p1 = new Person();
        p1.setName("Sarah");
        p1.setAge(28);
        personRepository.save(p1);

        personRepository.findAll().forEach(p -> log.info("Person: {}", p));

        familyService.printItemsGt15();



    }
}
