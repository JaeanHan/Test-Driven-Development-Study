package memberManage.service;

import lombok.RequiredArgsConstructor;
import memberManage.domain.entity.Member;
import memberManage.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;

    @Override
    public int join(Member member) {
        boolean flag = validateDuplicateMember(member);
        if(flag)
            memberRepository.save(member);

        return member.getId();
    }

    private boolean validateDuplicateMember(Member member) {
        if (memberRepository.findByName(member.getName()) != null)
            throw new IllegalStateException(member.getName() + "는 이미 존재하는 회원입니다.");

        return true;
    }

    @Override
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Override
    public Member findOne(int id) {
        return memberRepository.findById(id);
    }
}
