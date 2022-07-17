package memberManage;

import memberManage.domain.entity.Member;
import memberManage.domain.repository.MemberRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryImplTest {
    MemberRepositoryImpl repository = new MemberRepositoryImpl();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setName("jaean");

        repository.save(member);
        Member result = repository.findById(member.getId());
        Assertions.assertEquals(member, result);
    }

    @Test
    void findById() {
        Member member = new Member();
        member.setName("jaeAn");

        repository.save(member);

        assertEquals(repository.findById(member.getId()), member);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("jaean1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("jaean2");
        repository.save(member2);

        Member result = repository.findByName("jaean1");
        assertEquals(member1, result);
    }

    @Test
    void findAll() {
        Member member3 = new Member();
        member3.setName("jaean3");
        repository.save(member3);

        Member member4 = new Member();
        member4.setName("jaean4");
        repository.save(member4);

        Member member5 = new Member();
        member5.setName("jaean5");
        repository.save(member5);

        List<Member> members = repository.findAll();

        assertEquals(members.size(), 3);
    }

    @Test
    void clearStore() {
        Member member6 = new Member();
        member6.setName("jaean6");
        repository.save(member6);

        repository.clearStore();

        assertEquals(repository.findAll().size(), 0);
    }
}