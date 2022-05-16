package ApiTest;

import Config.APITestBase;
import Entities.*;
import Entities.Error;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


public class ProductionInfoApiTest extends APITestBase{


    Product product;

    String text = "Verschiedene Anbieter/Banken bieten Kreditkarten an. Diese unterscheiden sich im Leistungsumfang sowie in der Jahresgebühr.";
    String icon = "QUESTIONMARK_GREY";
    String label = "Kartenanbieter";
    String value = "Barclays";
    String featuredDetail="true";
    String url = "https://finanzen.check24.de/accounts/product/creditcard/200007/productdetail.pdf";
    String tabName="Allgemein";

    @Before
    public void createTestProduct(){

        //Create overlay entity
        Overlay overlay = new Overlay(text);

        //Create tooltip entity
        ToolTip toolTip = new ToolTip(icon,overlay);

        //Create Row entity
        List<Row> rows = new ArrayList<>();
        Row testRow = new Row(label,toolTip,value,featuredDetail);
        rows.add(testRow);

        //Create SectionGeneral entity
        SectionGeneral sectionGeneral = new SectionGeneral(rows);

        //Create Sections entity
        Section section = new Section(sectionGeneral);

        //Create Tab Content
        List<Section> sections=new ArrayList<>();;
        sections.add(section);
        TabContent tabContent = new TabContent(sections,url);

        //Create General entity
        General general = new General(tabName,tabContent);

        //Create Tab entity
        //I assume the other tabs without any details. In real, their constructors should be as the General class constructor
        //And also we should create test entities for them.
        //For now I am just creating them as null instances.

        Payment payment=null;
        CashWithdrawal cashWithdrawal=null;
        Fee fee =null ;  //Actually it should be a Fee list as Fees
        AdditionalInfoAndBonus additionalInfoAndBonus =null;
        Insurance insurance =null;
        Travel travel=null;

        Tab tabs = new Tab(general,payment,cashWithdrawal,fee,additionalInfoAndBonus,insurance,travel);
        //tabs is not a list in here,I named it so because of according the json all other attributes seems like a different tab.

        // And for final creating product entities
        product = new Product(1,tabs);
        List<Product> products = new ArrayList<>();;
        products.add(product);


        //now I have a product, I can use it to post or get if I know it already exists in database.
    }


    @Test
    public void CheckGetResponseWithValidID() {

        Response response =
                given()
                        .when()
                        .get("200007");
        assertThat(response.body().asPrettyString(), containsString(product.getTabs().getGeneral().getTabName()));
        assertThat(response.body().asPrettyString(), containsString(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getLabel()));
        assertThat(response.body().asPrettyString(), containsString(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getToolTip().getIcon()));
        assertThat(response.body().asPrettyString(), containsString(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getValue()));
        assertThat(response.body().asPrettyString(), containsString(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getFeaturedDetail()));
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);


    }


    @Test
    public void CheckPostMethodResponseWithATestProduct() {
    //If we were testing post method I would like to do it like that
    //These test will be fail because the post URL is fake

        Response response =
                given()
                        .body(product)
                        .when()
                        .post("https://finanzen.check24.de/accounts/r/frs/productInfo/createNewCC");



        assertThat(tabName, equals(product.getTabs().getGeneral().getTabName()));
        assertThat(label, equals(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getLabel()));
        assertThat(icon, equals(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getToolTip().getIcon()));
        assertThat(value, equals(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getValue()));
        assertThat(featuredDetail, equals(product.getTabs().getGeneral().getTabContent().getSections().get(0).getSectionGeneral().getRows()
                .get(0).getFeaturedDetail()));

        //System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),200);

        //When we create a new entity with post, we could check if the attributes are coherence with calling get method with this id
    }


        @Test
        public void CheckErrorWithInvalidType() {

            Error error = given()
                    .when()
                    .get("abcd")
                    .then()
                    .assertThat()
                    .statusCode(404)
                    .extract().as(Error.class);
            Assert.assertEquals(error.getMessage(),"HTTP 404 Not Found");


        }


    @Test
    public void CheckErrorWithValidTypeInvalidID() {

        Response response =
                given()
                        .when()
                        .get("5456");
        System.out.println(response.asPrettyString());
        Assert.assertEquals(response.statusCode(),204);
        //In this test, the parameter has correct type but there is no data with this id, so we should assert 204 message for this test case
        // -The server successfully proceed the request but is not returning any content


    }

    }

