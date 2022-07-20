package optional;

import lombok.*;

@Getter
@RequiredArgsConstructor
public class Master {
    private final String username;
    private final String password;
    private final String name;
}
