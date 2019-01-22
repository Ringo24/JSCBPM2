package com.lee.jscbpm2.sns;

import java.util.List;

public interface SnsMapper {

	public abstract int write(Sns s);
	
	public abstract int writeReply(Reply r);
	
	public abstract int update(Sns s);
	
	public abstract int updateReply(Reply r);
	
	public abstract int delete(Sns s);
	
	public abstract int deleteReplybyJrno(Reply r);
	
	public abstract int deleteReplybyJrjsno(Sns s);
	
	public abstract Sns getOneSns(Sns s);
	
	public abstract List<Reply> getReply(Sns s);
	
	public abstract List<Sns> getSns(SnsNo sn);
	
	public abstract List<Sns> search(Query q);
	
	public abstract int getAllSnsCount();
}
