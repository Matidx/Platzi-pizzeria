package com.platzi.pizza.persistence.entity;

import com.platzi.pizza.persistence.audit.AuditPizzaListener;
import com.platzi.pizza.persistence.audit.AuditableEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "pizza")
@EntityListeners({AuditingEntityListener.class, AuditPizzaListener.class})
@Getter
@Setter
@NoArgsConstructor //crea un constructor por defecto (sin parametros)
public class PizzaEntity extends AuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pizza", nullable = false)
    private Integer IdPizza;

    @Column(nullable = false, length = 30, unique = true)
    private String name;

    @Column(nullable = false,length = 150)
    private String description;

    //Guarda un maximo de 5 digitos y reserva los ultimos 2 digitos para guardarlos con el decimal (123,45)
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private Double price;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegetarian;

    @Column(columnDefinition = "TINYINT")
    private Boolean vegan;

    @Column(columnDefinition = "TINYINT", nullable = false)
    private Boolean available;

    @Override
    public String toString() {
        return "PizzaEntity{" +
                "IdPizza=" + IdPizza +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", vegetarian=" + vegetarian +
                ", vegan=" + vegan +
                ", available=" + available +
                '}';
    }
}
