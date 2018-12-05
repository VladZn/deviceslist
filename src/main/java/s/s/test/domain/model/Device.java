package s.s.test.domain.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.UUID;

@Table(name = "devices", uniqueConstraints = {@UniqueConstraint(columnNames = "serial_no", name = "devices_serial_no_uindex")})
public class Device {

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
    @Column(name = "type", nullable = false)
    private String description;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User owner;

    @NotNull
    @Column(name = "created_at", columnDefinition = "timestamp with time zone default now()")
    private Date createdAt;

    public Device() {
    }


}
