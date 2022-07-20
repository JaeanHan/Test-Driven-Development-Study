package optional;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Detail {
    private String contact;
    private String address;

    private String provider;

    String getContact() {return contact;}
    String getAddress() {return address;}

    Optional<String> getProvider() {return Optional.ofNullable(provider).or(() -> Optional.of("unknown"));}
}
