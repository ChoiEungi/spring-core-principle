package springcore.principle;

import springcore.principle.member.Grade;
import springcore.principle.member.Member;
import springcore.principle.member.MemberService;
import springcore.principle.member.MemberServieImpl;

public class MemberApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        //        MemberService memberService = new MemberServieImpl();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new Member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());


    }
}
