package com.reviewanime.service;

import java.util.List;

import com.reviewanime.model.CategoryModel;
import com.reviewanime.paging.Pageble;

public interface ICategoryService {
	List<CategoryModel> findAll(Pageble pageble);
	List<CategoryModel> findAll();
    CategoryModel findOne(Long id);
    List<CategoryModel> findByAnimeId(Long animeId);
    CategoryModel save(CategoryModel categoryModel);
	CategoryModel update(CategoryModel categoryModel);
	void delete(long[] ids);
	int getTotalItem();
}
