package com.itwill.member;

import java.util.List;

public class MemberService {
	private MemberDao memberDao;
	public MemberService() throws Exception{
		memberDao=new MemberDao();
	}
	/*
	 * 회원가입
	 *  - 아이디가 중복된경우에는 메세지를띄운다.
	 */
	public boolean addMember(Member newMember) throws Exception {
		boolean isSuccess=false;
		/*
		 * 아이디존재여부체크
		 * 	- 존재하면 메세지
		 *  - 존재안하면 가입
		 */
		if(memberDao.findByPrimaryKey(newMember.getM_id())==null) {
			int rowCount=memberDao.insert(newMember);
			isSuccess=true;
		}else {
			isSuccess=false;
		}
		return isSuccess;
	}
	
	
	/*
	 * 회원로그인
	 */
	public int login(String id,String password) throws Exception{
		/*
		 * 0:성공
		 * 1:아이디존재안함
		 * 2:패쓰워드불일치
		 */
		int loginResult = -9999;
		Member findMember=memberDao.findByPrimaryKey(id);
		if(findMember==null) {
			//아이디존재안함
			loginResult=1;
		}else {
			//아이디존재함
			if(password.equals(findMember.getM_password())) {
				//패쓰워드일치
				loginResult=0;
			}else {
				//패쓰워드불일치
				loginResult=2;
			}
		}
		return loginResult;
	}
	/*
	 * 회원아이디중복체크
	 */
	public  boolean isDuplicateId(String m_id)throws Exception {
		Member findMember=memberDao.findByPrimaryKey(m_id);
		if(findMember==null) {
			return false;
		}else {
			return true;
		}
	}
	
	/*
	 * 회원상세보기
	 */
	public Member memberDetail(String m_id) throws Exception {
		return memberDao.findByPrimaryKey(m_id);
	}
	/*
	 * 회원수정
	 */
	public int memberUpdate(Member member) throws Exception{
		return memberDao.update(member);
	}
	/*
	 * 회원탈퇴
	 */
	public int memberDelete(String m_id) throws Exception{
		return memberDao.delete(m_id);
	}
	/*
	 * << admin >> 
	 * 회원전체리스트
	 */
	public List<Member> memberList() throws Exception{
		return memberDao.findAll();
	}
	
	/* admin
	 * 회원전체검색
	 * 회원이름으로검색
	 * 회원주소로검색
	 * 회원나이로검색
	 * 회원결혼여부로검색
	 * 회원가입일로검색
	 */
	
	
	
}
