package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 구현클래스에서는 상태필드(의존성)를 갖는다.
 * 저장매체는 ConcurrentHashMap으로 결정
 * */
@Component
public class MemoryMemberRepository implements MemberRepository{

    private static final Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long id) {
        return store.get(id);
    }
}
