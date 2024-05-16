package com.westernunion.customerportal.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Email(message = "Email should be valid")
    private String email;

    @Pattern(regexp="[0-9]+", message="Phone number should only contain digits")
    @Length(min=10,max = 10)
    private String phoneNumber;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
}
