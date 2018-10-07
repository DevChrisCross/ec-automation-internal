package com.elavon.tasks.searchCustomer;

import com.elavon.constants.search.SearchBy;
import com.elavon.constants.search.SearchFilter;
import com.elavon.constants.search.SearchMatch;
import net.serenitybdd.core.steps.Instrumented;

public class SearchForTheAccount {

    public static SearchAccountBuilder by(SearchBy by) {
        return new SearchAccountBuilder(by);
    }

    public static class SearchAccountBuilder {

        private SearchBy by;
        private SearchMatch match;
        private SearchFilter filter;

        public SearchAccountBuilder(SearchBy by) {
            this.by = by;
        }

        public SearchAccountBuilder withThe(SearchFilter filter) {
            this.filter = filter;
            return this;
        }

        public SearchAccountBuilder that(SearchMatch match) {
            this.match = match;
            return this;
        }

        public SearchAccount theWord(String input) {
            return Instrumented.instanceOf(SearchAccount.class).withProperties(by, filter, match, input);
        }
    }
}
