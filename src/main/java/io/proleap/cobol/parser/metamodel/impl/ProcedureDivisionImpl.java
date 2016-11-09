/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.impl;

import io.proleap.cobol.Cobol85Parser.ProcedureDivisionContext;
import io.proleap.cobol.parser.metamodel.CobolScope;
import io.proleap.cobol.parser.metamodel.CopyBook;
import io.proleap.cobol.parser.metamodel.ProcedureDivision;

public class ProcedureDivisionImpl extends CobolScopedElementImpl implements ProcedureDivision {

	protected final ProcedureDivisionContext ctx;

	public ProcedureDivisionImpl(final CopyBook copyBook, final CobolScope superScope,
			final ProcedureDivisionContext ctx) {
		super(copyBook, superScope, ctx);

		this.ctx = ctx;
	}

}