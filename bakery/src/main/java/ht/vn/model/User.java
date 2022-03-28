package ht.vn.model;


import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(name = "full_name")
    private String fullName;

    @Column(unique = true, nullable = false)
//    @NotBlank(message = "Email is mandatory")
//    @Email(message = "Không đúng định dạng email! Vui lòng nhập lại")
    private String email;

    @NotNull
    private String phone;


    private int age;

    private String avatar;

    @NotNull
    private String address;

    @NotNull
    private Status status;

    private String password;

    @NotNull
    private Role role;

    @Column(columnDefinition = "boolean default false")
    private boolean deleted;

    public User(){

    }

    public User(Long id, String fullName, String email, String phone, int age, String avatar, String address, Status status, String password, Role role, boolean deleted) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
        this.password = password;
        this.role = role;
        this.deleted = deleted;
    }

    public User(Long id, String fullName, String email, String phone, int age, String avatar, String address, Status status, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.avatar = avatar;
        this.address = address;
        this.status = status;
        this.password = password;
        this.role = role;
    }

    public User(Long id, String fullName, String email, String phone, int age, String address, Status status, String password, Role role) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
        this.password = password;
        this.role = role;
    }
    public User( String fullName, String email, String phone, int age, String address, Status status, String password, Role role) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.age = age;
        this.address = address;
        this.status = status;
        this.password = password;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
