package s.s.test.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Entity
@NamedQueries({@NamedQuery(name = Device.GET_ALL, query = "SELECT d FROM Device d WHERE d.owner.id=:userId ORDER BY d.createdAt DESC")})
@Table(name = "devices", uniqueConstraints = {@UniqueConstraint(columnNames = "serial_no", name = "devices_serial_no_uindex")})
public class Device {

    public static final String GET_ALL = "Device.getAll";

    @Id
    private UUID id;

    @NotBlank
    @Size(min = 4, max = 50)
    @Column(name = "serial_no", nullable = false)
    private String serialNo;

    @NotBlank
    @Size(min = 2, max = 50)
    @Column(name = "type", nullable = false)
    private String type;

    @NotBlank
    @Size(min = 2, max = 255)
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User owner;

    @NotNull
    @DateTimeFormat(pattern = "YYYY-MM-DDThh:mm:ss±hh")
    @Column(name = "created_at", columnDefinition = "timestamp with time zone default now()")
    private Date createdAt;

    public Device() {
    }

    public Device(@NotBlank @Size(min = 4, max = 50) String serialNo, @NotBlank @Size(min = 2, max = 50) String type, @NotBlank @Size(min = 2, max = 255) String description, @NotNull User owner) {
        this.id = UUID.randomUUID();
        this.serialNo = serialNo;
        this.type = type;
        this.description = description;
        this.owner = owner;
        this.createdAt = new Date();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isNew(){
        return this.id == null;
    }
}
