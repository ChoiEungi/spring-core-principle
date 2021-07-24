package springcore.principle.order;

import springcore.principle.discount.DiscountPolicy;
import springcore.principle.discount.FixDiscountPolicy;
import springcore.principle.member.Member;
import springcore.principle.member.MemberRepository;
import springcore.principle.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderSevice{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
