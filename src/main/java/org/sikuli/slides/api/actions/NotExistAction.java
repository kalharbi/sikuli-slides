package org.sikuli.slides.api.actions;

import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.slides.api.Context;

import com.google.common.base.Objects;

public class NotExistAction extends DefaultAction {
	
	private Target target;
	public NotExistAction(Target target){
		this.target = target; 
	}
	
	@Override
	public void execute(Context context) throws ActionExecutionException{
		logger.debug("executing {}", this);
		ScreenRegion screenRegion = context.getScreenRegion();
		ScreenRegion ret = screenRegion.find(target);
		if (ret != null){
			throw new ActionExecutionException("Target not expected to exist is found", this);
		}
	}	
	
	public String toString(){
		return Objects.toStringHelper(this).add("target",target).toString();
	}


}