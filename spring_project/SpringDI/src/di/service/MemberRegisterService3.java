package di.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import di.dao.Dao;
import di.dao.MemberDao;
import di.domain.Member;
import di.domain.RegisterRequest;
import di.exception.AlreadyExistingMemberException;

@Resource(name="dao")
public class MemberRegisterService3 {
	@Autowired
	//의존성 낮춤
	private Dao dao;
	//반드시 public으로 선언해야 함(컨테이너 의존성 주입)
	//메서드 주입 방식
	public void setDao(Dao dao) {
		this.dao=dao;
	}
	
	public void regist(RegisterRequest req) throws AlreadyExistingMemberException {
		Member member = dao.selectByEmail(req.getEmail());
		if (member != null) {
			throw new AlreadyExistingMemberException("dup email " + req.getEmail());
		}
		Member newMember = new Member(req.getEmail(), req.getPassword(), req.getName(), new Date());
		dao.insert(newMember);
	}

}
