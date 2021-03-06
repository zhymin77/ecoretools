/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecoretools.design.properties.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.design.properties.parts.EcoreViewsRepository;
import org.eclipse.emf.ecoretools.design.properties.parts.InstanciationPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;


// End of user code

/**
 * 
 * 
 */
public class EClassInstanciationPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String INSTANCIATION_PART = "Instanciation"; //$NON-NLS-1$

	
	
	/**
	 * Default constructor
	 * 
	 */
	public EClassInstanciationPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eClass, String editing_mode) {
		super(editingContext, eClass, editing_mode);
		parts = new String[] { INSTANCIATION_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.Instanciation.class;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#initPart(java.lang.Object, int, org.eclipse.emf.ecoretools.design.properties.EObject, 
	 *      org.eclipse.emf.ecoretools.design.properties.resource.ResourceSet)
	 * 
	 */
	public void initPart(Object key, int kind, EObject elt, ResourceSet allResource) {
		setInitializing(true);
		if (editingPart != null && key == partKey) {
			editingPart.setContext(elt, allResource);
			
			final EClass eClass = (EClass)elt;
			final InstanciationPropertiesEditionPart instanciationPart = (InstanciationPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EcoreViewsRepository.Instanciation.instanceClassName))
				instanciationPart.setInstanceClassName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eClass.getInstanceClassName()));
			
			if (isAccessible(EcoreViewsRepository.Instanciation.instanceTypeName))
				instanciationPart.setInstanceTypeName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eClass.getInstanceTypeName()));
			
			// init filters
			
			
			// init values for referenced views
			
			// init filters for referenced views
			
		}
		setInitializing(false);
	}





	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#associatedFeature(java.lang.Object)
	 */
	public EStructuralFeature associatedFeature(Object editorKey) {
		if (editorKey == EcoreViewsRepository.Instanciation.instanceClassName) {
			return EcorePackage.eINSTANCE.getEClassifier_InstanceClassName();
		}
		if (editorKey == EcoreViewsRepository.Instanciation.instanceTypeName) {
			return EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EClass eClass = (EClass)semanticObject;
		if (EcoreViewsRepository.Instanciation.instanceClassName == event.getAffectedEditor()) {
			eClass.setInstanceClassName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.Instanciation.instanceTypeName == event.getAffectedEditor()) {
			eClass.setInstanceTypeName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			InstanciationPropertiesEditionPart instanciationPart = (InstanciationPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && instanciationPart != null && isAccessible(EcoreViewsRepository.Instanciation.instanceClassName)) {
				if (msg.getNewValue() != null) {
					instanciationPart.setInstanceClassName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					instanciationPart.setInstanceClassName("");
				}
			}
			if (EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && instanciationPart != null && isAccessible(EcoreViewsRepository.Instanciation.instanceTypeName)) {
				if (msg.getNewValue() != null) {
					instanciationPart.setInstanceTypeName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					instanciationPart.setInstanceTypeName("");
				}
			}
			
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getNotificationFilters()
	 */
	@Override
	protected NotificationFilter[] getNotificationFilters() {
		NotificationFilter filter = new EStructuralFeatureNotificationFilter(
			EcorePackage.eINSTANCE.getEClassifier_InstanceClassName(),
			EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.EClass.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.Instanciation.instanceClassName)
			return "The erased instance class name denoted by this classifier"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.Instanciation.instanceTypeName)
			return "The full instance type name denoted by this classifier"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.Abstraction.abstract_)
			return "Whether instances of this class can be created"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Properties.Abstraction.interface_)
			return "Whether no corresponding implementation will be generated for this class"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.EClass.Inheritance.eSuperTypes)
			return "The immediate super types of this class"; //$NON-NLS-1$
		return super.getHelpContent(key, kind);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent#validateValue(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public Diagnostic validateValue(IPropertiesEditionEvent event) {
		Diagnostic ret = Diagnostic.OK_INSTANCE;
		if (event.getNewValue() != null) {
			try {
				if (EcoreViewsRepository.Instanciation.instanceClassName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClassifier_InstanceClassName().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.Instanciation.instanceTypeName == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getEClassifier_InstanceTypeName().getEAttributeType(), newValue);
				}
			} catch (IllegalArgumentException iae) {
				ret = BasicDiagnostic.toDiagnostic(iae);
			} catch (WrappedException we) {
				ret = BasicDiagnostic.toDiagnostic(we);
			}
		}
		return ret;
	}


	

}
