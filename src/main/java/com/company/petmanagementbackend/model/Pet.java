package com.company.petmanagementbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotBlank(message = "Name is mandatory and should not be empty")
    @NotNull(message = "Name must not be null")
    @Length(min = 1, max = 50, message = "Name length must be from 1 to 50 symbols")
    private String name;
    @Min(value = 100000000000L, message = "Code size must be 12 digits")
    @Max(value = 999999999999L, message = "Code size must be 12 digits")
    @NotNull(message = "Code must not be null")
    private Long code;
    @Pattern(regexp = "Cat|Dog|Horse|Rabbit|Parrot", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Type value must be in [Cat, Dog, Horse, Rabbit, Parrot]")
    @NotBlank(message = "Type is mandatory and should not be empty")
    private String type;
    @Pattern(regexp = "Black|White|Brown|Yellow|Blue", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Fur color value must be in [Black, White, Brown, Yellow, Blue]")
    @NotBlank(message = "Fur color is mandatory and should not be empty")
    private String furColor;
    @Pattern(regexp = "Estonia|Latvia|Lithuania|Finland|Sweden|Norway", flags = Pattern.Flag.CASE_INSENSITIVE,
            message = "Country value must be in [Estonia, Latvia, Lithuania, Finland, Sweden, Norway]")
    @NotBlank(message = "Country is mandatory and should not be empty")
    private String country;

    @ManyToOne
    private User owner;

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code=" + code +
                ", type='" + type + '\'' +
                ", furColor='" + furColor + '\'' +
                ", country='" + country + '\'' +
                ", owner=" + owner +
                '}';
    }
}

