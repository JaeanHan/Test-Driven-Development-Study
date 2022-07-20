package optional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@AllArgsConstructor
public class User {
    private Master master;
    private Detail detail;

    Optional<Master> getMaster() {return Optional.of(master);}

    Optional<Detail> getDetail() {return Optional.ofNullable(detail);}
}
