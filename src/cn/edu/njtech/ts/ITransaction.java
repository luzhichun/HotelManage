package cn.edu.njtech.ts;

public interface ITransaction {
	/**
	 * 开启事务
	 */
	public void beginTransaction();
	/**
	 * 提交事务
	 */
	public void commit();
	
	/**
	 * 回滚事务
	 */
	public void rollback();
}
