package elements.pages;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import elements.pages.settings.SettingsGeneralPage;

public class PagesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(NativeLoginPage.class).to(NativeLoginPage.class);
        bind(AllDashboardsPage.class).in(Scopes.SINGLETON);
        bind(SettingsPage.class).in(Scopes.SINGLETON);
        bind(SettingsGeneralPage.class).in(Scopes.SINGLETON);
    }
}
