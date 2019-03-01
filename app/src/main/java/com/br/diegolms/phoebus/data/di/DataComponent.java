package com.br.diegolms.phoebus.data.di;


import com.br.diegolms.phoebus.data.DataManager;
import dagger.Component;

@Component(modules = DataModule.class) public interface DataComponent {
    void inject(DataManager dataManager);
}
