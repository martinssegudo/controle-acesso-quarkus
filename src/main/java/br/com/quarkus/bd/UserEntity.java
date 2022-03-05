package br.com.quarkus.bd;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDate;


@Table(name = "TB_USUARIO")
@Entity
@GenericGenerator(
        name = "SEQ_USUARIO",
        strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
        parameters = {
                @Parameter(name = "sequence_name", value = "SEQ_USUARIO"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "1")
        }
)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_VEICULO")
    @Column(name = "ID_VEICULO", nullable = false)
    public Long id;

    @Column(name = "DS_USER_NAME")
    public String userName;

    @Column(name = "DS_PASSWORD")
    public String password;

    @Column(name = "DT_NASCIMENTO")
    public LocalDate bithday;

}
