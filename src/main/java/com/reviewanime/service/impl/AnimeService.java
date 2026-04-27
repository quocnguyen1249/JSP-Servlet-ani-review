package com.reviewanime.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import com.reviewanime.dao.IAnimeDao;
import com.reviewanime.dao.ICategoryDao;
import com.reviewanime.dao.ICommentDao;
import com.reviewanime.model.AnimeModel;
import com.reviewanime.model.CategoryModel;
import com.reviewanime.paging.Pageble;
import com.reviewanime.service.IAnimeService;

public class AnimeService implements IAnimeService{
	@Inject
	private IAnimeDao animeDao;
	@Inject
	private ICategoryDao categoryDao;
	@Inject
	private ICommentDao commentDao;
	
	@Override
	public List<AnimeModel> findAll(Pageble pageble) {
		return animeDao.findAll(pageble);
	}
	@Override
	public AnimeModel findOne(Long id) {
		AnimeModel animeModel = animeDao.findOne(id);
		animeModel.setCategoryModels(categoryDao.findByAnimeId(id));
		return animeModel;
	}
	@Override
	public List<AnimeModel> findByCategoryId(Long categoryId) {
		return animeDao.findByCategoryId(categoryId);
	}
	@Override
	public AnimeModel save(AnimeModel animeModel) {
		animeModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		List<Long> categoryIds = findCategoryIdByCategoryCodes(Arrays.asList(animeModel.getCategoryCodes()));
		return findOne(animeDao.saveWithCategories(animeModel, categoryIds));
	}
	@Override
	public AnimeModel update(AnimeModel animeModel) {
		AnimeModel animeold = animeDao.findOne(animeModel.getId());
		animeModel.setCreatedBy(animeold.getCreatedBy());
		animeModel.setCreatedDate(animeold.getCreatedDate());
		animeModel.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		List<Long> categoryIds = findCategoryIdByCategoryCodes(Arrays.asList(animeModel.getCategoryCodes()));
		animeDao.updateWithCategories(animeModel, categoryIds);
		return findOne(animeModel.getId());
	}
	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			commentDao.deleteAllByAnimeId(id);
			animeDao.delete(id);
		}
	}
	@Override
	public List<Long> findCategoryIdByCategoryCodes(List<String> codes) {
		List<Long> ids = new ArrayList<Long>();
		for (String code : codes) {
		    CategoryModel c = categoryDao.findOneByCode(code);
		    if (c != null) ids.add(c.getId());
		}
		return ids;
	}
	@Override
	public int getTotalItem() {
		return animeDao.getTotalItem();
	}
	@Override
	public List<AnimeModel> findByCategoryCodes(List<String> codes, Pageble pageble) {
		return animeDao.findByCategoryCodes(codes, pageble);
	}
	@Override
	public int getTotalItemByCategoryCodes(List<String> codes) {
		return animeDao.getTotalItemByCategoryCodes(codes);
	}
}
