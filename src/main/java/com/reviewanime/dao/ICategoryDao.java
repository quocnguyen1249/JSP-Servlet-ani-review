package com.reviewanime.dao;

import java.util.List;

import com.reviewanime.model.CategoryModel;
import com.reviewanime.paging.Pageble;

public interface ICategoryDao {
	List<CategoryModel> findAll(Pageble pageble);
	List<CategoryModel> findAll();
	List<CategoryModel> findByAnimeId(Long animeId);
	CategoryModel findOne(Long id);
	CategoryModel findOneByCode(String code);
	Long save(CategoryModel categoryModel);
	void update(CategoryModel categoryModel);
	void delete(Long id);
	int getTotalItem();
}
