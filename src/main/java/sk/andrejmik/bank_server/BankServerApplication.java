package sk.andrejmik.bank_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
        scanBasePackages = {
                "sk.andrejmik.bank_server"
        }
)
@ComponentScan("sk.andrejmik.bank_server.*")
public class BankServerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BankServerApplication.class, args);
    }
}
