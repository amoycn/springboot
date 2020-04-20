package com.dalin.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.dalin.model.User;
import com.dalin.repository.UserCondition;

@Service
public class UserConditionService {

	@Autowired
	private UserCondition ud;
	
	/**
	 * 单条件查询
	 * 
	 */
	public List<User> find_one() {
		Specification<User> spec = new Specification<User>() {
			private static final long serialVersionUID = 1L;
	       /**
	        * @return Predicate:定义了查询条件
	        * @param Root<Users> root:根对象。封装了查询条件的对象
	        * @param CriteriaQuery<?> query:定义了一个基本的查询.一般不使用
	        * @param CriteriaBuilder cb:创建一个查询条件
	        */
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//查询name = "dalin" 的数据
				Predicate p1 = criteriaBuilder.equal(root.get("name"), "dalin");
				return p1;
			}
		};
		
		List<User> list = ud.findAll(spec);
		return list;
	}
	
	/**
	 * 多条件查询
	 * 
	 */
	public List<User> find_more() {
		Specification<User> spec = new Specification<User>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
//				//equal 等于查询
//				Predicate p1 = criteriaBuilder.equal(root.get("name"), "dalin");
//				list.add(p1);
//				//like 模糊查询
//				Predicate p2 = criteriaBuilder.like(root.get("sex"), "%man%");
//				list.add(p2);
				//between 区间
				Predicate p3 = criteriaBuilder.between(root.get("salary"), 12667, 12999);
				list.add(p3);
				//greaterThan 大于等于
				//其他更多参数-也类似
				
				Predicate[] arr = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(arr));
			}
		};
		
		List<User> list = ud.findAll(spec);
		return list;
	}
	
	/**
	 * 多条件查询
	 * 
	 */
	public List<User> find_more2() {
		Specification<User> spec = new Specification<User>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//or或者的查询
				//return cb.or(cb.equal(root.get("name"), "dalin"),cb.like(root.get("sex"), "%man%"));
				//and且的查询
				return cb.and(cb.equal(root.get("name"), "dalin"),cb.like(root.get("sex"), "%man%"));
			}
		};
		
		List<User> list = ud.findAll(spec);
		return list;
	}
}
