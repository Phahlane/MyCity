package com.entersekt.mycity.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyCityApplicationModule {

    private Application app;

    public MyCityApplicationModule(Application app){
        this.app = app;
    }


    @Provides
    @Singleton
    Context provideContext(){
        return app;
    }

}
