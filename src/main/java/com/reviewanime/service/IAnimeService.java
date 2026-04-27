package com.reviewanime.service;

import java.util.List;

import com.reviewanime.model.AnimeModel;
import com.reviewanime.paging.Pageble;

public interface IAnimeService {
	List<AnimeModel> findAll(Pageble pageble);
	List<AnimeModel> findByCategoryCodes(List<String> codes, Pageble pageble);
	AnimeModel findOne(Long id);
	List<AnimeModel> findByCategoryId(Long categoryId);
	AnimeModel save(AnimeModel animeModel);
	AnimeModel update(AnimeModel animeModel);
	void delete(long[] ids);
	List<Long> findCategoryIdByCategoryCodes(List<String> codes);
	int getTotalItem();
	int getTotalItemByCategoryCodes(List<String> codes);
}
