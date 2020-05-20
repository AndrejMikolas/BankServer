package sk.andrejmik.bank_server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("PERSONS")
public class Person extends BaseEntity
{
    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "BORN_DATE")
    private Date born;
}
