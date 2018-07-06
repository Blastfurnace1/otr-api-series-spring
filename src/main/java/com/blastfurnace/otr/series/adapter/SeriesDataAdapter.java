package com.blastfurnace.otr.series.adapter;

import java.util.List;
import java.util.Map;

import com.blastfurnace.otr.api.response.GenericResponse;
import com.blastfurnace.otr.data.series.service.model.SeriesDataWrapper;
import com.blastfurnace.otr.service.request.QueryData;
public interface SeriesDataAdapter {

	GenericResponse<SeriesDataWrapper> get(Long id);

	GenericResponse<List<Map<String, Object>>> query(QueryData qry);

	GenericResponse<Long> getResultsCount(QueryData qry);

	GenericResponse<String> delete(Long id);

	GenericResponse<SeriesDataWrapper> save(SeriesDataWrapper series);

}