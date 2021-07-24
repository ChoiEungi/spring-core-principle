package springcore.principle;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springcore.principle.member.Grade;
import springcore.principle.member.Member;
import springcore.principle.member.MemberService;
import springcore.principle.member.MemberServieImpl;

public class MemberServiceTest {

    MemberService memberService = new MemberServieImpl();

    @Test
    void join(){

        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
