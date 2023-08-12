package com.bigmoney.testproject.service;

import java.util.List;
import java.util.Map;

public interface ItemService {
	String insert(Map<String, Object> map);
	List<Map<String, Object>> selectAll();
	Map<String, Object> detail(Map<String, Object> map);
	boolean update(Map<String, Object> map);
	void delete(Map<String, Object> map);
	List<Map<String, Object>> pselect(int offset, int pageSize);
	int getcount();
}
