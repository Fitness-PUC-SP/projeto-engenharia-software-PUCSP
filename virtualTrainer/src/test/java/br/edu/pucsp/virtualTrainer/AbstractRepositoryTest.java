package br.edu.pucsp.virtualTrainer;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@Rollback
public class AbstractRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {
}
