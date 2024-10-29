package hello.core.member;

/**인터페이스라서 상태는 없다. 구현클래스에서 상태필드를 도입할 것이다.
 * 인터페이스라서 기능만 명세한다.*/
public interface MemberRepository {

    // 입력객체로 객체를 저장한다. 어떤 저장매체를 사용할진 구현클래스에서 결정한다.
    void save(Member member);

    // 입력id로 Member객체를 찾는다. 어떤 저장매체에서 가져올진 구현클래스에서 결정한다.
    Member findById(Long id);
}
