package memberManage.domain.repository;

import memberManage.domain.entity.Member;

import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Member findById(int id);
    Member findByName(String name);
    List<Member> findAll();
}
