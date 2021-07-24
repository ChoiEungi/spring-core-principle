package springcore.principle.order;

import springcore.principle.discount.DiscountPolicy;
import springcore.principle.member.Member;
import springcore.principle.member.MemberRepository;
import springcore.principle.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderSevice{

    // interface에만 의존
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
