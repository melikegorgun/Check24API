package Config;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

public class APITestBase {

    public static RequestSpecification proInf_requestSpec;
    public static ResponseSpecification proInf_responseSpec;

    private static final String API_ROOT = "https://finanzen.check24.de/accounts/r/frs/productInfo/kreditkarte/";

    @BeforeClass
    public static void setup() {

        proInf_requestSpec = new RequestSpecBuilder()
                .setBaseUri(API_ROOT)
                .setContentType("application/json")
                .setAccept("application/json")
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        RestAssured.requestSpecification = proInf_requestSpec;
        RestAssured.responseSpecification = proInf_responseSpec;
    }
}