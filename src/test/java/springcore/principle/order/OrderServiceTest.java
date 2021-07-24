package springcore.principle.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springcore.principle.member.Grade;
import springcore.principle.member.Member;
import springcore.principle.member.MemberService;
import springcore.principle.member.MemberServieImpl;

public class OrderServiceTest {

    MemberService memberService = new MemberServieImpl();
    OrderSevice orderSevice = new OrderServiceImpl();

    @Test
    void createOrder(){
        //long에는 null이 안들어감
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderSevice.createOrder(memberId, "itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}
