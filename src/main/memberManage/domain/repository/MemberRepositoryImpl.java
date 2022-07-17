package memberManage.domain.repository;

import memberManage.domain.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemberRepositoryImpl implements MemberRepository{

    private static final Map<Integer, Member> store = new HashMap<>();

    private static int sequence = 0;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Member findById(int id) {
        return store.get(id);
    }

    @Override
    public Member findByName(String name) {
        for(Member target : store.values()) {
            if (target.getName().equals(name))
                return target;
        }
        return null;
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
