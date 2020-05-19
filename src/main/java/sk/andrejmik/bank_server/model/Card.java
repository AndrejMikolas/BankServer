package sk.andrejmik.bank_server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "CARDS")
public class Card extends BaseEntity
{
    @Column(name = "CARD_NO", length = 16, unique = true)
    private String cardNo;

    @Column(name = "EXPIRE_YEAR")
    private int expirationYear;

    @Column(name = "EXPIRE_MONTH")
    private int expirationMonth;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    @JsonIgnore
    private Account account;
}