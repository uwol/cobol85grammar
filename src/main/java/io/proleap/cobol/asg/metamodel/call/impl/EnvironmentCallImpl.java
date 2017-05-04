/*
 * Copyright (C) 2017, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.asg.metamodel.call.impl;

import org.antlr.v4.runtime.ParserRuleContext;

import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.EnvironmentCall;

public class EnvironmentCallImpl extends CallImpl implements EnvironmentCall {

	protected final CallType callType = CallType.ENVIRONMENT_CALL;

	public EnvironmentCallImpl(final String name, final ProgramUnit programUnit, final ParserRuleContext ctx) {
		super(name, programUnit, ctx);
	}

	@Override
	public CallType getCallType() {
		return callType;
	}

}
