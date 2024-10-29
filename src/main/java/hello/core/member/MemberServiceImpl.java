package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // MemberServiceImpl클래스가 오직 Memory기반 리포지토리에 의존적이다 (컴파일타임에 이미 결정)
    // MemberServiceImpl은 MemberRepository, MemoryRepository 모두에 의존함
    // OCP (open-closed 원칙을 위배)
    // 구체클래스 MemoryRepository에 의존하기 때문에 DbRepository로 교체하고 싶을 때 MemberServiceImpl(클라이언트)를 수정해야한다.
    private final MemberRepository memberRepository = new MemoryRepository();


    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }


    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }
}
