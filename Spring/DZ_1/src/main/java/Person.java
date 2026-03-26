import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private String firstName;
    private String lastName;
    private int age;

    @Override
    public String toString() {
        // Используем ToStringBuilder для красивого вывода
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }

    @Override
    public boolean equals(Object o) {
        // Используем EqualsBuilder для сравнения объектов
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        // Используем HashCodeBuilder для генерации хэш-кода
        return HashCodeBuilder.reflectionHashCode(this);
    }
}
