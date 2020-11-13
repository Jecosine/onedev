package io.onedev.server.web.component.select2;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

@SuppressWarnings("serial")
public abstract class SelectToAddChoice<T> extends Select2Choice<T> {

	private transient T selection;
	
	public SelectToAddChoice(String id, ChoiceProvider<T> choiceProvider) {
		this(id);
		setProvider(choiceProvider);
	}

	public SelectToAddChoice(String id) {
		super(id);
		
		setModel(new IModel<T>() {

			@Override
			public void detach() {
			}

			@Override
			public T getObject() {
				return selection;
			}

			@Override
			public void setObject(T object) {
				selection = object;
			}
			
		});
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		
		setOutputMarkupId(true);
	}

	protected abstract void onSelect(AjaxRequestTarget target, T selection);
}
