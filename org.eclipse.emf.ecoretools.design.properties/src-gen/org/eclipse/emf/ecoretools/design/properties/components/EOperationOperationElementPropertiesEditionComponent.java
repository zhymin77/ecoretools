/**
 * Generated with Acceleo
 */
package org.eclipse.emf.ecoretools.design.properties.components;

// Start of user code for imports
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecoretools.design.properties.parts.EcoreViewsRepository;
import org.eclipse.emf.ecoretools.design.properties.parts.OperationElementPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.api.notify.EStructuralFeatureNotificationFilter;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.notify.NotificationFilter;
import org.eclipse.emf.eef.runtime.context.PropertiesEditingContext;
import org.eclipse.emf.eef.runtime.context.impl.EReferencePropertiesEditionContext;
import org.eclipse.emf.eef.runtime.impl.components.SinglePartPropertiesEditingComponent;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.impl.utils.EEFConverterUtil;
import org.eclipse.emf.eef.runtime.policies.PropertiesEditingPolicy;
import org.eclipse.emf.eef.runtime.policies.impl.CreateEditingPolicy;
import org.eclipse.emf.eef.runtime.providers.PropertiesEditingProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.ButtonsModeEnum;
import org.eclipse.emf.eef.runtime.ui.widgets.eobjflatcombo.EObjectFlatComboSettings;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;


// End of user code

/**
 * 
 * 
 */
public class EOperationOperationElementPropertiesEditionComponent extends SinglePartPropertiesEditingComponent {

	
	public static String OPERATIONELEMENT_PART = "Operation Element"; //$NON-NLS-1$

	
	/**
	 * Settings for eType EObjectFlatComboViewer
	 */
	private EObjectFlatComboSettings eTypeSettings;
	
	
	/**
	 * Default constructor
	 * 
	 */
	public EOperationOperationElementPropertiesEditionComponent(PropertiesEditingContext editingContext, EObject eOperation, String editing_mode) {
		super(editingContext, eOperation, editing_mode);
		parts = new String[] { OPERATIONELEMENT_PART };
		repositoryKey = EcoreViewsRepository.class;
		partKey = EcoreViewsRepository.OperationElement.class;
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
			
			final EOperation eOperation = (EOperation)elt;
			final OperationElementPropertiesEditionPart operationElementPart = (OperationElementPropertiesEditionPart)editingPart;
			// init values
			if (isAccessible(EcoreViewsRepository.OperationElement.Properties.name))
				operationElementPart.setName(EEFConverterUtil.convertToString(EcorePackage.Literals.ESTRING, eOperation.getName()));
			
			if (isAccessible(EcoreViewsRepository.OperationElement.Properties.ordered)) {
				operationElementPart.setOrdered(eOperation.isOrdered());
			}
			if (isAccessible(EcoreViewsRepository.OperationElement.Properties.unique)) {
				operationElementPart.setUnique(eOperation.isUnique());
			}
			if (isAccessible(EcoreViewsRepository.OperationElement.Cardinality.lowerBound)) {
				operationElementPart.setLowerBound(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, eOperation.getLowerBound()));
			}
			
			if (isAccessible(EcoreViewsRepository.OperationElement.Cardinality.upperBound)) {
				operationElementPart.setUpperBound(EEFConverterUtil.convertToString(EcorePackage.Literals.EINT, eOperation.getUpperBound()));
			}
			
			if (isAccessible(EcoreViewsRepository.OperationElement.Properties.eType)) {
				// init part
				eTypeSettings = new EObjectFlatComboSettings(eOperation, EcorePackage.eINSTANCE.getETypedElement_EType());
				operationElementPart.initEType(eTypeSettings);
				// set the button mode
				operationElementPart.setETypeButtonMode(ButtonsModeEnum.BROWSE);
			}
			// init filters
			
			
			
			
			
			if (isAccessible(EcoreViewsRepository.OperationElement.Properties.eType)) {
				operationElementPart.addFilterToEType(new ViewerFilter() {
				
					/**
					 * {@inheritDoc}
					 * 
					 * @see org.eclipse.jface.viewers.ViewerFilter#select(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
					 */
					public boolean select(Viewer viewer, Object parentElement, Object element) {
						return (element instanceof String && element.equals("")) || (element instanceof EClassifier); //$NON-NLS-1$ 
					}
					
				});
				// Start of user code for additional businessfilters for eType
				// End of user code
			}
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
		if (editorKey == EcoreViewsRepository.OperationElement.Properties.name) {
			return EcorePackage.eINSTANCE.getENamedElement_Name();
		}
		if (editorKey == EcoreViewsRepository.OperationElement.Properties.ordered) {
			return EcorePackage.eINSTANCE.getETypedElement_Ordered();
		}
		if (editorKey == EcoreViewsRepository.OperationElement.Properties.unique) {
			return EcorePackage.eINSTANCE.getETypedElement_Unique();
		}
		if (editorKey == EcoreViewsRepository.OperationElement.Cardinality.lowerBound) {
			return EcorePackage.eINSTANCE.getETypedElement_LowerBound();
		}
		if (editorKey == EcoreViewsRepository.OperationElement.Cardinality.upperBound) {
			return EcorePackage.eINSTANCE.getETypedElement_UpperBound();
		}
		if (editorKey == EcoreViewsRepository.OperationElement.Properties.eType) {
			return EcorePackage.eINSTANCE.getETypedElement_EType();
		}
		return super.associatedFeature(editorKey);
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updateSemanticModel(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void updateSemanticModel(final IPropertiesEditionEvent event) {
		EOperation eOperation = (EOperation)semanticObject;
		if (EcoreViewsRepository.OperationElement.Properties.name == event.getAffectedEditor()) {
			eOperation.setName((java.lang.String)EEFConverterUtil.createFromString(EcorePackage.Literals.ESTRING, (String)event.getNewValue()));
		}
		if (EcoreViewsRepository.OperationElement.Properties.ordered == event.getAffectedEditor()) {
			eOperation.setOrdered((Boolean)event.getNewValue());
		}
		if (EcoreViewsRepository.OperationElement.Properties.unique == event.getAffectedEditor()) {
			eOperation.setUnique((Boolean)event.getNewValue());
		}
		if (EcoreViewsRepository.OperationElement.Cardinality.lowerBound == event.getAffectedEditor()) {
			eOperation.setLowerBound((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EcoreViewsRepository.OperationElement.Cardinality.upperBound == event.getAffectedEditor()) {
			eOperation.setUpperBound((EEFConverterUtil.createIntFromString(EcorePackage.Literals.EINT, (String)event.getNewValue())));
		}
		if (EcoreViewsRepository.OperationElement.Properties.eType == event.getAffectedEditor()) {
			if (event.getKind() == PropertiesEditionEvent.SET) {
				eTypeSettings.setToReference((EClassifier)event.getNewValue());
			} else if (event.getKind() == PropertiesEditionEvent.ADD) {
				EReferencePropertiesEditionContext context = new EReferencePropertiesEditionContext(editingContext, this, eTypeSettings, editingContext.getAdapterFactory());
				PropertiesEditingProvider provider = (PropertiesEditingProvider)editingContext.getAdapterFactory().adapt(semanticObject, PropertiesEditingProvider.class);
				if (provider != null) {
					PropertiesEditingPolicy policy = provider.getPolicy(context);
					if (policy instanceof CreateEditingPolicy) {
						policy.execute();
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#updatePart(org.eclipse.emf.common.notify.Notification)
	 */
	public void updatePart(Notification msg) {
		super.updatePart(msg);
		if (editingPart.isVisible()) {
			OperationElementPropertiesEditionPart operationElementPart = (OperationElementPropertiesEditionPart)editingPart;
			if (EcorePackage.eINSTANCE.getENamedElement_Name().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationElementPart != null && isAccessible(EcoreViewsRepository.OperationElement.Properties.name)) {
				if (msg.getNewValue() != null) {
					operationElementPart.setName(EcoreUtil.convertToString(EcorePackage.Literals.ESTRING, msg.getNewValue()));
				} else {
					operationElementPart.setName("");
				}
			}
			if (EcorePackage.eINSTANCE.getETypedElement_Ordered().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationElementPart != null && isAccessible(EcoreViewsRepository.OperationElement.Properties.ordered))
				operationElementPart.setOrdered((Boolean)msg.getNewValue());
			
			if (EcorePackage.eINSTANCE.getETypedElement_Unique().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationElementPart != null && isAccessible(EcoreViewsRepository.OperationElement.Properties.unique))
				operationElementPart.setUnique((Boolean)msg.getNewValue());
			
			if (EcorePackage.eINSTANCE.getETypedElement_LowerBound().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationElementPart != null && isAccessible(EcoreViewsRepository.OperationElement.Cardinality.lowerBound)) {
				if (msg.getNewValue() != null) {
					operationElementPart.setLowerBound(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					operationElementPart.setLowerBound("");
				}
			}
			if (EcorePackage.eINSTANCE.getETypedElement_UpperBound().equals(msg.getFeature()) && msg.getNotifier().equals(semanticObject) && operationElementPart != null && isAccessible(EcoreViewsRepository.OperationElement.Cardinality.upperBound)) {
				if (msg.getNewValue() != null) {
					operationElementPart.setUpperBound(EcoreUtil.convertToString(EcorePackage.Literals.EINT, msg.getNewValue()));
				} else {
					operationElementPart.setUpperBound("");
				}
			}
			if (EcorePackage.eINSTANCE.getETypedElement_EType().equals(msg.getFeature()) && operationElementPart != null && isAccessible(EcoreViewsRepository.OperationElement.Properties.eType))
				operationElementPart.setEType((EObject)msg.getNewValue());
			
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
			EcorePackage.eINSTANCE.getENamedElement_Name(),
			EcorePackage.eINSTANCE.getETypedElement_Ordered(),
			EcorePackage.eINSTANCE.getETypedElement_Unique(),
			EcorePackage.eINSTANCE.getETypedElement_LowerBound(),
			EcorePackage.eINSTANCE.getETypedElement_UpperBound(),
			EcorePackage.eINSTANCE.getETypedElement_EType()		);
		return new NotificationFilter[] {filter,};
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.impl.components.StandardPropertiesEditionComponent#getHelpContent(java.lang.Object, int)
	 * 
	 */
	public String getHelpContent(Object key, int kind) {
		if (key == EcoreViewsRepository.OperationElement.Properties.name)
			return "The name of this model element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.OperationElement.Properties.ordered)
			return "Whether the order in which values occur is meaningful"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.OperationElement.Properties.unique)
			return "Whether the same value may occur more than once"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.OperationElement.Cardinality.lowerBound)
			return "The minimum number of values that must occur"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.OperationElement.Cardinality.upperBound)
			return "The maximum number of values that may occur; -1 represents unbounded and -2 represents unspecified"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.OperationElement.Properties.eType)
			return "The type of this element"; //$NON-NLS-1$
		if (key == EcoreViewsRepository.Exceptions.Exceptions_.eExceptions)
			return "The exceptions thrown by this operation"; //$NON-NLS-1$
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
				if (EcoreViewsRepository.OperationElement.Properties.name == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getENamedElement_Name().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.OperationElement.Properties.ordered == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_Ordered().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_Ordered().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.OperationElement.Properties.unique == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_Unique().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_Unique().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.OperationElement.Cardinality.lowerBound == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_LowerBound().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_LowerBound().getEAttributeType(), newValue);
				}
				if (EcoreViewsRepository.OperationElement.Cardinality.upperBound == event.getAffectedEditor()) {
					Object newValue = event.getNewValue();
					if (newValue instanceof String) {
						newValue = EEFConverterUtil.createFromString(EcorePackage.eINSTANCE.getETypedElement_UpperBound().getEAttributeType(), (String)newValue);
					}
					ret = Diagnostician.INSTANCE.validate(EcorePackage.eINSTANCE.getETypedElement_UpperBound().getEAttributeType(), newValue);
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
