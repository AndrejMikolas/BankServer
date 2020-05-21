package sk.andrejmik.bank_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@ComponentScan("sk.*")
@EnableRedisRepositories
public class BankServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BankServerApplication.class, args);
    }
}
