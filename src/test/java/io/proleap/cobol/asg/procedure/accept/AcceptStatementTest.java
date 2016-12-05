package io.proleap.cobol.asg.procedure.accept;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import io.proleap.cobol.CobolTestSupport;
import io.proleap.cobol.asg.applicationcontext.CobolParserContext;
import io.proleap.cobol.asg.metamodel.CompilationUnit;
import io.proleap.cobol.asg.metamodel.Program;
import io.proleap.cobol.asg.metamodel.ProgramUnit;
import io.proleap.cobol.asg.metamodel.call.Call;
import io.proleap.cobol.asg.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.asg.metamodel.procedure.StatementTypeEnum;
import io.proleap.cobol.asg.metamodel.procedure.accept.AcceptFromDate;
import io.proleap.cobol.asg.metamodel.procedure.accept.AcceptFromMnemonic;
import io.proleap.cobol.asg.metamodel.procedure.accept.AcceptMessageCount;
import io.proleap.cobol.asg.metamodel.procedure.accept.AcceptStatement;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class AcceptStatementTest extends CobolTestSupport {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() throws Exception {
		final File inputFile = new File("src/test/resources/io/proleap/cobol/asg/procedure/accept/AcceptStatement.cbl");
		final Program program = CobolParserContext.getInstance().getParserRunner().analyzeFile(inputFile,
				CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("AcceptStatement");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final ProcedureDivision procedureDivision = programUnit.getProcedureDivision();
		assertEquals(0, procedureDivision.getParagraphs().size());
		assertEquals(3, procedureDivision.getStatements().size());

		{
			final AcceptStatement acceptStatement = (AcceptStatement) procedureDivision.getStatements().get(0);
			assertEquals(StatementTypeEnum.Accept, acceptStatement.getStatementType());
			assertNotNull(acceptStatement.getAcceptCall());
			assertEquals(Call.CallType.UndefinedCall, acceptStatement.getAcceptCall().getCallType());
			assertNotNull(acceptStatement.getAcceptFromDate());

			final AcceptFromDate acceptFromDate = acceptStatement.getAcceptFromDate();
			assertEquals(AcceptFromDate.DateType.TodaysName, acceptFromDate.getDateType());
		}

		{
			final AcceptStatement acceptStatement = (AcceptStatement) procedureDivision.getStatements().get(1);
			assertEquals(StatementTypeEnum.Accept, acceptStatement.getStatementType());
			assertNotNull(acceptStatement.getAcceptCall());
			assertEquals(Call.CallType.UndefinedCall, acceptStatement.getAcceptCall().getCallType());
			assertNotNull(acceptStatement.getAcceptFromMnemonic());

			final AcceptFromMnemonic acceptFromMnemonic = acceptStatement.getAcceptFromMnemonic();
			assertNotNull(acceptFromMnemonic.getMnemonicCall());
			assertEquals(Call.CallType.UndefinedCall, acceptFromMnemonic.getMnemonicCall().getCallType());
		}

		{
			final AcceptStatement acceptStatement = (AcceptStatement) procedureDivision.getStatements().get(2);
			assertEquals(StatementTypeEnum.Accept, acceptStatement.getStatementType());
			assertNotNull(acceptStatement.getAcceptCall());
			assertEquals(Call.CallType.UndefinedCall, acceptStatement.getAcceptCall().getCallType());
			assertNotNull(acceptStatement.getAcceptMessageCount());

			final AcceptMessageCount acceptMessageCount = acceptStatement.getAcceptMessageCount();
			assertNotNull(acceptMessageCount);
		}
	}
}