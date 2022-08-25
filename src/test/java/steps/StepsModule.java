package steps;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class StepsModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(LoginSteps.class).in(Scopes.SINGLETON);
        bind(LeftBarSteps.class).in(Scopes.SINGLETON);
        bind(SettingsGeneralSteps.class).in(Scopes.SINGLETON);
    }
}
