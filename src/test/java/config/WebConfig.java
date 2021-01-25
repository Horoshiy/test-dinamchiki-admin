package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:${environment}.properties"
})
public interface WebConfig extends Config {
    @Key("webdriver.remote")
    String webdriverRemote();

    @Key("site.home")
    String siteHomePage();

    @Key("site.user")
    String siteUser();

    @Key("site.password")
    String sitePassword();
}
