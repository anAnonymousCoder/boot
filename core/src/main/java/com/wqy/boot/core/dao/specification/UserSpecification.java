package com.wqy.boot.core.dao.specification;

import com.wqy.boot.core.domain.entity.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.LinkedList;
import java.util.List;

public class UserSpecification implements Specification<User> {

    private String name;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> whereList = new LinkedList<>();

        if (!StringUtils.isEmpty(name)) {
            whereList.add(criteriaBuilder.equal(root.get("name"), name));
        }
        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("createAt")));
        return criteriaBuilder.and(whereList.toArray(new Predicate[0]));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
