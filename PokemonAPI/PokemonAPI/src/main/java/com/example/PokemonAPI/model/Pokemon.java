package com.example.PokemonAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre no puede ser vacío.")
    @Size(min = 2, max = 20, message = "El nombre debe tener entre 2 y 20 caracteres.")
    @Column(name = "nombre")
    private String nombre;

    @NotBlank(message = "El tipo no puede ser vacío.")
    @Column(name = "tipo")
    private String tipo;

    @NotNull(message = "El nivel es requerido.")
    @Min(value = 1, message = "El minimo es 1.")
    @Max(value = 100, message = "El nivel máximo es 100.")
    @Column(name = "nivel")
    private Integer nivel;

    @Min(value = 1, message = "El ataque minimo es 1.")
    @Column(name = "ataque")
    private Integer ataque;

    @Min(value = 1, message = "La defensa no puede ser negativa.")
    @Column(name = "defensa")
    private Integer defensa;

    @Size(max = 255, message = "La longitud de la descripción no puede exceder los 255 caracteres.")
    @Column(name = "descripcion")
    private String descripcion;

    @URL(message = "la imagen debe ser un URL.")
    @Column(name = "imagen_Url")
    private String imagenUrl;

    @Email
    @Column(name = "correo_Entrenador")
    private String correoEntrenador;

    @PastOrPresent(message = "La fecha de nacimiento no puede ser mayor a la actual.")
    @Column(name = "fecha_Nacimiento")
    private LocalDate fechaNacimiento;

    @Positive(message = "El peso del pokemon debe ser mayor a 0.")
    @Column(name = "peso_Pokemon")
    private Double peso;

    @Pattern(regexp = "^\\d{10}$", message = "El formato del telefono no es valido.")
    private String telefonoEntrenador;

    @AssertTrue(message = "El pokemon debe estar sano.")
    private Boolean estaSano;

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

