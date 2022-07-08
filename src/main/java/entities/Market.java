package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "market")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , nullable = false)
    private int id;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "number", nullable = false)
    private int number;

    @OneToMany(mappedBy = "market")
    private Set<Aisle> aisleset = new LinkedHashSet<>();

    @OneToMany
    @JoinTable(
            name = "market_product" ,
            joinColumns = @JoinColumn(name = "market_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List <Product> productSet = new ArrayList<>() ;

    @OneToOne(mappedBy = "market_product")

    private Director director ;

    public Market(int id, String name, String street, String city, int number) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.city = city;
        this.number = number;
    }
}
