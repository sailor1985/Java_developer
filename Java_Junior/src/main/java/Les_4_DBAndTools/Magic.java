package Les_4_DBAndTools;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "magic", schema = "test")
@NoArgsConstructor
@ToString
@Data
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idmagic;
    @Column(name = "название")
    private String name;
    @Column(name = "повреждение")
    private int damage;
    @Column(name = "атака")
    private Integer attBonus;
    @Column(name = "броня")
    private int armor;

    public Magic(String name, int damage, int attBonus, Integer armor) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
        this.armor = armor;
    }
}
