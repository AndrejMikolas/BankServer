package sk.andrejmik.bank_server.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("ACCOUNTS")
public class Account extends BaseEntity
{
    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED_ON")
    private Date dateCreated;

    @Column(name = "OWNER")
    private Person owner;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Card> cardsList = new ArrayList<>();

}
