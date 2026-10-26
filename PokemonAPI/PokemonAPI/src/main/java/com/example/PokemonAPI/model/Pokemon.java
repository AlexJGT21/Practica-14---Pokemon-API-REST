package com.example.PokemonAPI.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "nivel")
    private Integer nivel;

    @Column(name = "ataque")
    private Integer ataque;

    @Column(name = "defensa")
    private Integer defensa;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen_Url")
    private String imagenUrl;

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nivel=" + nivel +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", descripcion='" + descripcion + '\'' +
                ", imagenUrl='" + imagenUrl + '\'' +
                '}';
    }

}

