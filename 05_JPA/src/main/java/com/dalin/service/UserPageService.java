package com.dalin.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.dalin.model.User;
import com.dalin.repository.UserCondition;

@Service
public class UserPageService {

	@Autowired
	private UserCondition ud;

	public Page<User> find_page() {
		//查询条件
		Specification<User> spec = new Specification<User>() {
			private static final long serialVersionUID = 1L;
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				List<Predicate> list = new ArrayList<Predicate>();
				//equal 等于查询
				Predicate p1 = criteriaBuilder.equal(root.get("name"), "dalin");
				list.add(p1);
				Predicate[] arr = new Predicate[list.size()];
				return criteriaBuilder.and(list.toArray(arr));
			}
		};
		
		//分页
		int page = 0;
		int pagesize = 3;
		//单个条件排序
		//Sort sort = Sort.by(Sort.Direction.DESC, "id");

		//多条件排序
		List<Sort.Order> orders = new ArrayList<>();
		orders.add(new Sort.Order(Sort.Direction.DESC, "id"));
		orders.add(new Sort.Order(Sort.Direction.ASC, "sex"));
		Sort sort = Sort.by(orders);

		//分页和排序信息
		Pageable pageable = PageRequest.of(page,pagesize,sort);
		
		Page<User> list = ud.findAll(spec, pageable);
		
		return list;
	}

}
