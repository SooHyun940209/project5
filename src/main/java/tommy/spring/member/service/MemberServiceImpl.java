package tommy.spring.member.service;

import tommy.spring.member.vo.MemberVO;
import tommy.spring.member.vo.UpdateInfo;

public class MemberServiceImpl implements MemberService {
	//원래대로 하면 여기에 DAO를 주입
	
	@Override
	public void regist(MemberVO member) {
		System.out.println("[Service] - MemberServiceImpl.regist() 메소드 실행");
	}

	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("[Service] - MemberServiceImpl.update() 메소드 실행");
		return true;
	}

}
