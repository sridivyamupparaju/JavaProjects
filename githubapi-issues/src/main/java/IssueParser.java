package main.java;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import main.java.IssueBean;

public class IssueParser {

    public List<IssueBean> ParseIssues(String jsonData) {
        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
                .setFieldNamingPolicy(
                        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();

        List<IssueBean> expectedIssues = new ArrayList<IssueBean>();
        Type collectionType = new TypeToken<List<IssueBean>>() {
        }.getType();
        expectedIssues = gson.fromJson(jsonData, collectionType);

        return expectedIssues;
    }
}
