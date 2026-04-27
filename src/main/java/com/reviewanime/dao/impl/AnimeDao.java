package com.reviewanime.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.reviewanime.dao.IAnimeDao;
import com.reviewanime.mapper.AnimeMapper;
import com.reviewanime.model.AnimeModel;
import com.reviewanime.paging.Pageble;

public class AnimeDao extends AbstractDao<AnimeModel> implements IAnimeDao {

	@Override
	public List<AnimeModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("SELECT * FROM anime");
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
		return query(sql.toString(), new AnimeMapper());
	}

	@Override
	public AnimeModel findOne(Long id) {
		String sql = "SELECT * FROM anime WHERE id = ?";
		List<AnimeModel> animeList = query(sql, new AnimeMapper(), id);
		return animeList.isEmpty() ? null : animeList.get(0);
	}

	@Override
	public List<AnimeModel> findByCategoryId(Long categoryId) {
		StringBuilder sql = new StringBuilder("SELECT a.* FROM anime a ");
		sql.append("INNER JOIN animecategory ac ON a.id = ac.animeid ");
		sql.append("WHERE ac.categoryid = ?");
		List<AnimeModel> animeList = query(sql.toString(), new AnimeMapper(), categoryId);
		return animeList;
	}

	@Override
	public Long save(AnimeModel animeModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO anime (title, thumbnail, shortdescription, content, ");
		sql.append("rating, releaseyear, episodes, status, country, createddate, createdby)");
		sql.append(" VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

		return insert(sql.toString(), animeModel.getTitle(), animeModel.getThumbnail(),
				animeModel.getShortDescription(), animeModel.getContent(), animeModel.getRating(),
				animeModel.getReleaseYear(), animeModel.getEpisodes(), animeModel.getStatus(), animeModel.getCountry(),
				animeModel.getCreatedDate(), animeModel.getCreatedBy());
	}

	@Override
	public void update(AnimeModel animeModel) {
		StringBuilder sql = new StringBuilder("UPDATE anime SET ");
		sql.append("title = ?, thumbnail = ?, shortdescription = ?, content = ?, ");
		sql.append("rating = ?, releaseyear = ?, episodes = ?, status = ?, country = ?, ");
		sql.append("modifieddate = ?, modifiedby = ? ");
		sql.append("WHERE id = ?");

		update(sql.toString(), animeModel.getTitle(), animeModel.getThumbnail(), animeModel.getShortDescription(),
				animeModel.getContent(), animeModel.getRating(), animeModel.getReleaseYear(), animeModel.getEpisodes(),
				animeModel.getStatus(), animeModel.getCountry(), animeModel.getModifiedDate(),
				animeModel.getModifiedBy(), animeModel.getId());
	}

	@Override
	public void delete(Long id) {
		String sqlCategory = "DELETE FROM animecategory WHERE animeid = ?";
		update(sqlCategory, id);
		String sqlAnime = "DELETE FROM anime WHERE id = ?";
		update(sqlAnime, id);
	}

	@Override
	public Long saveWithCategories(AnimeModel animeModel, List<Long> categoryIds) {
		Long animeId = save(animeModel);
		String sql = "INSERT INTO animecategory (animeid, categoryid) VALUES (?, ?)";
		for (Long categoryId : categoryIds) {
			insert(sql, animeId, categoryId);
		}
		return animeId;
	}

	@Override
	public void updateWithCategories(AnimeModel animeModel, List<Long> categoryIds) {
		update(animeModel);
		String deleteSql = "DELETE FROM animecategory WHERE animeid = ?";
		update(deleteSql, animeModel.getId());
		String insertSql = "INSERT INTO animecategory (animeid, categoryid) VALUES (?, ?)";
		for (Long categoryId : categoryIds) {
			insert(insertSql, animeModel.getId(), categoryId);
		}
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM anime";
		return count(sql);
	}

	@Override
	public List<AnimeModel> findByCategoryCodes(List<String> codes, Pageble pageble) {
	    StringBuilder sql = new StringBuilder("SELECT DISTINCT a.* FROM anime a ");
	    sql.append("JOIN animecategory ac ON a.id = ac.animeid ");
	    sql.append("JOIN category c ON ac.categoryid = c.id ");

	    if (codes != null && !codes.isEmpty()) {
	        sql.append("WHERE c.code IN (");
	        for (int i = 0; i < codes.size(); i++) {
	            sql.append("?");
	            if (i < codes.size() - 1) {
	                sql.append(",");
	            }
	        }
	        sql.append(")");
	    }
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

	    return query(sql.toString(), new AnimeMapper(), codes.toArray());
	}


	@Override
	public int getTotalItemByCategoryCodes(List<String> codes) {
	    StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT a.id) ");
	    sql.append("FROM anime a ");
	    sql.append("JOIN animecategory ac ON a.id = ac.animeid ");
	    sql.append("JOIN category c ON ac.categoryid = c.id ");
	    
	    if (codes != null && !codes.isEmpty()) {
	        sql.append("WHERE c.code IN (");
	        for (int i = 0; i < codes.size(); i++) {
	            sql.append("?");
	            if (i < codes.size() - 1) {
	                sql.append(",");
	            }
	        }
	        sql.append(")");
	    }
	    return count(sql.toString(), codes.toArray());
	}

}
