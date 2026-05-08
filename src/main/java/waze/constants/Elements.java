package waze.constants;

public class Elements {

    // ref: Destination
    public String whereTo = "//android.widget.TextView[@text=\"Where to?\"]";
    public String searchBox = "//*[@resource-id='com.waze:id/coordinatorsView']//android.widget.EditText";
    public String searchResult = "//*[@content-desc=\"SEARCH_AUTOCOMPLETE_LIST\"]/android.view.View[1]";
    public String streetInfo = "//android.widget.ScrollView/android.view.View[1]";
    public String routeInfo = "new UiSelector().className(\"android.widget.ScrollView\")";
    public String tripOverview = "//*[@resource-id=\"com.waze:id/tripOverviewDetails\"]";
    public String goNow = "//*[@text='Go now']";
    public String activeRouteModal = "//*[@resource-id=\"com.waze:id/dragHandle\"]";
    public String scrollActiveRouteModal = "new UiSelector().resourceId(\"com.waze:id/dragHandle\")";
    public String activeRouteAddress = "//*[@resource-id=\"com.waze:id/lblAddress\"]";
    public String shareDrive = "//*[@resource-id=\"com.waze:id/lblSendEta\"]";
    public String stopButton = "//*[@resource-id=\"com.waze:id/lblStopNav\"]";

    // ref: SavePlace
    public String InfoBody = "//android.widget.ScrollView";
    public String lastInfoBodyItem = "//android.widget.ScrollView/android.view.View[last()]";
    public String saveIcon = "//android.widget.HorizontalScrollView/android.view.View[1]";
    public String givePlaceAName = "//android.view.ViewGroup/android.view.View[1]";
    public String doneButton = "//*[@content-desc=\"CALL_TO_ACTION_BAR_FIRST_ACTION\"]";
    public String searchResultPage = "//*[@resource-id=\"com.waze:id/coordinatorsView\"]";
    public String searchBackButton = "//android.view.View[2]/android.widget.Button[1]";
    public String savePlaceModalTitle = "//*[@resource-id=\"com.waze:id/titleBarTitleText\"]";
    public String savePlacesList = "//*[@resource-id=\"com.waze:id/cellTitle\" and not(@text=\"\")]";
    public String backButton = "//*[@resource-id=\"com.waze:id/titleBarCloseButtonFake\"]";
}
