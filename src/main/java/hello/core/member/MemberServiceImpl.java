package hello.core.member;

public class MeberServiceImpl implements MemberService{

    private MemberRepository memberRepository = new MemoryRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long id) {
        return memberRepository.findById(id);
    }
}
