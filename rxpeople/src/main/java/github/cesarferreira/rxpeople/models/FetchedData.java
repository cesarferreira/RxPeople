package github.cesarferreira.rxpeople.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FetchedData {

    @SerializedName("results")
    public List<EncapsulatedUser> results;
}
