package com.lee.jscbpm2.member;

public interface MemberMapper {

	public abstract int join(Member m);
	
	public abstract int delete(Member m);
	
	public abstract int updateWithPhoto(Member m);
	
	public abstract int updateWithoutPhoto(Member m);
	
	public abstract Member getMemberInfoByJM_ID(Member m);
	
}
