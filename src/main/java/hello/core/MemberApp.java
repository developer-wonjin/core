package hello.core;

import hello.core.member.Grade;
import hello.core.member.MemberServiceImpl;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(member);
        System.out.println(findMember);
        System.out.println(member == findMember);
    }
}
