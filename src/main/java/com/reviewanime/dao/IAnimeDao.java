package com.reviewanime.dao;

import java.util.List;

import com.reviewanime.model.AnimeModel;
import com.reviewanime.paging.Pageble;

public interface IAnimeDao {
	List<AnimeModel> findAll(Pageble pageble);
	List<AnimeModel> findByCategoryCodes(List<String> codes, Pageble pageble);
	AnimeModel findOne(Long id);
	List<AnimeModel> findByCategoryId(Long categoryId);
	Long save(AnimeModel animeModel);
	void update(AnimeModel animeModel);
	void delete(Long id);
	Long saveWithCategories(AnimeModel animeModel, List<Long> categoryIds);
	void updateWithCategories(AnimeModel animeModel, List<Long> categoryIds);
	int getTotalItem();
	int getTotalItemByCategoryCodes(List<String> codes);
}
