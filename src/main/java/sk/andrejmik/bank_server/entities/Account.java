package sk.andrejmik.bank_server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("ACCOUNTS")
public class Account extends BaseEntity
{
    private String name;

    private Date dateCreated;

    private Person owner;

    private List<Card> cardsList = new ArrayList<>();

}
