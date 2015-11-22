package github.cesarferreira.rxpeople;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import github.cesarferreira.rxpeople.models.EncapsulatedUser;
import github.cesarferreira.rxpeople.models.FakeUser;
import github.cesarferreira.rxpeople.models.FetchedData;
import github.cesarferreira.rxpeople.rest.RestClient;
import rx.Observable;
import rx.functions.Func1;


public class RxPeople {

    private Context mContext;
    private static RxPeople mRxPeople;
    private String mNationality;
    private String mGender;
    private int mAmount;
    private String mSeed;

    public static RxPeople with(Context context) {
        mRxPeople = new RxPeople(context);
        return mRxPeople;
    }

    private RxPeople(Context context) {
        mContext = context;
    }

    /**
     * Set the nationality
     */
    public RxPeople nationality(String nationality) {
        mNationality = nationality;
        return mRxPeople;
    }

    /**
     * Set the gender
     */
    public RxPeople gender(String gender) {
        mGender = gender;
        return mRxPeople;
    }

    /**
     * Amount of RxPeoples
     *
     * @param amount amount of RxPeoples
     */
    public RxPeople amount(int amount) {
        mAmount = amount;
        return mRxPeople;
    }

    /**
     * Seeds allow you to always generate the same user (or set of users).
     * For example, the seed "foobar" will always return results for "Mathew Weaver"
     * Seeds can be any string or sequence of characters.
     *
     * @param seed
     */
    public RxPeople seed(String seed) {
        mSeed = seed;
        return mRxPeople;
    }

    public String upperCaseFirstLetter(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public Observable<List<FakeUser>> intoObservable() {

        String nationality = mNationality != null ? mNationality.toString() : null;
        Integer amount = mAmount > 0 ? mAmount : null;
        String gender = mGender != null ? mGender.toString() : null;

        return new RestClient().getAPI().getUsers(nationality, mSeed, amount, gender)
                .map(new Func1<FetchedData, List<FakeUser>>() {
                    @Override
                    public List<FakeUser> call(FetchedData fetchedData) {
                        List<FakeUser> users = new ArrayList<>();

                        for (EncapsulatedUser encapsulatedUser : fetchedData.results) {
                            encapsulatedUser.user.getName().title = RxPeople.this.upperCaseFirstLetter(encapsulatedUser.user.getName().title);
                            encapsulatedUser.user.getName().first = RxPeople.this.upperCaseFirstLetter(encapsulatedUser.user.getName().first);
                            encapsulatedUser.user.getName().last = RxPeople.this.upperCaseFirstLetter(encapsulatedUser.user.getName().last);

                            users.add(encapsulatedUser.user);
                        }
                        return users;
                    }
                });
    }

}
