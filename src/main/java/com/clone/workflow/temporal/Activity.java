package com.clone.workflow.temporal;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

@ActivityInterface
public interface Activity {

	@ActivityMethod
	void placeOrder();

	@ActivityMethod
	void setOrderAccepted();

	@ActivityMethod
	void setOrderPickedUp();

	@ActivityMethod
	void setOrderDelivered();
}
