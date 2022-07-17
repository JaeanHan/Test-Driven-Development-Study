package memberManage.service;

import memberManage.domain.entity.Member;

import java.util.List;

public interface MemberService {
    int join(Member member);
    List<Member> findMembers();
    Member findOne(int id);
}
