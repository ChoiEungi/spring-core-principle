package springcore.principle;

import springcore.principle.discount.DiscountPolicy;
import springcore.principle.discount.FixDiscountPolicy;
import springcore.principle.member.MemberService;
import springcore.principle.member.MemberServieImpl;
import springcore.principle.member.MemoryMemberRepository;
import springcore.principle.order.OrderServiceImpl;
import springcore.principle.order.OrderSevice;

public class AppConfig {

    // 1. create memoryMemberRepository
    // 2. inject memoryMemberRepository into MemberServiceImpl
    public MemberService memberService() {
        return new MemberServieImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderSevice orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }

}
