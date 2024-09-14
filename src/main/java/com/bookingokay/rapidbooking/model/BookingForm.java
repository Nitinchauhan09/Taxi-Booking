package com.bookingokay.rapidbooking.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "bookingform")
public class BookingForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "name can't be empty")
    @NotBlank(message = "name can't be blank")
    @Size(min = 2, max = 30, message = "invalid name length")
    @Pattern(regexp = "^[A-Za-z]+$", message = "name must contain only alphabet")
    @Column(length = 30)
    private String name;

    @NotEmpty(message = "source can't be empty")
    @NotBlank(message = "source can't be blank")
    @Size(min = 2, max = 100, message = "invalid source length")
    @Column(length = 100)
    private String source;

    @NotEmpty(message = "email can't be empty")
    @NotBlank(message = "email can't be blank")
    @Size(min = 7, max = 50, message = "invalid email length")
    @Column(length = 50)
    private String email;

    @NotEmpty(message = "destination can't be empty")
    @NotBlank(message = "destination can't be blank")
    @Size(min = 2, max = 50, message = "invalid destination length")
    @Column(length = 2000)
    private String destination;

    @NotNull(message = "time can't be empty")
    private LocalTime time;

    @NotNull(message = "date can't be empty")
    private LocalDate date;

    @NotEmpty(message = "comfort can't be empty")
    @Size(min = 2, max = 20, message = "invalid comfort length")
    @Column(length = 20)
    private String comfort;

    @Min(value = 1, message = "adult can be atleast 1")
    @Max(value = 4, message = "adult can be atmost 4")
    private int adult;

    @Max(value = 3, message = "children can be atmost 3")
    private int children;

    @NotEmpty(message = "message can't be empty")
    @NotBlank(message = "message can't be blank")
    @Size(min = 2, max = 2000, message = "invalid message length")
    @Column(length = 2000)
    private String message;

}
