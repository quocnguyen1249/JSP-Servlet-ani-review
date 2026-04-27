package com.reviewanime.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.reviewanime.dao.ICategoryDao;
import com.reviewanime.model.CategoryModel;
import com.reviewanime.paging.Pageble;
import com.reviewanime.service.ICategoryService;

public class CategoryService implements ICategoryService{
	@Inject
    private ICategoryDao categoryDao;

    @Override
    public List<CategoryModel> findAll(Pageble pageble) {
        return categoryDao.findAll(pageble);
    }

    @Override
    public CategoryModel findOne(Long id) {
        return categoryDao.findOne(id);
    }

    @Override
    public List<CategoryModel> findByAnimeId(Long animeId) {
        return categoryDao.findByAnimeId(animeId);
    }

	@Override
	public CategoryModel save(CategoryModel categoryModel) {
		categoryModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		Long categoryId = categoryDao.save(categoryModel);
		return categoryDao.findOne(categoryId);
	}

	@Override
	public CategoryModel update(CategoryModel categoryModel) {
		CategoryModel categoryOld = categoryDao.findOne(categoryModel.getId());
		categoryModel.setCreatedBy(categoryOld.getCreatedBy());
		categoryModel.setCreatedDate(categoryOld.getCreatedDate());
		categoryModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		categoryDao.update(categoryModel);
		return categoryDao.findOne(categoryModel.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			categoryDao.delete(id);
		}
	}

	@Override
	public int getTotalItem() {
		return categoryDao.getTotalItem();
	}

	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}

}
