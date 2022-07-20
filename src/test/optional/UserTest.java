package optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;
    User userEmpty;
    private boolean c;

    @BeforeEach
    public void initUser() {
        Master mst = new Master("아이디", "비밀번호", "재안");
        Detail dtl = new Detail("010 . . .", "주소", "제공");

        user = new User(mst, dtl);
        userEmpty = new User(mst, new Detail());
    }

    @Test
    public void optMethodTest() {
        System.out.println("user mst is empty : " + user.getMaster().isEmpty());
        System.out.println("user mst is present : " + user.getMaster().isPresent());

        System.out.println("user dtl is empty : " + user.getDetail().isEmpty());
        System.out.println("user dtl is present : " + user.getDetail().isPresent());
    }

    @Test
    public void setEmpty() {
        System.out.println("userEmpty dtl empty : " + userEmpty.getDetail().isEmpty());
        System.out.println("userEmpty dtl present : " + userEmpty.getDetail().isPresent());
    }

    @Test
    public void setNull() {
        User userNull = new User(null, null);

        System.out.println("userNull dtl empty : " + userNull.getDetail().isEmpty());
        System.out.println("userNull dtl present : " + userNull.getDetail().isPresent());
    }

    @Test
    public void optGetOnEmptyOpt() {
        Optional <String> contactOpt = userEmpty.getDetail().map(Detail::getContact);
        System.out.println("contactOpt : " + contactOpt);

        assertTrue(contactOpt.isEmpty());
    }

    @Test
    public void optGet() {
        Optional<String> usernameOpt = user.getMaster().map(Master::getUsername);

        System.out.println("username : " + usernameOpt);
        System.out.println("username.get() : " + usernameOpt.get());

        user.getMaster()
                .map(Master::getUsername)
                .ifPresent(u -> System.out.println("username : " + u));

        assertTrue(usernameOpt.isPresent());
    }

    @Test
    public void optGetSimpleObject() {
        String name = user.getMaster().map(Master::getName).get();

        String name2 = userEmpty.getMaster().map(Master::getName).orElse("empty");

        String userEmptyContact = userEmpty
                .getDetail()
                .map(Detail::getContact)
                .orElseGet(() -> {
                    System.out.println("함수 실행");
                    return "empty";
                });

        System.out.println("name : " + name);
        System.out.println("name2 : " + name2);
        System.out.println("userEmptyContact : " + userEmptyContact);
    }

    @Test
    public void optIfPresent() {
     user.getMaster()
             .map(Master::getUsername)
             .ifPresent(u -> System.out.println("username : " + u));

     userEmpty.getMaster()
             .map(Master::getUsername)
             .ifPresentOrElse(u -> System.out.println(u), () -> System.out.println("empty"));
    }

    @Test
    public void OptOr() {
        user.getDetail()
                .map(Detail::getProvider)
                .ifPresent(p -> System.out.println("provider : " + p.get()));

        userEmpty.getDetail()
                .map(Detail::getProvider)
                .ifPresent(p -> System.out.println("provider : " + p.get()));

        assertTrue(user.getDetail().map(Detail::getProvider).isPresent());
    }

//    @Test
//    public void OptFilter() {
//        List<User> list = new ArrayList<>();
//        list.add(user);
//        list.add(userEmpty);
//
//        List<String> filtered = new ArrayList<>();
//
//        list.forEach(u -> u.getDetail().map(Detail::getContact).ifPresentOrElse(t -> filtered.add(t)));
//
//
//    }

}