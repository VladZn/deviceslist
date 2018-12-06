package s.s.test.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "USERS", uniqueConstraints = {@UniqueConstraint(columnNames = "username", name = "users_unique_name_idx")})
@NamedQueries({
        //@NamedQuery(name = User.DELETE, query = "DELETE FROM User u WHERE u.id=:id"),
        @NamedQuery(name = User.BY_NAME, query = "SELECT u FROM User u WHERE u.name=?1")//,
        //@NamedQuery(name = User.ALL_SORTED, query = "SELECT u FROM User u ORDER BY u.name, u.email"),
})

public class User {//implements Persistable{
    public static final int START_SEQ = 1000;
    public static final String BY_NAME = "User.getByName";

    @Id
    @SequenceGenerator(name = "users_id_seq", sequenceName = "users_id_seq", allocationSize = 1, initialValue = START_SEQ)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_seq")
    private Integer id;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "username")
    private String name;

    @NotBlank
    @Size(min = 5, max = 100)
    @Column(name = "password", nullable = false)
    private String password;

    @NotNull
    @Column(name = "registered", columnDefinition = "timestamp with time zone default now()")
    private Date registered = new Date();

    @Column(name = "enabled", nullable = false, columnDefinition = "bool default true")
    private boolean enabled = true;

    public User(){
    }

    public User(int id, String name, String password, boolean enabled, Date registered) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.enabled = enabled;
        this.registered = registered;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    public boolean isNew(){
        return id == null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enabled=" + enabled +
                ", registered=" + registered +
                '}';
    }
}
