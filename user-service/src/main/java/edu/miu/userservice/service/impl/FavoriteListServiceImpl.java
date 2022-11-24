package edu.miu.userservice.service.impl;

import edu.miu.sharemodule.enumerate.VideoType;
import edu.miu.userservice.dto.FavoriteListDTO;
import edu.miu.userservice.dto.FavoriteMovieOrTvSeriesDTO;
import edu.miu.userservice.entity.FavoriteList;
import edu.miu.userservice.entity.MovieSnapshot;
import edu.miu.userservice.entity.TVSeriesSnapshot;
import edu.miu.userservice.repository.FavoriteListRepository;
import edu.miu.userservice.repository.MovieSnapshotRepository;
import edu.miu.userservice.repository.TVSeriesSnapshotRepository;
import edu.miu.userservice.service.FavoriteListService;
import edu.miu.userservice.service.MovieServiceClient;
import edu.miu.userservice.service.TVSeriesServiceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Author: Kuylim TITH
 * Date: 11/23/2022
 */
@Service
@RequiredArgsConstructor
public class FavoriteListServiceImpl implements FavoriteListService {

    private final MovieSnapshotRepository movieSnapshotRepository;
    private final TVSeriesSnapshotRepository tvSeriesSnapshotRepository;
    private final FavoriteListRepository favoriteListRepository;

    private final MovieServiceClient movieServiceClient;
    private final TVSeriesServiceClient tvSeriesServiceClient;

    @Override
    public FavoriteListDTO createFavoriteList(FavoriteListDTO dto) {
        FavoriteList favoriteList = new FavoriteList();
        BeanUtils.copyProperties(dto, favoriteList);
        favoriteListRepository.save(favoriteList);
        return dto;
    }

    @Override
    public Boolean addMovieOrTVSeriesToFavoriteList(FavoriteMovieOrTvSeriesDTO dto) {
        Optional<FavoriteList> optional = favoriteListRepository.findById(dto.getFavoriteListId());
        if (optional.isPresent()) {
            if (VideoType.MOVIE.equals(dto.getVideoType())) {
                MovieSnapshot movieSnapshot = new MovieSnapshot();
                BeanUtils.copyProperties(movieServiceClient.getByMovieById(dto.getMovieOrTvSeriesId()), movieSnapshot);
                movieSnapshot.setFavoriteList(optional.get());
                movieSnapshotRepository.save(movieSnapshot);
            } else {
                TVSeriesSnapshot tvSeriesSnapshot = new TVSeriesSnapshot();
                // todo call to tvseries service
                tvSeriesSnapshot.setFavoriteList(optional.get());
                tvSeriesSnapshotRepository.save(tvSeriesSnapshot);
            }
        }
        return true;
    }

    @Override
    public Boolean removeMovieOrTVSeriesFromFavoriteList(Long id) {
        favoriteListRepository.deleteById(id);
        return true;
    }
}
