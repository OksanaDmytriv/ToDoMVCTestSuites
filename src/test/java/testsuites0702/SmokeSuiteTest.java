package testsuites0702;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testsuites0702.categories.Buggy;
import testsuites0702.categories.Smoke;
import testsuites0702.features.TodosE2E;
import testsuites0702.features.TodosOperationsAtAllFilter;

@RunWith(Categories.class)
@Suite.SuiteClasses({TodosE2E.class, TodosOperationsAtAllFilter.class})
@Categories.IncludeCategory(Smoke.class)
@Categories.ExcludeCategory(Buggy.class)
public class SmokeSuiteTest{
}
