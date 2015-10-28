package github.cesarferreira.rxpeople.interfaces;

import java.util.List;

import github.cesarferreira.rxpeople.models.FakeUser;

public interface FakeUsersCallback {
    void onSuccess(List<FakeUser> fakeUsers);
    void onError(Throwable exceptions);
}
