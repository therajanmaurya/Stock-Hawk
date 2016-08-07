package rajan.udacity.stock.hawk.test.common.injection.component;

import javax.inject.Singleton;

import dagger.Component;
import rajan.udacity.stock.hawk.injection.component.ApplicationComponent;
import rajan.udacity.stock.hawk.test.common.injection.module.ApplicationTestModule;

@Singleton
@Component(modules = ApplicationTestModule.class)
public interface TestComponent extends ApplicationComponent {

}
