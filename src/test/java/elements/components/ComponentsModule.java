package elements.components;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import elements.components.settings.general.LaunchInactivityTimeoutList;
import elements.components.settings.general.LaunchInactivityTimeoutValue;

public class ComponentsModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(LeftBar.class).in(Scopes.SINGLETON);
        bind(NotificationsArea.class).in(Scopes.SINGLETON);
        bind(LaunchInactivityTimeoutList.class).in(Scopes.SINGLETON);
        bind(LaunchInactivityTimeoutValue.class).in(Scopes.SINGLETON);
    }
}
