package com.srm.user.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name="user_table")
@NoArgsConstructor
@AllArgsConstructor
public class UserClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public  int id;

    @Column
    public String name;

    @Column
    public String email;

    @Column
    public String password;

    @Column
    public String phone_number;

    @Column
    public String address;
}
