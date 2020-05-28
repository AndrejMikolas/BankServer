package sk.andrejmik.bank_server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("PERSONS")
public class Person extends BaseEntity
{
    private String name;

    private String surname;
}
