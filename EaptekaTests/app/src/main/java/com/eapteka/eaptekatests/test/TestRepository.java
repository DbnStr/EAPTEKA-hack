package com.eapteka.eaptekatests.test;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.eapteka.eaptekatests.database.DatabaseApiRepository;
import com.eapteka.eaptekatests.database.DatabaseCallback;
import com.eapteka.eaptekatests.database.Logger;
import com.eapteka.eaptekatests.database.UserApi;
import com.eapteka.eaptekatests.test_models.Test;

import retrofit2.Response;

public class TestRepository {
    private static final String LOG_TAG = "TestRepository";

    private final Context context;

    private final UserApi userApi;

    private final Logger logger;

    private final MutableLiveData<Test> testData = new MutableLiveData<>();

    public TestRepository(Context context) {
        this.context = context;

        logger = new Logger(LOG_TAG, true);

        userApi = DatabaseApiRepository.from(context).getUserApi();
    }

    public LiveData<Test> getTestData() {
        return testData;
    }

    public void updateTestInformation(final String username, final String numberOfTest) {
        userApi.getTest(username, numberOfTest).enqueue(new DatabaseCallback<Test>(LOG_TAG) {
            @Override
            public void onNullResponse(Response<Test> response) {
                logger.errorLog("Fail with update");
            }

            @Override
            public void onSuccessResponse(Response<Test> response) {
                testData.postValue(response.body());
                logger.log(response.body().getTitle());
            }
        });
    }

}
