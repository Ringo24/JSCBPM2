package com.lee.jscbpm2.data;

import java.util.List;

import com.lee.jscbpm2.sns.Query;
import com.lee.jscbpm2.sns.SnsNo;

public interface DataMapper {

	public abstract int write(Data d);
	public abstract int delete(Data d);
	public abstract int updateNoFile(Data d);
	public abstract int updateFile(Data d);
	
	public abstract List<Data> search(Query q);
	public abstract Data getOneData(Data d);
	public abstract List<Data> getData(SnsNo sn);
	public abstract int getAllDataCount();
}
