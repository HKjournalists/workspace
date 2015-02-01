package com.youchat.service.travelGuide;

import java.util.List;

import com.youchat.dto.query.travelGuide.TravelGuideCommentQuery;
import com.youchat.entity.travelGuide.TravelGuideComment;

public interface ITravelGuideCommentService {
    public boolean addTravelGuideComment(TravelGuideComment travelGuideComment);
    public boolean updateTravelGuideComment(TravelGuideComment travelGuideComment);
    public boolean deleteTravelGuideComment(TravelGuideComment travelGuideComment);
    public boolean deleteTravelGuideComments(List<TravelGuideComment> travelGuideComments);
    public List<TravelGuideComment> queryTravelGuideComment(TravelGuideCommentQuery query);
}
