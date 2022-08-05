package com.example.springdatajpaexample;

import com.example.springdatajpaexample.repositories.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringDataJpaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaExampleApplication.class, args);
    }

    @Component
    public class ApplicationStartupRunner implements CommandLineRunner {
        // We have created an ApplicationStartupRunner class and made it a component with the @Component annotation.
        private final TeacherRepository repository;

        public ApplicationStartupRunner(TeacherRepository repository) {
            // create and inject a repository bean and assign it to the repository field in the class.
            // The constructor has a TeacherRepository parameter which means Spring Boot will automatically
            this.repository = repository;
        }

        // Once Spring Boot has finished setting things up, it will call the run method
        // and this is where we will be testing out the repository methods.
        @Override
        public void run(String... args) {

			/* CREATE (spring.jpa.hibernate.ddl-auto=create)
			// Here are the steps for creating an entity and persisting it in the database:
			// 1. Create entity object.
			Teacher teacher1 = new Teacher();
			Teacher teacher2 = new Teacher();
			// 2. Set object properties using setters.
			teacher1.setName("Otha");
			teacher2.setName("Ian");
			// 3. Call repository.save(entity) to save the entity to the database.
			repository.save(teacher1);
			repository.save(teacher2);
             */

            /* READ (spring.jpa.hibernate.ddl-auto=none)
            Optional<Teacher> teacher1 = repository.findById(1);
            System.out.println("Teacher with ID 1:" + teacher1.orElse(null));

            Iterable<Teacher> teachers = repository.findAll();
            System.out.println("All Teachers:");
            teachers.forEach(System.out::println);
             */

            /* UPDATE (spring.jpa.hibernate.ddl-auto=none)
            // 1. In order to update database records, we have to first fetch them using findById,
            Optional<Teacher> teacher1Optional = repository.findById(1);

            Teacher teacher1 = teacher1Optional.orElseThrow(() -> new Error("object not found"));
            System.out.println("Teacher with ID 1:" + teacher1);

            // 2. update the object instance,
            teacher1.setName("Michelle");
            System.out.println("Teacher with ID 1 after update: " + teacher1);

            // 3. and call repository.save() method with the modified object instance.
            repository.save(teacher1);
             */

            /* DELETE
            // We can use delete() or deleteById() methods to delete an entity.
            // We will be using the delete method since we will be fetching
            // a record from the database and storing it as an object.
            Optional<Teacher> teacher1Optional = repository.findById(1);
            Teacher teacher1 = teacher1Optional.orElseThrow(() -> new Error("object not found"));
            repository.delete(teacher1);
             */
        }

        /*
        Conclusion:
        We have learned how to create CRUD repositories to make it easier to work with entities and databases.
        We also created our first Spring Data JPA project.
        Spring Data JPA provides all the benefits of JPA along with additional helpers to streamline database interaction in our applications.
         */

    }
}
