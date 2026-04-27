package com.reviewanime.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.reviewanime.dao.ICategoryDao;
import com.reviewanime.mapper.CategoryMapper;
import com.reviewanime.model.CategoryModel;
import com.reviewanime.paging.Pageble;

public class CategoryDao extends AbstractDao<CategoryModel> implements ICategoryDao {

	@Override
	public List<CategoryModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM category");
		if (pageble != null) {
			if (pageble.getSorter() != null && StringUtils.isNotBlank(pageble.getSorter().getSortName())) {
				String sortName = pageble.getSorter().getSortName();
				String sortBy = pageble.getSorter().getSortBy();
				if ("RAND()".equalsIgnoreCase(sortName)) {
					sql.append(" ORDER BY RAND()");
				} else if (StringUtils.isNotBlank(sortBy)) {
					sql.append(" ORDER BY ").append(sortName).append(" ").append(sortBy);
				}
			}
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql.append(" LIMIT ").append(pageble.getOffset()).append(", ").append(pageble.getLimit());
			}
		}
		return query(sql.toString(), new CategoryMapper());
	}

	@Override
	public List<CategoryModel> findByAnimeId(Long animeId) {
		StringBuilder sql = new StringBuilder("SELECT c.* FROM category c ");
		sql.append("INNER JOIN animecategory ac ON c.id = ac.categoryid ");
		sql.append("WHERE ac.animeid = ?");
		List<CategoryModel> categoryList = query(sql.toString(), new CategoryMapper(), animeId);
		return categoryList;
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "SELECT * FROM category WHERE id = ?";
		List<CategoryModel> categoryList = query(sql, new CategoryMapper(), id);
		return categoryList.isEmpty() ? null : categoryList.get(0);
	}

	@Override
	public Long save(CategoryModel category) {
		StringBuilder sql = new StringBuilder(
				"INSERT INTO category (name, code, createddate, createdby) ");
		sql.append("VALUES (?, ?, ?, ?)");
		return insert(sql.toString(), category.getName(), category.getCode(), category.getCreatedDate(),
				 category.getCreatedBy());
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE category SET name = ?, code = ?, modifieddate = ?, modifiedby = ? WHERE id = ?";
		update(sql, category.getName(), category.getCode(), category.getModifiedDate(), category.getModifiedBy(),
				category.getId());
	}

	@Override
	public void delete(Long id) {
		String sqlAnimeCategory = "DELETE FROM animecategory WHERE categoryid = ?";
		update(sqlAnimeCategory, id);
		String sqlCategory = "DELETE FROM category WHERE id = ?";
		update(sqlCategory, id);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "SELECT * FROM category WHERE code = ?";
		List<CategoryModel> categoryList = query(sql, new CategoryMapper(), code);
		return categoryList.isEmpty() ? null : categoryList.get(0);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM category";
		return count(sql);
	}

	@Override
	public List<CategoryModel> findAll() {
		StringBuilder sql = new StringBuilder("SELECT * FROM category");
		return query(sql.toString(), new CategoryMapper());
	}

}
