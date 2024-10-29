package hello.core.member;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class MemoryRepositoryTest {

    private final MemberRepository memberRepository = new MemoryRepository();

    @Test
    public void saveAndFind() {
        Member member = new Member(1L, "wonjin", Grade.VIP);
        memberRepository.save(member);

        Member findMember = memberRepository.findById(1L);

        assertThat(findMember).isEqualTo(member);
    }
}