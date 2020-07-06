package tommy.spring.board.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import tommy.spring.board.service.ReadArticleService;
import tommy.spring.board.vo.ArticleNotFoundException;
import tommy.spring.board.vo.ArticleVO;
import tommy.spring.member.service.MemberService;
import tommy.spring.member.vo.UpdateInfo;

public class MainFour {
	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContextFour.xml" };
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(configLocations);
		
		ReadArticleService readArticleService = context.getBean("readArticleService", ReadArticleService.class);
		
		try {
			ArticleVO article1 = readArticleService.getArticleAndIncreaseReadCount(1);
			//얻을 때 캐시가 없기 때문에 캐시에 추가할 예정
			ArticleVO article2 = readArticleService.getArticleAndIncreaseReadCount(1);
			//캐시에서 얻어오기 때문에 article1과 같을 예정
			System.out.println("article1 == article2 : " + (article1 == article2)); //주소값까지 같은지 확인용
			
			readArticleService.getArticleAndIncreaseReadCount(0); //Throwing 동작용
			
		} catch (ArticleNotFoundException e) {
		}
		MemberService memberService = context.getBean("memberService", MemberService.class);
		memberService.update("javaline", new UpdateInfo());
		context.close();
	}
}
