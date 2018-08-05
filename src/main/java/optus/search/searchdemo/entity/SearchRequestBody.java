package optus.search.searchdemo.entity;

import java.util.List;

public class SearchRequestBody {

    private List<String> searchText;

    public List<String> getSearchText() {
        return searchText;
    }

    public void setSearchText(List<String> searchText) {
        this.searchText = searchText;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SearchRequestBody{");
        sb.append("searchText=").append(searchText);
        sb.append('}');
        return sb.toString();
    }
}
