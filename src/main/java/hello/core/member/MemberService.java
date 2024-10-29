package hello.core.member;

/**
 * 인터페이스는 상태를 갖지않는다.
 * 기능만 명세할 뿐이다.
 */
public interface MemberService {

    void join(Member member);
    Member findMember(Long id);
}
