package com.reviewanime.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.reviewanime.model.AnimeModel;

public class AnimeMapper implements RowMapper<AnimeModel> {

    private static final Logger logger = Logger.getLogger(AnimeMapper.class.getName());

    @Override
    public AnimeModel mapRow(ResultSet rs) throws SQLException {
        try {
            AnimeModel animeModel = new AnimeModel();
            animeModel.setId(rs.getLong("id"));
            animeModel.setTitle(rs.getString("title"));
            animeModel.setThumbnail(rs.getString("thumbnail"));
            animeModel.setShortDescription(rs.getString("shortdescription"));
            animeModel.setContent(rs.getString("content"));
            animeModel.setRating(rs.getFloat("rating"));

            animeModel.setReleaseYear(rs.getString("releaseyear"));
            animeModel.setEpisodes(rs.getString("episodes"));
            animeModel.setStatus(rs.getString("status"));
            animeModel.setCountry(rs.getString("country"));

            animeModel.setCreatedDate(rs.getTimestamp("createddate"));
            animeModel.setCreatedBy(rs.getString("createdby"));

            if (rs.getTimestamp("modifieddate") != null)
                animeModel.setModifiedDate(rs.getTimestamp("modifieddate"));
            if (rs.getString("modifiedby") != null)
                animeModel.setModifiedBy(rs.getString("modifiedby"));

            return animeModel;
        } catch (SQLException e) {
            logger.severe("Lỗi map AnimeModel: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
