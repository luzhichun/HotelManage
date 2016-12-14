package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.dao.IForeDAO;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;
import cn.edu.njtech.service.IForeService;

public class ForeServiceImpl implements IForeService {
	private IForeDAO foreDao;

	public IForeDAO getForeDao() {
		return foreDao;
	}

	public void setForeDao(IForeDAO foreDao) {
		this.foreDao = foreDao;
	}

	@Override
	public List<Dinnertable> getFreeTable(int currentPage) {
		// TODO Auto-generated method stub
		List<Dinnertable> list = null;
		try {
			list = foreDao.getFreeTable(currentPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getFreeDinnerNum() {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.getFreeDinnerNum();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Food> showFoodMenu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Food> list = null;
		try {
			list = foreDao.showFoodMenu(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Food> showFoodMenuByTypeId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Food> list = null;
		try {
			list = foreDao.showFoodMenuByTypeId(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Food selectByFoodId(int id) {
		// TODO Auto-generated method stub
		Food food = null;
		try {
			food = foreDao.selectByFoodId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public int updateTable(Dinnertable dt) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.updateTable(dt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int addOrders(Orders o) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.addOrders(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Dinnertable selectByTableId(int id) {
		// TODO Auto-generated method stub
		List<Dinnertable> list = null;
		try {
			list = foreDao.selectByTableId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public Orders selectordersByTableId(int id) {
		// TODO Auto-generated method stub
		List<Orders> list = null;
		try {
			list = foreDao.selectordersByTableId(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.size() > 0 ? list.get(0) : null;
	}

	@Override
	public int addOrderDetail(OrderDetail od) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.addOrderDetail(od);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateDetail(OrderDetail od) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.updateDetail(od);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteDetail(OrderDetail od) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.deleteDetail(od);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail od) {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;
		try {
			System.out.println(od);
			list = foreDao.getOrderDetailByOrderId(od);
			System.out.println(list);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderDetail> selectOrderDetailById(int id) {
		// TODO Auto-generated method stub
		List<OrderDetail> list = null;
		try {
			list = foreDao.selectOrderDetailById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateOrder(Orders o) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.updateOrder(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getFood() {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.getFood();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int getFoodByFoodType(int id) {
		// TODO Auto-generated method stub
		int result = 0;
		try {
			result = foreDao.getFoodByFoodType(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Foodtype> getFoodType(int currentPage) {
		// TODO Auto-generated method stub
		List<Foodtype> list = null;
		try {
			list = foreDao.getFoodType(currentPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
