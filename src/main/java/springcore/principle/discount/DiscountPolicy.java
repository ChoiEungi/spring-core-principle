package springcore.principle.discount;


import springcore.principle.member.Member;

public interface DiscountPolicy {


    int discount(Member member, int price);


}
