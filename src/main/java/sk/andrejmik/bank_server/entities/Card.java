package sk.andrejmik.bank_server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("CARDS")
public class Card extends BaseEntity
{
    private String cardNo;

    private int expirationYear;

    private int expirationMonth;
}
