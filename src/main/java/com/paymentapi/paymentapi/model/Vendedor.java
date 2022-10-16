import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    @NotEmpty(message = "Name field is required")
    private String name;

    @Column(length = 11)
    @NotEmpty(message = "CPF field is required")
    @CPF(message = "CPF invalid")
    private String cpf;

    @Column(length = 30)
    @NotEmpty(message = "E-mail field is required")
    @EMAIL(message = "E-mail invalid")
    private String email;

    @Column(length = 11)
    @NotEmpty(message = "Telefone field is required")
    @TELEFONE(message = "Telefone invalid")
    private String telefone;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<OrderItem> orderItems;

    public Vendedor(Integer id, String name){
        this.id = id;
        this.name = name;
    }
}