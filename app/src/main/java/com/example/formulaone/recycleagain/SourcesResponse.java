package com.example.formulaone.recycleagain;

import android.graphics.Movie;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by chetan_rane on 5/30/2017.
 */

public class SourcesResponse {
    @SerializedName("page")
    private int page;
    @SerializedName("results")
    private List<Source> results;
    @SerializedName("total_results")
    private int totalResults;
    @SerializedName("total_pages")
    private int totalPages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<Source> getResults() {
        return results;
    }

    public void setResults(List<Source> results) {
        this.results = results;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
