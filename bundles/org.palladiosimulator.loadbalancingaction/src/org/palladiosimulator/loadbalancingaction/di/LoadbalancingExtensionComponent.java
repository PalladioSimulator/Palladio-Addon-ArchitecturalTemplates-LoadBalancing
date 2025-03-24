package org.palladiosimulator.loadbalancingaction.di;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IExecutableExtensionFactory;
import org.palladiosimulator.loadbalancingaction.rdseff.LoadbalancingRDSeffSwitch;
import org.palladiosimulator.simulizar.di.component.core.SimuLizarRuntimeComponent;
import org.palladiosimulator.simulizar.di.extension.ExtensionComponent;
import org.palladiosimulator.simulizar.di.scopes.RuntimeExtensionScope;

import dagger.Component;

@Component(dependencies = SimuLizarRuntimeComponent.class)
@RuntimeExtensionScope
public interface LoadbalancingExtensionComponent extends ExtensionComponent {
    
    LoadbalancingRDSeffSwitch.Factory rdseffExtensionFactory();
    
    @Component.Factory
    public static interface Factory extends ExtensionComponent.Factory {
        LoadbalancingExtensionComponent create(SimuLizarRuntimeComponent runtimeComponent);
    }
    
    public static class EclipseFactory implements IExecutableExtensionFactory {
        @Override
        public Object create() throws CoreException {
            return DaggerLoadbalancingExtensionComponent.factory();
        }
        
    }

}
