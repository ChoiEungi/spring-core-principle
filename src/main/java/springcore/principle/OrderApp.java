package springcore.principle;


import springcore.principle.member.Grade;
import springcore.principle.member.Member;
import springcore.principle.member.MemberService;
import springcore.principle.member.MemberServieImpl;
import springcore.principle.order.Order;
import springcore.principle.order.OrderServiceImpl;
import springcore.principle.order.OrderSevice;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServieImpl();
        OrderSevice orderSevice = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderSevice.createOrder(memberId,"itemA",10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
    }

}
