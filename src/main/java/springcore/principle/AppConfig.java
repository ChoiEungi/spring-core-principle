package springcore.principle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springcore.principle.discount.DiscountPolicy;
import springcore.principle.discount.RateDiscountPolicy;
import springcore.principle.member.MemberService;
import springcore.principle.member.MemberServieImpl;
import springcore.principle.member.MemoryMemberRepository;
import springcore.principle.order.OrderServiceImpl;
import springcore.principle.order.OrderSevice;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServieImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderSevice orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
