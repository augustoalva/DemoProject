package com.example.listoftasks.di.mod;

import com.example.data.ent.map.DMTask;
import com.example.data.rep.DRTask;
import com.example.data.rep.dat.DSFTask;
import com.example.domain.rep.RepTask;
import com.example.domain.usecase.UCITask;
import com.example.domain.usecase.UCTask;
import com.example.listoftasks.view.ViewLoadData;

import dagger.Module;
import dagger.Provides;

@Module
public class ModProvides {
    public final ViewLoadData ioViewLoadData;

    public ModProvides(ViewLoadData poViewLoadData) {
        this.ioViewLoadData = poViewLoadData;
    }


    /*
    ************************************************************************************************
    * USE CASE
    ************************************************************************************************
    * */
    @Provides
    public UCTask provideUCTask(RepTask poRepTask) {
        return new UCITask(poRepTask);
    }

    /*
    ************************************************************************************************
    * REPOSITORY
    ************************************************************************************************
    * */
    @Provides
    public RepTask provideRepTask(DSFTask poDSFTask, DMTask poDMTask) {
        return DRTask.getInstance(poDSFTask, poDMTask);
    }

    /*
   ************************************************************************************************
   * DATA STORE FACTORY
   ************************************************************************************************
   * */

    @Provides
    public DSFTask provideDSFTask() {
        return new DSFTask(ioViewLoadData.getContext());
    }

    /*
    ************************************************************************************************
    * DATA MAPPER
    ************************************************************************************************
    * */
    @Provides
    DMTask provideDMTask() {
        return new DMTask();
    }
}
