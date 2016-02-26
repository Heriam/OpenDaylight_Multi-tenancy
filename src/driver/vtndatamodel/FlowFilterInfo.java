package driver.vtndatamodel;

import org.json.JSONObject;

/**
 * Created by Hao on 2/26/16.
 */
public class FlowFilterInfo extends JSONObject implements Serializable {

    private int index;
    private String condition;
    private FilterType filterType;

    public FlowFilterInfo(){}
    public FlowFilterInfo(int index, String condition, FilterType filterType){
        this.index = index;
        this.condition = condition;
        this.filterType = filterType;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public FilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(FilterType filterType) {
        this.filterType = filterType;
    }

    @Override
    public String toString() {
        return "FlowFilterInfo{" +
                "index='" + index + '\'' +
                ", condition='" + condition + '\'' +
                ", filterType=" + filterType +
                '}';
    }
}
