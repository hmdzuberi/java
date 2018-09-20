package com.training.domains;

import com.training.ifaces.IAutomobile;

public class UpdatedQuoteManager extends QuoteManager {

	@Override
	public IAutomobile getModel(int key) {

		if (key == 3) {
			return new Tractor();
		} else {
			return super.getModel(key);
		}

	}

}
