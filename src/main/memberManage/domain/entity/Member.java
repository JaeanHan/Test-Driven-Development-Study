package memberManage.domain.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private int id;
    private String name;

    public boolean equalsTo(Member member) {
            return (id == member.getId() && name.equals(member.getName()));
    }

}
