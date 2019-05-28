package com.entersekt.mycity;

import android.app.Application;

import com.entersekt.mycity.database.CitiesDatabase;
import com.entersekt.mycity.di.components.ApplicationComponent;
import com.entersekt.mycity.di.components.DaggerApplicationComponent;
import com.entersekt.mycity.di.modules.MyCityApplicationModule;

public class MyApplication  extends Application {

    private static ApplicationComponent applicationComponent;
    public static MyApplication appInstance;

    public MyApplication(){

    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;

        applicationComponent = DaggerApplicationComponent
                .builder()
                .myCityApplicationModule(new MyCityApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent(){
        return applicationComponent;
    }

    public CitiesDatabase getDatabaseInstance(){
        return CitiesDatabase.getDatabaseInstance(this);
    }

}
