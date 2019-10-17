package com.neobis.eshop.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

    /*
      {
          "firstName": "First Name",
          "lastName": "Last Name",
          "email": "my.email@gmail.com",
          "password": "********",
          "phone": "+996(221)231-323",
          "roles": ["CUSTOMER", "ADMINISTRATOR"],
      }
     */

@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email" )
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "contact_number")
    private String phone;

    @Column(name = "is_active", nullable = false)
    private boolean is_active = false;

    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private List<OrderEntity> orders;

    public UserEntity() {
    }

    public UserEntity(String firstName, String lastName, Set<Role> roles, String email, String password, String phone, boolean is_active, List<OrderEntity> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.is_active = is_active;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderEntity> orders) {
        this.orders = orders;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

}